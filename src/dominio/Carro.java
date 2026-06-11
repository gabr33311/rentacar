package dominio;

public class Carro extends Veiculo {
    public Carro(String matricula, String marca, String modelo, double precoDiario) {
        super(matricula, marca, modelo, precoDiario);
    }

    @Override
    public double calcularPrecoTotal(int dias) {
        return getPrecoDiario() * dias;
    }
}