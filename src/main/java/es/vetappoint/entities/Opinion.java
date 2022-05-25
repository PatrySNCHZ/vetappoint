package es.vetappoint.entities;

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
    private Long idUsuario;
    private Long idClinica;

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

    public Opinion () {

    }

    public Opinion(Long id, int puntuacion, String comentario, Long idUsuario, Long idClinica) {
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

