package tipoInterface;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tipoPrograma.Controlador;

public class TelaCadMarca extends Application {
    GridPane root;
    //label e textfield
    Label lMarca;
    TextField tMarca;
    
    //botões
    Button bCadastrar, bCancelar;
    HBox pBotoes;
    
    //listas
    Controlador listas;
    
    @Override
    public void init(){
        //Instanciando root
        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10));
        
        //label e textfield
        lMarca = new Label("Marca: ");
        tMarca = new TextField();
        
        //botoes e painel auxiliar
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");
        pBotoes = new HBox(bCadastrar, bCancelar);
        pBotoes.setSpacing(10);
        pBotoes.setAlignment(Pos.BASELINE_CENTER);
        
        //adicionando a raiz
        root.add(lMarca,0,0);
        root.add(tMarca,1,0);
        
        root.add(pBotoes,0,1,2,1);
    }
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root);
        
        bCadastrar.setOnAction( e -> {
            listas.cadastraMarca(tMarca.getText());
            primaryStage.close();
        });
        bCancelar.setOnAction( e -> primaryStage.close());
        
        primaryStage.setTitle("Cadastro Marca");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public TelaCadMarca(Controlador listas) {
        this.listas = listas;
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
