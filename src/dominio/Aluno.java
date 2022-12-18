package dominio;

public class Aluno {

    private int matricula; //id_filial, id_fun,
    private int id_filial;
    private int id_fun;
    private String nome;
    private int idade;
    private float altura;
    private float peso;
    private String sexo;
    private String contato;
    private String endereco;

    public Aluno(int matricula, int id_filial, int id_fun, String nome, int idade, float altura, float peso, String sexo, String contato, String endereco){

        this.matricula = matricula;
        this.id_filial = id_filial;
        this.id_fun = id_fun;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.contato = contato;
        this.endereco = endereco;

    }

    public Aluno() {

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
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

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }

    public int getId_fun() {
        return id_fun;
    }

    public void setId_fun(int id_fun) {
        this.id_fun = id_fun;
    }
}
