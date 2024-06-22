import java.awt.event.*;
import javax.swing.*;

public class TelaUsuario {

    // componentes da tela
    private JFrame frame;
    private JComboBox tipoImovelInput;
    private JTextField valorFinanciamentoInput;
    private JTextField taxaJurosAnualInput;
    private JTextField duracaoFinanciamentoInput;
    private JButton btnSimular;
    private JLabel resultado;

    // entradas
    private JLabel tipoImovelLabel;
    private JLabel valorFinanciamentoLabel;
    private JLabel taxaJurosAnualLabel;
    private JLabel duracaoFinanciamentoLabel;

    // metodo para exibir a tela de input para o usuário
    public void exibir() {

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
        btnSimular.setBounds(100, 300, 89,23);
        btnSimular.addActionListener(new CalcularListener());
        frame.getContentPane().add(btnSimular);

        resultado = new JLabel("");
        resultado.setBounds(100, 200, 250,23);
        frame.getContentPane().add(resultado);

        frame.setVisible(true);

    }

    

    // classe para pegar os dados e calcular o resultado
    private class CalcularListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // variáveis da tela
            String tipoImovel = (String) tipoImovelInput.getSelectedItem();
            double valorFinanciamento = Double.parseDouble(valorFinanciamentoInput.getText());
            double taxaJurosAnual = Double.parseDouble(taxaJurosAnualInput.getText());
            int duracaoFinanciamento = Integer.parseInt(duracaoFinanciamentoInput.getText());

            double pagamentoMensal = Calculadora.calcularPagamentoMensal(valorFinanciamento, duracaoFinanciamento, taxaJurosAnual);
            resultado.setText("Parcelas mensais: $" + Math.floor(pagamentoMensal));
        }

    }

}
