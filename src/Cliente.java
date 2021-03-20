
public class Cliente extends Pessoa {
    double valorDaDivida;

    // Método Construtor
    public Cliente(String nome, String cpf, double valorDivida) {
        super(nome, cpf);
        valorDaDivida = valorDivida;
    }
}
