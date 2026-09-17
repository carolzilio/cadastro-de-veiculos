import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CadastroVeiculoService service = new CadastroVeiculoService();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1 -> System.out.println("Cadastrar (em construcao)");
                case 2 -> System.out.println("Listar (em construcao)");
                case 3 -> System.out.println("Consultar (em construcao)");
                case 0 -> System.out.println("Encerrando o sistema. Ate logo!");
                default -> System.out.println("Opcao invalida. Tente novamente.\n");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("======= Cadastro de Veiculos OO =======");
        System.out.println("1 - Cadastrar Veiculo");
        System.out.println("2 - Listar Veiculos");
        System.out.println("3 - Consultar Veiculo");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, informe um numero inteiro valido.");
            }
        }
    }
}