import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaUsuario {

    // componentes da tela
    private JFrame frame;
    private JComboBox tipoImovelInput;
    private JTextField valorFinanciamentoInput;
    private JTextField taxaJurosAnualInput;
    private JTextField duracaoFinanciamentoInput;
    private JButton btnSimular;
    private JTextArea resultado;

    // entradas
    private JLabel tipoImovelLabel;
    private JLabel valorFinanciamentoLabel;
    private JLabel taxaJurosAnualLabel;
    private JLabel duracaoFinanciamentoLabel;

    private void limpar() {
        tipoImovelInput.setSelectedItem("Selecione");
        valorFinanciamentoInput.setText(null);
        taxaJurosAnualInput.setText(null);
        duracaoFinanciamentoInput.setText(null);

    }

    // metodo para exibir a tela de input para o usuário
    public void exibir() {

        try {

            frame = new JFrame("Simulador de Financiamento");
            frame.setBounds(100, 100, 730, 489);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            tipoImovelLabel = new JLabel("Tipo do Imóvel");
            tipoImovelLabel.setBounds(65, 31, 247, 14);
            frame.getContentPane().add(tipoImovelLabel);

            tipoImovelInput = new JComboBox();
            tipoImovelInput.addItem("Selecione");
            tipoImovelInput.addItem("Casa");
            tipoImovelInput.addItem("Terreno");
            tipoImovelInput.addItem("Apartamento");
            tipoImovelInput.setBounds(188, 28, 91, 20);
            frame.getContentPane().add(tipoImovelInput);

            valorFinanciamentoLabel = new JLabel("Valor total do financiamento");
            valorFinanciamentoLabel.setBounds(65, 68, 258, 14);
            frame.getContentPane().add(valorFinanciamentoLabel);

            valorFinanciamentoInput = new JTextField();
            valorFinanciamentoInput.setBounds(248, 65, 200, 20);
            frame.getContentPane().add(valorFinanciamentoInput);
            valorFinanciamentoInput.setColumns(10);

            taxaJurosAnualLabel = new JLabel("Valor Juros Anual %");
            taxaJurosAnualLabel.setBounds(65, 115, 200, 14);
            frame.getContentPane().add(taxaJurosAnualLabel);

            taxaJurosAnualInput = new JTextField();
            taxaJurosAnualInput.setBounds(248, 112, 200, 20);
            frame.getContentPane().add(taxaJurosAnualInput);
            taxaJurosAnualInput.setColumns(10);

            duracaoFinanciamentoLabel = new JLabel("Duração do Financiamento (em meses)");
            duracaoFinanciamentoLabel.setBounds(65, 162, 250, 14);
            frame.getContentPane().add(duracaoFinanciamentoLabel);

            duracaoFinanciamentoInput = new JTextField();
            duracaoFinanciamentoInput.setBounds(315, 159, 200, 20);
            frame.getContentPane().add(duracaoFinanciamentoInput);

            btnSimular = new JButton("Calcular");
            btnSimular.setBounds(200, 410, 89, 23);
            btnSimular.addActionListener(new CalcularListener());
            frame.getContentPane().add(btnSimular);

            resultado = new JTextArea("");
            resultado.setBounds(65, 200, 600, 200);
            frame.getContentPane().add(resultado);

            frame.setVisible(true);

        } catch (Exception e) {
            System.out.println(
                    "Ocorreu um erro ao chamar o método de exibir os campos para o usuário inputar os dados solicitados: "
                            + e);

        }

    }


    // classe para pegar os dados e calcular o resultado
    private class CalcularListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                // variáveis da tela
                String tipoImovel = (String) tipoImovelInput.getSelectedItem();
                double valorFinanciamento = Double.parseDouble(valorFinanciamentoInput.getText());
                double taxaJurosAnual = Double.parseDouble(taxaJurosAnualInput.getText());
                int duracaoFinanciamento = Integer.parseInt(duracaoFinanciamentoInput.getText());

                //variaveis
                ArrayList<String> financiamentos = new ArrayList<String>();
                String mensagemFinal;

                Financiamento financiamento = new Financiamento(valorFinanciamento, taxaJurosAnual,
                        duracaoFinanciamento);

                double resultadoCalculoParcelasMensais = financiamento.calcularPagamentoMensal(valorFinanciamento,
                        duracaoFinanciamento,
                        taxaJurosAnual);

                double resultadoCalculoFinanciamentoTotal = financiamento.calcularTotalPagamento(valorFinanciamento, taxaJurosAnual);

                mensagemFinal = "Financiamento 1 - valor do imóvel: R$" + valorFinanciamento + "\nvalor do financiamento: R$" + resultadoCalculoFinanciamentoTotal + "\nvalor das parcelas mensais: R$" + resultadoCalculoParcelasMensais; 

                financiamentos.add(mensagemFinal);
                limpar();
               
                resultado.append(mensagemFinal);

            } catch (Exception ex) {
                System.out.println("Ocorreu um erro ao receber os dados de entrada do usuário: " + ex);
            }

        }

    }


}
