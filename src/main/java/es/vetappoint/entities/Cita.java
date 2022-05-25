package es.vetappoint.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "citas")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_cita", nullable = false)
    private Long id;

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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_usuario")
    private Usuario idUsuario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_clinica")
    private Clinica idClinica;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_mascota")
    private Mascota idMascota;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_veterinario")
    private Veterinario idVeterinario;


    public Cita() {

    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Clinica getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinica idClinica) {
        this.idClinica = idClinica;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public Veterinario getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Veterinario idVeterinario) {
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
