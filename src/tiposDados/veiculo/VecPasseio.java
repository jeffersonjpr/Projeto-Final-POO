package tiposDados.veiculo;

import java.io.Serializable;

public final class VecPasseio extends Automovel implements Serializable{
    private int npassageiros;

    public VecPasseio(int npassageiros, String placa, String cor, int nroportas, int tipo_combustivel, long quilometragem, long renavam, String chassi, double valor_locacao, Modelo modelo, double autonomia) {
        super(placa, cor, nroportas, tipo_combustivel, quilometragem, renavam, chassi, valor_locacao, modelo);
        this.npassageiros = npassageiros;
        setAutonomia(autonomia);
    }
    
    
    @Override
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        return super.getModelo().toString() + ' ' + super.getPlaca();
    }

    public int getNpassageiros() {
        return npassageiros;
    }

    public void setNpassageiros(int npassageiros) {
        this.npassageiros = npassageiros;
    }
    
    
}
