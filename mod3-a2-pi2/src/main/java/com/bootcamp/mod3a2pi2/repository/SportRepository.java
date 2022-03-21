package com.bootcamp.mod3a2pi2.repository;

import com.bootcamp.mod3a2pi2.models.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class SportRepository implements MyRepository<Sport> {

    private static List<Sport> sports = new ArrayList<>(
            Arrays.asList(
                    new Sport("Football", "1"),
                    new Sport("Tennis", "2"),
                    new Sport("Volley", "3"),
                    new Sport("MMA", "4"),
                    new Sport("Golf", "5"),
                    new Sport("Karate", "6"),
                    new Sport("Chess", "7")
            )
    );

    @Override
    public Sport find(String sportName) {
        return SportRepository.getSports().stream().filter(sport -> sport.getName().equals(sportName))
                .findFirst().orElse(null);
    }

    @Override
    public List<Sport> getAll() {
        return sports;
    }

    public static List<Sport> getSports() {
        return sports;
    }

    public static void setSports(List<Sport> sports) {
        SportRepository.sports = sports;
    }

    public String getRandomSport() {
        List<String> availableSports = getSports().stream().map(sport -> sport.getName())
                .collect(Collectors.toList());

        return availableSports.get(new Random().nextInt(availableSports.size()));
    }
}
