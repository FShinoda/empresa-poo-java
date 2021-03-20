
public class Pessoa {
    String nome;
    String cpf;

    /* MÉTODOS */
    // Construtor
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf; 
    }

    // Sobrescrever 'toString()'
    public String toString() {
        return "Nome: " + nome + " | CPF: " + cpf;
    }
}
