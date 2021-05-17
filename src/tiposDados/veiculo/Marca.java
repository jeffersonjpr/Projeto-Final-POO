package tiposDados.veiculo;

import java.io.Serializable;

public class Marca implements Serializable{
    private String descricao;
    
    //construtor
    public Marca(String descricao) {
        this.descricao = descricao;
    }

    //geter seter
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
