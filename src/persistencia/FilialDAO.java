package persistencia;

import dominio.Filial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FilialDAO {
    private Conexao c;
    private String Relatorio = "select * from filial";
    private String Buscar = "select * from filial where idf = ?";
    private String Inserir = "insert into filial (idf, endereco, contato, horario) values(?, ?, ?, ?)";
    private String Alterar = "update filial set idf=?, endereco=?, contato=?, horario=?";

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
                filia = new Filial(rs.getInt("idf"), rs.getString("endereco"), rs.getString("contato"), rs.getString("horario"));
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
            instrucao.setInt(1, filia.getIdf());
            instrucao.setString(2, filia.getEndereco());
            instrucao.setString(3, filia.getContato());
            instrucao.setString(4, filia.getHorario());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na inclusão");
        }
    }
    public ArrayList<Filial> emitirRelatorio(){
        Filial fila;
        ArrayList<Filial> lista = new ArrayList<Filial>();
        try {
            c.conectar();
            Statement instrucao = c.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(Relatorio);
            while (rs.next()){
                fila = new Filial(rs.getInt("idf"), rs.getString("endereco"), rs.getString("contato"), rs.getString("horario"));
                lista.add(fila);
            }
        }catch (Exception e){
            System.out.println("Erro");
        }
        return lista;
    }

    public void alterar(Filial filia){
        try {
            c.conectar();
            PreparedStatement instrucao = c.getConexao().prepareStatement(Alterar);
            instrucao.setInt(1, filia.getIdf());
            instrucao.setString(2, filia.getEndereco());
            instrucao.setString(3, filia.getContato());
            instrucao.setString(4, filia.getHorario());
            instrucao.execute();
            c.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na alteração");
        }
    }
}
