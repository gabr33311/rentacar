package controller;

import java.sql.Connection;
import java.sql.Statement;

public class CriarTabelas {
    public static void main(String[] args) {
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            
            // Criar tabela Clientes
            stmt.execute("CREATE TABLE IF NOT EXISTS Clientes ("
                    + "nif TEXT PRIMARY KEY, "
                    + "nome TEXT NOT NULL)");
            
            // Criar tabela Veiculos
            stmt.execute("CREATE TABLE IF NOT EXISTS Veiculos ("
                    + "matricula TEXT PRIMARY KEY, "
                    + "marca TEXT NOT NULL, "
                    + "estado TEXT NOT NULL)");
            
            System.out.println("Tabelas criadas com sucesso na base de dados!");
            
        } catch (Exception e) {
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}