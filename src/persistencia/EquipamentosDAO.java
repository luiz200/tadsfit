package persistencia;

import dominio.Equipamentos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipamentosDAO {
    private Conexao c;
    private String Buscar = "select * from equipamentos where patrimonio = ?";
    private String Inserir = "insert into equipamentos (patrimonio, nome, status) values(?, ?, ?)";

    public EquipamentosDAO(){
        c = new Conexao("jdbc:postgresql://localhost:5432/tadsfit","postgres", "12345");
    }

    public Equipamentos buscar(int equipamentosAux){
        Equipamentos equipamento = null;
        try{
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Buscar);
            instrucao.setInt(1, equipamentosAux);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){//andando no resultset
                equipamento = new Equipamentos(rs.getInt("patrimonio"), rs.getString("nome"), rs.getString("status"));
            }
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca");
        }
        return equipamento;
    }

    public void inserir(Equipamentos equipamento){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Inserir);
            instrucao.setInt(1, equipamento.getPatrimonio());
            instrucao.setString(2, equipamento.getNome());
            instrucao.setString(3, equipamento.getStatus());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na inclusão");
        }
    }
}
