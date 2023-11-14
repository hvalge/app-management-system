package com.example.appmanagementsystem.db.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "App_code")
    private UUID appCode;

    @Column(name = "Name")
    @NotNull
    @Length(min = 1, max = 200)
    private String name;

    @Column(name = "App_group")
    @NotNull
    @Length(min = 1, max = 200)
    private String appGroup;

    @Column(name = "App_type")
    @NotNull
    @Length(min = 1, max = 200)
    private String appType;

    @Column(name = "Description")
    @NotNull
    @Length(min = 1, max = 20000)
    private String description;

    @Column(name = "App_cost")
    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal appCost;

    @Column(name = "Last_modified")
    @NotNull
    private LocalDateTime lastModified;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "application")
    private List<AppService> appServices;

    @PreUpdate
    @PrePersist
    public void updateLastModified() {
        lastModified = LocalDateTime.now();
    }
}
