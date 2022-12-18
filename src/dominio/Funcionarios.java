package dominio;

public class Funcionarios {

    private int matricula;
    private int id_filial;
    private String nome;
    private int idade;
    private String sexo;
    private String contato;
    private String endereco;
    private String horario;

    public Funcionarios(){

    }

    public Funcionarios(int matricula, int id_filial, String nome, int idade, String sexo, String contato, String endereco, String horario){

        this.matricula = matricula;
        this.id_filial = id_filial;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.contato = contato;
        this.endereco = endereco;
        this.horario = horario;

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
