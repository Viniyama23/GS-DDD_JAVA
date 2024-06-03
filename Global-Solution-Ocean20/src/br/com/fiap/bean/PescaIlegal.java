package br.com.fiap.bean;

//RM:550908 - Vinicius Santos Yamashita de Farias
//RM:99874 - Rafael Carvalho Mattos

import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 * Classe que representa uma instância de PescaIlegal, contendo informações sobre a pesca ilegal.
 */
public class PescaIlegal {
    private String coordenada;
    private int numeroDeEmbarcacoes;
    private int tempoDePermanecia;
    private String identificacao;
    private int velocidade;
    private int distanciaCosta;
    private int totalPeixes;

    /**
     * Construtor padrão de PescaIlegal.
     */
    public PescaIlegal() {}

    /**
     * Construtor de PescaIlegal com todos os parâmetros.
     * 
     * @param coordenada A coordenada da pesca ilegal.
     * @param numeroDeEmbarcacoes O número de embarcações presentes.
     * @param tempoDePermanecia O tempo de permanência em minutos.
     * @param identificacao A identificação da pesca ilegal.
     * @param velocidade A velocidade da embarcação.
     * @param distanciaCosta A distância da costa.
     */
    public PescaIlegal(String coordenada, int numeroDeEmbarcacoes, int tempoDePermanecia, String identificacao, int velocidade, int distanciaCosta) {
        this.coordenada = coordenada;
        this.numeroDeEmbarcacoes = numeroDeEmbarcacoes;
        this.tempoDePermanecia = tempoDePermanecia;
        this.identificacao = identificacao;
        this.velocidade = velocidade;
        this.distanciaCosta = distanciaCosta;
    }

    // Métodos getters e setters

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public int getNumeroDeEmbarcacoes() {
        return numeroDeEmbarcacoes;
    }

    public void setNumeroDeEmbarcacoes(int numeroDeEmbarcacoes) {
    	try {
			if (numeroDeEmbarcacoes >= 1) {
				this.numeroDeEmbarcacoes = numeroDeEmbarcacoes;
			} else {
				throw new Exception("Valor inválido !!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    public int getTempoDePermanecia() {
        return tempoDePermanecia;
    }

    public void setTempoDePermanecia(int tempoDePermanecia) {
        try {
			if (tempoDePermanecia >= 1) {
				this.tempoDePermanecia = tempoDePermanecia;
			} else {
				throw new Exception("Valor inválido !!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        try {
			if (velocidade >= 1) {
				this.velocidade = velocidade;
			} else {
				throw new Exception("Valor inválido !!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    public int getDistanciaCosta() {
        return distanciaCosta;
    }

    public void setDistanciaCosta(int distanciaCosta) {
        try {
			if (distanciaCosta >= 1) {
				this.distanciaCosta = distanciaCosta;
			} else {
				throw new Exception("Valor inválido !!!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
        
    }

    public int getTotalPeixes() {
        return totalPeixes;
    }

    // Métodos

    /**
     * Método para exibir alerta para instituição de fiscalização.
     * 
     * @param tempoDePermanecia Tempo de permanência da embarcação.
     * @param numeroDeEmbarcacoes Número de embarcações no local.
     * @param velocidade Velocidade da embarcação.
     * @param distanciaCosta Distância da embarcação até a costa.
     * @return 
     */
    public PescaIlegal emiteAlerta(int tempoDePermanecia, int numeroDeEmbarcacoes, int velocidade, int distanciaCosta) {
        if (tempoDePermanecia >= 30 || numeroDeEmbarcacoes > 0 || velocidade <= 7 || distanciaCosta < 30) {
            JOptionPane.showMessageDialog(null, "ALERTA !!! Pesca ilegal" + 
            									"\nEmbarcação a " + tempoDePermanecia + " minutos" +
            									"\nExiste " + numeroDeEmbarcacoes + " embarcações no local" + 
            									"\nEstão a " + velocidade + " nós" + 
            									"\nEstão a " + distanciaCosta + " metros da costa");
        }
		return null;
    }

    /**
     * Método para retornar a data atual.
     * 
     * @return Data atual.
     */
    public LocalDate diaHoje() {
        return LocalDate.now();
    }

    /**
     * Método para registrar a quantidade de peixe de qualquer tipo.
     * 
     * @param quantidade Quantidade de peixes.
     * @param tipoPeixe Tipo de peixe.
     * @param pesca Indicador de pesca ilegal.
     */
    public void registrarPeixe(int quantidade, String tipoPeixe, int pesca) {
        JOptionPane.showMessageDialog(null, "Existem " + quantidade + " de " + tipoPeixe);
    }

    /**
     * Método de sobrecarga para registrar a quantidade de garoupa pescado.
     * 
     * @param quantidade Quantidade de garoupas.
     * @param pesca Indicador de pesca ilegal.
     */
    public void registrarPeixe(int quantidade, int pesca) {
        JOptionPane.showMessageDialog(null, "Existem " + quantidade + " de Garoupas");
    }

    /**
     * Método de sobrescrita para retornar o dia formatado como String.
     * 
     * @return Data atual formatada.
     */
    public String diaFormatado() {
        return LocalDate.now().toString();
    }

    /**
     * Método para atualizar a fauna de peixes.
     * 
     * @param quantidade A quantidade de peixes a ser adicionada ou subtraída.
     */
    public void atualizarFaunaPeixes(int quantidade) {
        totalPeixes += quantidade;
        if (quantidade > 0) {
            JOptionPane.showMessageDialog(null, "Adicionando " + Math.abs(quantidade) + " peixes");
        } else if (quantidade < 0) {
            JOptionPane.showMessageDialog(null, "Removendo " + Math.abs(quantidade) + " peixes");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma alteração na fauna de peixes.");
        }
    }
}
