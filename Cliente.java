package model;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

    protected String nome;
    protected String cpf;
    protected String senha;
    protected List<Veiculo> veiculoCliente;
    protected List<Combustivel> combustivelCliente;
    public Boolean clienteAutenticado;

    public Cliente(String nome, String cpf, String senha, Boolean clienteAutenticado) {
        this.veiculoCliente = new LinkedList<>();
        this.combustivelCliente = new LinkedList<>();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.clienteAutenticado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getClienteAutenticado() {
        return clienteAutenticado;
    }

    public List<Veiculo> getVeiculoCliente() {
        return veiculoCliente;
    }

    public void setVeiculoCliente(List<Veiculo> veiculoCliente) {
        this.veiculoCliente = veiculoCliente;
    }

    public void setClienteAutenticado(Boolean clienteAutenticado) {
        this.clienteAutenticado = clienteAutenticado;
    }

    public List<Combustivel> getCombustivelCliente() {
        return combustivelCliente;
    }

    public void setCombustivelCliente(List<Combustivel> combustivelCliente) {
        this.combustivelCliente = combustivelCliente;
    }

}