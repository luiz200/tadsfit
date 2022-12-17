package visao;

import dominio.Equipamentos;
import persistencia.EquipamentosDAO;

import java.util.Scanner;

public class EquipamentosVisao {
    public void visao(){
        Scanner sc = new Scanner(System.in);
        EquipamentosDAO eqDao = new EquipamentosDAO();
        int op1=0, equipamentosAux;
        Equipamentos c;
        do {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1 - Ficha do equipamento");
            System.out.println("2 - Cadastrar equipamento");
            System.out.println("0 - Sair");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("Digite a opção desejada: ");
            op1 = sc.nextInt();
            if(op1 == 0){
                System.out.println("");
                break;
            }
            switch (op1){
                case 1:
                    System.out.println("Digite o patrimônio do equipamento: ");
                    equipamentosAux = sc.nextInt();
                    c = eqDao.buscar(equipamentosAux);
                    if(c == null){
                        System.out.println("Atenção, equipamento não cadastrado no patrimônio");
                    }else{
                        System.out.println("Equimanto encontrado...");
                        System.out.println("Patrimônio: " + c.getPatrimonio());
                        System.out.println("Maquína: " + c.getNome());
                        System.out.println("Status: " + c.getStatus());
                    }
                    break;
                case 2:
                    System.out.println("Cadastrando equipamento...");
                    System.out.println("Digite o patrimônio do equipamento: ");
                    equipamentosAux = sc.nextInt();
                    c = eqDao.buscar(equipamentosAux);
                    if (c == null){
                        c = new Equipamentos();
                        c.setPatrimonio(equipamentosAux);
                        System.out.println("Nome do equipamento: ");
                        c.setNome(sc.nextLine());
                        c.setStatus("Status do equipamento: ");
                        c.setStatus(sc.nextLine());
                        eqDao.inserir(c);
                        System.out.println("Equipamento incluído com sucesso!");
                    } else{
                        System.out.println("Equipamento já está cadastrado!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (true);
    }
}