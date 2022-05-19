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

@Entity(name = "tratamientos")
@Table(name = "tratamientos")
public class Tratamiento implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "idTratamiento",
            nullable = false)
    private Long id;

    private String idMascota;

    private String idVeterinario;

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
