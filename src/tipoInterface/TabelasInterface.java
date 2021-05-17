/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoInterface;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tipoPrograma.Controlador;


public class TabelasInterface{
    
    /**
     * 
     * @param listas Objeto do tipo Controlador contendo as listas principais
     * @return Uma tabela TableView adequada a lista de clientes
     */
    public static TableView tableCliente(Controlador listas){
        
        TableView table = new TableView();
        //table.setEditable(true);
        
        TableColumn ccpf = new TableColumn("CPF");
        ccpf.setCellValueFactory(new PropertyValueFactory<>("cpf_cli"));
        
        TableColumn cnome = new TableColumn("Nome");
        cnome.setCellValueFactory(new PropertyValueFactory<>("nom_cli"));
        
        TableColumn cend = new TableColumn("Endereço");
        cend.setCellValueFactory(new PropertyValueFactory<>("end_cli"));
        
        TableColumn ctel = new TableColumn("Telefone");
        ctel.setCellValueFactory(new PropertyValueFactory<>("tel_cli"));
        
        TableColumn cemail = new TableColumn("Email");
        cemail.setCellValueFactory(new PropertyValueFactory<>("email_cli"));
        
        table.getColumns().addAll(ccpf, cnome, cend, ctel, cemail);
        table.setItems(listas.getaCliente());
        
        return table;
    }
    
    public static TableView tableLocacao(Controlador listas){
        
        TableView table = new TableView();
        
        //private LocalDate dt_locacao;
        //private LocalTime hora_locacao;
        //private LocalDate dt_devolucao;
        //private LocalTime hora_devolucao;
        //private long quilometragem;
        //private double valor_caucao;
        //private double valor_locacao;
        //private boolean devolvido;
        //
        //private Cliente cliente;
        //private Automovel automovel;
        
        TableColumn cdtloc = new TableColumn("Data Locação");
        cdtloc.setCellValueFactory(new PropertyValueFactory<>("dt_locacao"));
        
        TableColumn chrloc = new TableColumn("Hora Locação");
        chrloc.setCellValueFactory(new PropertyValueFactory<>("hora_locacao"));
        
        TableColumn cdtdev = new TableColumn("Data Devolução");
        cdtdev.setCellValueFactory(new PropertyValueFactory<>("dt_devolucao"));
        
        TableColumn chrdev = new TableColumn("Hora Devolução");
        chrdev.setCellValueFactory(new PropertyValueFactory<>("hora_devolucao"));
        
        TableColumn cquilome = new TableColumn("Quilometragem");
        cquilome.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
        
        TableColumn cvalcauc = new TableColumn("Valor Caução");
        cvalcauc.setCellValueFactory(new PropertyValueFactory<>("valor_caucao"));
        
        TableColumn cvalloc = new TableColumn("Valor Locação");
        cvalloc.setCellValueFactory(new PropertyValueFactory<>("valor_locacao"));
        
        TableColumn cdevolvido = new TableColumn("Devolvido");
        cdevolvido.setCellValueFactory(new PropertyValueFactory<>("devolvido"));
        
        TableColumn ccliente = new TableColumn("Cliente");
        ccliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        ccliente.minWidthProperty();
        
        TableColumn cautomovel = new TableColumn("Automovel");
        cautomovel.setCellValueFactory(new PropertyValueFactory<>("automovel"));
        
        
        
        table.getColumns().addAll(ccliente,cautomovel, cdevolvido, cdtloc, chrloc, cdtdev, chrdev, cquilome, cvalcauc,cvalloc);
        table.setItems(listas.getaLocacao());
        
        return table;
    }
    
    public static TableView tableVecPass(Controlador listas){
        TableView table = new TableView();
        
        
        //private String placa;
        //private String cor;
        //private int nroportas;
        //private int tipo_combustivel;
        //private long quilometragem;
        //private long renavam;
        //private String chassi;
        //private double valor_locacao;
        //private int npassageiros;
        
        TableColumn cplaca = new TableColumn("Placa");
        cplaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        
        TableColumn ccor = new TableColumn("Cor");
        ccor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        
        TableColumn cnpas = new TableColumn("N pass");
        cnpas.setCellValueFactory(new PropertyValueFactory<>("npassageiros"));
        
        TableColumn cModelo = new TableColumn("Modelo");
        cModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        
        TableColumn cnroportas = new TableColumn("N° Portas");
        cnroportas.setCellValueFactory(new PropertyValueFactory<>("nroportas"));
        
        TableColumn ctipo_combustivel = new TableColumn("Combustivel");
        ctipo_combustivel.setCellValueFactory(new PropertyValueFactory<>("tipo_combustivel"));
        
        TableColumn cquilometragem = new TableColumn("Quilometragem");
        cquilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
        
        TableColumn crenavam = new TableColumn("Renavam");
        crenavam.setCellValueFactory(new PropertyValueFactory<>("renavam"));
        
        TableColumn cchassi = new TableColumn("Chassi");
        cchassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
        
        TableColumn cvalloc = new TableColumn("Valor Locação");
        cvalloc.setCellValueFactory(new PropertyValueFactory<>("valor_locacao"));
        
        TableColumn cautonomia = new TableColumn("Autonomia");
        cautonomia.setCellValueFactory(new PropertyValueFactory<>("autonomia"));
        
        
        
        table.getColumns().addAll(cModelo, cplaca, ccor, cnpas, cnroportas, ctipo_combustivel, cquilometragem, crenavam, cchassi, cvalloc, cautonomia);
        table.setItems(listas.getaVecPasseio());
        return table;
    }
    
    public static TableView tableVecCarg(Controlador listas){
        TableView table = new TableView();
        
        
        //private String placa;
        //private String cor;
        //private int nroportas;
        //private int tipo_combustivel;
        //private long quilometragem;
        //private long renavam;
        //private String chassi;
        //private double valor_locacao;
        //private int npassageiros;
        
        TableColumn cplaca = new TableColumn("Placa");
        cplaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        
        TableColumn ccor = new TableColumn("Cor");
        ccor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        
        TableColumn cCargaMax = new TableColumn("Carga Max");
        cCargaMax.setCellValueFactory(new PropertyValueFactory<>("cargaMax"));
        
        TableColumn cModelo = new TableColumn("Modelo");
        cModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        
        TableColumn cnroportas = new TableColumn("N° Portas");
        cnroportas.setCellValueFactory(new PropertyValueFactory<>("nroportas"));
        
        TableColumn ctipo_combustivel = new TableColumn("Combustivel");
        ctipo_combustivel.setCellValueFactory(new PropertyValueFactory<>("tipo_combustivel"));
        
        TableColumn cquilometragem = new TableColumn("Quilometragem");
        cquilometragem.setCellValueFactory(new PropertyValueFactory<>("quilometragem"));
        
        TableColumn crenavam = new TableColumn("Renavam");
        crenavam.setCellValueFactory(new PropertyValueFactory<>("renavam"));
        
        TableColumn cchassi = new TableColumn("Chassi");
        cchassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
        
        TableColumn cvalloc = new TableColumn("Valor Locação");
        cvalloc.setCellValueFactory(new PropertyValueFactory<>("valor_locacao"));
        
        TableColumn cautonomia = new TableColumn("Autonomia");
        cautonomia.setCellValueFactory(new PropertyValueFactory<>("autonomia"));
        
        
        
        table.getColumns().addAll(cModelo, cplaca, ccor, cCargaMax, cnroportas, ctipo_combustivel, cquilometragem, crenavam, cchassi, cvalloc, cautonomia);
        table.setItems(listas.getaVecCarga());
        return table;
    }
}
