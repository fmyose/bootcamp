package com.bootcamp.mod3a3pi3.service;

import com.bootcamp.mod3a3pi3.model.Vehicle;
import com.bootcamp.mod3a3pi3.model.dto.VehicleDTO;
import com.bootcamp.mod3a3pi3.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleDTO> getVehiclesByManufactureDate() {
        return VehicleDTO.convertToDTO(vehicleRepository.getVehicles());
    }

    public Vehicle add(Vehicle vehicle) {
        vehicleRepository.addVehicle(vehicle);

        return vehicle;
    }

    public List<Vehicle> getVehiclesByManufactureDate(int sinceDate, int toDate) {
        return vehicleRepository.getVehicles().stream()
                        .filter(vehicle -> vehicle.getManufacturingDate().getYear() >= sinceDate ||
                                vehicle.getManufacturingDate().getYear() <= toDate)
                .collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByPrices(Double sincePrice, Double toPrice) {
        return vehicleRepository.getVehicles().stream()
                .filter(vehicle -> vehicle.getPrice() >= sincePrice ||
                        vehicle.getManufacturingDate().getYear() <= toPrice)
                .collect(Collectors.toList());
    }

    public Vehicle getVehicle(Integer id) {
        return vehicleRepository.getVehicles().stream().filter(vehicle -> vehicle.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
