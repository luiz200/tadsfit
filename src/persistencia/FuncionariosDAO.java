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
    private String Inserir = "insert into funcionarios(matricula, id_filial, nome, idade, sexo, contato, endereco, horario) values(?, ?, ?, ?, ?, ?, ?, ?)";
    private String Alterar = "update funcionarios set matricula=?, id_filial=?, nome=?, idade=?, sexo=?, contato=?, endereco=?, horario=? where matricula=?";
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
                funcionario = new Funcionarios(rs.getInt("matricula"), rs.getInt("id_filial"), rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo"), rs.getString("contato"), rs.getString("endereco"), rs.getString("horario"));
            }
            c.desconectar();

        }catch (SQLException e){
            System.out.println(e);
        }
        return funcionario;
    }

    public void inserir(Funcionarios funcionario){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Inserir);
            instrucao.setInt(1, funcionario.getMatricula());
            instrucao.setInt(2, funcionario.getId_filial());
            instrucao.setString(3, funcionario.getNome());
            instrucao.setInt(4, funcionario.getIdade());
            instrucao.setString(5, funcionario.getSexo());
            instrucao.setString(6, funcionario.getContato());
            instrucao.setString(7, funcionario.getEndereco());
            instrucao.setString(8, funcionario.getHorario());
            instrucao.execute();
            System.out.println("Cadastrado com sucesso!");
            c.desconectar();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro na inclusão");
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
                funcionario = new Funcionarios(rs.getInt("matricula"), rs.getInt("id_filial"), rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo"), rs.getString("contato"), rs.getString("endereco"), rs.getString("horario"));
                lista.add(funcionario);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return lista;
    }

    public void alterar(Funcionarios funcionario){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setInt(1, funcionario.getMatricula());
            instrucao.setInt(2, funcionario.getId_filial());
            instrucao.setString(3, funcionario.getNome());
            instrucao.setInt(4, funcionario.getIdade());
            instrucao.setString(5, funcionario.getSexo());
            instrucao.setString(6, funcionario.getContato());
            instrucao.setString(7, funcionario.getEndereco());
            instrucao.setString(8, funcionario.getHorario());
            instrucao.setInt(9, funcionario.getMatricula());
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
            System.out.println(e);
        }
    }
}
