package br.com.compras.modelo;

public class Produto {

    private String descricao;
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "%s - R$ %.2f".formatted(descricao, valor);
    }
}
