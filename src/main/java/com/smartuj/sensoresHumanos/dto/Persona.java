package com.smartuj.sensoresHumanos.dto;

public class Persona {
    private String idPersona;
    private String primerApellido;
    private String segundoApellido;
    private String genero;
    private String usuario;
    private DocumentoIdentificacion documentosIdentificacion;
    private String fechaNacimiento;

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public DocumentoIdentificacion getDocumentosIdentificacion() {
        return documentosIdentificacion;
    }

    public void setDocumentosIdentificacion(DocumentoIdentificacion documentosIdentificacion) {
        this.documentosIdentificacion = documentosIdentificacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona='" + idPersona + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", genero='" + genero + '\'' +
                ", usuario='" + usuario + '\'' +
                ", documentosIdentificacion=" + documentosIdentificacion +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}
