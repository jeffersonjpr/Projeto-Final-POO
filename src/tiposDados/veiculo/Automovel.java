
package tiposDados.veiculo;

import java.io.Serializable;

public abstract class Automovel implements Serializable{
    
    private String placa;
    private String cor;
    private int nroportas;
    private int tipo_combustivel;
    private long quilometragem;
    private long renavam;
    private String chassi;
    private double valor_locacao;
    
    protected double autonomia;
    
    private Modelo modelo;

    //constructor

    public Automovel(String placa, String cor, int nroportas, int tipo_combustivel, long quilometragem, long renavam, String chassi, double valor_locacao, Modelo modelo) {
        this.placa = placa;
        this.cor = cor;
        this.nroportas = nroportas;
        this.tipo_combustivel = tipo_combustivel;
        this.quilometragem = quilometragem;
        this.renavam = renavam;
        this.chassi = chassi;
        this.valor_locacao = valor_locacao;
        this.modelo = modelo;
        this.autonomia = 0.0;
    }
    
    
    //set get
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNroportas() {
        return nroportas;
    }

    public void setNroportas(int nroportas) {
        this.nroportas = nroportas;
    }

    public int getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(int tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public long getRenavam() {
        return renavam;
    }

    public void setRenavam(long renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public double getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(double valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    //metodo abstrato
    public abstract void setAutonomia(double autonomia);
    public double getAutonomia(){
        return this.autonomia;
    }
}