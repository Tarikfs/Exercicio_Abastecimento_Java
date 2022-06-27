package model;

public class Veiculo {

    public int chassi;
    public String tipoDeVeiculo;
    public int combustivelAtual;
    public int capacidadeMaxima;
    public String combustivel;

    public Veiculo(int chassi, String tipoDeVeiculo, int combustivelAtual, int capacidadeMaxima,
            String combustivel) {
        this.chassi = chassi;
        this.tipoDeVeiculo = tipoDeVeiculo;
        this.combustivelAtual = combustivelAtual;
        this.capacidadeMaxima = capacidadeMaxima;
        this.combustivel = combustivel;
    }

    public String toString() {
        return "Veiculo " + ", chassi= " + chassi + ", combustivel= " + combustivel
                + ", tipoDeVeiculo= " + tipoDeVeiculo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getTipoDeVeiculo() {
        return tipoDeVeiculo;
    }

    public void setTipoDeVeiculo(String tipoDeVeiculo) {
        this.tipoDeVeiculo = tipoDeVeiculo;
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public int getCombustivelAtual() {
        return combustivelAtual;
    }

    public void setCombustivelAtual(int combustivelAtual) {
        this.combustivelAtual = combustivelAtual;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

}
