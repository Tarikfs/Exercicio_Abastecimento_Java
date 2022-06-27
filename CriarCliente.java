package service;

import java.util.List;
import java.util.Scanner;

import model.Cliente;

public class CriarCliente extends Cliente {

    public CriarCliente(String nome, String cpf, String senha, Boolean clienteAutenticado) {
        super(nome, cpf, senha, clienteAutenticado);

    }

    public void criarCliente(List<Cliente> clienteList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do Cliente: ");
        String nome = sc.next();
        System.out.println("\n Insira o CPF");
        String cpf = sc.next();
        System.out.println("\n Defina uma senha");
        String senha = sc.next();
        Cliente cliente = new Cliente(nome, cpf, senha, false);
        if (clienteList.contains(cliente)) {
            System.out.println("Cadastro de Cliente ja existe já existe!");
        } else {
            clienteList.add(cliente);
        }

        VoltarAoMenu.voltarAoMenu(sc);
        System.out.println("Cliente Cadastrado!");
    }
}
