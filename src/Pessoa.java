public class Pessoa {
    String nome;
    String cpf;

    // { MÉTODOS }
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf; 
    }

    public String toString() {
        return "Nome: " + nome + " | CPF: " + cpf;
    }
}
