package es.vetappoint.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "especialidades")
@Table(name = "especialidades")
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidad", nullable = false)
    private Long id;
    @Column(name = "Nombre_esp")
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad() {

    }

    public Especialidad(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
