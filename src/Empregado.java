
public class Empregado extends Pessoa {
    String matricula;

    // Método Construtor
    public Empregado(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }
}
