package pe.regioncusco.ivcumbre.evento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.regioncusco.ivcumbre.common.Tpl;
import pe.regioncusco.ivcumbre.common.Utils;
import pe.regioncusco.ivcumbre.config.AccessTokenImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
    private static final Logger LOG = LoggerFactory.getLogger(AsistenciaServiceImpl.class);

    @Autowired
    private AccessTokenImpl accessToken;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Override
    public Tpl guardarAsistencia(String ndoc) {
        if(!verifyAccount()){
            return Utils.tpl(false, "anonymousUser");
        }

        ParticipateEntity participateEntity = participanteRepository.findById(ndoc).orElse(null);
        if(participateEntity == null){
            return Utils.tpl(false, "Nro doc. " + ndoc + " no esta registrado.");
        }
        AsistenciaEntity newAsist = new AsistenciaEntity();
        newAsist.setParticipante(participateEntity);
        newAsist.setFechaRegistro(new Date());
        newAsist.setUsuario(accessToken.getUserId());

        AsistenciaEntity asistenciaEntity = asistenciaRepository.save(newAsist);
        if(asistenciaEntity == null){
            return Utils.tpl(false, "Error al registrar asistencia. Intente mas tarde.");
        }
        AsistenciaDto asisDto = new AsistenciaDto(asistenciaEntity.getId(), asistenciaEntity.getParticipante(), asistenciaEntity.getFechaRegistro());
        List<AsistenciaDto> list = new ArrayList<>();
        list.add(asisDto);
        return Utils.tpl(true, list, 1);
    }

    private boolean verifyAccount() {
        if(accessToken.getPrincipal().equals("anonymousUser")){
            LOG.warn("Account anonymousUser");
            return false;
        }
        return true;
    }
}
