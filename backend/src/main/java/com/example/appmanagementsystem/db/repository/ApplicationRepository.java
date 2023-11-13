package com.example.appmanagementsystem.db.repository;

import com.example.appmanagementsystem.db.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
}
