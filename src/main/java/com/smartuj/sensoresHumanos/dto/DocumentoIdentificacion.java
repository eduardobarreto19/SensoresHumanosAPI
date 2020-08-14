package com.smartuj.sensoresHumanos.dto;

public class DocumentoIdentificacion {
    private String numero;
    private TipoIdentificacion tipo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoIdentificacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoIdentificacion tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "DocumentoIdentificacion{" +
                "numero='" + numero + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
