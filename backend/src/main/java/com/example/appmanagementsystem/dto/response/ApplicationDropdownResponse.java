package com.example.appmanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ApplicationDropdownResponse {

    private UUID appCode;
    private String name;
}
