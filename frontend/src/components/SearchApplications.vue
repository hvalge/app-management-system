<template>
  <v-container>
    <v-text-field v-model="searchQuery" label="Search Application services" @input="searchApplications" outlined></v-text-field>
    <v-row v-if="applicationResults">
      <v-col cols="12" v-for="app in applicationResults" :key="app.appCode">
        <v-card>
          <!-- ... other card components ... -->
          <v-list>
            <v-subheader>Services</v-subheader>
            <v-list-item-group>
              <v-list-item v-for="service in app.appServices" :key="service.serviceCode">
                <v-list-item-content>
                  <v-list-item-title>{{ service.name }}</v-list-item-title>
                  <!-- Display subtype only if it's not null -->
                  <v-list-item-subtitle>
                    Type: {{ service.type }}<template v-if="service.subType">, SubType: {{ service.subType }}</template>
                  </v-list-item-subtitle>
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
