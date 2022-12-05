package cadastros;

import cadastros.documento.Documento;
import listasFuncionarios.ListaSupervisores;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Supervisor extends Colaborador {

    private static Integer contador = 0;
    private List<Documento> listaDocumentosPendentes = new ArrayList<>();
    private List<Documento> listaDocumentosAprovados = new ArrayList<>();

    private List<Documento> listaDocumentosReprovados = new ArrayList<>();
    public Supervisor(String nome, String sobrenome, String dataNascimento, String cpf, String endereco) {
        super(String.valueOf(contador++), nome, sobrenome, dataNascimento, cpf, endereco);
        ListaSupervisores.adicionar(this);
    }

   // @Override
  //  public void adicionarDocumento(Documento documento){
     //   listaDocumentosPendentes.add(documento);
     //   System.out.println("Documento Criado pelo Supervisor");}

    public void aprovarDocumento(Long idMedicamentoPendente) {
            for (Documento documento : listaDocumentosPendentes) {
            if (Objects.equals(Documento.getIdDocumento(), idMedicamentoPendente)) {
                listaDocumentosPendentes.remove(documento);
                //documento.setNome("nome2");
                listaDocumentosAprovados.add(documento);
            }
                System.out.println("Documento com ID " + Documento.getIdDocumento() + " foi aprovado pelo supervisor " +  this.getNome());
        }
    }

    public void reverterDocumentoAprovado(Long idDocumentoAprovado) {
        System.out.println("Medicacao Revertida por FarmaceuticoSenior, nome: " + this.getNome());

        for (Documento documento :
                listaDocumentosAprovados) {
            if (Objects.equals(Documento.getIdDocumento(), idDocumentoAprovado)) {
                listaDocumentosPendentes.add(documento);
                listaDocumentosPendentes.remove(documento);
            }
            System.out.println("Documento com ID " + Documento.getIdDocumento() + " foi revertido de aprovado para pendente pelo supervisor " +  this.getNome());
        }
    }

    public void reprovarDocumento(Long idDocumento, Funcionario funcionario) {
        for (Documento documento : listaDocumentosPendentes) {
            if (Objects.equals(Documento.getIdDocumento(), idDocumento)) {
                funcionario.adicionarDocumento(documento);
                listaDocumentosPendentes.remove(documento);
            }
        }
    }



}
