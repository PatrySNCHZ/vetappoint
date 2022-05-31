package es.vetappoint.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private String fecha;
    @Column(name = "Hora")
    private String hora;

    @Column(name = "creado_el", columnDefinition = "date DEFAULT (curdate())")
    @Temporal(TemporalType.DATE)
    private Date creadoEl;
    private static final long serialVersionUID = 1L;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario idUsuario;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_clinica")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clinica idClinica;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_mascota")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Mascota idMascota;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_veterinario")
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
                ", creadoEl=" + creadoEl +
                '}';
    }
}
