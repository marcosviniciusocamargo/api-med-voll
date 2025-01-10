package med.voll.api.domain.paciente;

public record PacienteDTOListagem(Long id, String nome, String email, String cpf) {

    public PacienteDTOListagem(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
