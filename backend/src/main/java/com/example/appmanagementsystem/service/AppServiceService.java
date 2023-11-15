package com.example.appmanagementsystem.service;

import com.example.appmanagementsystem.db.entity.AppService;
import com.example.appmanagementsystem.db.entity.Application;
import com.example.appmanagementsystem.db.repository.AppServiceRepository;
import com.example.appmanagementsystem.db.repository.ApplicationRepository;
import com.example.appmanagementsystem.dto.request.AppServiceCreationRequest;
import com.example.appmanagementsystem.dto.response.AppServiceCreatedResponse;
import com.example.appmanagementsystem.dto.response.AppServiceSearchedResponse;
import com.example.appmanagementsystem.mapper.AppServiceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceService {

    private final AppServiceRepository appServiceRepository;
    private final ApplicationRepository applicationRepository;
    private final AppServiceMapper mapper;

    public AppServiceService(AppServiceRepository appServiceRepository, ApplicationRepository applicationRepository,
                             AppServiceMapper mapper) {
        this.appServiceRepository = appServiceRepository;
        this.applicationRepository = applicationRepository;
        this.mapper = mapper;
    }

    @Transactional
    public AppServiceCreatedResponse createAppService(AppServiceCreationRequest creationRequest) {
        Application application = applicationRepository.getReferenceById(creationRequest.getAppCode());
        AppService appService = appServiceRepository.save(mapper.appServiceCreationRequestToEntity(creationRequest, application));
        return mapper.applicationEntityToAppServiceCreatedResponse(appService);
    }

    public List<AppServiceSearchedResponse> searchAppServices(String name) {
        return appServiceRepository.findPartialMatchForAppServicesByName(name);
    }
}
