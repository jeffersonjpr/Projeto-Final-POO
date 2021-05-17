package tipoInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tipoPrograma.Controlador;

public class TelaCadCliente extends Application {
    GridPane root;
    Label lcpf, lnome, lend, ltel, lemail;
    TextField tcpf, tnome, tend, ttel, temail;
    
    
    Button bCadastrar, bCancelar;
    HBox pBotoes;
    
    
    Controlador listas;

    public TelaCadCliente(Controlador listas) {
        this.listas = listas;
    }
    
    @Override
    public void init(){
        //instanciando root
        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10));
        
        //inicializando labels
        lcpf = new Label("Cpf: ");
        lnome = new Label("Nome: ");
        lend = new Label("Endereço: ");
        ltel = new Label("Telefone: ");
        lemail = new Label("Email: ");
        
        //instanciando textfields
        tcpf = new TextField();
        tcpf.setPromptText("00000000000");
        
        tnome = new TextField();
        tend = new TextField();
        ttel = new TextField();
        ttel.setPromptText("00 00000-0000");
        temail = new TextField();
        
        //botões
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");
        
        //cpf
        root.add(lcpf, 0, 0);
        root.add(tcpf,1,0);
        //nome
        root.add(lnome, 0, 1);
        root.add(tnome,1,1);
        //endereço
        root.add(lend, 0, 2);
        root.add(tend,1,2);
        //telefone
        root.add(ltel, 0, 3);
        root.add(ttel,1,3);
        //email
        root.add(lemail,0,4);
        root.add(temail,1,4);
        
        //botoes
        pBotoes = new HBox(bCadastrar,bCancelar);
        root.add(pBotoes, 0, 5, 2 ,1);
        pBotoes.setSpacing(5);
        pBotoes.setAlignment(Pos.BASELINE_CENTER);
        
        
    }
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root);
        //Cliente dados (long cpf_cli, String nom_cli, String end_cli, String tel_cli, String email_cli)
        bCadastrar.setOnAction( e -> cadCliente());
        bCancelar.setOnAction( e -> primaryStage.close());
        
        primaryStage.setTitle("Cadastro de Cliente");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void cadCliente(){
        Long cpf;
        String nome, end, tel, email;
        try {
            cpf = Long.parseLong(tcpf.getText());
            nome = tnome.getText();
            end = tend.getText();
            tel = ttel.getText();
            email = temail.getText();
            
            if("".equals(nome) || null == nome) throw new NullPointerException();
            if("".equals(end) || null == end) throw new NullPointerException();
            if("".equals(tel) || null == tel) throw new NullPointerException();
            if("".equals(email) || null == email) throw new NullPointerException();
            
        }catch(NumberFormatException e){
            InterfacePrincipal.warning("Warning !!","Campo númerico preenchido incorretamente.","Corriga os campos !");
            return;
        }catch(NullPointerException e){
            InterfacePrincipal.warning("Warning !!","Campo em branco.","Preencha todos os campos");
            return;
        }
        
        if(listas.cadastraCliente(cpf, nome, end, tel, email)){
            //Cliente cadastrado com sucesso
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Cliente cadastrado com sucesso.");
            
            //Fechanmento da janela
            alert.showAndWait();
           ((Stage) root.getScene().getWindow()).close();
        }
        else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cliente não cadastrado !");
            alert.setContentText("Cliente já existe no banco de dados.");

            alert.showAndWait();
        }
    }
    
}
