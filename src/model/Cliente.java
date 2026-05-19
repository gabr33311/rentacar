package model;

public class Cliente {
    private String nif;
    private String nome;

    public Cliente(String nif, String nome) {
        this.nif = nif;
        this.nome = nome;
    }

    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}