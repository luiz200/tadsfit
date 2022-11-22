package dominio;

public class Equipamentos {

    private int patrimonio;
    private String nome;
    private String status;

    public Equipamentos(){

    }

    public Equipamentos(int patrimonio, String nome, String status){

        this.patrimonio = patrimonio;
        this.nome = nome;
        this.status = status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
