package es.vetappoint.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "opiniones")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opinion", nullable = false)
    private Long id;
    @Column(name = "Puntuacion")
    private int puntuacion;
    @Column(name = "Comentario")
    private String comentario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario id_usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_clinica")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clinica id_clinica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Clinica getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(Clinica id_clinica) {
        this.id_clinica = id_clinica;
    }

    public Opinion () {

    }

    public Opinion(Long id, int puntuacion, String comentario, Long idUsuario, Long idClinica) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.id_usuario = id_usuario;
        this.id_clinica = id_clinica;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", puntuacion=" + puntuacion +
                ", comentario='" + comentario + '\'' +
                ", idUsuario=" + id_usuario +
                ", idClinica=" + id_clinica +
                '}';
    }
}

