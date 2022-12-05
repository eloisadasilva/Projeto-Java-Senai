package cadastros.documento;


import listasFuncionarios.ListaDocumentos;
import listasFuncionarios.ListaFuncionarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.random.RandomGenerator;

import static listasFuncionarios.ListaDocumentos.listaDocumentosAprovados;
import static listasFuncionarios.ListaDocumentos.listaDocumentosArquivados;

public class Documento {

    private static Long idDocumento;
    private static Integer idResponsavel;
    private static Integer idCriador;
    private static String link;
    private static String dataDocumento;
    private static String estado; //arquivado ou ativo

    public Documento(Long idDocumento, Integer idCriador, Integer idResponsavel, String link, String dataDocumento, String ativo) {
    }
    private static List<Documento> listaDocumentosPendentes = new ArrayList<>();
    private static List <Documento> listaDocumentosRejeitados = new ArrayList<>();

    public Documento(Integer idDocumento, Integer idResponsavel, Integer idCriador, String link, String dataDocumento, String estado) {
        this.idDocumento = Long.valueOf(idDocumento);
        this.idResponsavel = idResponsavel;
        this.idCriador = idCriador;
        this.link = link;
        this.dataDocumento = dataDocumento;
        this.estado = estado;
        this.idDocumento = RandomGenerator.getDefault().nextLong();
    }



    @Override
    public String toString() {
        return "cadastros.documento.Documento{" +
                ", idDocumento='" + idDocumento + '\'' +
                ", idResponsavel='" + idResponsavel + '\'' +
                ", idCriador='" + idCriador + '\'' +
                ", link=" + link +
                ", estado='" + estado + '\'' +
                '}';
    }

    public static Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public static Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public static Integer getIdCriador() {
        return idCriador;
    }

    public void setIdCriador(Integer idCriador) {
        this.idCriador = idCriador;
    }

    public static String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public static String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    //Para o supervisor aprovar documento e deixá-lo na lista de aprovados para o gerente avaliar:
    public static void incluirListaAprovados(Long idDocumento){
        for (Documento documento : ListaDocumentos.listaDocumentosPendentes) {
            try{
                if (Objects.equals(getIdDocumento(), idDocumento)) {
                ListaDocumentos.listaDocumentosPendentes.remove(documento);
                listaDocumentosAprovados.add(documento);
                documento.setIdResponsavel(idResponsavel);
                }
            }catch (Exception e){
                throw e;
            }
        }
    }


    //Para o supervisor rejeitar documento e deixá-lo na lista de pendentes para o funcionário ajustar:
    public static void incluirListaRejeitados(Long idDocumento, Integer idResponsavel){
        for (Documento documento : listaDocumentosAprovados) {
            try{
            if (Objects.equals(getIdDocumento(), idDocumento)) {
                listaDocumentosAprovados.remove(documento);
                ListaDocumentos.listaDocumentosPendentes.add(documento);
                documento.setIdResponsavel(idResponsavel);
            }
            }catch (Exception e){
                throw e;
            }
        }
    }

    //Para o gerente aprovar o documento e deixá-lo na lista de arquivados:
    public static void incluirListaArquivados(Long idDocumento) {
        for (Documento documento : listaDocumentosAprovados) {
            try {
                if (Objects.equals(getIdDocumento(), idDocumento)) {
                    listaDocumentosAprovados.remove(documento);
                    ListaDocumentos.listaDocumentosArquivados.add(documento);
                    documento.setIdResponsavel(idResponsavel);
                    documento.setEstado("Arquivado");
                }
            } catch (Exception e) {
                throw e;
            }

        }
    }

    //Para o gerente desarquivar um documento:
    public static void desarquivar(Long idDocumento) {

        for (Documento documento : listaDocumentosAprovados) {
            try {
                if (Objects.equals(getIdDocumento(), idDocumento)) {
                    ListaDocumentos.listaDocumentosArquivados.remove(documento);
                    listaDocumentosAprovados.add(documento);
                    documento.setIdResponsavel(idResponsavel);
                    documento.setEstado("Ativo");
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    //Para contabilizar total de documentos:
    public static List<Documento> contarDocumento() {
        List<Documento> todosDocumentos = new ArrayList<>();
        todosDocumentos.addAll(listaDocumentosPendentes);
        todosDocumentos.addAll(listaDocumentosRejeitados);
        todosDocumentos.addAll(listaDocumentosAprovados);
        todosDocumentos.addAll(listaDocumentosArquivados);
        int i;
        for (i = 0; i < todosDocumentos.size(); i++) {
            todosDocumentos.get(i);
        }
        return (List<Documento>) todosDocumentos.get(i);

    }
}
