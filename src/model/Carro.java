package model;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String matricula, String marca, int numeroPortas) {
        super(matricula, marca);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() { return numeroPortas; }
    public void setNumeroPortas(int numeroPortas) { this.numeroPortas = numeroPortas; }
}