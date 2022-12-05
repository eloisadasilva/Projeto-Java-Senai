import cadastros.Funcionario;
import cadastros.Gerente;
import cadastros.Supervisor;
import cadastros.documento.Documento;
import funcionalidades.Funcionalidades;
import listasFuncionarios.ListaFuncionarios;
import listasFuncionarios.ListaGerentes;
import listasFuncionarios.ListaPessoas;
import listasFuncionarios.ListaSupervisores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {



        //Pré cadastro de funcionários
        Funcionario funcionario = new Funcionario(
                "Rodrigo ",
                "da Silva", "15/10/1975", "065852459-89",
                "Rua das Flores, 187");

        Funcionario funcionario1 = new Funcionario(
                "Antonio",
                "Souza", "01/01/1982", "123456789",
                "Rua São João, 240");

        Funcionario funcionario2 = new Funcionario(
                "Joana",
                "Pereira", "25/08/1965", "123456789",
                "Avenida Bela Vista, 89");

        //Pré cadastro de supervisores
        Supervisor supervisor = new Supervisor(
                "Maria ",
                "Rodrigues", "19/12/1964", "123456789",
                "Rua da Paz, 185");

        Supervisor supervisor1 = new Supervisor(
                "Marcos",
                "Oliveira", "01/12/1988", "123456789",
                "Rua das Lamentações, 84");

        Supervisor supervisor2 = new Supervisor(
                "Pedro",
                "Pereira", "23/09/1977", "123456789",
                "Rua Dom Pedro II, 72");

        //Pré cadastro de gerentes
        Gerente gerente = new Gerente(
                "Maria ",
                "Rodrigues", "19/12/1964", "123456789",
                "Rua da Paz, 185");

        Gerente gerenter1 = new Gerente(
                "Marcos",
                "Oliveira", "12/01/1988", "123456789",
                "Rua das Lamentações, 84");

        Gerente gerente2 = new Gerente(
                "Henrique",
                "Pereira", "23/08/1977", "123456789",
                "Rua Dom Pedro II, 72");


        //Pré cadastro de documentos
        Documento documento = new Documento(1, 1,
                1, "www.link.com.br", "25/10/2022",
                "Ativo");

        Documento documento1 = new Documento(2, 3,
                2, "www.link2.com.br", "25/10/2022",
                "Arquivado");

        Documento documento2 = new Documento(3, 1,
                3, "www.link3.com.br", "25/10/2022",
                "Arquivado");

        Documento documento3 = new Documento(4, 1,
                3, "www.link4.com.br", "25/10/2022",
                "Arquivado");

        Funcionalidades funcionalidade = new Funcionalidades();


        Scanner scanner = new Scanner(System.in);

        boolean executa = true;
        while (executa) {

            System.out.print("Qual a sua função? " +
                    "\n Digite:" +
                    "\n 1 - Funcionário" +
                    "\n 2 - Supervisor" +
                    "\n 3 - Gerente \n");
            Integer colaborador = scanner.nextInt();

            System.out.print("O que gostaria de fazer?" +
                    "\n 1 - Entrar em uma conta" +
                    "\n 2 - Criar uma conta\n");
            Integer acesso = scanner.nextInt();

            if (acesso == 1) {

                System.out.print("Digite o seu identificador:");
                Integer id = scanner.nextInt();

                //Métodos para os Funcionários:
                if(colaborador == 1) {
                    Funcionario usuarioFuncionario = ListaFuncionarios.retornar(id);


                    System.out.print("Escolha qual processo deseja realizar:" +
                            "\n 1 - Criar Documento" +
                            "\n 2 - Listar Documentos Criados" +
                            "\n 3 - Listar Documentos Rejeitados \n");

                    Integer processoFuncionario = scanner.nextInt();

                    switch (processoFuncionario) {
                        case 1:
                            funcionalidade.criarDocumento(usuarioFuncionario);
                            break;
                        case 2:
                            funcionalidade.listaDocumentosPendentes();
                            break;
                        case 3:
                            funcionalidade.listaDocumentosRejeitados();
                            break;
                    }
                }

                //Métodos para os Supervisores
                if(colaborador == 2) {
                    Supervisor usuarioSupervisor = ListaSupervisores.retornar(id);
                    System.out.println();

                    System.out.print("Escolha qual processo deseja realizar:" +
                            "\n 1 - Verificar Documento" +
                            "\n 2 - Tramitar Documento" +
                            "\n 3 - Listar Documentos Pendentes \n");

                    Integer processoSupervisor = scanner.nextInt();

                    switch (processoSupervisor) {
                        case 1:
                           funcionalidade.aprovarDocumento(usuarioSupervisor);
                            break;
                        case 2:
                           funcionalidade.rejeitarDocumento(usuarioSupervisor);
                            break;
                        case 3:
                           funcionalidade.listaDocumentosPendentes();
                            break;

                    }
                }

                //Métodos para os Gerentes
                if(colaborador == 3) {
                    Gerente usuarioGerente = ListaGerentes.retornar(id);
                    System.out.println();

                    System.out.print("Escolha qual processo deseja realizar:" +
                            "\n 1 - Listar Documentos Aprovados" +
                            "\n 2 - Arquivar documento" +
                            "\n 3 - Desarquivar documento" +
                            "\n 4 - Listagem de Funcionários" +
                            "\n 5 - Listagem de Supervisores" +
                            "\n 6 - Listagem de Gerentes" +
                            "\n 7 - Listar Documentos Arquivados" +
                            "\n 8 - Listagem de Total de Documentos" +
                            "\n 8 - Quantidade Total de Documentos \n");

                    Integer processoGerente = scanner.nextInt();

                    switch (processoGerente) {
                        case 1:
                           funcionalidade.listaDocumentosAprovados();
                            break;
                        case 2:
                           funcionalidade.arquivarDocumento(usuarioGerente);
                            break;
                        case 3:
                            funcionalidade.desarquivarDocumento(usuarioGerente);
                            break;
                        case 4:
                           funcionalidade.listaFuncionarios();
                            break;
                        case 5:
                            funcionalidade.listaSupervisores();
                            break;
                        case 6:
                            funcionalidade.listaGerentes();
                            break;
                        case 7:
                            funcionalidade.listaDocumentosArquivados();
                            break;
                        case 8:
                            funcionalidade.listaTodosDocumentos();
                            break;
                        case 9:
                            funcionalidade.qtdTotalDocumentos();
                            break;
                    }
                }
            }


        //Para cadastro de usuários
        if (acesso == 2) {

            System.out.print("Digite seu sobrenome:");
            String nome = scanner.nextLine();


            System.out.print("Digite seu sobrenome:");
            String sobrenome = scanner.nextLine();

            System.out.print("Digite sua data de nascimento:");
            String dataNascimento = scanner.nextLine();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            Date format = f.parse(dataNascimento);

            System.out.print("Digite seu CPF:");
            String cpf = scanner.nextLine();

            System.out.print("Digite seu endereço:");
            String endereco = scanner.nextLine();


            switch (colaborador) {
                case 1:
                    Funcionario cadastroFuncionario = new Funcionario(nome, sobrenome, dataNascimento, cpf, endereco);
                    ListaFuncionarios.adicionar(cadastroFuncionario);

                    break;
                case 2:
                    Supervisor cadastroSupervisor = new Supervisor(nome, sobrenome, dataNascimento, cpf, endereco);
                    ListaSupervisores.adicionar(cadastroSupervisor);
                    break;
                case 3:
                    Gerente cadastroGerente = new Gerente(nome, sobrenome, dataNascimento, cpf, endereco);
                    ListaGerentes.adicionar(cadastroGerente);
                    break;
            }
        }

            //Para encerramento da aplicação
            System.out.print("Deseja Encerrar? " +
                    "\n 1 - Sim" +
                    "\n 2 - Não" +
                    "\n Entre a opção escolhida:");

            Integer encerrar = scanner.nextInt();

            switch (encerrar) {
                case 1:
                    executa = false;
                    break;
                case 2:
                    executa = true;
                    break;
            }

        }


    }







}