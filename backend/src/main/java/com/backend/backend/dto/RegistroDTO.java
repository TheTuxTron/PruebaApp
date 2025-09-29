package com.backend.backend.dto;

public class RegistroDTO {
    private Integer id;
    private String nombreEstudiante;
    private String codigoEstudiante;
    private String nombreMateria;
    private String nombrePeriodo;
    private Boolean aprobada;

    public RegistroDTO(Integer id, String nombreEstudiante, String codigoEstudiante,
                       String nombreMateria, String nombrePeriodo, Boolean aprobada) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.codigoEstudiante = codigoEstudiante;
        this.nombreMateria = nombreMateria;
        this.nombrePeriodo = nombrePeriodo;
        this.aprobada = aprobada;
    }

    // Getters y setters
    public Integer getId() { return id; }
    public String getNombreEstudiante() { return nombreEstudiante; }
    public String getCodigoEstudiante() { return codigoEstudiante; }
    public String getNombreMateria() { return nombreMateria; }
    public String getNombrePeriodo() { return nombrePeriodo; }
    public Boolean getAprobada() { return aprobada; }
}
