package persistencia;

import dominio.Filial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilialDAO {
    private Conexao c;
    private String Buscar = "select * from filial where id = ?";
    private String Inserir = "insert into filial (id, endereco, contato, horario) values(?, ?, ?, ?)";

    public FilialDAO(){
        c = new Conexao("jdbc:postgresql://localhost:5432/tadsfit","postgres", "12345");
    }

    public Filial buscar(int idAux){
        Filial filia = null;
        try{
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
            instrucao.setInt(1, idAux);
            ResultSet rs = instrucao.executeQuery();
            if (rs.next()){//andando no resultset
                filia = new Filial(rs.getInt("id"), rs.getString("endereco"), rs.getString("contato"), rs.getString("horario"));
            }
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na busca");
        }
        return filia;
    }

    public void inserir(Filial filia){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Inserir);
            instrucao.setInt(1, filia.getId());
            instrucao.setString(2, filia.getEndereco());
            instrucao.setString(3, filia.getContato());
            instrucao.setString(4, filia.getHorario());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na inclusão");
        }
    }
}
