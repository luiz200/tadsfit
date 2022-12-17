package visao;

import dominio.Funcionarios;
import persistencia.FuncionariosDAO;

import java.util.Scanner;

public class FuncionariosVisao {
    public void visao() {
        Scanner sc = new Scanner(System.in);
        FuncionariosDAO fun = new FuncionariosDAO();
        int op3 = 0, matriculaAux;
        Funcionarios c;
        do {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1 - Ficha do funcionário");
            System.out.println("0 - Sair");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("Digite a opção desejada: ");
            op3 = sc.nextInt();
            if (op3 == 0) {
                System.out.println("");
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
                        System.out.println("Digite o nome: ");
                        c.setNome(sc.nextLine());
                        System.out.println("Digite a idade: ");
                        c.setIdade(sc.nextInt());
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
                    }else{
                        System.out.println("Esse profissional já tem cadastro!");
                    }
                    break;
                default:
                    System.out.println("Cadastrando um novo profissional...");
                    break;
            }
        } while (true);
    }
}
