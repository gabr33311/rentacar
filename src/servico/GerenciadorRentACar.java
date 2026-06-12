package servico;

import dominio.*;
import controller.Conexao;
import java.sql.*;

public class GerenciadorRentACar {

    public void adicionarCliente(Cliente c) {
        String sql = "INSERT INTO Cliente (nif, nome) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNif());
            stmt.setString(2, c.getNome());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro Cliente: " + e.getMessage());
        }
    }

    public void adicionarVeiculo(Veiculo v) {
        // Adicionámos a coluna 'disponivel' e forçámos o valor para 'true'
        String sql = "INSERT INTO Veiculo (matricula, marca, modelo, preco, disponivel) VALUES (?, ?, ?, ?, true)";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, v.getMatricula());
            stmt.setString(2, v.getMarca());
            stmt.setString(3, v.getModelo());
            stmt.setDouble(4, v.getPrecoDiario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro Veiculo: " + e.getMessage());
        }
    }

    public Cliente buscarCliente(String nif) {
        String sql = "SELECT * FROM Cliente WHERE nif = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nif);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return new Cliente(rs.getString("nif"), rs.getString("nome"));
        } catch (SQLException e) {}
        return null;
    }

    public Veiculo buscarVeiculo(String matricula) {
        String sql = "SELECT * FROM Veiculo WHERE matricula = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Carro c = new Carro(rs.getString("matricula"), rs.getString("marca"), rs.getString("modelo"), rs.getDouble("preco"));
                c.setDisponivel(rs.getBoolean("disponivel"));
                return c;
            }
        } catch (SQLException e) {}
        return null;
    }

    public boolean registarAluguer(String nif, String matricula, int dias) {
        Cliente c = buscarCliente(nif);
        Veiculo v = buscarVeiculo(matricula);
        if (c == null || v == null || !v.isDisponivel()) return false;

        String sqlAluguer = "INSERT INTO Aluguer (nif_cliente, matricula, dias) VALUES (?, ?, ?)";
        String sqlUpdateCarro = "UPDATE Veiculo SET disponivel = false WHERE matricula = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt1 = conn.prepareStatement(sqlAluguer);
             PreparedStatement stmt2 = conn.prepareStatement(sqlUpdateCarro)) {
            
            stmt1.setString(1, nif);
            stmt1.setString(2, matricula);
            stmt1.setInt(3, dias);
            stmt1.executeUpdate();

            stmt2.setString(1, matricula);
            stmt2.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro Aluguer: " + e.getMessage());
        }
        return false;
    }

    public double processarDevolucao(String matricula) {
        String sqlBusca = "SELECT * FROM Aluguer WHERE matricula = ?";
        String sqlDelete = "DELETE FROM Aluguer WHERE matricula = ?";
        String sqlUpdate = "UPDATE Veiculo SET disponivel = true WHERE matricula = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt1 = conn.prepareStatement(sqlBusca);
             PreparedStatement stmt2 = conn.prepareStatement(sqlDelete);
             PreparedStatement stmt3 = conn.prepareStatement(sqlUpdate)) {
            
            stmt1.setString(1, matricula);
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                int dias = rs.getInt("dias");
                Veiculo v = buscarVeiculo(matricula);
                double total = v.calcularPrecoTotal(dias);

                stmt2.setString(1, matricula);
                stmt2.executeUpdate();

                stmt3.setString(1, matricula);
                stmt3.executeUpdate();

                return total;
            }
        } catch (SQLException e) {}
        return -1;
    }
}