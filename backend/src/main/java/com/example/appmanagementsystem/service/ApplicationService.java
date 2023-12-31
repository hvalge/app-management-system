package com.example.appmanagementsystem.service;

import com.example.appmanagementsystem.db.entity.Application;
import com.example.appmanagementsystem.db.repository.ApplicationRepository;
import com.example.appmanagementsystem.dto.request.ApplicationCreationRequest;
import com.example.appmanagementsystem.dto.response.AppServiceSearchedResponse;
import com.example.appmanagementsystem.dto.response.ApplicationCreatedResponse;
import com.example.appmanagementsystem.dto.response.ApplicationDropdownResponse;
import com.example.appmanagementsystem.dto.response.ApplicationSearchedResponse;
import com.example.appmanagementsystem.mapper.ApplicationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper mapper;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicationMapper mapper) {
        this.applicationRepository = applicationRepository;
        this.mapper = mapper;
    }

    @Transactional
    public ApplicationCreatedResponse createApplication(ApplicationCreationRequest creationRequest) {
        Application application = applicationRepository.save(mapper.applicationCreationRequestToEntity(creationRequest));
        return mapper.applicationEntityToApplicationCreatedResponse(application);
    }


    public List<ApplicationSearchedResponse> searchApplications(String name) {
        List<Application> applications = applicationRepository.findPartialMatchForApplicationsByName(name);
        return applications.stream()
                .map(this::toApplicationSearchedResponse)
                .collect(Collectors.toList());
    }

    public List<ApplicationDropdownResponse> getApplicationsForDropdown() {
        return applicationRepository.findApplicationsForDropdown();
    }

    private ApplicationSearchedResponse toApplicationSearchedResponse(Application application) {
        List<AppServiceSearchedResponse> appServices = application.getAppServices().stream()
                .map(appService -> new AppServiceSearchedResponse(
                        appService.getServiceCode(), appService.getName(),
                        appService.getType(), appService.getSubType(),
                        appService.getDescription()))
                .collect(Collectors.toList());

        return new ApplicationSearchedResponse(
                application.getAppCode(), application.getName(),
                application.getAppGroup(), application.getAppType(),
                application.getDescription(), application.getAppCost(),
                appServices);
    }
}
