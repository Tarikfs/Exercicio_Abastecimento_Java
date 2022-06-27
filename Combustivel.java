package model;
public class Combustivel {

    private int id;
    public String tipoDeCombustivel;
    public int quantidadeMaxima;
    public int quantidadeAtual;

    public Combustivel(int id, String tipoDeCombustivel, int quantidadeMaxima, int quantidadeAtual) {
        this.id = id;
        this.tipoDeCombustivel = tipoDeCombustivel;
        this.quantidadeMaxima = quantidadeMaxima;
        this.quantidadeAtual = quantidadeAtual;
    }

    public String toString() {
        return "Combustivel id= " + id + ", tipoDeCombustivel= " + tipoDeCombustivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDeCombustivel() {
        return tipoDeCombustivel;
    }

    public void setTipoDeCombustivel(String tipoDeCombustivel) {
        this.tipoDeCombustivel = tipoDeCombustivel;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public int getCombustivel() {
        return 0;
    }

}
