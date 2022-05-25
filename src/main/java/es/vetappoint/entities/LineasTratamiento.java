package es.vetappoint.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "linea_tratamientos")
public class LineasTratamiento implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_lineatratamiento",
            nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name="id_tratamientos")
    private Tratamiento id_tratamientos;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tratamiento getId_tratamiento() {
        return id_tratamientos;
    }

    public void setId_tratamiento(Tratamiento id_tratamiento) {
        this.id_tratamientos = id_tratamiento;
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

    @Override
    public String toString() {
        return "LineasTratamiento{" +
                "id_lineatratamiento=" + id +
                ", tratamiento=" + id_tratamientos +
                ", medicamento='" + medicamento + '\'' +
                ", posologia='" + posologia + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", creadoEl=" + creadoEl +
                '}';
    }
}
