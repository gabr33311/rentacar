package view;

import java.util.Scanner;
import dominio.Cliente;
import dominio.Carro;
import servico.GerenciadorRentACar;

public class Main {
    public static void main(String[] args) {
        GerenciadorRentACar gestor = new GerenciadorRentACar();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- Menu Rent-a-Car ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Carro");
            System.out.println("3. Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

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
                
                gestor.adicionarVeiculo(new Carro(mat, marca, modelo, 50.0));
                System.out.println("Carro inserido com sucesso!");
            }
        }
        scanner.close();
        System.out.println("Aplicação encerrada.");
    }
}