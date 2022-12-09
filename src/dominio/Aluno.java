package dominio;

public class Aluno {

    private int matricula;
    private String nome;
    private int idade;
    private float altura;
    private float peso;
    private String sexo;
    private String contato;
    private String endereco;

    public Aluno(){

    }
    public void estado() {
    	System.out.println("------------------------------------------");
		System.out.println("Nome: "+this.getNome());
		System.out.println("Matricula: "+this.getMatricula());
		System.out.println("Idade: "+this.getIdade());
		System.out.println("Altura: "+this.getAltura()+"cm");
		System.out.println("Peso: "+this.getPeso()+"Kg");
		System.out.println("Sexo:"+this.getSexo());
		System.out.println("Contato: "+this.getContato());
		System.out.println("Endereço: "+this.getEndereco());
		System.out.println("------------------------------------------");
    }

    public Aluno(int matricula, String nome, int idade, float altura, float peso, String sexo, String contato, String endereco){

        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.contato = contato;
        this.endereco = endereco;

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
}
