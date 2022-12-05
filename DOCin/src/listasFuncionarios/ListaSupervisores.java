package listasFuncionarios;

import cadastros.Pessoa;
import cadastros.Supervisor;

import java.util.ArrayList;
import java.util.List;

public class ListaSupervisores {

    public static List<Supervisor> supervisores = new ArrayList<>();

    public static void adicionar(Supervisor supervisor){
        supervisores.add(supervisor);
    }
    public static Supervisor retornar(Integer id){
        return supervisores.get(id);
    }

    public static List<Supervisor> listarSupervisores(){
        return supervisores;
    }


}
