package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteDTOCadastro;

public record PacienteDTODetalhado(Long id, String nome, String email, String telefone,
                                   String cpf, Endereco endereco, Boolean ativo) {
    public PacienteDTODetalhado(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(),
                paciente.getCpf(), paciente.getEndereco(), paciente.getAtivo());
    }
}
