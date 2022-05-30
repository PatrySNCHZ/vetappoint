package es.vetappoint.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "historial_veterinario")
public class HistorialVet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_historialvet", nullable = false)
    private Long id;


    @Column(name = "Procedimiento")
    private String procedimiento;

    @ManyToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="id_mascotas")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Mascota mascota;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_veterinario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Veterinario veterinario;

    public HistorialVet() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }


    @Override
    public String toString() {
        return "HistorialVet{" +
                "id=" + id +
                ", procedimiento='" + procedimiento + '\'' +
                ", mascota=" + mascota +
                ", veterinario=" + veterinario +
                '}';
    }

}
