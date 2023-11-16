<template>
  <v-container>
    <v-text-field v-model="searchQuery" label="Search App Services" @input="searchAppServices" outlined></v-text-field>
    <v-row v-if="appServiceResults">
      <v-col cols="12" v-for="service in appServiceResults" :key="service.serviceCode">
        <v-card>
          <v-card-title>{{ service.name }}</v-card-title>
          <v-card-subtitle>Type: {{ service.type }}<template v-if="service.subType">, SubType: {{ service.subType }}</template></v-card-subtitle>
          <v-card-text>{{ service.description }}</v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { defineComponent } from 'vue';
import apiService from '../services/apiService';

export default defineComponent({
  data() {
    return {
      searchQuery: '',
      appServiceResults: null,
    };
  },
  methods: {
    searchAppServices() {
      apiService.searchAppServices(this.searchQuery)
        .then(response => {
          this.appServiceResults = response.data;
        })
        .catch(error => {
          console.error('Error searching:', error);
        });
    },
  },
});
</script>
