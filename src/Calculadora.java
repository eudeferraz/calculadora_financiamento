public class Calculadora {

    public static double calcularPagamentoMensal(double valorFinanciamento, int duracaoFinanciamento,
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
}
