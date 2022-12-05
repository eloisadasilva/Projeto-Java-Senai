package cadastros;

import cadastros.documento.Documento;
import listasFuncionarios.ListaFuncionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static listasFuncionarios.ListaDocumentos.listaDocumentosPendentes;

public class Funcionario extends Colaborador {
    private static Integer contador = 0;


    public Funcionario(String nome, String sobrenome, String dataNascimento, String cpf, String endereco) {
        super(String.valueOf(contador++), nome, sobrenome, dataNascimento, cpf, endereco);

        ListaFuncionarios.adicionar(this);
    }


    // Para o funcionário adicionar um documento na lista de documentos pendentes:
    @Override
    public void adicionarDocumento(Documento documento){
        listaDocumentosPendentes.add(documento);
        System.out.println("Documento Criado pelo Funcionário");
    }

  //  public static void listarDocumentosCriados() {
       // System.out.println("Lista de documentos criados: ");

       // for (Documento documento : listaDocumentosPendentes) {
       //     if (Objects.equals(Documento.getIdDocumento(), Documento.getIdCriador())) {
       // listaDocumentosPendentes.forEach(documento -> System.out.println(documento));

          //  }
          //  System.out.println(documento);
//    }



}



