
public class Main {

    public static void main(String[] args) {
        // declaração das variáveis
        double valorFinanciamento, taxaJurosAnual, parcelasMensais;
        int duracaoFinanciamento;
        String tipoImovel;

        try {
            //chama a classe responsável por exibir a tela de input
            TelaUsuario telaUsuario = new TelaUsuario();
            telaUsuario.exibir();

        

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao chamar a classe responsável por exibir e calcular o financiamento (main): " + e);
        }

    }
}
