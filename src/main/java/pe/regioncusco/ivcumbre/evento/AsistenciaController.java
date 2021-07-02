package pe.regioncusco.ivcumbre.evento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.regioncusco.ivcumbre.common.Tpl;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
    @Autowired
    private AsistenciaService asistenciaService;

    @PostMapping("/registrar/{ndoc}")
    @RolesAllowed("sintomatologia_personal")
    @ResponseStatus(HttpStatus.CREATED)
    public Tpl registrarEncuestaDetalle(@PathVariable String ndoc){
        return asistenciaService.guardarAsistencia(ndoc);
    }

}
