package com.example.appmanagementsystem.db.repository;

import com.example.appmanagementsystem.db.entity.AppService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppServiceRepository extends JpaRepository<AppService, UUID> {
}
