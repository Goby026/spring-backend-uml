package dev.uml.selva.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;

    private String nombres;
    private String apellidos;
    private String dni;
    private String dependencia;

    @Column(name = "num_documento")
    private String numDocumento;

    @Column(name = "fecha_cita")
    private Date fechaCita;

    @Column(name = "fecha_atencion")
    private Date fechaAtencion;

    @Column(name = "hora_inicio")
    private Date horaInicio;

    @Column(name = "hora_fin")
    private Date horaFin;

    @Column(name = "elapsed_time")
    public Date elapsedTime;

    @Column(name = "hora_cita")
    private Date horaCita;

    @Column(name = "fecha_peritaje") //nullable true
    private Date fechaPeritaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peritosId", nullable = false)
    private Perito perito;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "estadoId")
    private EstadoCita estado;

    @JsonIgnore
    @OneToMany(mappedBy = "cita", fetch = FetchType.LAZY)
    private Set<Reprogramacion> reprogramaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "userId")
    private User user;

    private static final long serialVersionUID = 1L;

    @CreationTimestamp()
    @Column(name = "created_at", updatable=false)
    private Date createdAt;

    @UpdateTimestamp()
    @Column(name = "updated_at")
    private Date updatedAt;
}
