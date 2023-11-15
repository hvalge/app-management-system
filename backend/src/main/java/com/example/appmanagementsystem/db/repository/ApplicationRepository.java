package com.example.appmanagementsystem.db.repository;

import com.example.appmanagementsystem.db.entity.Application;
import com.example.appmanagementsystem.dto.response.ApplicationSearchedResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {

    @Query("SELECT a FROM Application a LEFT JOIN FETCH a.appServices " +
            "WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Application> findPartialMatchForApplicationsByName(String name);
}
