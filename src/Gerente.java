public class Gerente extends Empregado implements Bonus{
    double salario;
    double bonus;

    // Construtor
    public Gerente(String nome, String cpf, String matricula, double salario, double bonus){
        super(nome, cpf, matricula);
        this.salario = salario;
        this.bonus = bonus;

    }

    // Metodos
    public double calcularBonus(){
        return salario * bonus ;
    }


    
}
