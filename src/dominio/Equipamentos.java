package dominio;

public class Equipamentos {

    private int patrimonio;
    private int id_filial;

    private String nome;
    private String status1;

    public Equipamentos(int patrimonio, int id_filial, String nome, String status1){

        this.patrimonio = patrimonio;
        this.id_filial = id_filial;
        this.nome = nome;
        this.status1 = status1;

    }

    public Equipamentos() {

    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }
}
