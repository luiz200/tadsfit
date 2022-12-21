package persistencia;

import dominio.Aluno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDAO {
    private Conexao c;
    private String Relatorio = "select * from aluno";
    private String Busca = "select * from aluno where matricula = ?";
    private String Inserir = "insert into aluno (nome, matricula, id_filial, id_fun, idade, altura, peso, sexo, contato, endereco) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String Alterar = "update aluno set matricula=?, id_filial=?, id_fun=?, nome=?, idade=?, altura=?, peso=?, sexo=?, contato=?, endereco=? where matricula=?";
    private String Deletar = "delete from aluno where matricula=?";

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
                pessoa = new Aluno(rs.getInt("matricula"), rs.getInt("id_filial"), rs.getInt("id_fun"), rs.getString("nome"), rs.getInt("idade"), rs.getFloat("altura"), rs.getFloat("peso"), rs.getString("sexo"), rs.getString("contato"), rs.getString("endereco"));
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
            instrucao.setString(1, pessoa.getNome());
            instrucao.setInt(2, pessoa.getMatricula());
            instrucao.setInt(3, pessoa.getId_filial());
            instrucao.setInt(4, pessoa.getId_fun());
            instrucao.setInt(5, pessoa.getIdade());
            instrucao.setFloat(6, pessoa.getAltura());
            instrucao.setFloat(7, pessoa.getPeso());
            instrucao.setString(8, pessoa.getSexo());
            instrucao.setString(9, pessoa.getContato());
            instrucao.setString(10, pessoa.getEndereco());
            instrucao.execute();
            c.desconectar();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Aluno> emitirRelatorio(){
        Aluno pessoa;
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        try {
            c.conectar();
            Statement instrucao = c.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(Relatorio);
            while (rs.next()){
                pessoa = new Aluno(rs.getInt("matricula"), rs.getInt("id_filial"), rs.getInt("id_fun"), rs.getString("nome"), rs.getInt("idade"), rs.getFloat("altura"), rs.getFloat("peso"), rs.getString("sexo"), rs.getString("contato"), rs.getString("endereco"));
                lista.add(pessoa);
            }
        }catch (Exception e){
            System.out.println("Erro");
        }
        return lista;
    }

    public void alterar(Aluno pessoa){
        try{
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setInt(1, pessoa.getMatricula());
            instrucao.setInt(2, pessoa.getId_filial());
            instrucao.setInt(3, pessoa.getId_fun());
            instrucao.setString(4, pessoa.getNome());
            instrucao.setInt(5, pessoa.getIdade());
            instrucao.setFloat(6, pessoa.getAltura());
            instrucao.setFloat(7, pessoa.getPeso());
            instrucao.setString(8, pessoa.getSexo());
            instrucao.setString(9, pessoa.getContato());
            instrucao.setString(10, pessoa.getEndereco());
            instrucao.setInt(11, pessoa.getMatricula());
            instrucao.execute();
            c.desconectar();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void excluir(int matriculaAux){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Deletar);
            instrucao.setInt(1, matriculaAux);
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("erro");
        }
    }
}
