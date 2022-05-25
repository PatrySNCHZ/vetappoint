package es.vetappoint.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tratamientos")
public class Tratamiento implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_tratamiento",
            nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_mascota")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Mascota mascota;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_veterinario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Veterinario veterinario;

    @Column(
            name = "creado_el",
            columnDefinition = "date DEFAULT (curdate())"
    )
    @Temporal(TemporalType.DATE)
    private Date creadoEl;
    private static final long serialVersionUID = 1L;

    @OneToOne(mappedBy="tratamientos", cascade = CascadeType.ALL,  orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private LineasTratamiento linea_tratamiento;

    public Tratamiento() {
    }

    public Long getIdTratamiento() {
        return id;
    }

    public void setIdTratamiento(Long idTratamiento) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public LineasTratamiento getLinea_tratamiento() {
        return linea_tratamiento;
    }

    public void setLinea_tratamiento(LineasTratamiento linea_tratamiento) {
        this.linea_tratamiento = linea_tratamiento;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }
}
