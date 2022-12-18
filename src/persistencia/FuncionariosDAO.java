package persistencia;

import dominio.Funcionarios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncionariosDAO {
    private Conexao c;
    private String Relatorio = "select * from funcionarios";
    private String Buscar = "select * from funcionarios where matricula = ?";
    private String Inserir = "insert into funcionarios(matricula, nome, idade, sexo, contato, endereco, horario) valeus(?, ?, ?, ?, ?, ?, ?)";
    private String Alterar = "update funcionarios set matricula=?, nome=?, idade=?, sexo=?, contato=?, endereco=?, horario=?";
    private String Deletar = "delete from funcionarios where matricula=?";

    public FuncionariosDAO(){
        c = new Conexao("jdbc:postgresql://localhost:5432/tadsfit","postgres", "12345");
    }

    public Funcionarios buscar(int matriculaAux){
        Funcionarios funcionario = null;
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
            instrucao.setInt(1, matriculaAux);
            ResultSet rs = instrucao.executeQuery();
            if (rs.next()){//andando no resultset
                funcionario = new Funcionarios(rs.getInt("matricula"), rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo"), rs.getString("contato"), rs.getString("endereco"), rs.getString("horario"));
            }
            c.desconectar();

        }catch (SQLException e){
            System.out.println("Erro na busca");
        }
        return funcionario;
    }

    public void inserir(Funcionarios funcionario){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Inserir);
            instrucao.setInt(1, funcionario.getMatricula());
            instrucao.setString(2, funcionario.getNome());
            instrucao.setInt(3, funcionario.getIdade());
            instrucao.setString(4, funcionario.getSexo());
            instrucao.setString(5, funcionario.getContato());
            instrucao.setString(6, funcionario.getEndereco());
            instrucao.setString(7, funcionario.getHorario());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na inclusão");
        }
    }

    public void relatorio(Funcionarios funcionario){
        try{

        }catch (Exception e){

        }
    }

    public ArrayList<Funcionarios> emitirRelatorio(){
        Funcionarios funcionario;
        ArrayList<Funcionarios> lista = new ArrayList<Funcionarios>();
        try {
            c.conectar();
            Statement instrucao = c.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(Relatorio);
            while (rs.next()){
                funcionario = new Funcionarios(rs.getInt("matricula"), rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo"), rs.getString("contato"), rs.getString("endereco"), rs.getString("horario"));
                lista.add(funcionario);
            }
        }catch (Exception e){
            System.out.println("Erro");
        }
        return lista;
    }

    public void alterar(Funcionarios funcionario){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setInt(1, funcionario.getMatricula());
            instrucao.setString(2, funcionario.getNome());
            instrucao.setInt(3, funcionario.getIdade());
            instrucao.setString(4, funcionario.getSexo());
            instrucao.setString(5, funcionario.getContato());
            instrucao.setString(6, funcionario.getEndereco());
            instrucao.setString(7, funcionario.getHorario());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na alteração");
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
