package visao;

//import java.util.Scanner;

import dominio.Aluno;
import dominio.Equipamentos;
import dominio.Filial;

import java.util.Scanner;

public class  Principal {

    public static void main(String[] args){
        //TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i=0;
		do {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Bem-vindo a TADSFIT!");
			System.out.println("1 - Aluno");
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
					int o = 0;

					do {
						System.out.println("---------------------------------------------------------------------------");
						System.out.println("1 - Relecão dos alunos");
						System.out.println("0 - Retorna ao menu anterior");
						System.out.println("---------------------------------------------------------------------------");
						System.out.print("Digite a opção desejada: ");
						o = sc.nextInt();
						if(o == 0){
							break;
						}
						switch (0){
							case 1:
								Aluno a1 = new Aluno();
								a1.estado();
								break;
						}
					}while (true);
			}
//			Equipamentos eq1 = new Equipamentos();
//			eq1.estadoEquipamento();
//
//			Filial f1 = new Filial();
//			f1.estadoFilial();
		}while (true);
    }
}
