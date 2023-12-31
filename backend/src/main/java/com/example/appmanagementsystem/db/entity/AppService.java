package com.example.appmanagementsystem.db.entity;


import com.example.appmanagementsystem.constants.AppServiceSubType;
import com.example.appmanagementsystem.constants.AppServiceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "App_service", indexes = {
        @Index(name = "idx_application_name", columnList = "Name")
})
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
    @Length(min = 1, max = 200)
    private String name;

    @Column(name = "Description")
    @NotNull
    @Length(min = 1, max = 20000)
    private String description;

    @Column(name = "Last_modified")
    @NotNull
    private LocalDateTime lastModified;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AppServiceType type;

    @Enumerated(EnumType.STRING)
    private AppServiceSubType subType;

    @PreUpdate
    @PrePersist
    public void updateLastModified() {
        lastModified = LocalDateTime.now();
    }
}
