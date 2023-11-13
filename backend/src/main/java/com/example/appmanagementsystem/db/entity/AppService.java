package com.example.appmanagementsystem.db.entity;


import com.example.appmanagementsystem.constants.ServiceSubType;
import com.example.appmanagementsystem.constants.ServiceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "App_service")
public class AppService {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Service_code")
    private UUID serviceCode;

    @ManyToOne
    @JoinColumn(name = "App_code", referencedColumnName = "App_code")
    @NotNull
    private Application application;

    @Column(name = "Name")
    @NotNull
    private String name;

    @Column(name = "Description")
    @NotNull
    @Length(max = 20000)
    private String description;

    @Column(name = "Last_modified")
    @NotNull
    private LocalDateTime lastModified;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ServiceType Type;

    @Enumerated(EnumType.STRING)
    private ServiceSubType SubType;
}