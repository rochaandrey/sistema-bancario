package sistemabancario.funcoes;

import sistemabancario.objetos.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteTeste {
    static List<Cliente> arrayClientes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static String nome;
    private static String cpf;
    private static double saldo;
    private static boolean encontrado;

    public static void criarConta(){
        verificacaoBasica();

        Cliente cliente = new Cliente(nome, cpf);
        arrayClientes.add(cliente);

        System.out.println("Conta criada para "+nome);
        scanner.nextLine();
    }

    public static void depositar(){
        verificacaoBasica();

        Cliente cliente = new Cliente(nome, cpf);
        if(!arrayClientes.contains(cliente)){
            System.out.println("Esse cliente não existe no banco de dados");
            scanner.nextLine();
            return;
        }

        System.out.print("Digite a quantidade do seu depósito: ");
        saldo = scanner.nextDouble();

        scanner.nextLine();
        for(Cliente random : arrayClientes){
            if(random.getNome().equalsIgnoreCase(nome) && random.getCpf().equalsIgnoreCase(cpf) && saldo>=0){
                random.setSaldo(random.getSaldo()+saldo);
                System.out.println("Depósito de R$ "+String.format("%.2f",saldo)+" realizado com sucesso");

                scanner.nextLine();
                break;
            }
        }

    }

    public static void retirar(){
        verificacaoBasica();

        Cliente cliente = new Cliente(nome, cpf);
        if(!arrayClientes.contains(cliente)){
            System.out.println("Esse cliente não existe no banco de dados");
            scanner.nextLine();
            return;
        }

        System.out.print("Digite a quantidade do seu saque: ");
        saldo = scanner.nextDouble();

        scanner.nextLine();
        for(Cliente random : arrayClientes){
            if(random.getNome().equalsIgnoreCase(nome) && random.getCpf().equalsIgnoreCase(cpf)){
                if( saldo > random.getSaldo()){
                    System.out.println("você possui somente R$"+String.format("%.2f",random.getSaldo())+"!\nDigite uma quantia válida!");
                    scanner.nextLine();
                    retirar();
                }
                random.setSaldo(random.getSaldo()-saldo);
                System.out.println("Saque de R$"+String.format("%.2f",saldo)+" realizado com sucesso.");
                scanner.nextLine();
                break;
            }
        }
    }

    public static void verSaldo(){
        verificacaoBasica();

        Cliente cliente = new Cliente(nome, cpf);
        if(!arrayClientes.contains(cliente)){
            System.out.println("Esse cliente não existe no banco de dados");
            scanner.nextLine();
            return;
        }

        for(Cliente random : arrayClientes){
            if(random.getNome().equalsIgnoreCase(nome) && random.getCpf().equalsIgnoreCase(cpf)){
                System.out.println("Saldo atual: "+String.format("%.2f",random.getSaldo()));
                break;
            }
        }
        scanner.nextLine();
    }

    public static void verificacaoBasica(){
        System.out.print("Digite o nome do TITULAR da conta: ");
        nome = scanner.nextLine();
        do{
            System.out.print("Digite o CPF do TITULAR: ");
            cpf = scanner.nextLine().replaceAll("[^0-9]","");
        }while(cpf.length()!=11);
    }
}
