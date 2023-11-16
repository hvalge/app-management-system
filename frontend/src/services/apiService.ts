import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export default {
  createApplication(data: any) {
    return axios.post(`${API_URL}/applications`, data);
  },
  searchApplications(name: string) {
    return axios.get(`${API_URL}/applications`, { params: { name } });
  },
  createAppService(data: any) {
    return axios.post(`${API_URL}/appservices`, data);
  },
  searchAppServices(name: string) {
    return axios.get(`${API_URL}/appservices`, { params: { name } });
  },
  getApplicationsForDropdown() {
    return axios.get(`${API_URL}/applications/dropdown`);
  }
};
