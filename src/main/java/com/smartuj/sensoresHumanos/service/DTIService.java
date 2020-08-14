package com.smartuj.sensoresHumanos.service;

import com.smartuj.sensoresHumanos.dto.Persona;

public interface DTIService {
    public String getPersonasToken();
    public String getEstudiantesToken();
    public Persona getUserData(String usuario);
    public String getDatosContacto(String usuario);
    public String getEstadosPrograma(String usuario);
    public String getClasesActivas(String usuario);
    public String getClasesActivasHorario(String usuario);
    public String getNotas(String usuario);
}
