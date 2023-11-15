package com.example.appmanagementsystem.dto.request;

import com.example.appmanagementsystem.constants.AppServiceSubType;
import com.example.appmanagementsystem.constants.AppServiceType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class AppServiceCreationRequest {

    @NotNull
    private UUID appCode;

    @NotNull
    @Length(min = 1, max = 200)
    private String name;

    @NotNull
    private AppServiceType type;

    @NotNull
    private AppServiceSubType subType;

    @NotNull
    @Length(min = 1, max = 20000)
    private String description;
}
