package com.bootcamp.mod3a2pi2.models;

import com.bootcamp.mod3a2pi2.services.AthleteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDTO {
    private String name;
    private String surname;
    private String sportName;

    public AthleteDTO convertToDTO(Athlete athlete) {
        this.name = athlete.getPerson().getName();
        this.surname = athlete.getPerson().getSurname();
        this.sportName = athlete.getSport().getName();

        return this;
    }

    public static List<AthleteDTO> convertToDTO(List<Athlete> athletes) {
        return athletes.stream().map(
                athlete -> new AthleteDTO(athlete.getPerson().getName(),
                        athlete.getPerson().getSurname(),
                        athlete.getSport().getName()))
                .collect(Collectors.toList());
    }
}
