<template>
  <v-container>
    <v-form ref="form" @submit.prevent="submitApplication">
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.name" :rules="nameRules" label="App Name" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.appGroup" :rules="nameRules" label="App Group" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.appType" :rules="nameRules" label="App Type" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-textarea v-model="formData.description" :rules="descriptionRules" label="Description" auto-grow rows="3" required></v-textarea>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.appCost" :rules="costRules" label="appCost" type="number" required></v-text-field>
        </v-col>
      </v-row>
      <v-btn type="submit">Create Application</v-btn>
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
        name: null,
        appGroup: null,
        appType: null,
        description: null,
        appCost: null,
      },
      nameRules: [
        v => !!v || 'Field is required',
        v => (v && v.length <= 200) || 'Name must be less than 200 characters'
      ],
      descriptionRules: [
        v => !!v || 'Description is required',
        v => (v && v.length <= 20000) || 'Description must be less than 20000 characters'
      ],
      costRules: [
        v => !!v || 'Cost is required as a number',
        v => (v && v > 0) || 'Cost must be greater than 0'
      ],
      error: null
    };
  },
  methods: {
    submitApplication() {
      if (this.$refs.form.validate()) {
        apiService.createApplication(this.formData)
          .then(response => {
            console.log('Application created:', response.data);
            this.$emit('created');
            this.$refs.form.reset();
          })
          .catch(error => {
            this.error = error.response?.data?.message || 'Error creating application';
          });
      }
    },
  },
};
</script>
