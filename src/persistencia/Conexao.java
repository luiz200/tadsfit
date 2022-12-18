package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String usuario;
    private String senha;
    private String caminho;
    private Connection minhaConexao;

    public Conexao(String caminho, String usuario, String senha){
        this.caminho = caminho;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver");//carrega o driver do postgres
            minhaConexao = DriverManager.getConnection(caminho, usuario, senha);//abrir a conexao
            System.out.println("Conexão realizada com sucesso");
        }catch (Exception e){
            System.out.println("Erro na conexão");
        }
    }

    public void desconectar(){
        try{
            minhaConexao.close();
        }catch (Exception e){
            System.out.println("Erro na desconexão...");
        }
    }

    public Connection getConexao(){
        return minhaConexao;
    }
}
