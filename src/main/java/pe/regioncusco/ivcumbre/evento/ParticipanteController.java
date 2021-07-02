package pe.regioncusco.ivcumbre.evento;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.regioncusco.ivcumbre.common.Tpl;
import pe.regioncusco.ivcumbre.common.Utils;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

    @GetMapping("/listar")
    @RolesAllowed("sintomatologia_personal")
    @ResponseStatus(HttpStatus.OK)
    public Tpl listarParticipantes(){
        return Utils.tpl(true, "ok");
    }
}
