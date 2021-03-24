import static javax.swing.JOptionPane.*;

import java.util.ArrayList;

import static java.lang.Integer.*;

public class Principal {
    public static void main(String[] args) {

        
        ArrayList<Pessoa> lista = new ArrayList<>();
        
        

        int opcao;
        String tipo;

        do {
            opcao = parseInt(showInputDialog(mostrarMenu()));

            switch(opcao){
                case 1: // 1. Cadastrar Empregado
                    do{
                        tipo = showInputDialog(null, "O cadastro será para Gerente ou Vendedor?");
                    } while(!tipo.equalsIgnoreCase("Gerente") && !tipo.equalsIgnoreCase("Vendedor"));

                    if(tipo.equalsIgnoreCase("Gerente")){
                        //inputs
                        String nome = showInputDialog("Digite o nome do Gerente: ");
                        String cpf = showInputDialog("Digite o CPF do Gerente: ");
                        double salario = Double.parseDouble(showInputDialog("Digite seu salário"));
                        double bonus = Double.parseDouble(showInputDialog("Digite seu bonus"));
                        String matricula = showInputDialog("Digite a matricula: ");
                        
                        //Instancia um objeto de Gerente na lista
                        lista.add(new Gerente(nome, cpf, matricula, salario, bonus));

                    } else {
                        //inputs
                        String nome = showInputDialog("Digite o nome do Vendedor: ");
                        String cpf = showInputDialog("Digite o CPF do Vendedor: ");
                        double totalDasVendas = Double.parseDouble(showInputDialog("Digite seu Total de Vendas"));
                        double comissao = Double.parseDouble(showInputDialog("Digite sua Comissão: "));
                        String matricula = showInputDialog("Digite a matricula: ");
                        
                        //Instancia um objeto de Vendedor na lista
                        lista.add(new Vendedor(nome, cpf, matricula, totalDasVendas, comissao));

                    }

                break;

                case 2: // 2. Cadastrar Cliente
                    
                    //inputs
                    String nome = showInputDialog("Digite o nome do Cliente: ");
                    String cpf = showInputDialog("Digite o CPF do Cliente: ");
                    double valorDivida = Double.parseDouble(showInputDialog("Digite o valor da Dívida: "));
                    
                    //Instancia um objeto de Cliente na lista
                    lista.add(new Cliente(nome, cpf, valorDivida));

                break;

                case 3: // 3. Pesquisar
                    String cpfProcurado = showInputDialog("Digite o CPF do Cliente: ");
                    pesquisarCpf(cpfProcurado, lista);

                break;
                case 4: // 4. Listar Empregados
                listarEmpregados(lista);
                break;
                case 5: // 5. Listar Cliente
                listarClientes(lista);
                break;
                case 6: // 6. Remover
                String cpfRemocao = showInputDialog("Insira o CPF da pessoa a ser removida do sistema:");
                remover(lista, cpfRemocao);
                break;
                case 7: // É necessário colocar o caso 7 para não cair em default
                //o vazio ocupando espaço aqui
                break;

                default:
                    showMessageDialog(null, "Opção Inválida!");
            }
        } while(opcao != 7);
        
    }

    public static String mostrarMenu(){
        String tela = "Escolha uma operação:\n";
        tela += "1. Cadastrar Empregado\n";
        tela += "2. Cadastrar Cliente\n";
        tela += "3. Pesquisar\n";
        tela += "4. Listar Empregados\n";
        tela += "5. Listar Clientes\n";
        tela += "6. Remover\n";
        tela += "7. Finalizar";

        return tela;
    }


    public static void pesquisarCpf(String cpf, ArrayList<Pessoa> lista){
        String classe = "";
        
        for(Pessoa p : lista){
            if( p.cpf.equals(cpf) ){
                classe = p.getClass().getName();
                break;
            }
        }

        if(classe.length() == 0){
            showMessageDialog(null, "Não foi encontrado nenhum CPF como este.");
        } else{
            if(classe.equalsIgnoreCase("Cliente")){
                showMessageDialog(null, "A pessoa encontrada é um Cliente.");
            } else {
                showMessageDialog(null, "A pessoa encontrada é um Empregado.");
            }
        }

        
    }

    public static void listarEmpregados(ArrayList<Pessoa> pessoas) {
        String lista = "";
        String classe = "";

        for(Pessoa jk : pessoas) {
            classe = jk.getClass().getName();
            
            if(classe.equalsIgnoreCase("vendedor") || classe.equalsIgnoreCase("gerente")){
                lista += jk + "\n";
            }
        }

        showMessageDialog(null, lista);
    }

    public static void listarClientes(ArrayList<Pessoa> pessoas) {
        String lista = "";
        String classe = "";

        for(Pessoa jk : pessoas) {
            classe = jk.getClass().getName();

            if(classe.equalsIgnoreCase("cliente")) {
                lista += jk + "\n";
            }
        }

        showMessageDialog(null, lista);
    }

    public static void remover(ArrayList<Pessoa> pessoas, String cpf) {
        int index = 0;

        for(Pessoa jk : pessoas) {
            if(jk.cpf.equals(cpf)) {
                index = pessoas.indexOf(jk);

                pessoas.remove(index);

                break;
            }
        }
        

    }
}
