package view;

import controller.GestorFrota;
import model.Carro;
import model.Cliente;

public class Main {
    public static void main(String[] args) {
        GestorFrota gestor = new GestorFrota();

        Carro carro1 = new Carro("11-AA-22", "Toyota", 5);
        Cliente cliente1 = new Cliente("123456789", "Gabriel");

        gestor.adicionarVeiculo(carro1);
        gestor.adicionarCliente(cliente1);

        System.out.println("Carro adicionado: " + gestor.getVeiculos().get(0).getMarca());
        System.out.println("Cliente adicionado: " + gestor.getClientes().get(0).getNome());
    }
}