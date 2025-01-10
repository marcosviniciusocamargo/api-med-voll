package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaDTO;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsultas{
    public void validar(ConsultaDTO dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferenca = Duration.between(dataConsulta, agora).toMinutes();
        if (diferenca < 30){
            throw new ValidacaoException("A agenda deve ser realizada com pelo menos " +
                    "30 minutos de antecedência!");
        }
    }
}
