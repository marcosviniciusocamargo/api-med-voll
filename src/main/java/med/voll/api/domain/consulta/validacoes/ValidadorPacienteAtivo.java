package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaDTO;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas{
    @Autowired
    private PacienteRepository repository;

    public void validar(ConsultaDTO dados){
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído!");
        }
    }
}
