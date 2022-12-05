package listasFuncionarios;

import cadastros.documento.Documento;

import java.util.ArrayList;
import java.util.List;



public class ListaDocumentos {

    public static List<Documento> listaDocumentosPendentes = new ArrayList<>();
    private static List <Documento> listaDocumentosRejeitados = new ArrayList<>();
    public static List <Documento> listaDocumentosAprovados = new ArrayList<>();
    public static List <Documento> listaDocumentosArquivados = new ArrayList<>();


    //Relatóros de documentos:
    public static List<Documento> listarDocumentosPendentes(){
        return listaDocumentosPendentes;
    }

    public static List<Documento> listarDocumentosRejeitados(){
        return listaDocumentosRejeitados;
    }

    public static List<Documento> listarDocumentosAprovados(){
        return listaDocumentosAprovados;
    }

    public static List<Documento> listarDocumentosArquivados(){
        return listaDocumentosArquivados;
    }

    //Para listar todos os documentos e contabilizar o total:
    public static List<Documento> listarTodos(){
        List<Documento> todosDocumentos = new ArrayList<>();
        todosDocumentos.addAll(listaDocumentosPendentes);
        todosDocumentos.addAll(listaDocumentosRejeitados);
        todosDocumentos.addAll(listaDocumentosAprovados);
        todosDocumentos.addAll(listaDocumentosArquivados);
        return todosDocumentos;
    }


}
