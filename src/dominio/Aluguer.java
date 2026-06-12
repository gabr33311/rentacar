package dominio;

public class Aluguer {
    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;

    public Aluguer(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
        this.veiculo.setDisponivel(false);
    }

    public Cliente getCliente() { return cliente; }
    public Veiculo getVeiculo() { return veiculo; }
    public int getDias() { return dias; }

    public double calcularPrecoFinal() {
        return veiculo.calcularPrecoTotal(dias);
    }
}