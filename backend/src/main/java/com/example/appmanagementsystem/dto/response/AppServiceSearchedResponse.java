package com.example.appmanagementsystem.dto.response;

import com.example.appmanagementsystem.constants.AppServiceSubType;
import com.example.appmanagementsystem.constants.AppServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AppServiceSearchedResponse {

    private UUID serviceCode;
    private String name;
    private AppServiceType type;
    private AppServiceSubType subType;
    private String description;
}
