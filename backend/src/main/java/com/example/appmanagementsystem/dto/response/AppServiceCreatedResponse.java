package com.example.appmanagementsystem.dto.response;

import com.example.appmanagementsystem.constants.ServiceSubType;
import com.example.appmanagementsystem.constants.ServiceType;
import lombok.Data;

import java.util.UUID;

@Data
public class AppServiceCreatedResponse {

    private UUID serviceCode;
    private UUID appCode;
    private String name;
    private ServiceType type;
    private ServiceSubType subType;
    private String description;
}
