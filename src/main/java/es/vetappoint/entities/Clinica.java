package es.vetappoint.entities;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "clinicas")
public class Clinica implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_clinica",
            nullable = false

    )

    private Long id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="CIF")
    private String cif;
    private String clave;
    private String email;
    @Column(name="Tlf1")
    private String tlf1;
    @Column(name="Tlf2")
    private String tlf2;
    @Column(name="Tlf_urgencia")
    private String tlfu;
    @Column(name="Direccion1")
    private String linea1;
    @Column(name="Direccion2")
    private String linea2;
    @Column(name="Localidad")
    private String localidad;
    @Column(name="CP")
    private String cp;
    @Column(name="Provincia")
    private String provincia;
    @Column(name="Horario")
    private String horario;
    @Column(name="Granularidad")
    private String granularidad;
    private String rol = "ROLE_CLINICA";

    @Column(name = "creado_el", columnDefinition = "date DEFAULT (curdate())")
    @Temporal(TemporalType.DATE)
    private Date creadoEl;
    private static final long serialVersionUID = 1L;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE
    })
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name="clinicas_veterinarios",
            joinColumns= @JoinColumn (name= "id_clinica"),
            inverseJoinColumns = @JoinColumn(name="id_veterinario"))
    private List<Veterinario> veterinarios;



    public Clinica() {
    }

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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf1() {
        return tlf1;
    }

    public void setTlf1(String tlf1) {
        this.tlf1 = tlf1;
    }

    public String getTlf2() {
        return tlf2;
    }

    public void setTlf2(String tlf2) {
        this.tlf2 = tlf2;
    }

    public String getTlfu() {
        return tlfu;
    }

    public void setTlfu(String tlfu) {
        this.tlfu = tlfu;
    }

    public String getLinea1() {
        return linea1;
    }

    public void setLinea1(String linea1) {
        this.linea1 = linea1;
    }

    public String getLinea2() {
        return linea2;
    }

    public void setLinea2(String linea2) {
        this.linea2 = linea2;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getGranularidad() {
        return granularidad;
    }

    public void setGranularidad(String granularidad) {
        this.granularidad = granularidad;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }

    public List<Veterinario> getVeterinario() {
        return veterinarios;
    }

    public void setVeterinario(List<Veterinario> veterinario) {
        this.veterinarios = veterinario;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Clinica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cif='" + cif + '\'' +
                ", clave='" + clave + '\'' +
                ", email='" + email + '\'' +
                ", tlf1='" + tlf1 + '\'' +
                ", tlf2='" + tlf2 + '\'' +
                ", tlfu='" + tlfu + '\'' +
                ", linea1='" + linea1 + '\'' +
                ", linea2='" + linea2 + '\'' +
                ", localidad='" + localidad + '\'' +
                ", cp='" + cp + '\'' +
                ", provincia='" + provincia + '\'' +
                ", horario='" + horario + '\'' +
                ", granularidad='" + granularidad + '\'' +
                ", creadoEl=" + creadoEl +
                '}';
    }
}
