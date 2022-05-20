package es.vetappoint.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "linea_tratamientos")
public class LineasTratamiento implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_lineatratamiento",
            nullable = false)
    private Long id_lineatratamiento;

    private Long idTratamiento;
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

    public Long getId_lineatratamiento() {
        return id_lineatratamiento;
    }

    public void setId_lineatratamiento(Long id_lineatratamiento) {
        this.id_lineatratamiento = id_lineatratamiento;
    }

    public Long getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Long idTratamiento) {
        this.idTratamiento = idTratamiento;
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
                "id=" + id_lineatratamiento +
                ", idTratamiento=" + idTratamiento +
                ", medicamento='" + medicamento + '\'' +
                ", posologia='" + posologia + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", creadoEl=" + creadoEl +
                '}';
    }
}
