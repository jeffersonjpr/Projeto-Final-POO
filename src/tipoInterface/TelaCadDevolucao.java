package tipoInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tipoException.CampoNumericoInvalido;
import tipoException.DataInvalidaExecption;
import tipoPrograma.Controlador;
import tiposDados.locacao.Locacao;

public class TelaCadDevolucao extends Application {
    GridPane root;
    
    HBox  hdev,hdev2,aux1;
    
    DatePicker  dataDev;
    
    //botoes
    Button bCadastrar, bCancelar;
    HBox pBotoes;
    
    //combobox
    ComboBox<Locacao> comboLocacao;
    
    //listas
    Controlador listas;
    //label
    Label ldt_devolucao, lhora_devolucao, lcomboloc;
    Label lquilometragem, lvalor_locacao; 
    
    //text fields
    TextField tquilometragem, tvalloc;
        
    //spiner horario
    Spinner<Integer> shrdev,smindev;
    
    public TelaCadDevolucao(Controlador listas) {
        this.listas = listas;
    }
    
    
    @Override
    public void init(){
        hdev = TelaCadLocacao.setHcaixa();
        hdev2 = TelaCadLocacao.setHcaixa();
        aux1 = TelaCadLocacao.setHcaixa();
        
        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10));
        
        //botoes
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");
        pBotoes = new HBox(bCadastrar,bCancelar);
        pBotoes.setSpacing(10);
        pBotoes.setAlignment(Pos.BASELINE_CENTER);
        
        //textfields
        tquilometragem = new TextField();
        tvalloc = new TextField();
        //labels
        ldt_devolucao = new Label("Data de Devolução: ");
        lhora_devolucao = new Label("Hora de Devolução: ");
        lcomboloc = new Label("Locação: ");
        lquilometragem = new Label("Quilometragem na Devolução: ");
        lvalor_locacao = new Label("Valor Locação: ");
        
        //date picker
        dataDev = new DatePicker();
        //devolucao
        shrdev = TelaCadLocacao.setRodador(0, 23, 12, 1);
        smindev = TelaCadLocacao.setRodador(0,50,30,10);
        
        //combo
        hdev.getChildren().addAll(ldt_devolucao,dataDev);
        hdev2.getChildren().addAll(lhora_devolucao,shrdev,smindev,lvalor_locacao,tvalloc);
        
        //combo
        comboLocacao = new ComboBox<>();
        comboLocacao.itemsProperty().setValue(listas.getaLocacao());
        
        
        aux1.getChildren().addAll(lcomboloc,comboLocacao,lquilometragem,tquilometragem);
        //adiconando ao root
        root.add(aux1,0,0);
        root.add(hdev, 0, 1);
        root.add(hdev2, 0, 2);
        root.add(pBotoes, 0, 3);
    }
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root);
        
        bCadastrar.setOnAction (e -> registraDevolucao());
        bCancelar.setOnAction( e -> primaryStage.close());
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void registraDevolucao() {
        Locacao auxloc;
        LocalDate dt_devolucao;
        LocalTime hora_devolucao;
        long quilometragem;
        double valor_locacao;
        
        try {
            auxloc = comboLocacao.getValue();
            if(auxloc.isDevolvido()){
                InterfacePrincipal.warning("Warning !!", "Veículo já devolvido.", "Selecione uma locação.");
                return;
            }
            
            dt_devolucao = dataDev.getValue();
            if(null == dt_devolucao) throw new DataInvalidaExecption("Data Devolução");
            
            hora_devolucao = LocalTime.of(shrdev.getValue(), smindev.getValue());
            
            if(dt_devolucao.isBefore(auxloc.getDt_locacao()))throw new DataInvalidaExecption("Data de devolução anterior a Locação");
            else if(dt_devolucao.isEqual(auxloc.getDt_locacao())){
                if(hora_devolucao.isBefore(auxloc.getHora_locacao())) throw new DataInvalidaExecption("Hora de devolução anterior a Locação");
            }
            
            quilometragem = Long.parseLong(tquilometragem.getText());
            valor_locacao = Double.parseDouble(tvalloc.getText());
            
            if(quilometragem < auxloc.getAutomovel().getQuilometragem()) throw new CampoNumericoInvalido("Quilometragem menor que a anterior.");
            
            if(valor_locacao <= 0) throw new CampoNumericoInvalido("Valor de locação invalido");
        } catch (NullPointerException e) {
            InterfacePrincipal.warning("Warning !!", "Locação não selecionada.", "Selecione uma locação.");
            return;
        }catch(NumberFormatException e){
            InterfacePrincipal.warning("Warning !!","Campo númerico preenchido incorretamente.","Corriga o campo !");
            return;
        }catch (DataInvalidaExecption e) {
            InterfacePrincipal.warning("Warning !!", e.toString(), "Escolha outra data.");
            return;
        }catch (CampoNumericoInvalido e) {
            InterfacePrincipal.warning("Warning !!", e.toString(), "preencha novamente.");
            return;
        }
        
        auxloc.setDt_devolucao(dt_devolucao);
        auxloc.setHora_devolucao(hora_devolucao);
        auxloc.setQuilometragem(quilometragem);
        auxloc.getAutomovel().setQuilometragem(quilometragem);
        auxloc.setValor_locacao(valor_locacao);
        auxloc.setDevolvido(true);
        
        //Devolução cadastrada com sucesso
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Locação Cadastrada com sucesso.");

        //Fechanmento da janela
        alert.showAndWait();
       ((Stage) root.getScene().getWindow()).close();
    }
    
}
