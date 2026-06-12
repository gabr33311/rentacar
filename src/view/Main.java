package view;

import java.util.Scanner;
import dominio.*;
import servico.GerenciadorRentACar;

public class Main {
    public static void main(String[] args) {
        GerenciadorRentACar gestor = new GerenciadorRentACar();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Dados de teste iniciais para não estares sempre a digitar do zero
        gestor.adicionarCliente(new Cliente("123", "Gabriel"));
        gestor.adicionarVeiculo(new Carro("AA-00-00", "BMW", "116d", 60.0));

        while (opcao != 5) {
            System.out.println("\n--- Menu Rent-a-Car ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Carro");
            System.out.println("3. Registar Aluguer");
            System.out.println("4. Devolver Carro");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("NIF: ");
                String nif = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                gestor.adicionarCliente(new Cliente(nif, nome));
                System.out.println("Cliente inserido com sucesso!");

            } else if (opcao == 2) {
                System.out.print("Matrícula: ");
                String mat = scanner.nextLine();
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                System.out.print("Preço Diário: ");
                double preco = scanner.nextDouble();
                gestor.adicionarVeiculo(new Carro(mat, marca, modelo, preco));
                System.out.println("Carro inserido com sucesso!");

            } else if (opcao == 3) {
                System.out.print("NIF do Cliente: ");
                String nif = scanner.nextLine();
                System.out.print("Matrícula do Carro: ");
                String mat = scanner.nextLine();
                System.out.print("Dias de Aluguer: ");
                int dias = scanner.nextInt();

                if (gestor.registarAluguer(nif, mat, dias)) {
                    System.out.println("Aluguer registado! O veículo está agora INDISPONÍVEL.");
                } else {
                    System.out.println("Erro: Verifique se o NIF e Matrícula existem ou se o carro já está alugado.");
                }

            } else if (opcao == 4) {
                System.out.print("Matrícula do Carro a devolver: ");
                String mat = scanner.nextLine();
                double total = gestor.processarDevolucao(mat);

                if (total != -1) {
                    System.out.println("Devolução concluída com sucesso!");
                    System.out.printf("Total a pagar: %.2f€\n", total);
                } else {
                    System.out.println("Erro: Não foi encontrado nenhum aluguer ativo para esta matrícula.");
                }
            }
        }
        scanner.close();
        System.out.println("Aplicação encerrada.");
    }
}