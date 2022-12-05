package cadastros;

import cadastros.documento.Documento;
import listasFuncionarios.ListaPessoas;

import java.util.ArrayList;
import java.util.List;

public class Colaborador extends Pessoa {
   
    private List <Documento> listaDocumentos = new ArrayList<>();

    public Colaborador(String identificador, String nome, String sobrenome, String dataNascimento, String cpf, String endereco) {
        super(identificador, nome, sobrenome, dataNascimento, cpf, endereco);

        ListaPessoas.adicionar(this);
    }


    public void adicionarDocumento(Documento documento){
        listaDocumentos.add(documento);
        System.out.println("Documento Criado");
    };

}

