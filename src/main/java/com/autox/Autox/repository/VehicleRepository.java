package com.autox.Autox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autox.Autox.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}