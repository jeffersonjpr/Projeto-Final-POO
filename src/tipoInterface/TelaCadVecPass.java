package tipoInterface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tipoException.CampoNaoInformado;
import tipoException.CampoNumericoInvalido;
import tipoPrograma.Controlador;
import tiposDados.veiculo.Modelo;


public class TelaCadVecPass extends Application {
    GridPane root;
    HBox auxbox1;
    
    //Botoes e painel de apoio
    Button bCadastrar, bCancelar, bCadMod;
    HBox pBotoes;
    
    //labels
    Label lnPassageiros, lplaca, lcor, lnroportas, ltipo_combustivel, lquilometragem, lrenavam, lchassi, lvalor_locacao, lmodelo, lautonomia;
    //textfields
    TextField tnPassageiros, tplaca, tcor, tnroportas, tquilometragem, trenavam, tchassi, tvalor_locacao, tmodelo, tautonomia;
    
    //Combo box
    ComboBox<Modelo> comboModelo;
    ComboBox comboCores;
    
    //listas
    Controlador listas;
    
    //radioButton
    String rcombustiveis[] = {"0 - Gasolina", "1 - Etanol", "2 - Diesel", "3 - Elétrico"};
    RadioButton[] rBcombustiveis = new RadioButton[rcombustiveis.length];
    ToggleGroup tgCombustiveis;
    TilePane hbRadioComb;
    
    public TelaCadVecPass(Controlador listas) {
        this.listas = listas;
    }
    
    @Override
    public void init(){
        //hbox da primeira linha
        auxbox1 = new HBox();
        auxbox1.setSpacing(5);
        //iniciando root
        root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(10));
        
        //labels
        lnPassageiros = new Label("N° de Passageiros: ");
        lplaca = new Label("Placa: ");
        lcor = new Label("Cor: ");
        lnroportas = new Label("N° de portas: ");
        ltipo_combustivel = new Label("Tipo de Combustivel: ");
        lquilometragem = new Label("Quilometragem: ");
        lrenavam = new Label("Renavam: ");
        lchassi = new Label("Chassi: ");
        lvalor_locacao = new Label("Valor de Locação: ");
        lmodelo = new Label("Modelo: ");
        lautonomia = new Label("Autonomia: ");
        
        ////textfields
        tnPassageiros = new TextField();
        tnPassageiros.setMaxWidth(30);
        tplaca = new TextField();
        tplaca.setMaxWidth(100);
        tcor = new TextField();
        tnroportas = new TextField();
        tnroportas.setMaxWidth(40);
        tquilometragem = new TextField();
        trenavam = new TextField();
        tchassi = new TextField();
        tvalor_locacao = new TextField();
        tautonomia = new TextField();
        
        ////combo box
        comboModelo = new ComboBox<>();
        comboModelo.itemsProperty().setValue(listas.getaModelo());
        
        ////botões
        bCadastrar = new Button("Cadastrar");
        //bCadastrar.defaultButtonProperty();
        bCancelar = new Button("Cancelar");
        //bCancelar.cancelButtonProperty();
        bCadMod = new Button("Cad. Modelo");
        pBotoes = new HBox(bCadastrar,bCancelar,bCadMod);
        pBotoes.setSpacing(10);
        pBotoes.setAlignment(Pos.BASELINE_CENTER);
        
        //radioButtons
        hbRadioComb = new TilePane();
        hbRadioComb.setPrefColumns(2);
        hbRadioComb.setTileAlignment(Pos.CENTER_LEFT);
        hbRadioComb.setHgap(5);
        hbRadioComb.setVgap(5);
        
        //combo box cores
        comboCores = new ComboBox();
        comboCores.itemsProperty().setValue(listas.getaCores());
        comboCores.setEditable(true);  
        
        //toggle group combustiveis
        tgCombustiveis = new ToggleGroup();
        for (int i = 0; i < rcombustiveis.length; i++) {
            rBcombustiveis[i] = new RadioButton(rcombustiveis[i]);
            rBcombustiveis[i].setToggleGroup(tgCombustiveis); //togglegroup
            rBcombustiveis[i].setUserData(rBcombustiveis[i]); //user data
            
            hbRadioComb.getChildren().add(rBcombustiveis[i]);
        }
        
        //adicionando a HBOX de apoio, primeira linha do grid pane
        auxbox1.getChildren().add(lnPassageiros);
        auxbox1.getChildren().add(tnPassageiros);
        
        auxbox1.getChildren().add(lplaca);
        auxbox1.getChildren().add(tplaca);
        
        auxbox1.getChildren().add(lnroportas);
        auxbox1.getChildren().add(tnroportas);
        
        ////adiconando ao root
        root.add(auxbox1,0,1,2,1);
        
        root.add(lcor,0,2);
        root.add(comboCores,1,2);
        
        root.add(ltipo_combustivel,0,4);
        root.add(hbRadioComb,1,4,2,1);
        
