/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userpremium;
import connection.Conexao;
import hashdata.HashData;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import userordinario.UserOrdinario;


/**
 *
 * @author Balreira
 * @version 1.00, 18 Dec 2018
 */
public class UserPremium {
    
    Conexao connect = new Conexao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    CallableStatement cstmt = null;
    UserOrdinario u = new UserOrdinario();
    HashData h = new HashData();
    
    
    /**
     * método do tipo boolean que verifica se o lugar está ou não ocupado
     * @see UserPremium
     * @param numLugar
     * @return (true) caso o lugar esteja desocupado (0 - Livre); (false) se o lugar estiver ocupado (1 - Ocupado)
     * @throws SQLException 
     * verifica na query se o lugar dado como parâmetro está livre
     * estabelece ligação e retorna true se o cursor se mudar de posição (rs.next())
     */
    private boolean checkLugar(int numLugar) throws SQLException{
        String query = "SELECT numlugar FROM lugar l WHERE l.numlugar = ? AND l.estado = 0;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setInt(1, numLugar);
        rs = pstmt.executeQuery();
        return rs.next();
    }
    /**
     * método getter que verifica se o utilizador é ou não premium
     * @see UserPremium
     * @param login
     * @return
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean checkPremium(String login) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        if(u.checkTelemovel(login)) login = h.getHashData(login);
        conn  = connect.connect();
        cstmt = conn.prepareCall("{ ? = call checkpremium( ? ) }");
        
        cstmt.registerOutParameter(1, Types.BOOLEAN);
        cstmt.setString(2, login);
        cstmt.execute();
        return cstmt.getBoolean(1);
    }
    /**
     * método getter que retorna o valor premium das zonas
     * @see UserPremium
     * @param tipozona
     * @return
     * @throws SQLException 
     */
    public float getPrecoZonaPremium(char tipozona) throws SQLException{
        String sql = "SELECT custopremium FROM zona WHERE tipozona = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Character.toString(tipozona));
        rs = pstmt.executeQuery();
        rs.next();
        return rs.getFloat(1);
    }
}