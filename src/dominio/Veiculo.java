package dominio;

public abstract class Veiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private double precoDiario;
    private boolean disponivel;

    public Veiculo(String matricula, String marca, String modelo, double precoDiario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precoDiario = precoDiario;
        this.disponivel = true;
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecoDiario() { return precoDiario; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public abstract double calcularPrecoTotal(int dias);
}