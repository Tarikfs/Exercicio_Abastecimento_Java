package service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Cliente;
import model.Veiculo;

public class LoginCliente extends CriarCliente {

    public LoginCliente(String nome, String cpf, String senha, Boolean clienteAutenticado) {
        super(nome, cpf, senha, clienteAutenticado);
    }

    public Cliente loginCliente(List<Cliente> clientes, List<Veiculo> veiculos) {

        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;

        System.out.println("****************LOGIN***************");
        System.out.println("Cpf do Cliente: ");
        String cpf = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        System.out.println("************************************");

        List<Cliente> clienteList = clientes.stream().filter(c -> c.getCpf().equals(cpf)).collect(Collectors.toList());
        for (Cliente clienteLogado : clienteList) {
            if (clienteLogado.getCpf().equals(cpf)) {
                cliente = clienteLogado;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Usuário de Cliente não existe");
        }
        try {
            if (cliente.getCpf() == null && cliente.getSenha() == null) {
                System.out.println("Usuário de Cliente inválido ");
            } else if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
                cliente.setClienteAutenticado(true);
                System.out.println("autenticado");
                return cliente;
            } else {
                cliente.setClienteAutenticado(false);
                System.out.println("Usuário ou senha Inválida");
            }

        } catch (NullPointerException e) {
        } finally {
            // if (sc != null) {
            // sc.close();
            // }
        }

        VoltarAoMenu.voltarAoMenu(sc);

        return null;
    }
}
