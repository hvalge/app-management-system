<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>App Management System</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text @click="currentView = 'ApplicationForm'">Create App</v-btn>
      <v-btn text @click="currentView = 'AppServiceForm'">Create App Service</v-btn>
      <v-btn text @click="currentView = 'SearchResults'">Search</v-btn>
    </v-app-bar>
    <v-main>
      <application-form @created="handleCreation" v-if="currentView === 'ApplicationForm'" />
      <app-service-form @created="handleCreation" v-if="currentView === 'AppServiceForm'" />
      <search-results v-if="currentView === 'SearchResults'" />
    </v-main>
  </v-app>
</template>

<script>
import { defineComponent, ref } from 'vue';
import ApplicationForm from './components/ApplicationForm.vue';
import AppServiceForm from './components/AppServiceForm.vue';
import SearchResults from './components/SearchResults.vue';

export default defineComponent({
  components: {
    ApplicationForm,
    AppServiceForm,
    SearchResults
  },
  setup() {
    const currentView = ref('SearchResults');

    const handleCreation = () => {
      currentView.value = 'SearchResults';
    };

    return { currentView, handleCreation };
  }
});
</script>
