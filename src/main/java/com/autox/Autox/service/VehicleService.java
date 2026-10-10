package com.autox.Autox.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.autox.Autox.entity.Vehicle;
import com.autox.Autox.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Add vehicle
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Get vehicle by ID
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {

    Vehicle existing = vehicleRepository.findById(id).orElse(null);

    if (existing == null) {
        return null;
    }

    existing.setRegistrationNumber(vehicle.getRegistrationNumber());
    existing.setBrand(vehicle.getBrand());
    existing.setModel(vehicle.getModel());
    existing.setVariant(vehicle.getVariant());
    existing.setManufacturingYear(vehicle.getManufacturingYear());
    existing.setFuelType(vehicle.getFuelType());
    existing.setTransmission(vehicle.getTransmission());
    existing.setColor(vehicle.getColor());
    existing.setOdometer(vehicle.getOdometer());

    return vehicleRepository.save(existing);
}

    // Delete vehicle
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}