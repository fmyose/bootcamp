package com.bootcamp.mod3a3pi3.model.dto;

import com.bootcamp.mod3a3pi3.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private int countOfOwners;

    public static VehicleDTO convertToDTO(Vehicle vehicle) {
                return new VehicleDTO(
                        vehicle.getBrand(), vehicle.getModel(),vehicle.getManufacturingDate(),
                        vehicle.getNumberOfKilometers(),vehicle.getDoors(), vehicle.getPrice(),
                        vehicle.getCurrency(), vehicle.getCountOfOwners());
    }

    public static List<VehicleDTO> convertToDTO(List<Vehicle> vehicles) {
        return vehicles.stream().map(vehicle -> convertToDTO(vehicle))
                .collect(Collectors.toList());
    }
}
