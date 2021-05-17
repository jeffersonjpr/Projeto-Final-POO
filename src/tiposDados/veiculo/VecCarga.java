package tiposDados.veiculo;

import java.io.Serializable;

public class VecCarga extends Automovel implements Serializable{
    double cargaMax;

    public VecCarga(double carga, String placa, String cor, int nroportas, int tipo_combustivel, long quilometragem, long renavam, String chassi, double valor_locacao, Modelo modelo, double cargaMax) {
        super(placa, cor, nroportas, tipo_combustivel, quilometragem, renavam, chassi, valor_locacao, modelo);
        this.cargaMax = cargaMax;
        setAutonomia(autonomia);
    }
    
    
    @Override
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia / ((Double)this.cargaMax / 2.0);
    }

    @Override
    public double getAutonomia() {
        return autonomia;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(double cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return super.getModelo().toString() + ' ' + super.getPlaca();
    }
    
}
