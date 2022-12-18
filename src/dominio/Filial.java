package dominio;

public class Filial {

    private int idf;
    private String endereco;
    private String contato;
    private String horario;

    public Filial(){

    }

    public Filial(int idf, String endereco, String contato, String horario){
        this.idf = idf;
        this.endereco = endereco;
        this.contato = contato;
        this.horario = horario;
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
}
