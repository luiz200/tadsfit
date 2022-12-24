package visao;

import dominio.Equipamentos;
import dominio.Filial;
import dominio.Funcionarios;
import persistencia.EquipamentosDAO;
import persistencia.FilialDAO;
import persistencia.FuncionariosDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class FilialVisao {
    public void visao() {
        Scanner sc = new Scanner(System.in);
        FilialDAO fi = new FilialDAO();
        FuncionariosDAO fun = new FuncionariosDAO();
        EquipamentosDAO eq = new EquipamentosDAO();
        int op2 = 0, op3 = 0, op4 = 0, idAux;
        ArrayList<Filial> lista;
        ArrayList<Funcionarios> lista2;
        ArrayList<Equipamentos> lista3;
        Filial c;
        Funcionarios f;
        Equipamentos e;
        do {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1 - Ficha da filial");
            System.out.println("2 - Cadastrar filial");
            System.out.println("3 - Atualizar filial");
            System.out.println("4 - Listar filiais");
            System.out.println("0 - Sair");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("Digite a opção desejada: ");
            op2 = sc.nextInt();
            if (op2 == 0) {
                break;
            }
            switch (op2) {
                case 1:
                    System.out.println("Digite a filial: ");
                    idAux = sc.nextInt();
                    c = fi.buscar(idAux);
                    f = fun.buscar2(idAux);
                    e = eq.buscar(idAux);
                    if(c==null){
                        System.out.println("Atenção, essa filial não existe.");
                    }else{
                        System.out.println("Filial encontrada...");
                        System.out.println("Filial: " + c.getIdf());
                        System.out.println("Endereço: " + c.getEndereco());
                        System.out.println("Contato: " + c.getContato());
                        System.out.println("Horário: " + c.getHorario());
                        System.out.println("Gostaria de ver os funcionários que trabalham nessa filial(1 - sim e 0 - não)? ");
                        op3 = sc.nextInt();
                        if (op3 == 1){
                            if(f==null){
                                System.out.println("Não existe funcionários cadastrado nessa filial.");
                                System.out.println("Gostaria de ver os equipamentos cadastrado nessa filial(1 - sim e 0 - não)? ");
                                op4 = sc.nextInt();
                                if (op4 == 1){
                                    if (e==null){
                                        System.out.println("Ainda não existe equipamentos cadastrado nessa filial.");
                                    }else{
                                        System.out.println("Equipamentos da filial: ");
                                        lista3 = eq.emitirRelatorio();
                                        for (int h = 0; h< lista3.size(); h++){
                                            if(lista3.get(h).getId_filial()==idAux){
                                                System.out.println("\t"+lista3.get(h).getPatrimonio()+"\t"+lista3.get(h).getId_filial()+
                                                        "\t"+lista3.get(h).getNome()+"\t"+lista3.get(h).getStatus1());
                                            }
                                        }
                                    }
                                }else if (op4 == 0) {
                                    break;
                                }else{
                                    System.out.println("Opção inválida.");
                                }
                            }else{
                                System.out.println("Funcionários que trabalham na filial:");
                                lista2 = fun.emitirRelatorio2();
                                for (int i=0; i<lista2.size(); i++){
                                    if(lista2.get(i).getId_filial()==idAux){
                                        System.out.println((i+1)+") "+lista2.get(i).getId_filial()+"\t"+lista2.get(i).getMatricula()+"\t"+lista2.get(i).getNome());
                                    }
                                }
                                System.out.println("Gostaria de ver os equipamentos cadastrado nessa filial(1 - sim e 0 - não)? ");
                                op4 = sc.nextInt();
                                if (op4 == 1){
                                    if (e==null){
                                        System.out.println("Ainda não existe equipamentos cadastrado nessa filial.");
                                    }else{
                                        System.out.println("Equipamentos da filial: ");
                                        lista3 = eq.emitirRelatorio();
                                        for (int h = 0; h< lista3.size(); h++){
                                            if(lista3.get(h).getId_filial()==idAux){
                                                System.out.println("\t"+lista3.get(h).getPatrimonio()+"\t"+lista3.get(h).getId_filial()+
                                                        "\t"+lista3.get(h).getNome()+"\t"+lista3.get(h).getStatus1());
                                            }
                                        }
                                    }
                                }else if (op4 == 0) {
                                    break;
                                }else{
                                    System.out.println("Opção inválida.");
                                }
                            }
                        } else if (op3 == 0) {
                            break;
                        }else{
                            System.out.println("Opção inválida.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Cadastrando uma nova filial...");
                    System.out.println("Digite o id da filial: ");
                    idAux = sc.nextInt();
                    c = fi.buscar(idAux);
                    if (c == null){
                        c = new Filial();
                        c.setIdf(idAux);
                        sc.nextLine();
                        System.out.println("Endereço da filial: ");
                        c.setEndereco(sc.nextLine());
                        System.out.println("Contato da filial: ");
                        c.setContato(sc.nextLine());
                        System.out.println("Horário de funcionamento da filial: ");
                        c.setHorario(sc.nextLine());
                        fi.inserir(c);
                        System.out.println("Filial incluída com sucesso!");
                    }else{
                        System.out.println("Filial já está cadastrada!");
                    }
                    break;
                case 3:
                    System.out.println("Cadastrando uma nova filial...");
                    System.out.println("Digite o id da filial: ");
                    idAux = sc.nextInt();
                    c = fi.buscar(idAux);
                    if (c == null){
                        System.out.println("Filial não está cadastrada!");
                    }else{
                        c = new Filial();
                        c.setIdf(idAux);
                        sc.nextLine();
                        System.out.println("Endereço da filial: ");
                        c.setEndereco(sc.nextLine());
                        System.out.println("Contato da filial: ");
                        c.setContato(sc.nextLine());
                        System.out.println("Horário de funcionamento da filial: ");
                        c.setHorario(sc.nextLine());
                        fi.alterar(c);
                        System.out.println("Filial atualizada com sucesso!");
                    }
                    break;
                case 4:
                    System.out.println("Listando filiais...");
                    lista = fi.emitirRelatorio();
                    for(int o=0; o< lista.size(); o++){
                        System.out.println("\t"+lista.get(o).getIdf()+"\t"+lista.get(o).getEndereco()+"\t"+lista.get(o).getContato()+"\t"+lista.get(o).getHorario());
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (true);
    }
}
