package tipoPrograma;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tiposDados.cliente.Cliente;
import tiposDados.locacao.Locacao;
import tiposDados.veiculo.Automovel;
import tiposDados.veiculo.Marca;
import tiposDados.veiculo.Modelo;
import tiposDados.veiculo.VecCarga;
import tiposDados.veiculo.VecPasseio;


public class Controlador implements Serializable{
    //veiculo
    private ObservableList <VecCarga> aVecCarga = FXCollections.observableArrayList();
    private ObservableList <VecPasseio> aVecPasseio = FXCollections.observableArrayList();
    private ObservableList<Marca> aMarca = FXCollections.observableArrayList();
    private ObservableList<Modelo> aModelo = FXCollections.observableArrayList();
    
    //cliente
    private ObservableList<Cliente> aCliente = FXCollections.observableArrayList();
    
    //locacao
    private ObservableList<Locacao> aLocacao = FXCollections.observableArrayList();

    //cores COSMETICO
    private ObservableList<String> aCores = FXCollections.observableArrayList();
    


    //setters e getters
    public ObservableList<VecCarga> getaVecCarga() {
        return aVecCarga;
    }

    public void setaVecCarga(ObservableList<VecCarga> aVecCarga) {
        this.aVecCarga = aVecCarga;
    }

    public ObservableList<VecPasseio> getaVecPasseio() {    
        return aVecPasseio;
    }
    public void setaVecPasseio(ObservableList<VecPasseio> aVecPasseio) {    
        this.aVecPasseio = aVecPasseio;
    }

    public ObservableList<String> getaCores() {
        return aCores;
    }

    public void setaCores(ObservableList<String> aCores) {
        this.aCores = aCores;
    }
    public ObservableList<Marca> getaMarca() {
        return aMarca;
    }

    public void setaMarca(ObservableList<Marca> aMarca) {
        this.aMarca = aMarca;
    }

    public ObservableList<Modelo> getaModelo() {
        return aModelo;
    }

    public void setaModelo(ObservableList<Modelo> aModelo) {
        this.aModelo = aModelo;
    }

    public ObservableList<Cliente> getaCliente() {
        return aCliente;
    }

    public void setaCliente(ObservableList<Cliente> aCliente) {
        this.aCliente = aCliente;
    }

    public ObservableList<Locacao> getaLocacao() {
        return aLocacao;
    }
    /**
     * Retorna o elemento de indice i da observablelist aLocacao
     * @param i indice
     * @return Objeto do tipo Locacao
     */
    public Locacao getIndexLoc(int i){
        return aLocacao.get(i);
    }
    public void setaLocacao(ObservableList<Locacao> aLocacao) {
        this.aLocacao = aLocacao;
    }
 
    /**
     * Cria um uma observablelist para veiculos de passeio e carga
     * @return Retorna uma observable list contendo veiculos de passeio e de carga 
     */
    public ObservableList<Automovel> getAutomovel() {
        ObservableList <Automovel> aAutomovel = FXCollections.observableArrayList();
        aAutomovel.addAll(aVecCarga);
        aAutomovel.addAll(aVecPasseio);
        
        return aAutomovel;
    }
    //metodos de cadastro
    ///METODOS DE CADASTRO
    /**
     * Converte a cor  
     * @param cor
     * @return Retorna uma string com somente a primeira letra maiuscula
     */
    public static String converter(String cor) {
        if(cor.length() <=0) return null;
        return Character.toUpperCase(cor.charAt(0)) + cor.substring(1).toLowerCase();
    }
    /**
     * Cadastra novas cores para os carros
     * @param cor
     * @return Retorna se a cor foi cadastrada ou não 
     */
    public boolean cadastraCores(String cor){
        cor = converter(cor);
        if(!aCores.contains(cor)){
            aCores.add(cor);
            return true;
        }
        return false;
    }
    /**
     * Cadastra um novo veiculo de passeio
     * @param nPassageiros
     * @param placa
     * @param cor
     * @param nroportas
     * @param tipo_combustivel
     * @param quilometragem
     * @param renavam
     * @param chassi
     * @param valor_locacao
     * @param modelo
     * @param autonomia
     * @return Retorna se o veiculo de passeio foi cadastrado ou não
     */
    public boolean cadastraVecPasseio(int nPassageiros, String placa, String cor, int nroportas, int tipo_combustivel, long quilometragem, long renavam, String chassi, double valor_locacao, Modelo modelo, double autonomia){
        VecPasseio auxPasseio = new VecPasseio(nPassageiros, placa, cor, nroportas, tipo_combustivel, quilometragem, renavam, chassi, valor_locacao, modelo, autonomia);
        if(!aVecPasseio.contains(auxPasseio)){
            aVecPasseio.add(auxPasseio);
            return true;
        }
        //se nao foi possivel adicionar
        return false;
    }
    
