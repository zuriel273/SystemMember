/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Arlindo
 */
public class Membro {
    private int id;
    private String nome,dataBatismo,congregacao,rg,cpf;
    private String dataNascimento,nomeDoPai,nomeDaMae,naturalidade,sexo,status,telefone;
    private byte[] foto;

    public Membro(String nome, String dataBatismo, String congregacao, String rg, String cpf, String dataNascimento, String nomeDoPai, String nomeDaMae, String naturalidade,String sexo,String status,byte[] foto, String telefone ) {
        this.nome = nome;
        this.dataBatismo = dataBatismo;
        this.congregacao = congregacao;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.status = status;
        this.foto = foto;
        this.telefone = telefone;
    }
    
    public Membro(String nome, String dataBatismo, String congregacao, String rg, String cpf, String dataNascimento, String nomeDoPai, String nomeDaMae, String naturalidade,String sexo,String status, String telefone) {
        this.nome = nome;
        this.dataBatismo = dataBatismo;
        this.congregacao = congregacao;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nomeDoPai = nomeDoPai;
        this.nomeDaMae = nomeDaMae;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.status = status;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(String dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCongregacao() {
        return congregacao;
    }

    public void setCongregacao(String congregacao) {
        this.congregacao = congregacao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
 }
