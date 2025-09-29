package com.backend.backend;

import com.backend.backend.dto.RegistroDTO;
import com.backend.backend.models.Estudiante;
import com.backend.backend.models.Materia;
import com.backend.backend.models.Periodo;
import com.backend.backend.models.EstudianteMateriaPeriodo;
import com.backend.backend.repository.EstudianteMateriaPeriodoRepository;
import com.backend.backend.services.EscuelaServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EscuelaServicesTest {

    @Mock
    private EstudianteMateriaPeriodoRepository empRepository;

    @InjectMocks
    private EscuelaServices escuelaServices;

    private Estudiante estudiante;
    private Materia materia;
    private Periodo periodo;
    private EstudianteMateriaPeriodo emp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        estudiante = new Estudiante();
        estudiante.setId(1);
        estudiante.setNombre("Juan Pérez");
        estudiante.setCodigo("EST001");

        materia = new Materia();
        materia.setId(1);
        materia.setNombre("Matemáticas");

        periodo = new Periodo();
        periodo.setId(1);
        periodo.setNombre("2025-I");

        emp = new EstudianteMateriaPeriodo();
        emp.setId(1);
        emp.setEstudiante(estudiante);
        emp.setMateria(materia);
        emp.setPeriodo(periodo);
        emp.setAprobada(true);
    }

    @Test
    void testBuscarRegistros_TodosNulos() {
        when(empRepository.findAll()).thenReturn(Collections.singletonList(emp));

        List<RegistroDTO> resultados = escuelaServices.buscarRegistros(null, null, null);

        assertEquals(1, resultados.size());
        assertEquals("Juan Pérez", resultados.get(0).getNombreEstudiante());
        verify(empRepository, times(1)).findAll();
    }

    @Test
    void testBuscarRegistros_SoloEstudiante() {
        when(empRepository.findByEstudianteId(1L)).thenReturn(Collections.singletonList(emp));

        List<RegistroDTO> resultados = escuelaServices.buscarRegistros(1L, null, null);

        assertEquals(1, resultados.size());
        assertEquals("EST001", resultados.get(0).getCodigoEstudiante());
        verify(empRepository, times(1)).findByEstudianteId(1L);
    }

    @Test
    void testBuscarRegistros_EstudianteYPeriodo() {
        when(empRepository.findByEstudianteIdAndPeriodoId(1L, 1L))
                .thenReturn(Collections.singletonList(emp));

        List<RegistroDTO> resultados = escuelaServices.buscarRegistros(1L, 1L, null);

        assertEquals(1, resultados.size());
        assertEquals("Matemáticas", resultados.get(0).getNombreMateria());
        verify(empRepository, times(1)).findByEstudianteIdAndPeriodoId(1L, 1L);
    }

    @Test
    void testBuscarRegistros_EstudiantePeriodoMateria() {
        when(empRepository.findByEstudianteIdAndPeriodoIdAndMateriaId(1L, 1L, 1L))
                .thenReturn(Collections.singletonList(emp));

        List<RegistroDTO> resultados = escuelaServices.buscarRegistros(1L, 1L, 1L);

        assertEquals(1, resultados.size());
        assertTrue(resultados.get(0).getAprobada());
        verify(empRepository, times(1)).findByEstudianteIdAndPeriodoIdAndMateriaId(1L, 1L, 1L);
    }

    @Test
    void testBuscarRegistros_EmptyResult() {
        when(empRepository.findByMateriaId(2L)).thenReturn(Collections.emptyList());

        List<RegistroDTO> resultados = escuelaServices.buscarRegistros(null, null, 2L);

        assertTrue(resultados.isEmpty());
        verify(empRepository, times(1)).findByMateriaId(2L);
    }
}
