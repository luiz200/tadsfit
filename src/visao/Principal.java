package visao;

import java.util.Scanner;

public class  Principal {

    public static void main(String[] args){
        //TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		AlunoVisao a1 = new AlunoVisao();
		EquipamentosVisao eq1 = new EquipamentosVisao();
		FilialVisao fi1 = new FilialVisao();
		FuncionariosVisao fun1 = new FuncionariosVisao();

		int i=0;
		do {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Bem-vindo a TADSFIT!");
			System.out.println("1 - Aluno");
			System.out.println("2 - Equipamentos");
			System.out.println("3 - Filial");
			System.out.println("4 - Funcionários");
			System.out.println("0 - Sair");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			i = sc.nextInt();
			if(i == 0){
				System.out.println("Até a próxima");
				break;
			}
			switch (i){
				case 1:
					a1.visao();
					break;
				case 2:
					eq1.visao();
					break;
				case 3:
					fi1.visao();
					break;
				case 4:
					fun1.visao();
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		}while (true);
    }
}
