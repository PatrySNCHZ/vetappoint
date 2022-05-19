package es.vetappoint.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "opiniones")
@Table(name = "opiniones")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOpinion", nullable = false)
    private Long id;
    @Column(name = "Puntuacion")
    private int puntuacion;
    @Column(name = "Comentario")
    private String comentario;
    private int idUsuario;
    private int idClinica;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    public Opinion () {

    }

    public Opinion(Long id, int puntuacion, String comentario, int idUsuario, int idClinica) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
        this.idClinica = idClinica;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", puntuacion=" + puntuacion +
                ", comentario='" + comentario + '\'' +
                ", idUsuario=" + idUsuario +
                ", idClinica=" + idClinica +
                '}';
    }
}

