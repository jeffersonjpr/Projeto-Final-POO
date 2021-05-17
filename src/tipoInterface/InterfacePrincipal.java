package tipoInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tipoPrograma.Controlador;
import tiposDados.cliente.Cliente;
import tiposDados.locacao.Locacao;
import tiposDados.veiculo.Marca;
import tiposDados.veiculo.Modelo;
import tiposDados.veiculo.VecCarga;
import tiposDados.veiculo.VecPasseio;

//herança Application
public class InterfacePrincipal extends Application{
    BorderPane root;
    
    Scene cenaPrincipal;
    
    Menu mVeiculo,mCliente,mLocacao;
    MenuItem miCadVec,miCadCarg,miShowPas,miShowCarg,miCadClie,miShowCli,miCadLoc,miShowLoc,miCadDevolucao;
    MenuBar barraMenu;
    
    Controlador listas;
    
    //imagem
    Image image;
    ImageView imagem;
    
    @Override
    public void init(){
        
        root = new BorderPane();
        listas = new Controlador();
        
//        //debugaçãoooo Funçao de Persistencia de arquivos ficara abaixo
//        //CLIENTES TESTE
//        listas.cadastraCliente(0637266106, "Jefferson", "Rua ermelino pinto", "41 4411 1441", "jefin@email.com");
//        listas.cadastraCliente(12032121,"Val","Rua celta vermelho", "23 2323-2332","val@teste.com");
//       
//
//        //CARROS TESTE
//        //marca
//        listas.cadastraMarca("Pegeout");
//        listas.cadastraMarca("Fiat");
//        System.out.println(listas.getImarca(0));
//        System.out.println(listas.getImarca(1));
//        //modelo
//        System.out.println(listas.cadastraModelo("207", listas.getImarca(0)));
//        System.out.println(listas.cadastraModelo("Palio fire 2000", listas.getImarca(1)));
//
//        System.out.println(listas.getImodelo(0));
//        System.out.println(listas.getImodelo(1));
//        //carros
//        listas.cadastraVecPasseio(2, "SSZ-2012", "Vermelho", 5, 0, 45454, 2332321, "fxa1231asad'", 1231, listas.getImodelo(0), 12.5);
////        System.out.println(listas.getaVecPasseio().get(0));
//        //cores
//        listas.cadastraCores("Azul");
//        listas.cadastraCores("Vermelho");
//        listas.cadastraCores("Amarelo");
//        listas.cadastraCores("Branco");
//        listas.cadastraCores("Preto");
//        listas.cadastraCores("Cinza");
//        //debugaççaopo persistencia acima
        
        
        
        //OPÇOES DA BARRA DE MNU
        mVeiculo = new Menu("Veículo");
        mCliente = new Menu("Cliente");
        mLocacao = new Menu("Locação");
        
        //OPÇÕES DAS OPÇÕES
        miCadVec = new MenuItem("Cadastrar Veículo Passeio");
        miCadCarg = new MenuItem("Cadastrar Veículo Carga");
        miShowPas = new MenuItem("Consultar Veículos de Passeio");
        miShowCarg = new MenuItem("Consultar Veículos de carga");
        miCadClie = new MenuItem("Cadastrar Cliente");
        miShowCli = new MenuItem("Consultar Clientes");
        miCadLoc = new MenuItem("Cadastrar Locação");
        miShowLoc = new MenuItem("Consultar Locações");
        miCadDevolucao = new MenuItem("Cadastrar Devolução");
        
        //adicionando sub opções
        mVeiculo.getItems().addAll(miCadVec,miCadCarg,miShowPas,miShowCarg);
        mCliente.getItems().addAll(miCadClie,miShowCli);
        mLocacao.getItems().addAll(miCadLoc,miShowLoc,miCadDevolucao);
        
        //imagem
        image = new Image("telaini.png");
        imagem = new ImageView(image);
        imagem.autosize();
        
        //barra de menu
        barraMenu = new MenuBar(mVeiculo, mCliente, mLocacao);
        
        root.setTop(barraMenu);
        root.setCenter(imagem);
        
        
        
        
       
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        try{
            FileInputStream f = new FileInputStream(new File("controlador.txt"));
            ObjectInputStream o = new ObjectInputStream(f);

            //lendo objetos
            List<String> listcores = (List<String>)o.readObject();
            listas.setaCores(FXCollections.observableList(listcores));
            
            List<Marca> listmarca = (List<Marca>)o.readObject();
            listas.setaMarca(FXCollections.observableList(listmarca));
            
            List<Modelo> listmodelo = (List<Modelo>)o.readObject();
            listas.setaModelo(FXCollections.observableList(listmodelo));
            
            List<VecPasseio> listvecpasseio = (List<VecPasseio>)o.readObject();
            listas.setaVecPasseio(FXCollections.observableList(listvecpasseio));
            
            List<VecCarga> listveccarga = (List<VecCarga>)o.readObject();
            listas.setaVecCarga(FXCollections.observableList(listveccarga));
            
            List<Cliente> listcliente = (List<Cliente>)o.readObject();
            listas.setaCliente(FXCollections.observableList(listcliente));
            
            List<Locacao> listlocacao = (List<Locacao>)o.readObject();
            listas.setaLocacao(FXCollections.observableList(listlocacao));
            
            
            o.close();
            f.close();
                        
        }catch (FileNotFoundException e) {
            System.out.println("Aquivo não encontrado");
        } catch (IOException e) {
            System.out.println("Erro de stream" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Scene scene = new Scene(root, 960, 540);
        primaryStage.setMinHeight(700);
        primaryStage.setMinWidth(900);
        //AÇÕES DOS BOTOES
        miCadClie.setOnAction( e -> cadCliente());
        miShowCli.setOnAction( e -> root.setCenter(TabelasInterface.tableCliente(listas)));
        
        //miCadVec.setOnAction( e -> cadVecPasseio());
        miCadVec.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                cadVecPasseio();
            }
        });
        miShowPas.setOnAction( e -> root.setCenter(TabelasInterface.tableVecPass(listas)));
        miCadCarg.setOnAction( e -> cadVecCarga());
        miShowCarg.setOnAction( e -> root.setCenter(TabelasInterface.tableVecCarg(listas)));
        miCadLoc.setOnAction(e -> cadLoc());
        miShowLoc.setOnAction( e -> root.setCenter(TabelasInterface.tableLocacao(listas)));
        miCadDevolucao.setOnAction( e -> cadDevolucao());
        
        
        primaryStage.setTitle("NAV Locações");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    @Override
    public void stop() throws IOException{
        try{
            FileOutputStream  f = new FileOutputStream (new File("controlador.txt"));
            ObjectOutputStream  o = new ObjectOutputStream(f);

            o.writeObject(new ArrayList<>(listas.getaCores()));
            o.writeObject(new ArrayList<>(listas.getaMarca()));
            o.writeObject(new ArrayList<>(listas.getaModelo()));
            o.writeObject(new ArrayList<>(listas.getaVecPasseio()));
            o.writeObject(new ArrayList<>(listas.getaVecCarga()));
            o.writeObject(new ArrayList<>(listas.getaCliente()));
            o.writeObject(new ArrayList<>(listas.getaLocacao()));
            
            o.close();
                        
        }catch (FileNotFoundException e) {
            System.out.println("Aquivo não encontrado");
        } catch (IOException e) {
            System.out.println("Erro de stream");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
    /**
     * Chama a tela de cadastro de cliente.
     */
    private void cadCliente(){
        TelaCadCliente tela = new TelaCadCliente(listas);
        tela.init();
        tela.start(chamarNovaJanela());
    }
    
    /**
     * Cria uma nova Janela
     * @return retorna a nova janela criada
     */ 
    public Stage chamarNovaJanela() {
        Stage novaJanela = new Stage ();
        novaJanela.initOwner((Stage) root.getScene().getWindow());
        novaJanela.initModality(Modality.APPLICATION_MODAL);
        
        return novaJanela;
    }

    /**
     * Chama o stage de cadastro:Veiculo Passeio
     */
    private void cadVecPasseio() {
        TelaCadVecPass tela = new TelaCadVecPass(listas);
        tela.init();
        tela.start(chamarNovaJanela());
    }
    
    /**
     * Chama o stage de cadastro:Veiculo Carga
     */
    private void cadVecCarga(){
        TelaCadVecCarga tela = new TelaCadVecCarga(listas);
        tela.init();
        tela.start(chamarNovaJanela());
    }
    
    /**
     * Chama o stage de cadastro:Locação
     */
    private void cadLoc(){
        TelaCadLocacao tela = new TelaCadLocacao(listas);
        tela.init();
        tela.start(chamarNovaJanela());
    }
    
    /**
     * Chama tela de warning  
     * @param titulo Titulo da tela
     * @param header Mensagem principal
     * @param content Mensagem auxiliar
     */
    public static void warning(String titulo, String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }

    /**
     * Chama tela de Devoluçao
     */
    private void cadDevolucao() {
        TelaCadDevolucao tela = new TelaCadDevolucao(listas);
        tela.init();
        tela.start(chamarNovaJanela());
    }
}
