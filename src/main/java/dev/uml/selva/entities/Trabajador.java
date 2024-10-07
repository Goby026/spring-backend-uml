package dev.uml.selva.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
public class Trabajador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String dni;
    private String dfiscal;
    private String dependencia;
    private String despacho;
    private String siglasdes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargoid", nullable = true)
    private CargoTrabajador cargo;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaing;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechanac;

    private String reglab;
    private String correoper;
    private String correoins;
    private String celular;
    private int estado;

    private String presupuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sedeid")
    private Sede sede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargotrabajadorid")
    private CargoTrabajador cargoTrabajador;

    private static final long serialVersionUID = 1L;

    @CreationTimestamp()
    @Column(name = "created_at", updatable=false)
    private Date createdAt;

    @UpdateTimestamp()
    @Column(name = "updated_at")
    private Date updatedAt;
}
