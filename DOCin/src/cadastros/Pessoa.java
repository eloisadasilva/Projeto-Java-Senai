package cadastros;

import listasFuncionarios.ListaPessoas;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Pessoa {
    private static Integer contador = 0;
   public static Integer identificador;
    private Integer idade;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String cpf;
    private String endereco;

    public Pessoa() {
    }

    public Pessoa(String identificador, String nome, String sobrenome, String dataNascimento, String cpf, String endereco) {

        this.identificador = contador++;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.validaCpf(cpf);
        this.endereco = endereco;
        //this.calculaIdade();
        ListaPessoas.adicionar(this);
    }
    void validaCpf(String cpf){

    }
    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    //public void calculaIdade(){
      //  this.idade = Date.now().getYear() - dataNascimento.getYear();
   // }

    @Override
    public String toString() {
        return "cadastroFuncionarios.Pessoa{" +
                "idade=" + idade +
                ", nome=" + nome + '\'' +
                ", sobrenome=" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public void inferir(){

    }

    public void gerarId(){

    }

    public void consultar(){

    }
}
