package pe.regioncusco.ivcumbre.evento;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class AsistenciaDto {
    private Long id;
    private ParticipateEntity participante;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="America/Lima")
    private Date fechaRegistro;

    public AsistenciaDto() {
    }

    public AsistenciaDto(Long id, ParticipateEntity participante, Date fechaRegistro) {
        this.id = id;
        this.participante = participante;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParticipateEntity getParticipante() {
        return participante;
    }

    public void setParticipante(ParticipateEntity participante) {
        this.participante = participante;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
