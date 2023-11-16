<template>
  <v-container>
    <v-text-field v-model="searchQuery" label="Search Applications" @input="searchApplications" outlined></v-text-field>
    <v-row v-if="applicationResults">
      <v-col cols="12" v-for="app in applicationResults" :key="app.appCode">
        <v-card>
          <v-card-title>{{ app.name }}</v-card-title>
          <v-card-subtitle>{{ app.appGroup }}, {{ app.appType }}, Cost: {{ app.appCost }}</v-card-subtitle>
          <v-card-text>{{ app.description }}</v-card-text>
          <v-list>
            <v-subheader>Services</v-subheader>
            <v-list-item-group>
              <v-list-item v-for="service in app.appServices" :key="service.serviceCode">
                <v-list-item-content>
                  <v-list-item-title>{{ service.name }}</v-list-item-title>
                  <v-list-item-subtitle>Type: {{ service.type }}, SubType: {{ service.subType }}</v-list-item-subtitle>
                  <v-list-item-subtitle>{{ service.description }}</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import apiService from '../services/apiService';

export default defineComponent({
  data() {
    return {
      searchQuery: '',
      applicationResults: null,
    };
  },
  methods: {
    searchApplications() {
      apiService.searchApplications(this.searchQuery)
        .then(response => {
          this.applicationResults = response.data;
        })
        .catch(error => {
          console.error('Error searching:', error);
        });
    },
  },
});
</script>
