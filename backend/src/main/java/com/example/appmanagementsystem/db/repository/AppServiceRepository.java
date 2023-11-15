package com.example.appmanagementsystem.db.repository;

import com.example.appmanagementsystem.db.entity.AppService;
import com.example.appmanagementsystem.dto.response.AppServiceSearchedResponse;
import com.example.appmanagementsystem.dto.response.ApplicationSearchedResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AppServiceRepository extends JpaRepository<AppService, UUID> {

    @Query("SELECT new com.example.appmanagementsystem.dto.response.AppServiceSearchedResponse(" +
            "a.serviceCode, a.name, a.type, a.subType, a.description) " +
            "FROM AppService a " +
            "WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<AppServiceSearchedResponse> findPartialMatchForAppServicesByName(String name);
}
