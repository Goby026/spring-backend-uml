package dev.uml.selva.entities;

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
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String ruta;
    private String imagen;
    private int estado;

    // *****************relaciones*****************
    /*
    @ManyToMany(type => Rol)
    @JoinTable()
    roles: Rol[];
     */

    private static final long serialVersionUID = 1L;

    @CreationTimestamp()
    @Column(name = "created_at", updatable=false)
    private Date createdAt;

    @UpdateTimestamp()
    @Column(name = "updated_at")
    private Date updatedAt;
}
