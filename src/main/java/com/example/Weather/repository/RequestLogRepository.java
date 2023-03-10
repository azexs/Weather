package com.example.Weather.repository;

import com.example.Weather.entity.RequestLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLogEntity, Long> {

}
