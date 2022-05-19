package es.vetappoint.entities;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="mascotas")
@Table(name="mascotas")
public class Mascota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mascota", nullable = false)
    private Long id;
    @Column(name="id_propietario")
    private Long idpropietario;
    @Column(name="Foto")
    private String foto;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Especie")
    private String especie;
    @Column(name="Raza")
    private String raza;
    @Column(name="Edad")
    private String edad;
    @Column(name="Descripcion")
    private String descripcion;
    @Column(name="Chip")
    private String chip;
    @Column(name="Genero")
    private String genero;
    private static final Long serialVersionUID=1L;

    public Mascota() {
    }


    public Long getId() {
        return id;
    }

    public Long getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(Long idpropietario) {
        this.idpropietario = idpropietario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", idpropietario=" + idpropietario +
                ", foto='" + foto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad='" + edad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", chip='" + chip + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
