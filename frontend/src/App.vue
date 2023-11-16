<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>App Management System</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text @click="currentView = 'SearchApplications'">Search Applications</v-btn>
      <v-btn text @click="currentView = 'SearchAppServices'">Search App Services</v-btn>
      <v-btn text @click="currentView = 'ApplicationForm'">Create App</v-btn>
      <v-btn text @click="currentView = 'AppServiceForm'">Create App Service</v-btn>
    </v-app-bar>
    <v-main>
      <search-applications v-if="currentView === 'SearchApplications'" />
      <search-app-services v-if="currentView === 'SearchAppServices'" />
      <application-form @created="handleCreation" v-if="currentView === 'ApplicationForm'" />
      <app-service-form @created="handleCreation" v-if="currentView === 'AppServiceForm'" />
    </v-main>
  </v-app>
</template>

<script>
import { defineComponent, ref } from 'vue';
import ApplicationForm from './components/ApplicationForm.vue';
import AppServiceForm from './components/AppServiceForm.vue';
import SearchApplications from './components/SearchApplications.vue';
import SearchAppServices from './components/SearchAppServices.vue';

export default defineComponent({
  components: {
    ApplicationForm,
    AppServiceForm,
    SearchApplications,
    SearchAppServices
  },
  setup() {
    const currentView = ref('SearchApplications');

    const handleCreation = () => {
      currentView.value = 'SearchApplications';
    };

    return { currentView, handleCreation };
  }
});
</script>
