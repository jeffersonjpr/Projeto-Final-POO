package tipoException;

public class DataInvalidaExecption extends Exception{
    private String mensagem;
    public DataInvalidaExecption(String mensagem) {
        super();
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Data em " + mensagem + " invalida.";
    }
}
