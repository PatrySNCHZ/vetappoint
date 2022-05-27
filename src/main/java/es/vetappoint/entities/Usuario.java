package es.vetappoint.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Clave")
    private String clave;
    @Column(name = "Email")
    private String email;
    @Column(name = "Tlf")
    private String tlf;
    @Column(name = "Dni")
    private String dni;
    @Column(name = "Linea_1")
    private String dir1;
    @Column(name = "Linea_2")
    private String dir2;
    @Column(name = "Localidad")
    private String localidad;
    @Column(name = "CP")
    private String cp;
    @Column(name = "Provincia")
    private String provincia;
    private String rol;
    private static final Long serialVersionUID=1L;


    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String clave, String email, String tlf, String dni, String dir1, String dir2, String localidad, String cp, String provincia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.clave = clave;
        this.email = email;
        this.tlf = tlf;
        this.dni = dni;
        this.dir1 = dir1;
        this.dir2 = dir2;
        this.localidad = localidad;
        this.cp = cp;
        this.provincia = provincia;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDir1() {
        return dir1;
    }

    public void setDir1(String dir1) {
        this.dir1 = dir1;
    }

    public String getDir2() {
        return dir2;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
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


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", clave='" + clave + '\'' +
                ", email='" + email + '\'' +
                ", tlf='" + tlf + '\'' +
                ", dni='" + dni + '\'' +
                ", dir1='" + dir1 + '\'' +
                ", dir2='" + dir2 + '\'' +
                ", localidad='" + localidad + '\'' +
                ", cp='" + cp + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
