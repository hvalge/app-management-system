package com.example.appmanagementsystem.controller;

import com.example.appmanagementsystem.dto.request.AppServiceCreationRequest;
import com.example.appmanagementsystem.dto.response.AppServiceCreatedResponse;
import com.example.appmanagementsystem.service.AppServiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appservices")
public class AppServiceController {

    private final AppServiceService appServiceService;

    public AppServiceController(AppServiceService appServiceService) {
        this.appServiceService = appServiceService;
    }

    @PostMapping
    private AppServiceCreatedResponse createAppService(@RequestBody @Valid AppServiceCreationRequest creationRequest) {
        return appServiceService.createAppService(creationRequest);
    }
}
