import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Combustivel;
import model.Veiculo;
import service.CriarCliente;
import service.LoginCliente;
import service.RegistrarVeiculo;
import service.VoltarAoMenu;

public class PostoDeCombustivel {

    public void inicio() throws Exception {

        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        int valor = 1;
        Combustivel bombaAlcool1 = new Combustivel(1, "Alcool", 1000, 1000);
        Combustivel bombaGasolina1 = new Combustivel(2, "Gasolina", 1000, 1000);
        Combustivel bombaDeisel1 = new Combustivel(3, "Diesel", 100, 100);

        List<Combustivel> combustiveis = new ArrayList<>();
        combustiveis.add(bombaAlcool1);
        combustiveis.add(bombaGasolina1);
        combustiveis.add(bombaDeisel1);

        // Veiculo v1 = new Veiculo(1, "Carro", 30, 50, "Gasolina");
        // Veiculo v2 = new Veiculo(2, "Moto", 5, 15, "Alcool");
        // Veiculo v3 = new Veiculo(3, "Caminhão", 70, 100, "Diesel");
        // Veiculo v4 = new Veiculo(4, "Ônibus", 50, 190, "Diesel");

        List<Veiculo> veiculo = new ArrayList<>();
        // veiculo.add(v1);
        // veiculo.add(v2);
        // veiculo.add(v3);
        // veiculo.add(v4);

        Cliente clienteLogado = null;

        do {
            System.out.println(
                    "0- Sair \n1- Criar Cliente \n2- Login Cliente \n3- Tipo de combustivel disponivel"
                            + " \n4- Registrar chassi do veiculo \n5- selecionar tipo de veiculo "
                            + "\n6- Realizar abastecimento \n7- Logout Cliente \nDigite a opção desejada: ");
            valor = sc.nextInt();
            VoltarAoMenu.voltarAoMenu(sc);

            if (valor == 1) {
                CriarCliente cliente = new CriarCliente(null, null, null, false);
                cliente.criarCliente(clientes);
            }
            if (valor == 2) {
                LoginCliente loginCliente = new LoginCliente(null, null, null, false);
                clienteLogado = loginCliente.loginCliente(clientes, veiculo);
            }
            if (valor == 3) {
                System.out.println("Combustíveis disponíveis");
                for (Combustivel combustivel : combustiveis) {
                    System.out.println(combustivel);
                }
                System.out.println("\n");
            }
            if (valor == 4) {
                RegistrarVeiculo registrarVeiculo = new RegistrarVeiculo(valor, null, valor, valor, null);
                registrarVeiculo.registrarVeiculo(veiculo);

            }
            if (valor == 5) {
                if (clienteLogado == null) {
                    System.out.println("Cliente não autenticado, favor fazer login");
                } else {
                    System.out.println("*** tipo de Veiculo ***");
                    for (Veiculo veiculos : veiculo) {
                        System.out.println(veiculos);
                    }
                    System.out.println("\n");

                    System.out.println("Digite o chassi do Veiculo: ");
                    int veiculoEscolhido = sc.nextInt();

                    for (Veiculo veiculos : veiculo) {
                        if (veiculos.getChassi() == veiculoEscolhido) {
                            ((Cliente) clienteLogado).getVeiculoCliente().add((Veiculo) veiculos);
                            System.out.println(
                                    ((Cliente) clienteLogado).getVeiculoCliente() + "\nTipo de Veiculo Escolhido!\n");
                        }
                    }
                }
            }
            if (valor == 6) {
                Veiculo veiculoEscolhido = clienteLogado.getVeiculoCliente().get(0);
                System.out.println("seu veiculo é" + veiculoEscolhido);
                System.out.println("nivel do reservatorio bombaAlcool1: " + bombaAlcool1.getQuantidadeAtual());
                System.out.println("nivel do reservatorio bombaGasolina1: " + bombaGasolina1.getQuantidadeAtual());
                System.out.println("nivel do reservatorio bombaDeisel1: " + bombaDeisel1.getQuantidadeAtual());
                if (veiculoEscolhido.getCombustivel().equals("Alcool")) {
                    funcaoAbastecimento(veiculoEscolhido, bombaAlcool1);
                } else if (veiculoEscolhido.getCombustivel().equals("Gasolina")) {
                    funcaoAbastecimento(veiculoEscolhido, bombaGasolina1);
                } else if (veiculoEscolhido.getCombustivel().equals("Diesel")) {
                    funcaoAbastecimento(veiculoEscolhido, bombaDeisel1);
                }
                System.out.println("seu veiculo é" + veiculoEscolhido);
                System.out.println("nivel do reservatorio bombaAlcool1: " + bombaAlcool1.getQuantidadeAtual());
                System.out.println("nivel do reservatorio bombaGasolina1: " + bombaGasolina1.getQuantidadeAtual());
                System.out.println("nivel do reservatorio bombaDeisel1: " + bombaDeisel1.getQuantidadeAtual());
            }
            if (valor == 7) {
                if (clienteLogado != null) {
                    clienteLogado.setClienteAutenticado(false);
                    clienteLogado = null;
                    System.out.println("log out realizado com sucesso!");
                }
            }
        } while (valor != 0);
    }

    public void funcaoAbastecimento(Veiculo veiculoEscolhido, Combustivel combustivelBombaReservatorio) {
        // 1 capacidade atual da bomba > que capacidade a ser abastecido
        // 2 capacidade atual da bomba < que capacidade a ser abastecido
        // 3 bomba esta vazia
        int litrosASerAbastecido = veiculoEscolhido.getCapacidadeMaxima() - veiculoEscolhido.getCombustivelAtual();
        if (combustivelBombaReservatorio.getQuantidadeAtual() >= litrosASerAbastecido) {
            combustivelBombaReservatorio
                    .setQuantidadeAtual(combustivelBombaReservatorio.getQuantidadeAtual() - litrosASerAbastecido);
            veiculoEscolhido.setCombustivelAtual(veiculoEscolhido.getCombustivelAtual() + litrosASerAbastecido);
        } else if (combustivelBombaReservatorio.getQuantidadeAtual() < litrosASerAbastecido) {
            veiculoEscolhido.setCombustivelAtual(
                    veiculoEscolhido.getCombustivelAtual() + combustivelBombaReservatorio.quantidadeAtual);
            combustivelBombaReservatorio.setQuantidadeAtual(0);
        } else if (combustivelBombaReservatorio.getQuantidadeAtual() == 0) {
            System.out.println("Reservatorio vazio :( ");
        }
    }
}
