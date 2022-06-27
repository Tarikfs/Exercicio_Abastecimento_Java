package service;

import java.util.List;
import java.util.Scanner;

import model.Veiculo;

public class RegistrarVeiculo extends Veiculo {

    public RegistrarVeiculo(int chassi, String tipoDeVeiculo, int combustivelAtual, int capacidadeMaxima,
            String combustivel) {
        super(chassi, tipoDeVeiculo, combustivelAtual, capacidadeMaxima, combustivel);
    }

    int escolha = 1;

    public void registrarVeiculo(List<Veiculo> veiculoList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero do chassi do veiculo: ");
        int chassi = sc.nextInt();
        System.out.println("\n Digite o tipo de veculo: ");
        String tipoDeVeiculo = sc.next();
        System.out.println("\n Digite o nivel de combustivel atual");
        int combustivelAtual = sc.nextInt();
        System.out.println("\n Digite a capacidade maxima de combustivel");
        int capacidadeMaxima = sc.nextInt();
        System.out.println("\n Escolha o tipo de combustivel");
        System.out.println("\n1- Gasolina \n2- Alcool \n3- Deisel");
        String combustivel = null;
        boolean escolhaCombustivel = false;
        while (escolhaCombustivel != true) {
            escolha = sc.nextInt();
            if (escolha == 1) {
                escolhaCombustivel = true;
                combustivel = "Gasolina";
            } else if (escolha == 2) {
                escolhaCombustivel = true;
                combustivel = "Alcool";
            } else if (escolha == 3) {
                escolhaCombustivel = true;
                combustivel = "Deisel";
            } else {
                System.out.println("Necessário escolher uma das opções abaixo: \n1- Gasolina \n2- Alcool \n3- Deisel");
            }
        }
        Veiculo veiculoRegistrado = new Veiculo(chassi, tipoDeVeiculo, combustivelAtual, capacidadeMaxima, combustivel);
        if (veiculoList.contains(veiculoRegistrado)) {
            System.out.println("veiculo já existe!");
        } else {
            veiculoList.add(veiculoRegistrado);
        }

        VoltarAoMenu.voltarAoMenu(sc);
        System.out.println("Veiculo registrado!");
    }

}
