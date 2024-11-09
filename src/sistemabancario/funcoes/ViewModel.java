package sistemabancario.funcoes;

import java.util.Scanner;

import static sistemabancario.funcoes.ClienteTeste.*;

public interface ViewModel {

    static void gui(){
        ViewModel.linhas();

        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Retirar");
        System.out.println("4 - Verificar saldo");
        System.out.println("5 - Sair");
    }

    static void linhas(){
        for(int i=0;i<50;i++){
            System.out.println();
        }
    }

    static int menu(){
        Scanner scanner = new Scanner(System.in);

        try {
            String entrada = scanner.nextLine();
            int num = Integer.parseInt(entrada);

            ViewModel.linhas();

            if (num == 1) {
                criarConta();
                return 1;
            } else if (num == 2) {
                depositar();
                return 2;
            } else if (num == 3) {
                retirar();
                return 3;
            } else if (num == 4) {
                verSaldo();
                return 4;
            } else if (num == 5){
                return 5;
            } else {
                System.out.println("Opção inválida! Digite um número entre 1 e 5.");
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Digite apenas números");
            scanner.nextLine();
            return 0;
        }
    }
}
