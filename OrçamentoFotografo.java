import java.util.Scanner;

public class OrçamentoFotografo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preços dos pacotes
        int pacote10 = 10;
        int pacote20 = 20;
        int pacote35 = 35;

        double precoPacote10 = 200.0;
        double precoPacote20 = 350.0;
        double precoPacote35 = 500.0;

        double precoFotoExtra = 10.0;
        double taxaEstudio = 100.0;

        // Escolha do pacote
        System.out.println("Escolha o pacote de fotos:");
        System.out.println("1 - 10 fotos (R$200)");
        System.out.println("2 - 20 fotos (R$350)");
        System.out.println("3 - 35 fotos (R$500)");
        int escolhaPacote = scanner.nextInt();

        int fotosIncluidas = 0;
        double precoBase = 0.0;

        switch (escolhaPacote) {
            case 1:
                fotosIncluidas = pacote10;
                precoBase = precoPacote10;
                break;
            case 2:
                fotosIncluidas = pacote20;
                precoBase = precoPacote20;
                break;
            case 3:
                fotosIncluidas = pacote35;
                precoBase = precoPacote35;
                break;
            default:
                System.out.println("Opção inválida. Encerrando...");
                scanner.close();
                return;
        }

        // Fotos extras
        System.out.println("Quantas fotos no total o cliente deseja?");
        int totalFotos = scanner.nextInt();
        int fotosExtras = Math.max(totalFotos - fotosIncluidas, 0);
        double valorFotosExtras = fotosExtras * precoFotoExtra;

        scanner.nextLine(); // limpar buffer
        System.out.println("Local da sessão (Externo ou Estúdio)?");
        String local = scanner.nextLine();

        boolean emEstudio = local.equalsIgnoreCase("estudio");

        // Cálculo total
        double total = precoBase + valorFotosExtras;

        if (emEstudio) {
            total += taxaEstudio;
        }

        // Saída
        System.out.println("\n--- ORÇAMENTO ESTIMADO ---");
        System.out.printf("Pacote selecionado: %d fotos (R$ %.2f)\n", fotosIncluidas, precoBase);
        System.out.printf("Fotos extras: %d (R$ %.2f)\n", fotosExtras, valorFotosExtras);
        System.out.printf("Local: %s\n", emEstudio ? "Estúdio (R$ 100,00)" : "Externo (sem taxa)");
        System.out.printf("Valor total: R$ %.2f\n", total);
        System.out.println("Forma de pagamento: 50% na reserva, 50% na entrega.");
        System.out.println("Prazo estimado de entrega: 5 dias úteis.");

        scanner.close();
    }
}
