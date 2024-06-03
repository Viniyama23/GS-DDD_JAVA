package br.com.fiap.main;

//RM:550908 - Vinicius Santos Yamashita de Farias
//RM:99874 - Rafael Carvalho Mattos

import javax.swing.JOptionPane;
import br.com.fiap.bean.PescaIlegal;

/**
 * Classe principal para interação com a classe PescaIlegal, permitindo ao usuário escolher entre fazer uma queixa de embarcação ilegal ou atualizar a fauna de peixes.
 */
public class UsaPescaIlegal {
    /**
     * Método principal para execução do programa.
     * 
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // Loop para permitir que o usuário escolha entre fazer uma queixa de embarcação ilegal ou atualizar a fauna de peixes
        while (true) {
            // Menu de opções
            String[] opcoes = {"Fazer queixa de embarcação ilegal", "Atualizar fauna de peixes", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            // Verifica a escolha do usuário
            switch (escolha) {
                case 0: // Fazer queixa de embarcação ilegal
                    fazerQueixaEmbarcacaoIlegal();
                    break;
                case 1: // Atualizar fauna de peixes
                    atualizarFaunaPeixes();
                    break;
                case 2: // Sair do programa
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;
            }
        }
    }

    /**
     * Método para fazer a queixa de uma embarcação ilegal.
     */
    private static void fazerQueixaEmbarcacaoIlegal() {
        // Solicita ao usuário que insira os detalhes da pesca ilegal
        String coordenada = JOptionPane.showInputDialog("Digite a coordenada:");
        int numeroDeEmbarcacoes = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de embarcações:"));
        int tempoDePermanecia = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de permanência (minutos):"));
        String identificacao = JOptionPane.showInputDialog("Digite a identificação:");
        int velocidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a velocidade (nós):"));
        int distanciaCosta = Integer.parseInt(JOptionPane.showInputDialog("Digite a distância da costa (metros):"));

        // Cria um objeto PescaIlegal com os detalhes fornecidos pelo usuário
        PescaIlegal pescaIlegal = new PescaIlegal(coordenada, numeroDeEmbarcacoes, tempoDePermanecia, identificacao, velocidade, distanciaCosta);

        //Exibe o alerta com as especificações em uma janela
        exibirDetalhesPescaIlegal(pescaIlegal.emiteAlerta(tempoDePermanecia, numeroDeEmbarcacoes, velocidade, distanciaCosta));
    }

    /**
     * Método para atualizar a fauna de peixes.
     */
    private static void atualizarFaunaPeixes() {
        // Solicita ao usuário que insira os detalhes da atualização da fauna de peixes
        int quantidadePeixe = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de peixe a ser atualizada:"));
        String tipoPeixe = JOptionPane.showInputDialog("Digite o tipo de peixe:");

        // Verifica se a quantidade de peixes é positiva ou negativa para realizar a operação correspondente
        if (quantidadePeixe > 0) {
            JOptionPane.showMessageDialog(null, "Adicionando " + Math.abs(quantidadePeixe) + " " + tipoPeixe);
        } else if (quantidadePeixe < 0) {
            JOptionPane.showMessageDialog(null, "Removendo " + Math.abs(quantidadePeixe) + " " + tipoPeixe);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma alteração na fauna de peixes.");
        }

        // Verifica se a quantidade de peixes está abaixo de 100 e exibe uma janela de alerta se necessário
        if (quantidadePeixe < 100) {
            JOptionPane.showMessageDialog(null, "Alerta: Quantidade de peixes está abaixo de 100!");
        }

        // Exibe os detalhes da atualização da fauna de peixes em uma janela
        exibirDetalhesAtualizacaoFaunaPeixes(quantidadePeixe, tipoPeixe);
    }

    /**
     * Método para exibir os detalhes da pesca ilegal em uma janela.
     * 
     * @param pescaIlegal Objeto PescaIlegal contendo os detalhes da pesca ilegal.
     */
    private static void exibirDetalhesPescaIlegal(PescaIlegal pescaIlegal) {
        String mensagem = "Detalhes da pesca ilegal:\n\n" +
                          "Coordenada: " + pescaIlegal.getCoordenada() + "\n" +
                          "Número de embarcações: " + pescaIlegal.getNumeroDeEmbarcacoes() + "\n" +
                          "Tempo de permanência: " + pescaIlegal.getTempoDePermanecia() + " minutos\n" +
                          "Identificação: " + pescaIlegal.getIdentificacao() + "\n" +
                          "Velocidade: " + pescaIlegal.getVelocidade() + " nós\n" +
                          "Distância da costa: " + pescaIlegal.getDistanciaCosta() + " metros";
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Método para exibir os detalhes da atualização da fauna de peixes em uma janela.
     * 
     * @param quantidadePeixe Quantidade de peixes.
     * @param tipoPeixe Tipo de peixe.
     */
    private static void exibirDetalhesAtualizacaoFaunaPeixes(int quantidadePeixe, String tipoPeixe) {
        String mensagem = "Detalhes da atualização da fauna de peixes:\n\n" +
                          "Quantidade de peixe: " + quantidadePeixe + "\n" +
                          "Tipo de peixe: " + tipoPeixe;
        JOptionPane.showMessageDialog(null, mensagem);
    }
}