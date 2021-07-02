package pe.regioncusco.ivcumbre.evento;

import javax.persistence.*;

@Entity
@Table(name = "participante")
public class ParticipateEntity {
    @Id
    @Column(name = "pa_ndoc")
    private String ndocumento;

    @Column(name = "pa_nombres")
    private String nombres;

    @Column(name = "pa_cargo")
    private String cargo;

    @Column(name = "pa_ciudad")
    private String ciudad;

    public String getNdocumento() {
        return ndocumento;
    }

    public void setNdocumento(String ndocumento) {
        this.ndocumento = ndocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
