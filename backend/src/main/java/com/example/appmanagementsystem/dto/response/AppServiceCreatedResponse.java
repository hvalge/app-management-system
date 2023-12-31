package com.example.appmanagementsystem.dto.response;

import com.example.appmanagementsystem.constants.AppServiceSubType;
import com.example.appmanagementsystem.constants.AppServiceType;
import lombok.Data;

import java.util.UUID;

@Data
public class AppServiceCreatedResponse {

    private UUID serviceCode;
    private UUID appCode;
    private String name;
    private AppServiceType type;
    private AppServiceSubType subType;
    private String description;
}
