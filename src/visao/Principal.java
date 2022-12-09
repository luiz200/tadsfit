package visao;

//import java.util.Scanner;

import dominio.Aluno;
import dominio.Equipamentos;
import dominio.Filial;

public class Principal {

    public static void main(String[] args){
        //TODO Auto-generated method stub
    	Aluno a1 = new Aluno();
    	a1.setNome("Ramonie");
    	a1.setMatricula(0001);
    	a1.setIdade(23);
    	a1.setAltura(170);
    	a1.setPeso(76);
    	a1.setSexo("M");
    	a1.setContato("(84)9 3333-4444");
    	a1.setEndereco("Rua rua");
    	a1.estado();
    	
    	Equipamentos eq1 = new Equipamentos();
    	eq1.setPatrimonio(2016);
    	eq1.setNome("Esterira");
    	eq1.setStatus("Em uso");
    	eq1.estadoEquipamento();
    	
    	Filial f1 = new Filial();
    	f1.setId(01);
    	f1.setEndereco("Perto da cidade de Júa");
    	f1.setContato("(84)9 6666-7777");
    	f1.setHorario("Abro e fecho na hora que eu quiser");
    	f1.estadoFilial();
    	
        

    }
}
