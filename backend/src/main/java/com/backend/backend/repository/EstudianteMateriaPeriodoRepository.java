package com.backend.backend.repository;

import com.backend.backend.models.EstudianteMateriaPeriodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteMateriaPeriodoRepository extends JpaRepository<EstudianteMateriaPeriodo, Long> {

    List<EstudianteMateriaPeriodo> findByEstudianteId(Long idEstudiante);
    List<EstudianteMateriaPeriodo> findByPeriodoId(Long idPeriodo);
    List<EstudianteMateriaPeriodo> findByMateriaId(Long idMateria);

    List<EstudianteMateriaPeriodo> findByEstudianteIdAndPeriodoId(Long idEstudiante, Long idPeriodo);
    List<EstudianteMateriaPeriodo> findByEstudianteIdAndMateriaId(Long idEstudiante, Long idMateria);
    List<EstudianteMateriaPeriodo> findByPeriodoIdAndMateriaId(Long idPeriodo, Long idMateria);

    List<EstudianteMateriaPeriodo> findByEstudianteIdAndPeriodoIdAndMateriaId(Long idEstudiante, Long idPeriodo, Long idMateria);
}
