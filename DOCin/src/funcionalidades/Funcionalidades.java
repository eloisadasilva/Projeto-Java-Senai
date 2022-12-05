package funcionalidades;

import cadastros.Funcionario;
import cadastros.Gerente;
import cadastros.Supervisor;
import cadastros.documento.Documento;
import listasFuncionarios.*;

import java.util.*;
import java.util.random.RandomGenerator;

import static cadastros.documento.Documento.*;

public class Funcionalidades {

    //Para criar documentos e deixá-los na lista de documentos pendentes:
    public void criarDocumento(Funcionario usuario){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o link do documento:");
        String link = scanner.nextLine();

        System.out.print("Confirme o seu identificador:");
        Integer idCriador = scanner.nextInt();

        System.out.print("Digite o identificador do responsável que irá avaliar o documento:");
        Integer idResponsavel = scanner.nextInt();

        System.out.print("Digite a data de criação:");
        String dataDocumento = scanner.next();

        String estado = "Ativo";

        Long idDocumento = RandomGenerator.getDefault().nextLong();
        Documento documento = new Documento(idDocumento, idCriador, idResponsavel, link, dataDocumento, "Ativo");
        usuario.adicionarDocumento(documento);
    }


  public void aprovarDocumento(Supervisor usuario) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Confirme o identificador do documento a ser aprovado:");
      Integer idDocumento = scanner.nextInt();
      incluirListaAprovados(Long.valueOf(idDocumento));
 }

    public void rejeitarDocumento(Supervisor usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirme o identificador do documento a ser rejeitado:");
        Integer idDocumento = scanner.nextInt();
        System.out.print("Confirme o identificador do funcionário que irá ajustar o documento:");
        Integer idResponsavel = scanner.nextInt();
        incluirListaRejeitados(Long.valueOf(idDocumento), idResponsavel);
    }

    public void arquivarDocumento(Gerente usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirme o identificador do documento a ser rejeitado:");
        Integer idDocumento = scanner.nextInt();
        incluirListaArquivados(Long.valueOf(idDocumento));
    }

    public void desarquivarDocumento(Gerente usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Confirme o identificador do documento a ser rejeitado:");
        Integer idDocumento = scanner.nextInt();
        incluirListaAprovados(Long.valueOf(idDocumento));
    }


    //Relatórios:
    public void listaFuncionarios() {
        System.out.printf(ListaFuncionarios.listarFuncionarios().toString());
    }

    public void listaSupervisores() {
        System.out.printf(ListaSupervisores.listarSupervisores().toString());
    }

    public void listaGerentes() {
        System.out.printf(ListaGerentes.listarGerentes().toString());
    }

    public void listaDocumentosPendentes() {
        System.out.printf(ListaDocumentos.listarDocumentosPendentes().toString());
    }

    public void listaDocumentosRejeitados() {
        System.out.printf(ListaDocumentos.listarDocumentosRejeitados().toString());
    }

    public void listaDocumentosAprovados() {
        System.out.printf(ListaDocumentos.listarDocumentosAprovados().toString());
    }

    public void listaDocumentosArquivados() {
        System.out.printf(ListaDocumentos.listarDocumentosArquivados().toString());
    }

    public void listaTodosDocumentos() {
        System.out.printf(ListaDocumentos.listarTodos().toString());
        }

    public void qtdTotalDocumentos() {
        System.out.printf(contarDocumento().toString());
    }


}
