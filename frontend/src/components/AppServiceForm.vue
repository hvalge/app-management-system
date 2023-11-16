<template>
  <v-container>
    <v-form @submit.prevent="submitAppService">
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.appCode" label="App Code" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.name" label="Name" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.type" label="Type" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.subType" label="SubType" required></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-col md="4">
          <v-text-field v-model="formData.description" label="Description" required></v-text-field>
        </v-col>
      </v-row>
      <v-btn type="submit">Create Application</v-btn>
    </v-form>
</v-container>
</template>

<script>
import { defineComponent, ref, onMounted } from 'vue';
import apiService from '../services/apiService';

export default defineComponent({
  data() {
    // TODO: Fetch UUID's and labels for them
    // TODO: Restrict type, subtype fields.
    return {
      formData: {
        appCode: '',
        name: '',
        type: '',
        subType: '',
        description: ''
      },
      applications: []
    };
  },
  methods: {
    submitAppService() {
      apiService.createAppService(this.formData)
        .then(response => {
          console.log('App Service created:', response.data);
          this.$emit('created');
        })
        .catch(error => {
          console.error('Error creating app service:', error);
        });
    },
    fetchApplications() {
      apiService.fetchApplications()
        .then(response => {
          this.applications = response.data.map((app) => ({
            name: app.name,
            appCode: app.appCode
          }));
        });
    }
  },
  mounted() {
    this.fetchApplications();
  }
});
</script>
