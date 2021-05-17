package tipoInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tipoPrograma.Controlador;
import tiposDados.veiculo.Marca;


public class TelaCadModelo extends Application {
    GridPane root;
    
    ComboBox<Marca> comboMarca; //comboBox de marcas
    
    //botões
    Button bCadastrar, bCancelar, bCadMarca;
    HBox pBotoes;
    
    //labels
    Label lModelo, lMarca;
    //text field
    TextField tModelo;
    
    //listas
    Controlador listas;
    
    @Override
    public void init(){
        //inicando root
        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10));
        
        //instanciando labels
        lModelo = new Label("Modelo: ");
        lMarca = new Label("Marca: ");
        
        //instanciando textfield
        tModelo = new TextField();
        
        //instanciando botões e painel
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");
        bCadMarca = new Button("Cad. Marca");
        pBotoes = new HBox(bCadastrar, bCancelar, bCadMarca);
        pBotoes.setSpacing(10);
        pBotoes.setAlignment(Pos.BASELINE_CENTER);
        
        //combo box MARCAS
        comboMarca = new ComboBox<>();
        comboMarca.itemsProperty().setValue(listas.getaMarca());
        
        //adicionando componentes ao root
        root.add(lModelo,0,0);
        root.add(tModelo,1,0);
        
        root.add(lMarca,0,1);
        root.add(comboMarca,1,1);
        
        root.add(pBotoes,0,2,2,1);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root);
        
        //actions
        bCadMarca.setOnAction( e-> cadMarca());
        bCadastrar.setOnAction( e -> {
            listas.cadastraModelo(tModelo.getText(), comboMarca.getValue());
            primaryStage.close();
        });
        bCancelar.setOnAction( e -> primaryStage.close());
        
        primaryStage.setTitle("Cadastro Modelo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public TelaCadModelo(Controlador listas) {
        this.listas = listas;
    }

    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Cria uma nova janela 
     * @return Retorna uma janela
     */
    public Stage chamarNovaJanela() {
        Stage novaJanela = new Stage ();
        novaJanela.initOwner((Stage) root.getScene().getWindow());
        novaJanela.initModality(Modality.APPLICATION_MODAL);
        
        return novaJanela;
    }
    
    /**
     * Cria uma janela para cadastrar uma nova Marca
     */
    private void cadMarca() {
        TelaCadMarca tela = new TelaCadMarca(listas);
        tela.init();
        tela.start(chamarNovaJanela());
    }
    
}
