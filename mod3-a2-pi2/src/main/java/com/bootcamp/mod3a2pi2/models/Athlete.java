package com.bootcamp.mod3a2pi2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Athlete {
    private Person person;
    private Sport sport;
}
