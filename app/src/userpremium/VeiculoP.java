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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import userordinario.Veiculo;

/**
 *
 * @author Cunha
 */
public class VeiculoP {
    Conexao connect = new Conexao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Statement stmt = null;
    String matricula;
    HashData h = new HashData();
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
        
    public void getmatricula(String login, Veiculo v) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        String sql = "Select * from getmatriculas WHERE email = ? OR telemovel = ?";
        conn = connect.connect();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, login); pstmt.setString(2, h.getHashData(login));
        rs = pstmt.executeQuery();
        rs.next();
        v.setMatricula(rs.getString("matricula"));
    }
}