    public boolean cadastraVecCarga(double cargamax, String placa, String cor, int nroportas, int tipo_combustivel, long quilometragem, long renavam, String chassi, double valor_locacao, Modelo modelo, double autonomia){
        VecCarga auxCarga = new VecCarga(cargamax, placa, cor, nroportas, tipo_combustivel, quilometragem, renavam, chassi, valor_locacao, modelo, autonomia);
        if(!aVecCarga.contains(auxCarga)){
            aVecCarga.add(auxCarga);
            return true;
        }
        //se nao foi possivel adicionar
        return false;
    }
    
    /**
     * Cadastra um novo cliente
     * @param cpf_cli
     * @param nom_cli
     * @param end_cli
     * @param tel_cli
     * @param email_cli
     * @return Retorna se o cliente foi cadastrado ou não
     */
    public boolean cadastraCliente(long cpf_cli, String nom_cli, String end_cli, String tel_cli, String email_cli){
        Cliente auxCliente = new Cliente(cpf_cli, nom_cli, end_cli, tel_cli, email_cli);
        if(!aCliente.contains(auxCliente)){
            aCliente.add(auxCliente);
            
            return true;

        }
        //se nao foi possivel adicionar
        return false;
    }
    
    /**
     * Cadastra um novo Modelo de veiculo
     * @param descricao
     * @param marca
     * @return Retorna se o modelo foi cadastrado ou não 
     */
    public boolean cadastraModelo(String descricao, Marca marca){
        Modelo auxModel = new Modelo(descricao, marca);
        
        //se a descrição for vazia ou nula a ação é desconsiderada
        if(descricao == null || descricao.equals("")) return false;
        //se a marca for nula, a ação é desconsiderada
        if(null == marca) return false;
        
        //se o modelo nao esta contida na lista ele é adicionado
        if(!aModelo.contains(auxModel)){
            aModelo.add(auxModel);
            return true;
        }
        //se nao foi possivel adicionar
        return false;
    }
    /**
     * Cadastra uma nova Marca
     * @param descricao
     * @return Retorna se foipossivel cadastrar a marca
     */
    public boolean cadastraMarca(String descricao){
        Marca auxMarc = new Marca(descricao);
        
        //se for vazio ou nulo a ação é desconsiderada
        if(descricao == null || descricao.equals("")) return false;
        
        // se a marca nao esta na lista, ela é adicionada
        if(!aMarca.contains(auxMarc)){
            aMarca.add(auxMarc);
            return true;
        }
        //caso ela ja pertença a lista
        return false;
    }
    
    /**
     * Cadastra veiculo alugado por um cliente, mas o mesmo já foi devolvido
     * @param dt_locacao
     * @param hora_locacao
     * @param dt_devolucao
     * @param hora_devolucao
     * @param quilometragem
     * @param valor_caucao
     * @param valor_locacao
     * @param devolvido
     * @param cliente
     * @param automovel
     * @return Retorna se o cliente conseguiu ou não alugar o veiculo
     */
    public boolean cadastraLocacao(LocalDate dt_locacao, LocalTime hora_locacao, LocalDate dt_devolucao, LocalTime hora_devolucao, long quilometragem, double valor_caucao, double valor_locacao, boolean devolvido, Cliente cliente, Automovel automovel){
        Locacao auxLoc = new Locacao(dt_locacao, hora_locacao, dt_devolucao, hora_devolucao, quilometragem, valor_caucao, valor_locacao, devolvido, cliente, automovel);
        
        // se a marca nao esta na lista, ela é adicionada
        if(!aLocacao.contains(auxLoc)){
            aLocacao.add(auxLoc);
            return true;
        }
        //caso ela ja pertença a lista
        return false;
    }
    
    /**
     * Cadastra veiculo alugado por um cliente
     * @param dt_locacao
     * @param hora_locacao
     * @param valor_caucao
     * @param cliente
     * @param automovel
     * @return Retorna se o cliente conseguiu ou não alugar o veiculo
     */
    public boolean cadastraLocacao(LocalDate dt_locacao, LocalTime hora_locacao, double valor_caucao, Cliente cliente, Automovel automovel){
        Locacao auxLoc = new Locacao(dt_locacao,hora_locacao,valor_caucao,cliente,automovel);
        
        // se a marca nao esta na lista, ela é adicionada
        if(!aLocacao.contains(auxLoc)){
            aLocacao.add(auxLoc);
            return true;
        }
        //caso ela ja pertença a lista
        return false;
    }
    
   
    //retorna o objeto da posição i da array de marca
    public Marca getImarca(int i){
        if(i < 0 || i >= this.aMarca.size()) return null;
        return this.aMarca.get(i);
    }
    
    //retorna o objeto da posição i da array de modelo
    public Modelo getImodelo(int i){
        if(i < 0 || i >= this.aModelo.size()) return null;
        return this.aModelo.get(i);
    }
    
    //debugação
    /**
     * printa uma listade clientes
     */
    public void clienteListar(){
        System.out.println(aCliente.toString());
    }
    
}
