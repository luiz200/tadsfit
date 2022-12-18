package persistencia;

import dominio.Equipamentos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EquipamentosDAO {
    private Conexao c;
    private String Relatorio = "select * from equipamentos";
    private String Buscar = "select * from equipamentos where patrimonio = ?";
    private String Inserir = "insert into equipamentos (patrimonio, nome, status) values(?, ?, ?)";
    private String Alterar = "update equipamentos set patrimonio=?, nome=?, status=?";

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

    public ArrayList<Equipamentos> emitirRelatorio(){
        Equipamentos equipamento;
        ArrayList<Equipamentos> lista = new ArrayList<Equipamentos>();
        try {
            c.conectar();
            Statement instrucao = c.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(Relatorio);
            while (rs.next()){
                equipamento = new Equipamentos(rs.getInt("patrimonio"), rs.getString("nome"), rs.getString("status"));
                lista.add(equipamento);
            }
        }catch (Exception e){
            System.out.println("Erro");
        }
        return lista;
    }

    public void alterar(Equipamentos equipamento){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setInt(1, equipamento.getPatrimonio());
            instrucao.setString(2, equipamento.getNome());
            instrucao.setString(3, equipamento.getStatus());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na alteração");
        }
    }
}
