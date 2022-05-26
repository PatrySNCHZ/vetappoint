package es.vetappoint.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "veterinarios")
public class Veterinario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario", nullable = false)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    private String email;

    @ManyToMany(mappedBy = "veterinarios",  cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Especialidad> id_especialidad;

    @ManyToMany(mappedBy = "veterinarios", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Clinica> id_clinica;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Especialidad> getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(List<Especialidad> id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public List<Clinica> getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(List<Clinica> id_clinica) {
        this.id_clinica = id_clinica;
    }

    public Veterinario(Long id, String nombre, String apellidos, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Veterinarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
