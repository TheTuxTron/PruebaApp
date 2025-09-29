package com.backend.backend.services;

import com.backend.backend.dto.RegistroDTO;
import com.backend.backend.models.EstudianteMateriaPeriodo;
import com.backend.backend.repository.EstudianteMateriaPeriodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EscuelaServices {

    @Autowired
    private EstudianteMateriaPeriodoRepository empRepository;

    public List<RegistroDTO> buscarRegistros(Long idEstudiante, Long idPeriodo, Long idMateria) {
        List<EstudianteMateriaPeriodo> registros;

        if (idEstudiante != null && idPeriodo != null && idMateria != null) {
            registros = empRepository.findByEstudianteIdAndPeriodoIdAndMateriaId(idEstudiante, idPeriodo, idMateria);
        } else if (idEstudiante != null && idPeriodo != null) {
            registros = empRepository.findByEstudianteIdAndPeriodoId(idEstudiante, idPeriodo);
        } else if (idEstudiante != null && idMateria != null) {
            registros = empRepository.findByEstudianteIdAndMateriaId(idEstudiante, idMateria);
        } else if (idPeriodo != null && idMateria != null) {
            registros = empRepository.findByPeriodoIdAndMateriaId(idPeriodo, idMateria);
        } else if (idEstudiante != null) {
            registros = empRepository.findByEstudianteId(idEstudiante);
        } else if (idPeriodo != null) {
            registros = empRepository.findByPeriodoId(idPeriodo);
        } else if (idMateria != null) {
            registros = empRepository.findByMateriaId(idMateria);
        } else {
            registros = empRepository.findAll();
        }

        return registros.stream()
                .map(r -> new RegistroDTO(
                        r.getId(),
                        r.getEstudiante().getNombre(),
                        r.getEstudiante().getCodigo(),
                        r.getMateria().getNombre(),
                        r.getPeriodo().getNombre(),
                        r.getAprobada()
                ))
                .collect(Collectors.toList());
    }
}
