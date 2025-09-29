package com.backend.backend.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Periodo")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo")
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "periodo")
    private Set<EstudianteMateriaPeriodo> estudiantes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<EstudianteMateriaPeriodo> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<EstudianteMateriaPeriodo> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
