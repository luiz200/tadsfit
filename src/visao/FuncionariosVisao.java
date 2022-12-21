package visao;

import dominio.Filial;
import dominio.Funcionarios;
import persistencia.FilialDAO;
import persistencia.FuncionariosDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionariosVisao {
    public void visao() {
        Scanner sc = new Scanner(System.in);
        FuncionariosDAO fun = new FuncionariosDAO();
        FilialDAO fi = new FilialDAO();
        int op3 = 0, matriculaAux, idAux;
        ArrayList<Funcionarios> lista;
        Funcionarios c;
        Filial f;
        do {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1 - Ficha do funcionário");
            System.out.println("2 - Cadastrar funcionário");
            System.out.println("3 - Atualizar funcionário");
            System.out.println("4 - Listar funcionários");
            System.out.println("5 - Desligar funcionário");
            System.out.println("0 - Sair");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("Digite a opção desejada: ");
            op3 = sc.nextInt();
            if (op3 == 0) {
                break;
            }
            switch (op3) {
                case 1:
                    System.out.println("Digite a matrícula do funcionário: ");
                    matriculaAux = sc.nextInt();
                    c = fun.buscar(matriculaAux);
                    if(c==null){
                        System.out.println("Atençã, esse funcionário não existe em nossas filiais.");
                    }else{
                        System.out.println("Profissional encontrado...");
                        System.out.println("Matrícula: "+c.getMatricula());
                        System.out.println("Filial: "+c.getId_filial());
                        System.out.println("Nome: "+c.getNome());
                        System.out.println("Idade: "+c.getIdade());
                        System.out.println("Sexo: "+c.getSexo());
                        System.out.println("Contato: "+c.getContato());
                        System.out.println("Endereço: "+c.getEndereco());
                        System.out.println("Horário: "+c.getHorario());
                    }
                    break;
                case 2:
                    System.out.println("Digite a matrícula: ");
                    matriculaAux = sc.nextInt();
                    c = fun.buscar(matriculaAux);
                    if (c==null){
                        c = new Funcionarios();
                        c.setMatricula(matriculaAux);
                        sc.nextLine();
                        System.out.println("Digite a filial");
                        idAux = sc.nextInt();
                        f = fi.buscar(idAux);
                        if(f==null){
                            System.out.println("Essa filial não existe.");
                        }else{
                            c.setId_filial(idAux);
                            sc.nextLine();
                            System.out.println("Digite o nome: ");
                            c.setNome(sc.nextLine());
                            System.out.println("Digite a idade: ");
                            c.setIdade(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Digite o sexo: ");
                            c.setSexo(sc.nextLine());
                            System.out.println("Digite o contato: ");
                            c.setContato(sc.nextLine());
                            System.out.println("Digite o endereço: ");
                            c.setEndereco(sc.nextLine());
                            System.out.println("Digite o horário: ");
                            c.setHorario(sc.nextLine());
                            fun.inserir(c);
                            System.out.println("Funcionário cadastrado com sucesso!");
                        }
                    }else{
                        System.out.println("Esse profissional já tem cadastro!");
                    }
                    break;
                case 3:
                    System.out.println("Digite a matrícula: ");
                    matriculaAux = sc.nextInt();
                    c = fun.buscar(matriculaAux);
                    if (c==null){
                        System.out.println("Esse profissional não tem cadastro!");
                    }else{
                        c = new Funcionarios();
                        c.setMatricula(matriculaAux);
                        sc.nextLine();
                        System.out.println("Digite a filial");
                        idAux = sc.nextInt();
                        f = fi.buscar(idAux);
                        if(f==null){
                            System.out.println("Essa filial não existe.");
                        }else{
                            c.setId_filial(idAux);
                            sc.nextLine();
                            System.out.println("Digite o nome: ");
                            c.setNome(sc.nextLine());
                            System.out.println("Digite a idade: ");
                            c.setIdade(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Digite o sexo: ");
                            c.setSexo(sc.nextLine());
                            System.out.println("Digite o contato: ");
                            c.setContato(sc.nextLine());
                            System.out.println("Digite o endereço: ");
                            c.setEndereco(sc.nextLine());
                            System.out.println("Digite o horário: ");
                            c.setHorario(sc.nextLine());
                            fun.alterar(c);
                            System.out.println("Funcionário atualizado com sucesso!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Listando profissionais...");
                    lista = fun.emitirRelatorio();
                    for (int o=0; o< lista.size(); o++){
                        System.out.println("\t"+lista.get(o).getMatricula()+"\t"+lista.get(o).getId_filial()+"\t"+lista.get(o).getNome()+"\t"+lista.get(o).getIdade()+
                                "\t"+lista.get(o).getSexo()+"\t"+lista.get(o).getContato()+"\t"+lista.get(o).getEndereco()+"\t"+lista.get(o).getHorario());
                    }
                    break;
                case 5:
                    System.out.println("Desligando funcionário...");
                    System.out.println("Digite a matrícula do funcionário: ");
                    matriculaAux = sc.nextInt();
                    sc.nextLine();
                    c = fun.buscar(matriculaAux);
                    if(c==null) {
                        System.out.println("Funcionário não cadastrado");
                    }else {
                        fun.excluir(matriculaAux);
                        System.out.println("Desligamento realizado com sucesso!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (true);
    }
}
