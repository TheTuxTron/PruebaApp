package com.backend.backend.controllers;

import com.backend.backend.dto.RegistroDTO;
import com.backend.backend.services.EscuelaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escuela")
public class EscuelaController {

    @Autowired
    private EscuelaServices escuelaService;

    /**
     * Endpoint para consultar registros filtrados.
     * Ejemplo: /api/escuela/registros?estudiante=1&periodo=2&materia=3
     */
    @GetMapping("/registros")
    public List<RegistroDTO> getRegistros(
            @RequestParam(required = false) Long estudiante,
            @RequestParam(required = false) Long periodo,
            @RequestParam(required = false) Long materia) {

        // Devuelve DTOs en lugar de entidades
        return escuelaService.buscarRegistros(estudiante, periodo, materia);
    }
}
