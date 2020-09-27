/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Balreira
 * @version 1.00, 7 Dec 2018
 */
public class Conexao {
    
    private final String url = "jdbc:postgresql://estga-dev.clients.ua.pt:5432/ptda-2018-gr4";
    private final String user = "[username]";
    private final String password = "[password]";
    
    /**
     * método do tipo Connection que verifica se obteve ligação com o PostgreSQL
     * @return (Connection) caso obtenha ligação com o PostgreSQL; (SQLException) caso não obtenha comunicação
     * @throws SQLException
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
}
