package dominio;

public class Cliente {
    private String nif;
    private String nome;

    public Cliente(String nif, String nome) {
        this.nif = nif;
        this.nome = nome;
    }

    public String getNif() { 
        return nif; 
    }
    
    public String getNome() { 
        return nome; 
    }
}