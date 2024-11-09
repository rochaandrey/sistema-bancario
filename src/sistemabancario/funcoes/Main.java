package sistemabancario.funcoes;

public class Main {
    public static void main(String[] args) {
        int i;
        do{
            ViewModel.gui();
            i = ViewModel.menu();

        }while(i < 5);
    }
}
