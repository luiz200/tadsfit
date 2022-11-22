package dominio;

public class Filial {

    private int id;
    private String endereco;
    private String contato;
    private String horario;

    public Filial(){

    }

    public Filial(int id, String endereco, String contato, String horario){
        this.id = id;
        this.endereco = endereco;
        this.contato = contato;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
