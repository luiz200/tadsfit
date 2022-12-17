package visao;

import dominio.Aluno;
import persistencia.AlunoDAO;
import java.util.Scanner;

public class AlunoVisao {
    public void visao(){
        Scanner sc = new Scanner(System.in);
        AlunoDAO aDao = new AlunoDAO();
        int op=0, matriculaAux;
        Aluno c;
        do {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1 - Ficha do aluno");
            System.out.println("2 - Cadastrar aluno");
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
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (true);
    }
}
