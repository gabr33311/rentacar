package model;

public abstract class Veiculo {
    private String matricula;
    private String marca;

    public Veiculo(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}