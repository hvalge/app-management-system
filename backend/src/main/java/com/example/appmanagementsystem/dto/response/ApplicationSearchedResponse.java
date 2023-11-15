package com.example.appmanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ApplicationSearchedResponse {

    private UUID appCode;
    private String name;
    private String appGroup;
    private String appType;
    private String description;
    private BigDecimal appCost;
    private List<AppServiceSearchedResponse> appServices;
}
