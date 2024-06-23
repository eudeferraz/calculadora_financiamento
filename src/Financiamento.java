
public class Financiamento {

    // variáveis
    private double valorImovel, taxaJurosAnual;
    private int prazoFinanciamento;

    // construtor
    public Financiamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    // metodo para calcular pagamento mensal
    public double calcularPagamentoMensal(double valorFinanciamento, int duracaoFinanciamento,
            double taxaJurosAnual) {

        // amortização mensal
        double amortizacaoMensal = valorFinanciamento / duracaoFinanciamento;

        // taxa juros mensal
        double taxaJurosMensal = (taxaJurosAnual / 100) / 12;

        // juros sobre cada parcela
        double parcelaJurosMensal = valorFinanciamento * taxaJurosMensal;

        // calcula pagamento total ao mês
        double pagamentoMensal = parcelaJurosMensal + amortizacaoMensal;

        System.out.println(pagamentoMensal * duracaoFinanciamento);

        // retorna o total do pagamento mensal
        return pagamentoMensal;
    }

    // metodo para calcular o total do pagamento
    public double calcularTotalPagamento(double valorFinanciamento, double taxaJurosAnual) {
        // calcula o total dos juros
        double juros = valorFinanciamento * (taxaJurosAnual/100);
        
        // calcula o total do pagamento + juros
        double pagamentoTotal = valorFinanciamento + juros;
        
        //retorna o valor
        return pagamentoTotal;
    }
}
