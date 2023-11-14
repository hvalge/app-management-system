package com.example.appmanagementsystem.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ApplicationCreatedResponse {

    private UUID appCode;
    private String name;
    private String appGroup;
    private String appType;
    private String description;
    private BigDecimal appCost;
}
