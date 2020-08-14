package com.smartuj.sensoresHumanos.controller;

import com.smartuj.sensoresHumanos.dto.Persona;
import com.smartuj.sensoresHumanos.service.DTIService;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/dti", produces = MediaType.APPLICATION_JSON_VALUE)
public class DtiController {

    private final DTIService DTIService;

    public DtiController(DTIService DTIService) {
        this.DTIService = DTIService;
    }

    @GetMapping(value = "/personas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> requestUserData(
            @RequestParam(value = "usuario", required = false) String usuario)
    {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(DTIService.getUserData(usuario));
    }

    @GetMapping(value = "/personas/{usuario}/datos-contacto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> requestUserContactData(
            @PathVariable(value = "usuario", required = false) String usuario)
    {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(DTIService.getDatosContacto(usuario));
    }

    @GetMapping(value = "/estudiantes/{usuario}/estados-programas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> requestProgramsStates(
            @PathVariable(value = "usuario", required = false) String usuario)
    {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(DTIService.getEstadosPrograma(usuario));
    }

    @GetMapping(value = "/estudiantes/{usuario}/clases-inscritas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> requestClasesInscritas(
            @PathVariable(value = "usuario", required = false) String usuario)
    {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(DTIService.getClasesActivas(usuario));
    }

    @GetMapping(value = "/estudiantes/{usuario}/horario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> requestClasesInscritasHorario(
            @PathVariable(value = "usuario", required = false) String usuario)
    {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(DTIService.getClasesActivasHorario(usuario));
    }

    @GetMapping(value = "/estudiantes/{usuario}/notas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> requestGrades(
            @PathVariable(value = "usuario", required = false) String usuario)
    {
        return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(DTIService.getNotas(usuario));
    }
}
