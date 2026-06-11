package servico;

import dominio.Veiculo;
import dominio.Cliente;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorRentACar {
    private List<Veiculo> frota = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionarVeiculo(Veiculo v) { 
        frota.add(v); 
    }
    
    public void adicionarCliente(Cliente c) { 
        clientes.add(c); 
    }
}