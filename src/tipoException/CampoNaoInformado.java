package tipoException;

public class CampoNaoInformado extends Exception{
    private String mensagem;

    public CampoNaoInformado(String mensagem) {
        super();
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Campo: " + mensagem + " não informado.";
    }
    
    
}
