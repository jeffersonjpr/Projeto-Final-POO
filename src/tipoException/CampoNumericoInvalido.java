package tipoException;

public class CampoNumericoInvalido extends Exception{
    private String mensagem;

    public CampoNumericoInvalido(String mensagem) {
        super();
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Campo númerico: " + mensagem + ", inválido.";
    }
    
}
