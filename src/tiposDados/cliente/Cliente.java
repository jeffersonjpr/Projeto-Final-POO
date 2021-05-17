package tiposDados.cliente;

import java.io.Serializable;


public class Cliente implements Serializable{

    private long cpf_cli;
    private String nom_cli;
    private String end_cli;
    private String tel_cli;
    private String email_cli;

    //constructor
    public Cliente(long cpf_cli, String nom_cli, String end_cli, String tel_cli, String email_cli) {    
        this.cpf_cli = cpf_cli;
        this.nom_cli = nom_cli;
        this.end_cli = end_cli;
        this.tel_cli = tel_cli;
        this.email_cli = email_cli;
    }

    @Override
    public String toString() {
        return nom_cli + " " + cpf_cli;
    }

    //get set
    public long getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(long cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public String getEnd_cli() {
        return end_cli;
    }

    public void setEnd_cli(String end_cli) {
        this.end_cli = end_cli;
    }

    public String getTel_cli() {
        return tel_cli;
    }

    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    

}
