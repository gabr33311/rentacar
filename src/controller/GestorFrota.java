package controller;

import model.Veiculo;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestorFrota {
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;

    public GestorFrota() {
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
        String sql = "INSERT INTO Clientes(nif, nome) VALUES(?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getNif());
            pstmt.setString(2, c.getNome());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao guardar cliente: " + e.getMessage());
        }
    }

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
        String sql = "INSERT INTO Veiculos(matricula, marca, estado) VALUES(?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, v.getMatricula());
            pstmt.setString(2, v.getMarca());
            pstmt.setString(3, "Disponivel");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao guardar veiculo: " + e.getMessage());
        }
    }

    public List<Veiculo> getVeiculos() { return veiculos; }
    public List<Cliente> getClientes() { return clientes; }
}