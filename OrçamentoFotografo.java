import java.util.Scanner;

public class OrçamentoFotografo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Valores fixos
        double precoPorHora = 150.0;
        double precoPorFotoExtra = 5.0;git
        int limiteFotosInclusas = 20;
        double taxaEstudio = 100.0;

        // Entrada de dados
        System.out.println("Quantas fotos deseja?");
        int fotos = scanner.nextInt();

        System.out.println("Quantas horas de ensaio ou evento?");
        int horas = scanner.nextInt();

        scanner.nextLine(); // limpar o buffer do scanner
        System.out.println("Local: Externo ou Estúdio?");
        String local = scanner.nextLine();

        // Cálculo
        double total = horas * precoPorHora;
        int fotosExtras = 0;
        double valorFotosExtras = 0.0;

        if (fotos > limiteFotosInclusas) {
            fotosExtras = fotos - limiteFotosInclusas;
            valorFotosExtras = fotosExtras * precoPorFotoExtra;
            total += valorFotosExtras;
        }

        if (local.equalsIgnoreCase("estudio")) {
            total += taxaEstudio;
        }

        // Saída
        System.out.println("\n--- ORÇAMENTO ESTIMADO ---");
        System.out.printf("Valor total: R$ %.2f\n", total);

        if (fotosExtras > 0) {
            System.out.printf("Fotos extras: %d (R$ %.2f)\n", fotosExtras, valorFotosExtras);
        } else {
            System.out.println("Nenhuma foto extra foi solicitada.");
        }

        System.out.println("Forma de pagamento: 50% na reserva, 50% na entrega.");
        System.out.println("Prazo estimado de entrega: 5 dias úteis.");

        scanner.close();
    }
}
