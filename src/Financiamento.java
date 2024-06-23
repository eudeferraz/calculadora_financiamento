
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
        System.out.println(amortizacaoMensal);

        // taxa juros mensal
        double taxaJurosMensal = (taxaJurosAnual / 100) / 12;
        System.out.println(taxaJurosMensal);

        // juros sobre cada parcela
        double parcelaJurosMensal = valorFinanciamento * taxaJurosMensal;
        System.out.println(parcelaJurosMensal);

        // calcula pagamento total ao mês
        double pagamentoMensal = parcelaJurosMensal + amortizacaoMensal;
        System.out.println(pagamentoMensal);

        return pagamentoMensal;
    }

    // metodo para calcular o total do pagamento
    public double calcularTotalPagamento(double valorFinanciamento, double taxaJurosAnual) {
        
        double pagamentoTotal = valorFinanciamento + valorFinanciamento * (taxaJurosAnual/100);
        return pagamentoTotal;
    }
}
