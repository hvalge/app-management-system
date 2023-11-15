package com.example.appmanagementsystem.db.repository;

import com.example.appmanagementsystem.db.entity.Application;
import com.example.appmanagementsystem.dto.response.ApplicationSearchedResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {

    @Query("SELECT new com.example.appmanagementsystem.dto.response.ApplicationSearchedResponse(" +
            "a.appCode, a.name, a.appGroup, a.appType, a.description, a.appCost) " +
            "FROM Application a " +
            "WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<ApplicationSearchedResponse> findPartialMatchForApplicationsByName(String name);
}
