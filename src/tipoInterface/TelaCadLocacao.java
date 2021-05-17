/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tipoException.CampoNaoInformado;
import tipoException.CampoNumericoInvalido;
import tipoException.DataInvalidaExecption;
import tipoPrograma.Controlador;
import tiposDados.cliente.Cliente;
import tiposDados.locacao.Locacao;
import tiposDados.veiculo.Automovel;

/**
 *
 * @author jefferson
 */
public class TelaCadLocacao extends Application {
    GridPane root;
    HBox hloc, hdev, hcliaut;
    HBox aux1,aux2;
    //labels
    Label ldt_locacao, lhora_locacao, ldt_devolucao, lhora_devolucao;
    Label lquilometragem, lvalor_caucao, lvalor_locacao; //ldevolvido;
    Label lautomovel, lcliente;
    
    //botoes
    Button bCadastrar, bCancelar;
    HBox pBotoes;
    
    //radio button
    RadioButton rDevolvido;
    //Combo box
    ComboBox<Automovel> comboAutomovel;
    ComboBox<Cliente> comboCliente;
    
    //date picker
    DatePicker dataLoc, dataDev;
    
    //spiner horario
    Spinner<Integer> shrloc,sminloc,shrdev,smindev;
    
    //text fields
    TextField tquilometragem, tValorCaucao, tValorLoc;
    //listas
    Controlador listas;
    @Override
    public void init(){
        //hbox da locacao
        hloc = setHcaixa();
        //hbox da devolucao
        hdev = setHcaixa();
        //hbox cliente/automovel
        hcliaut = setHcaixa();
        
        aux1 = setHcaixa();
        aux2 = setHcaixa();
        
        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10));
        
        //labels
        ldt_locacao = new Label("Data de Locação: ");
        lhora_locacao = new Label("Hora de Locação: ");
        ldt_devolucao = new Label("Data de Devolução: ");
        lhora_devolucao = new Label("Hora de Devolução: ");
        lquilometragem = new Label("Quilometragem na Devolução: ");
        lvalor_caucao = new Label("Valor Caução: ");
        lvalor_locacao = new Label("Valor Locação: ");
        //ldevolvido = new Label("Foi devolvido: ");
        lautomovel = new Label("Automóvel: ");
        lcliente = new Label("Cliente: ");
        
        //datePicker
        dataLoc = new DatePicker();
        dataDev = new DatePicker();
        
        //textfields
        tquilometragem = new TextField();
        tValorCaucao = new TextField();
        tValorLoc = new TextField();
        
        //spinners
        //devolucao
        shrloc = setRodador(0, 23, 12, 1);
        sminloc = setRodador(0,50,30,10);
        //loccacao
        shrdev = setRodador(0, 23, 12, 1);
        smindev = setRodador(0,50,30,10);
        
        //Combobox
        comboAutomovel = new ComboBox<>();
        comboAutomovel.itemsProperty().setValue(listas.getAutomovel());
        comboCliente = new ComboBox<>();
        comboCliente.itemsProperty().setValue(listas.getaCliente());
        
        //botoes
        bCadastrar = new Button("Cadastrar");
        bCancelar = new Button("Cancelar");
        pBotoes = new HBox(bCadastrar,bCancelar);
        pBotoes.setSpacing(10);
        pBotoes.setAlignment(Pos.BASELINE_CENTER);
        
        //radio button
        rDevolvido = new RadioButton("Devolvido");
        
        //adicionando ao root
        hloc.getChildren().addAll(ldt_locacao,dataLoc,lhora_locacao,shrloc,sminloc);
        hdev.getChildren().addAll(ldt_devolucao,dataDev,lhora_devolucao,shrdev,smindev);
        hcliaut.getChildren().addAll(lautomovel,comboAutomovel,lcliente,comboCliente);

        aux1.getChildren().addAll(rDevolvido,lquilometragem,tquilometragem);
        aux2.getChildren().addAll(lvalor_caucao,tValorCaucao,lvalor_locacao,tValorLoc);
        
        root.add(hloc,0,0,3,1);
        root.add(hdev,0,1,3,1);
        root.add(hcliaut,0,2,3,1);
        root.add(aux1, 0, 3, 3, 1);
        root.add(aux2, 0, 4, 3, 1);
        root.add(pBotoes, 0, 5, 3, 1);
    }

    public TelaCadLocacao(Controlador listas) {
        this.listas = listas;
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root);
        
        bCadastrar.setOnAction (e -> cadLocacao());
        bCancelar.setOnAction( e -> primaryStage.close());
        
        
        primaryStage.setTitle("Cadastra Locação");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Spinner setRodador(int min, int max, int ini, int step){
        Spinner auxSpin;
        auxSpin = new Spinner<>(min, max, ini, step);
        auxSpin.setMaxWidth(60);
        
        return auxSpin;
    }
    public static HBox setHcaixa(){
        HBox auxCaixa;
        auxCaixa = new HBox();
        auxCaixa.setSpacing(10);
        auxCaixa.setAlignment(Pos.CENTER);
        
        return auxCaixa;
    }

    private void cadLocacao() {
        //se o radiobutton estiver selecionado
        if(rDevolvido.isSelected()) cadDevolvido();
        else cadRetirada();
    }

    private void cadDevolvido() {
        LocalDate dt_locacao;
        LocalTime hora_locacao;
        LocalDate dt_devolucao;
        LocalTime hora_devolucao;
        long quilometragem;
        double valor_caucao;
        double valor_locacao;

        Cliente cliente;
        Automovel automovel;
        
        try{
            dt_locacao = dataLoc.getValue();
            if(null == dt_locacao) throw new DataInvalidaExecption("Data Locação");
            hora_locacao = LocalTime.of(shrloc.getValue(), sminloc.getValue());
            if(null == hora_locacao) throw new DataInvalidaExecption("Hora Locação");
            dt_devolucao = dataDev.getValue();
            if(null == dt_devolucao) throw new DataInvalidaExecption("Data Devolução");
            hora_devolucao = LocalTime.of(shrdev.getValue(), smindev.getValue());
            if(null == hora_devolucao) throw new DataInvalidaExecption("Hora Devolução");
            
            if(dt_devolucao.isBefore(dt_locacao))throw new DataInvalidaExecption("Data de devolução anterior a Locação");
            else if(dt_devolucao.isEqual(dt_locacao)){
                if(hora_devolucao.isBefore(hora_locacao)) throw new DataInvalidaExecption("Hora de devolução anterior a Locação");
            }
            
            
            
            automovel = comboAutomovel.getValue();
            if(null == automovel) throw new CampoNaoInformado("Automovel");
            cliente = comboCliente.getValue();
            if(null == cliente) throw new CampoNaoInformado("Cliente");
            
            
            
            
            quilometragem = Long.parseLong(tquilometragem.getText());
            if(quilometragem < automovel.getQuilometragem()) throw new CampoNumericoInvalido("Quilometragem");
            valor_caucao = Double.parseDouble(tValorCaucao.getText());
            valor_locacao = Double.parseDouble(tValorLoc.getText());
            
        }catch(NumberFormatException e){
            InterfacePrincipal.warning("Warning !!","Campo númerico preenchido incorretamente.","Corriga os campos !");
            return;
        }catch(NullPointerException e){
            InterfacePrincipal.warning("Warning !!","Campo em branco.","Preencha todos os campos");
            return;
        }catch(CampoNaoInformado e){
            InterfacePrincipal.warning("Warning !!", e.toString(), "Preencha novamente.");
            return;
        } catch (DataInvalidaExecption e) {
            InterfacePrincipal.warning("Warning !!", e.toString(), "Escolha outra data.");
            return;
        } catch (CampoNumericoInvalido e) {
            InterfacePrincipal.warning("Warning !!", e.toString(), "preencha novamente.");
            return;
        }
        
        automovel.setQuilometragem(quilometragem);
        alerta(listas.cadastraLocacao(dt_locacao, hora_locacao, dt_devolucao, hora_devolucao, quilometragem, valor_caucao, valor_locacao, true, cliente, automovel));
    }

    private void cadRetirada() {
        LocalDate dt_locacao;
        LocalTime hora_locacao;
        double valor_caucao;
        Cliente cliente;
        Automovel automovel;
        
        try{
            dt_locacao = dataLoc.getValue();
            hora_locacao = LocalTime.of(shrloc.getValue(), sminloc.getValue());
            
            automovel = comboAutomovel.getValue();
            if(null == automovel) throw new CampoNaoInformado("Automovel");
            cliente = comboCliente.getValue();
            if(null == cliente) throw new CampoNaoInformado("Cliente");
            
            if(!verificaLocacao(automovel)) throw new DataInvalidaExecption("Veiculo Já Locado");
            
            valor_caucao = Double.parseDouble(tValorCaucao.getText());
            
        }catch(NumberFormatException e){
            InterfacePrincipal.warning("Warning !!","Campo númerico preenchido incorretamente.","Corriga os campos !");
            return;
        }catch(NullPointerException e){
            InterfacePrincipal.warning("Warning !!","Campo em branco.","Preencha todos os campos");
            return;
        }catch(CampoNaoInformado e){
            InterfacePrincipal.warning("Warning !!", e.toString(), "Preencha novamente.");
            return;
        }catch (DataInvalidaExecption e) {
            InterfacePrincipal.warning("Warning !!", e.toString(), "Escolha outra data.");
            return;
        }
        
        alerta(listas.cadastraLocacao(dt_locacao, hora_locacao, valor_caucao, cliente, automovel));

    }
    
    private void alerta(boolean aux){
        if(aux){
            //Veiculo cadastrado com sucesso
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Locação Cadastrada com sucesso.");
            
            //Fechanmento da janela
            alert.showAndWait();
           ((Stage) root.getScene().getWindow()).close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText("Locação não cadastrada!");
            alert.setContentText("Locação ja existe no banco de dados");

            alert.showAndWait();
        }
    }

    private boolean verificaLocacao(Automovel automovel) {
        for (Locacao loc : listas.getaLocacao()) {
            if(loc.getAutomovel() == automovel){
                if(!loc.isDevolvido()) return false;
            }
        }
        return true;
    }
}
