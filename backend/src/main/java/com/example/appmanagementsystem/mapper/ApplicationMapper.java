package com.example.appmanagementsystem.mapper;

import com.example.appmanagementsystem.db.entity.Application;
import com.example.appmanagementsystem.dto.request.ApplicationCreationRequest;
import com.example.appmanagementsystem.dto.response.ApplicationCreatedResponse;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public Application applicationCreationRequestToEntity(ApplicationCreationRequest creationRequest) {
        Application applicationEntity = new Application();
        applicationEntity.setName(creationRequest.getName());
        applicationEntity.setAppGroup(creationRequest.getAppGroup());
        applicationEntity.setAppType(creationRequest.getAppType());
        applicationEntity.setDescription(creationRequest.getDescription());
        applicationEntity.setAppCost(creationRequest.getAppCost());

        return applicationEntity;
    }

    public ApplicationCreatedResponse applicationEntityToApplicationCreatedResponse(Application application) {
        ApplicationCreatedResponse createdResponse = new ApplicationCreatedResponse();
        createdResponse.setAppCode(application.getAppCode());
        createdResponse.setName(application.getName());
        createdResponse.setAppGroup(application.getAppGroup());
        createdResponse.setAppType(application.getAppType());
        createdResponse.setDescription(application.getDescription());
        createdResponse.setAppCost(application.getAppCost());


        return createdResponse;
    }
}
