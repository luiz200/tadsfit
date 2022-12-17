package persistencia;

import dominio.Aluno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {
    private Conexao c;
    private String Busca = "select * from aluno where matricula = ?";
    private String Inserir = "insert into aluno (matricula, nome, idade, altura, peso, sexo, contato, endereco) values(?, ?, ?, ?, ?, ?, ?, ?)";

    public AlunoDAO(){
        c = new Conexao("jdbc:postgresql://localhost:5432/tadsfit","postgres", "12345");
    }

    public Aluno buscar(int matriculaAux){
        Aluno pessoa = null;
        try{
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Busca);
            instrucao.setInt(1, matriculaAux);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){//andando no resultset
                pessoa = new Aluno(rs.getInt("matricula"), rs.getString("nome"), rs.getInt("idade"), rs.getFloat("altura"), rs.getFloat("peso"), rs.getString("sexo"), rs.getString("contato"), rs.getString("endereco"));
            }
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na busca");
        }
        return pessoa;
    }

    public void inserir(Aluno pessoa){
        try{
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Inserir);
            instrucao.setInt(1, pessoa.getMatricula());
            instrucao.setString(2, pessoa.getNome());
            instrucao.setInt(3, pessoa.getIdade());
            instrucao.setFloat(4, pessoa.getAltura());
            instrucao.setFloat(5, pessoa.getPeso());
            instrucao.setString(6, pessoa.getSexo());
            instrucao.setString(7, pessoa.getContato());
            instrucao.setString(8, pessoa.getEndereco());
            instrucao.execute();
            c.desconectar();

        } catch (Exception e) {
            System.out.println("Erro na inclusão");
        }
    }
}
