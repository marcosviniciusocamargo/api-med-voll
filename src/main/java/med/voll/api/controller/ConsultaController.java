package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.ConsultaDTO;
import med.voll.api.domain.consulta.ConsultaDTOCancela;
import med.voll.api.domain.consulta.ConsultaDTODetalhado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid ConsultaDTO dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new ConsultaDTODetalhado(null, null, null, null));
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody @Valid ConsultaDTOCancela dados){
        agenda.cancela(dados);
        return ResponseEntity.ok().build();
    }

}
