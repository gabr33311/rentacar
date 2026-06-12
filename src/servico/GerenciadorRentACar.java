package servico;

import dominio.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorRentACar {
    private List<Veiculo> frota = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Aluguer> alugueresAtivos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo v) { frota.add(v); }
    public void adicionarCliente(Cliente c) { clientes.add(c); }

    public Cliente buscarCliente(String nif) {
        for (Cliente c : clientes) {
            if (c.getNif().equals(nif)) return c;
        }
        return null;
    }

    public Veiculo buscarVeiculo(String matricula) {
        for (Veiculo v : frota) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) return v;
        }
        return null;
    }

    public boolean registarAluguer(String nif, String matricula, int dias) {
        Cliente c = buscarCliente(nif);
        Veiculo v = buscarVeiculo(matricula);

        if (c != null && v != null && v.isDisponivel()) {
            Aluguer novoAluguer = new Aluguer(c, v, dias);
            alugueresAtivos.add(novoAluguer);
            return true;
        }
        return false;
    }

    public double processarDevolucao(String matricula) {
        Aluguer aluguerEncontrado = null;
        for (Aluguer a : alugueresAtivos) {
            if (a.getVeiculo().getMatricula().equalsIgnoreCase(matricula)) {
                aluguerEncontrado = a;
                break;
            }
        }

        if (aluguerEncontrado != null) {
            double precoFinal = aluguerEncontrado.calcularPrecoFinal();
            aluguerEncontrado.getVeiculo().setDisponivel(true);
            alugueresAtivos.remove(aluguerEncontrado);
            return precoFinal;
        }
        return -1;
    }
}