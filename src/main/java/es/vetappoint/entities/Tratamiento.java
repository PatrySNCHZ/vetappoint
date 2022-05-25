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

    @ManyToOne
    @JoinColumn(name="id_mascota")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private String idMascota;

    @ManyToOne
    @JoinColumn(name="id_veterinario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private String idVeterinario;

    @Column(
            name = "creado_el",
            columnDefinition = "date DEFAULT (curdate())"
    )
    @Temporal(TemporalType.DATE)
    private Date creadoEl;
    private static final long serialVersionUID = 1L;

    @OneToOne(mappedBy="id_tratamientos", cascade = CascadeType.ALL,  orphanRemoval = true)
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

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }
}
