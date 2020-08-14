package com.smartuj.sensoresHumanos.dto;

import java.util.Arrays;

public class PersonasWrapper {
    private Persona[] personas;

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    @Override
    public String toString() {
        return "PersonasPayload{" +
                "personas=" + Arrays.toString(personas) +
                '}';
    }
}
