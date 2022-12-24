package dominio;

import java.util.ArrayList;

public class Filial {

    private int idf;
    private String endereco;
    private String contato;
    private String horario;
    private ArrayList<Funcionarios> listafun;
    private ArrayList<Equipamentos> listaeq;

    public Filial(){
        listafun = new ArrayList<>();
        listaeq = new ArrayList<>();
    }

    public Filial(int idf, String endereco, String contato, String horario){
        this.idf = idf;
        this.endereco = endereco;
        this.contato = contato;
        this.horario = horario;
        listafun = new ArrayList<>();
        listaeq = new ArrayList<>();
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Funcionarios cunsultaFuncionarios(int id_fun){
        int i;
        for (i=0; i<listafun.size(); i++){
            if(listafun.get(i).getMatricula()==id_fun){
                return listafun.get(i);
            }
        }
        return null;
    }
    public int getTamanhoLista(){
        return listafun.size();
    }
    public Funcionarios getFuncionarios(int i){
        return listafun.get(i);
    }
    public ArrayList<Funcionarios> getListafun() {
        return listafun;
    }
    public void setListafun(ArrayList<Funcionarios> listafun) {
        this.listafun = listafun;
    }

    public Equipamentos cunsultaEquipamentos(int id_eq){
        int i;
        for (i=0; i<listaeq.size(); i++){
            if(listaeq.get(i).getPatrimonio()==id_eq){
                return listaeq.get(i);
            }
        }
        return null;
    }
    public int getTamanhoList(){
        return listaeq.size();
    }
    public Equipamentos getEquipamentos(int i){
        return listaeq.get(i);
    }
    public ArrayList<Equipamentos> getListaeq() {
        return listaeq;
    }
    public void setListaeq(ArrayList<Equipamentos> listaeq) {
        this.listaeq = listaeq;
    }
}
