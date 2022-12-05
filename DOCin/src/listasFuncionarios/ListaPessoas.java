package listasFuncionarios;

import cadastros.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class ListaPessoas {

    public static List<Pessoa> pessoas = new ArrayList<>();

    public static void adicionar(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public static Pessoa retornar(Integer id){
        return pessoas.get(id);
    }

    public static List<Pessoa> retornarTodos(){
        return pessoas;
    }


}
