package cadastros;

import cadastros.documento.Documento;
import listasFuncionarios.ListaGerentes;


import java.util.ArrayList;
import java.util.List;

public class Gerente extends Colaborador {

    private static Integer contador = 0;
    private List<Documento> listaDocumentos = new ArrayList<>();

    public Gerente(String nome, String sobrenome, String dataNascimento, String cpf, String endereco) {
        super(String.valueOf(contador++), nome, sobrenome, dataNascimento, cpf, endereco);
        ListaGerentes.adicionar(this);
    }

    @Override
    public void adicionarDocumento(Documento documento){
        listaDocumentos.add(documento);
        System.out.println("Documento Criado pelo Gerente");
    }
}
