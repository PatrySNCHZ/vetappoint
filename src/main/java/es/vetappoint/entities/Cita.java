package es.vetappoint.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "citas")
@Table(name = "citas")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idCita", nullable = false)
    private Long id;
    private Long idUsuario;
    private Long idClinica;
    private Long idMascota;
    private Long idVeterinario;
    @Column(name = "Fecha")
    private LocalDate fecha;
    @Column(name = "Hora")
    private LocalDate hora;
    @Column(name = "Fecha_solicitud")
    private LocalDate fechaSolicitud;
    @Column(name = "Hora_solicitud")
    private LocalDate horaSolicitud;

    @Column(name = "creado_el", columnDefinition = "date DEFAULT (curdate())")
    @Temporal(TemporalType.DATE)
    private Date creadoEl;
    private static final long serialVersionUID = 1L;

    public Cita() {

    }

    public Cita(Long id, Long idUsuario, Long idClinica, Long idMascota, Long idVeterinario, LocalDate fecha, LocalDate hora, LocalDate fechaSolicitud, LocalDate horaSolicitud, Date creadoEl) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idClinica = idClinica;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.fecha = fecha;
        this.hora = hora;
        this.fechaSolicitud = fechaSolicitud;
        this.horaSolicitud = horaSolicitud;
        this.creadoEl = creadoEl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Long idClinica) {
        this.idClinica = idClinica;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Long getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(LocalDate horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idClinica=" + idClinica +
                ", idMascota=" + idMascota +
                ", idVeterinario=" + idVeterinario +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", fechaSolicitud=" + fechaSolicitud +
                ", horaSolicitud=" + horaSolicitud +
                ", creadoEl=" + creadoEl +
                '}';
    }
}
