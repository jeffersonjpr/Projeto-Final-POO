package tiposDados.locacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import tiposDados.cliente.Cliente;
import tiposDados.veiculo.Automovel;


public class Locacao implements Serializable{

    private LocalDate dt_locacao;
    private LocalTime hora_locacao;
    private LocalDate dt_devolucao;
    private LocalTime hora_devolucao;
    private long quilometragem;
    private double valor_caucao;
    private double valor_locacao;
    private boolean devolvido;

    private Cliente cliente;
    private Automovel automovel;
    
    //POLIMORFISMO SOBRECARGA
    //constructor tudo
    public Locacao(LocalDate dt_locacao, LocalTime hora_locacao, LocalDate dt_devolucao, LocalTime hora_devolucao, long quilometragem, double valor_caucao, double valor_locacao, boolean devolvido, Cliente cliente, Automovel automovel) {    
        this.dt_locacao = dt_locacao;
        this.hora_locacao = hora_locacao;
        this.dt_devolucao = dt_devolucao;
        this.hora_devolucao = hora_devolucao;
        this.quilometragem = quilometragem;
        this.valor_caucao = valor_caucao;
        this.valor_locacao = valor_locacao;
        this.devolvido = devolvido;
        this.cliente = cliente;
        this.automovel = automovel;
    }
    //constructor registro locação normal
    public Locacao(LocalDate dt_locacao, LocalTime hora_locacao, double valor_caucao, Cliente cliente, Automovel automovel) {
        this.dt_locacao = dt_locacao;
        this.hora_locacao = hora_locacao;
        this.valor_caucao = valor_caucao;
        this.cliente = cliente;
        this.automovel = automovel;
        this.devolvido = false;
    }
    
    //set get
    
    public LocalDate getDt_locacao() {
        return dt_locacao;
    }

    public void setDt_locacao(LocalDate dt_locacao) {
        this.dt_locacao = dt_locacao;
    }

    public LocalTime getHora_locacao() {
        return hora_locacao;
    }

    public void setHora_locacao(LocalTime hora_locacao) {
        this.hora_locacao = hora_locacao;
    }

    public LocalDate getDt_devolucao() {
        return dt_devolucao;
    }

    public void setDt_devolucao(LocalDate dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }

    public LocalTime getHora_devolucao() {
        return hora_devolucao;
    }

    public void setHora_devolucao(LocalTime hora_devolucao) {
        this.hora_devolucao = hora_devolucao;
    }

    public long getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(long quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getValor_caucao() {
        return valor_caucao;
    }

    public void setValor_caucao(double valor_caucao) {
        this.valor_caucao = valor_caucao;
    }

    public double getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(double valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }
    
    
    
    
}
