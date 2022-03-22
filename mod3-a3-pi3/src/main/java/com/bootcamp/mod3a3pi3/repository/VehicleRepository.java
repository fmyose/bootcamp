package com.bootcamp.mod3a3pi3.repository;

import com.bootcamp.mod3a3pi3.model.Service;
import com.bootcamp.mod3a3pi3.model.Vehicle;
import com.bootcamp.mod3a3pi3.model.dto.VehicleDTO;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Data
public class VehicleRepository {

    public List<Vehicle> vehicles = new ArrayList<>(
            Arrays.asList(
                    new Vehicle(1,"Chevrolet", "Corsa", LocalDate.of(2000,11,20),
                            115000, 5, 90000, "AR",
                            new ArrayList<>(Arrays.asList(new Service(LocalDate.of(2003, 5, 20),
                                    60000, "Change air filters"))),4),
                    new Vehicle(2,"Chevrolet", "Montana", LocalDate.of(2010,12,1),
                            90000, 5, 150000, "AR",
                            new ArrayList<>(Arrays.asList(new Service(LocalDate.of(2003, 5, 20),
                                    60000, "Change tires"))),2),
                    new Vehicle(3, "Toyota", "Corolla", LocalDate.of(19999,11,20),
                            315000, 5, 90000, "AR",
                            new ArrayList<>(Arrays.asList(new Service(LocalDate.of(2003, 5, 20),
                                    60000, "Change wind shield"))),2),
                    new Vehicle(4, "Honda", "Civic", LocalDate.of(2012,8,20),
                            80000, 5, 300000, "AR",
                            new ArrayList<>(Arrays.asList(new Service(LocalDate.of(2013, 7, 20),
                                    20000, "Change clutch"))),1),
                    new Vehicle(5, "Volkswagen", "Golf", LocalDate.of(2015,6,1),
                            50000, 5, 400000, "AR",
                            new ArrayList<>(Arrays.asList(new Service(LocalDate.of(2017, 3, 15),
                                    30000, "Change windows"))),1)
            )
    );

    public Vehicle addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }
}
