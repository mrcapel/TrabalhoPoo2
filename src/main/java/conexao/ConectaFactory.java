package conexao;

import java.sql.*;

public class ConectaFactory {
    
    public Connection getConection() {
        
        try{
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas", "teste", "123");
        }
        catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        
    }
    
}
