package visao;

import dominio.Aluno;
import persistencia.AlunoDAO;
import java.util.Scanner;
import java.util.ArrayList;

public class AlunoVisao {
    public void visao(){
        Scanner sc = new Scanner(System.in);
        AlunoDAO aDao = new AlunoDAO();
        int op=0, matriculaAux;
        ArrayList<Aluno> lsita;
        Aluno c;
        do {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1 - Ficha do aluno");
            System.out.println("2 - Cadastrar aluno");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Listar alunos");
            System.out.println("5 - Desligar aluno");
            System.out.println("0 - Sair");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("Digite a opção desejada: ");
            op = sc.nextInt();
            if(op == 0){
                System.out.println("");
                break;
            }
            switch (op){
                case 1:
                    System.out.println("Digite a matrícula do aluno que deseja buscar: ");
                    matriculaAux = sc.nextInt();
                    c = aDao.buscar(matriculaAux);
                    if(c == null){
                        System.out.println("Atenção, aluno não cadastrado!");
                    }else{
                        System.out.println("Aluno encontrado.");
                        System.out.println("Matrícula: "+c.getMatricula());
                        System.out.println("Filial: "+c.getId_filial());
                        System.out.println("Matrícula fun.: "+c.getId_fun());
                        System.out.println("Nome: "+c.getNome());
                        System.out.println("Idade: "+c.getIdade());
                        System.out.println("Altura: "+c.getAltura());
                        System.out.println("Peso: "+c.getPeso());
                        System.out.println("Sexo: "+c.getSexo());
                        System.out.println("Contato: "+c.getContato());
                        System.out.println("Endereço: "+c.getEndereco());
                    }
                    break;
                case 2:
                    System.out.println("Cadastrando aluno...");
                    System.out.println("Digite a matrícula do aluno: ");
                    matriculaAux = sc.nextInt();
                    c = aDao.buscar(matriculaAux);
                    if (c == null){
                        c = new Aluno();
                        c.setMatricula(matriculaAux);
                        System.out.println("Filial: ");
                        c.setId_filial(sc.nextInt());
                        System.out.println("matrícula do fun.: ");
                        c.setId_fun(sc.nextInt());
                        System.out.println("Nome: ");
                        c.setNome(sc.nextLine());
                        System.out.println("Idade: ");
                        c.setIdade(sc.nextInt());
                        System.out.println("Altura: ");
                        c.setAltura(sc.nextFloat());
                        System.out.println("Peso: ");
                        c.setPeso(sc.nextFloat());
                        System.out.println("Sexo: ");
                        c.setSexo(sc.nextLine());
                        System.out.println("Contato: ");
                        c.setContato(sc.nextLine());
                        System.out.println("Endereço: ");
                        c.setEndereco(sc.nextLine());
                        aDao.inserir(c);
                        System.out.println("incluido com sucesso");
                    }
                    else{
                        System.out.println("Aluno já matrículado na TADSFIT.");
                    }
                    break;
                case 3:
                    System.out.println("Atualizando aluno...");
                    System.out.println("Digite a matrícula do aluno: ");
                    matriculaAux = sc.nextInt();
                    c = aDao.buscar(matriculaAux);
                    if (c == null){
                        System.out.println("Aluno não matrículado na TADSFIT.");
                    }
                    else{
                        c = new Aluno();
                        c.setMatricula(matriculaAux);
                        System.out.println("Filial: ");
                        c.setId_filial(sc.nextInt());
                        System.out.println("matrícula do fun.: ");
                        c.setId_fun(sc.nextInt());
                        System.out.println("Nome: ");
                        c.setNome(sc.nextLine());
                        System.out.println("Idade: ");
                        c.setIdade(sc.nextInt());
                        System.out.println("Altura: ");
                        c.setAltura(sc.nextFloat());
                        System.out.println("Peso: ");
                        c.setPeso(sc.nextFloat());
                        System.out.println("Sexo: ");
                        c.setSexo(sc.nextLine());
                        System.out.println("Contato: ");
                        c.setContato(sc.nextLine());
                        System.out.println("Endereço: ");
                        c.setEndereco(sc.nextLine());
                        aDao.alterar(c);
                        System.out.println("atualizado com sucesso");
                    }
                    break;
                case 4:
                    System.out.println("Listando alunos...");
                    lsita = aDao.emitirRelatorio();
                    for(int o=0; o<lsita.size(); o++){
                        System.out.println("\t"+lsita.get(o).getMatricula()+"\t"+lsita.get(o).getId_filial()+"\t"+lsita.get(o).getId_fun()+"\t"+lsita.get(o).getNome()+"\t"+lsita.get(o).getIdade()+"\t"+lsita.get(o).getAltura()+
                                "\t"+lsita.get(o).getPeso()+"\t"+lsita.get(o).getSexo()+"\t"+lsita.get(o).getContato()+"\t"+lsita.get(o).getContato()+
                                "\t"+lsita.get(o).getEndereco());
                    }
                    break;
                case 5:
                    System.out.println("Desligando aluno...");
                    System.out.println("Digite a matrícula do aluno: ");
                    matriculaAux = sc.nextInt();
                    sc.nextLine();
                    c = aDao.buscar(matriculaAux);
                    if(c==null) {
                        System.out.println("Aluno não cadastrado");
                    }else {
                        aDao.excluir(matriculaAux);
                        System.out.println("Desligamento realizado com sucesso!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (true);
    }
}
