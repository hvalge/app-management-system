package com.example.appmanagementsystem.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
public class ApplicationCreationRequest {

    @NotNull
    @Length(min = 1, max = 100)
    private String name;

    @NotNull
    @Length(min = 1, max = 200)
    private String appGroup;

    @NotNull
    @Length(min = 1, max = 200)
    private String appType;

    @NotNull
    @Length(min = 1, max = 20000)
    private String description;

    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal appCost;
}