        root.add(lquilometragem,0,6);
        root.add(tquilometragem,1,6);
        
        root.add(lrenavam,0,7);
        root.add(trenavam,1,7);
        
        root.add(lchassi,0,8);
        root.add(tchassi,1,8);
        
        root.add(lvalor_locacao,0,9);
        root.add(tvalor_locacao,1,9);
        
        root.add(lmodelo,0,10);
        root.add(comboModelo,1,10);
        
        root.add(lautonomia,0,11);
        root.add(tautonomia,1,11);
        
        
        root.add(pBotoes, 0, 12, 2 ,1);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root);
        
        //ações
        bCadMod.setOnAction( e -> cadModelo());
        bCancelar.setOnAction( e -> primaryStage.close());
        bCadastrar.setOnAction (e -> cadVec());
        
        //Configurando Palco principal
        primaryStage.setTitle("Cadastro de Veiculo Passeio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Cria uma nova janela
     * @return retorna se a janela foi criada
     */
    public Stage chamarNovaJanela() {
        Stage novaJanela = new Stage ();
        novaJanela.initOwner((Stage) root.getScene().getWindow());
        novaJanela.initModality(Modality.APPLICATION_MODAL);
        
        return novaJanela;
    }
    
    /**
     * Cria uma janela para cadastrar um novo Modelo
     */
    private void cadModelo() {
        TelaCadModelo tela = new TelaCadModelo(listas);
        tela.init();
        tela.start(chamarNovaJanela());
    }

    /**
     * Cadastra um novo veiculo de passeio
     */
    private void cadVec() {
        int tipo_combustivel;
        int nPassageiros;
        String cor;
        int nroportas;
        long quilometragem;
        long revavam;
        double valor_locacao;
        double autonomia;
        String placa;
        String chassi;
        Modelo modelo;
        //CRIAR CLASEE EX
        try{
            tipo_combustivel = Integer.parseInt((((RadioButton)tgCombustiveis.getSelectedToggle().getUserData()).getText()).substring(0,1));
            nPassageiros = Integer.parseInt(tnPassageiros.getText());
            if(0 >= nPassageiros) throw new CampoNumericoInvalido("N° de Passageiros");
            cor = Controlador.converter(comboCores.getValue().toString());
            nroportas =  Integer.parseInt(tnroportas.getText());
            if(1 > nroportas) throw new CampoNumericoInvalido("N° de Portas");
            quilometragem = Long.parseLong(tquilometragem.getText());
            if(0 > quilometragem) throw new CampoNumericoInvalido("Quilometragem");
            revavam = Long.parseLong(trenavam.getText());
            if(100000000 > revavam) throw new CampoNumericoInvalido("Renavam");
            valor_locacao = Double.parseDouble(tvalor_locacao.getText());
            if(0 >= valor_locacao) throw new CampoNumericoInvalido("Valor Locação");
            autonomia = Double.parseDouble(tautonomia.getText());
            if(5 > autonomia) throw new CampoNumericoInvalido("Autonomia insuficiente");
            
            //throws
            placa = tplaca.getText();
            placa = placa.toUpperCase();
            chassi = tchassi.getText();
            chassi = chassi.toUpperCase();
            modelo = comboModelo.getValue();
            
            if("".equals(placa) || null == placa || placa.length() != 7) throw new CampoNaoInformado("Placa");
            if("".equals(chassi) || null == chassi) throw new CampoNaoInformado("Chassi");
            if("".equals(cor) || null == cor) throw new CampoNaoInformado("Cor");
            if(null == modelo) throw new CampoNaoInformado("Modelo");
            
        }catch(NumberFormatException e){
            InterfacePrincipal.warning("Warning !!","Campo númerico preenchido incorretamente.","Corriga os campos !");
            return;
        }catch(NullPointerException e){
            InterfacePrincipal.warning("Warning !!","Campo em branco.","Preencha todos os campos");
            return;
        }catch(CampoNumericoInvalido e) {
            InterfacePrincipal.warning("Warning !!", e.toString(), "preencha novamente.");
            return;
        }catch(CampoNaoInformado e) {
            InterfacePrincipal.warning("Warning !!", e.toString(), "Informe o campo.");
            return;
        }
        
        listas.cadastraCores(cor);
        //Mensagem de erro caso um veiculo identico ja esteja cadastrado
        if(!listas.cadastraVecPasseio(nPassageiros, placa, cor, nroportas, tipo_combustivel, quilometragem, revavam, chassi, valor_locacao, modelo, autonomia)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText("Veiculo não cadastrado !");
            alert.setContentText("Veiculo já existe no banco de dados.");

            alert.showAndWait();
        }
        else{
            //Veiculo cadastrado com sucesso
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Veículo cadastrado com sucesso.");
            
            //Fechanmento da janela
            alert.showAndWait();
           ((Stage) root.getScene().getWindow()).close();
        }
    }
    
    
}
