package visao;

import dominio.Filial;
import persistencia.FilialDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class FilialVisao {
    public void visao() {
        Scanner sc = new Scanner(System.in);
        FilialDAO fi = new FilialDAO();
        int op2 = 0, idAux;
        ArrayList<Filial> lista;
        Filial c;
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
                    if(c==null){
                        System.out.println("Atenção, essa filial não existe.");
                    }else{
                        System.out.println("Filial encontrada...");
                        System.out.println("Filial: " + c.getIdf());
                        System.out.println("Endereço: " + c.getEndereco());
                        System.out.println("Contato: " + c.getContato());
                        System.out.println("Horário: " + c.getHorario());
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
