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

    @Column(name = "Medicamento")
    private String medicamento;
    @Column(name = "Posologia")
    private String posologia;
    @Column(name = "Fecha_inicio")
    private String fechaInicio;
    @Column(name = "Fecha_fin")
    private String fechaFin;

    @Column(
            name = "creado_el",
            columnDefinition = "date DEFAULT (curdate())"
    )
    @Temporal(TemporalType.DATE)
    private Date creadoEl;
    private static final long serialVersionUID = 1L;



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

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }
}
