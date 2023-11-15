package com.example.appmanagementsystem.mapper;

import com.example.appmanagementsystem.db.entity.AppService;
import com.example.appmanagementsystem.db.entity.Application;
import com.example.appmanagementsystem.dto.request.AppServiceCreationRequest;
import com.example.appmanagementsystem.dto.response.AppServiceCreatedResponse;
import org.springframework.stereotype.Component;

@Component
public class AppServiceMapper {

    public AppService appServiceCreationRequestToEntity(AppServiceCreationRequest creationRequest, Application application) {
        AppService appService = new AppService();
        appService.setApplication(application);
        appService.setName(creationRequest.getName());
        appService.setType(creationRequest.getType());
        appService.setSubType(creationRequest.getSubType());
        appService.setDescription(creationRequest.getDescription());

        return appService;
    }

    public AppServiceCreatedResponse applicationEntityToAppServiceCreatedResponse(AppService appService) {
        AppServiceCreatedResponse createdResponse = new AppServiceCreatedResponse();
        createdResponse.setAppCode(appService.getApplication().getAppCode());
        createdResponse.setServiceCode(appService.getServiceCode());
        createdResponse.setName(appService.getName());
        createdResponse.setType(appService.getType());
        createdResponse.setSubType(appService.getSubType());
        createdResponse.setDescription(appService.getDescription());

        return createdResponse;
    }
}
