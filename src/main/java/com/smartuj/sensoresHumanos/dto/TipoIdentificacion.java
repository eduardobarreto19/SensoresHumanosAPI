package com.smartuj.sensoresHumanos.dto;

public class TipoIdentificacion {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "TipoIdentificacion{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}
