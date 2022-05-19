package es.vetappoint.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "historial_veterinario")
@Table(name = "historial_veterinario")
public class HistorialVet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idHistorial_Veterinario", nullable = false)
    private Long id;
    private Long idMascota;
    private Long idVeterinario;
    @Column(name = "Procedimiento")
    private String procedimiento;

    public HistorialVet() {

    }

    public HistorialVet(Long id, Long idMascota, Long idVeterinario, String procedimiento) {
        this.id = id;
        this.idMascota = idMascota;
        this.idVeterinario = idVeterinario;
        this.procedimiento = procedimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Long getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    @Override
    public String toString() {
        return "HistorialVeterinario{" +
                "id=" + id +
                ", idMascota=" + idMascota +
                ", idVeterinario=" + idVeterinario +
                ", procedimiento='" + procedimiento + '\'' +
                '}';
    }
}
