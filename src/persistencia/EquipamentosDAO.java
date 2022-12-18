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
    private String Inserir = "insert into equipamentos (patrimonio, id_filial, nome, status1) values(?, ?, ?, ?)";
    private String Alterar = "update equipamentos set patrimonio=?, id_filial=?, nome=?, status1=?";

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
                equipamento = new Equipamentos(rs.getInt("patrimonio"), rs.getInt("id_filial"), rs.getString("nome"), rs.getString("status1"));
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
            instrucao.setInt(2, equipamento.getId_filial());
            instrucao.setString(3, equipamento.getNome());
            instrucao.setString(4, equipamento.getStatus1());
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
                equipamento = new Equipamentos(rs.getInt("patrimonio"), rs.getInt("id_filial"),rs.getString("nome"), rs.getString("status1"));
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
            instrucao.setInt(2, equipamento.getId_filial());
            instrucao.setString(3, equipamento.getNome());
            instrucao.setString(4, equipamento.getStatus1());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na alteração");
        }
    }
}
