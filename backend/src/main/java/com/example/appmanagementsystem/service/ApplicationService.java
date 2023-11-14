package com.example.appmanagementsystem.service;

import com.example.appmanagementsystem.db.entity.Application;
import com.example.appmanagementsystem.db.repository.ApplicationRepository;
import com.example.appmanagementsystem.dto.request.ApplicationCreationRequest;
import com.example.appmanagementsystem.dto.response.ApplicationCreatedResponse;
import com.example.appmanagementsystem.mapper.ApplicationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
