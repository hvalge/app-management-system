package com.example.appmanagementsystem.controller;

import com.example.appmanagementsystem.dto.request.ApplicationCreationRequest;
import com.example.appmanagementsystem.dto.response.ApplicationCreatedResponse;
import com.example.appmanagementsystem.dto.response.ApplicationDropdownResponse;
import com.example.appmanagementsystem.dto.response.ApplicationSearchedResponse;
import com.example.appmanagementsystem.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ApplicationCreatedResponse createApplication(@RequestBody @Valid ApplicationCreationRequest creationRequest) {
        return applicationService.createApplication(creationRequest);
    }

    @GetMapping
    public List<ApplicationSearchedResponse> searchApplications(@RequestParam String name) {
        return applicationService.searchApplications(name);
    }

    @GetMapping("/dropdown")
    public List<ApplicationDropdownResponse> getApplicationsForDropdown() {
        return applicationService.getApplicationsForDropdown();
    }
}
