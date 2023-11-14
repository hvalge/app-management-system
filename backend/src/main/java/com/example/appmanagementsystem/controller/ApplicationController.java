package com.example.appmanagementsystem.controller;

import com.example.appmanagementsystem.dto.request.ApplicationCreationRequest;
import com.example.appmanagementsystem.dto.response.ApplicationCreatedResponse;
import com.example.appmanagementsystem.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    private ApplicationCreatedResponse createApplication(@RequestBody @Valid ApplicationCreationRequest creationRequest) {
        return applicationService.createApplication(creationRequest);
    }
}
