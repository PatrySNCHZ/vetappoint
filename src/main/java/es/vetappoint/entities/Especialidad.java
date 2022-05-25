package es.vetappoint.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "especialidades")
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad", nullable = false)
    private Long id;
    @Column(name = "Nombre_esp")
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name="especialidades_veterinario",
    joinColumns= @JoinColumn (name= "id_especialidad"),
    inverseJoinColumns = @JoinColumn(name="id_veterinario"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"id_especialidad", "id_veterinario"}))
    private List<Veterinario> veterinarios;



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
