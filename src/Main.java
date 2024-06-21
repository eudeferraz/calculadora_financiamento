import java.util.Scanner;
public class Main {

    public static void main(String[] args) {      
        // declaração das variáveis
        double valorFinanciamento, taxaJurosAnual, parcelasMensais;
        int duracaoFinanciamento;
        String tipoImovel;

        TelaUsuario telaUsuario = new TelaUsuario();
        telaUsuario.exibir();
        
        Scanner scanner = new Scanner (System.in);

        System.out.println("Qual o tipo do imovel? Casa, terreno ou Apartamento: ");
        tipoImovel = scanner.next();
        
        System.out.println("Insira o valor total do imovel: ");
        valorFinanciamento = scanner.nextDouble();
        
        System.out.println("Insira a taxa de juros (%): ");
        taxaJurosAnual = scanner.nextDouble();
        
        System.out.println("Insira a duracao do financiamento (em meses): ");
        duracaoFinanciamento = scanner.nextInt();

        scanner.close();

       parcelasMensais = Calculadora.calcularPagamentoMensal(valorFinanciamento, duracaoFinanciamento, taxaJurosAnual);
        
        System.out.println("valor total ao mes: $" + Math.round(parcelasMensais));

    }
}