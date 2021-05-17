package tiposDados.veiculo;

import java.io.Serializable;

public class Modelo implements Serializable{
    private String descricao;
    private Marca marca;

    //metodo construtor
    public Modelo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
    }

    
    //geter seter
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return descricao + ' ' + marca ;
    }
    
    
}
