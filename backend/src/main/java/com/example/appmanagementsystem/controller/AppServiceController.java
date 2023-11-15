package com.example.appmanagementsystem.controller;

import com.example.appmanagementsystem.dto.request.AppServiceCreationRequest;
import com.example.appmanagementsystem.dto.response.AppServiceCreatedResponse;
import com.example.appmanagementsystem.dto.response.AppServiceSearchedResponse;
import com.example.appmanagementsystem.dto.response.ApplicationSearchedResponse;
import com.example.appmanagementsystem.service.AppServiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appservices")
public class AppServiceController {

    private final AppServiceService appServiceService;

    public AppServiceController(AppServiceService appServiceService) {
        this.appServiceService = appServiceService;
    }

    @PostMapping
    public AppServiceCreatedResponse createAppService(@RequestBody @Valid AppServiceCreationRequest creationRequest) {
        return appServiceService.createAppService(creationRequest);
    }

    @GetMapping
    public List<AppServiceSearchedResponse> searchAppServices(String name) {
        return appServiceService.searchAppServices(name);
    }
}
