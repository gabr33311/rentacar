package controller;

import model.Veiculo;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class GestorFrota {
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;

    public GestorFrota() {
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}