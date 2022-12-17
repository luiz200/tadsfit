package persistencia;

import dominio.Funcionarios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionariosDAO {
    private Conexao c;
    private String Buscar = "select * from funcionarios where matricula = ?";
    private String Inserir = "insert into funcionarios(matricula, nome, idade, sexo, contato, endereco, horario) valeus(?, ?, ?, ?, ?, ?, ?)";

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
}
