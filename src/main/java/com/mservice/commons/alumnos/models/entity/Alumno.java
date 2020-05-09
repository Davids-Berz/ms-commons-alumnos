package com.mservice.commons.alumnos.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "alumnos")
public class Alumno {

    public Alumno() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Lob
    @JsonIgnore
    private byte[] foto;

    public Integer getFotoHashCode(){
        return (this.foto != null) ? this.foto.hashCode() : null;
    }

    @PrePersist
    public void prePersist(){
        this.createAt = new Date();
    }
}
