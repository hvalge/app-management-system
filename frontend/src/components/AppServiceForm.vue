<template>
  <v-container>
    <v-form ref="form" @submit.prevent="submitAppService">
      <v-row>
        <v-col md="4">
          <v-select
            :items="applications"
            item-title="name"
            item-value="appCode"
            v-model="formData.appCode"
            label="Select App"
            :rules="uuidRules"
            required
          ></v-select>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.name" label="Name" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-select
            v-model="formData.type"
            :items="['HTTP', 'SAML', 'SSH', 'JDBC', 'ODBC']"
            label="Type"
            required
          ></v-select>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-select
            v-model="formData.subType"
            :items="['REST', 'SOAP']"
            label="Sub-type"
          ></v-select>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-textarea
            v-model="formData.description"
            :rules="descriptionRules"
            label="Description"
            auto-grow
            rows="3"
            required
          ></v-textarea>
        </v-col>
      </v-row>
      <v-btn type="submit">Create App Service</v-btn>
      <v-alert
        v-if="error"
        type="error"
        dismissible
        @input="error = null">
        {{ error }}
      </v-alert>
    </v-form>
  </v-container>
</template>

<script>
import apiService from '../services/apiService';

export default {
  data() {
    return {
      formData: {
        appCode: null,
        name: null,
        type: null,
        subType: null,
        description: null
      },
      applications: [],
      error: null,
      nameRules: [
        v => !!v || 'Field is required',
        v => (v && v.length <= 200) || 'Name must be less than 200 characters'
      ],
      descriptionRules: [
        v => !!v || 'Description is required',
        v => (v && v.length <= 20000) || 'Description must be less than 20000 characters'
      ],
      uuidRules: [
        v => !!v || 'App selection is required'
      ],
    };
  },
  methods: {
    submitAppService() {
      if (this.$refs.form.validate()) {
        apiService.createAppService(this.formData)
          .then(response => {
            console.log('App Service created:', response.data);
            this.$emit('created');
            this.$refs.form.reset();
          })
          .catch(error => {
            this.error = error.response?.data?.message || 'Error creating app service';
          });
      }
    },
    getApplicationsForDropdown() {
      apiService.getApplicationsForDropdown()
        .then(response => {
          this.applications = response.data;
        })
        .catch(error => {
          console.error('Error fetching services:', error);
        });
    }
  },
  mounted() {
    this.getApplicationsForDropdown();
  }
};
</script>
