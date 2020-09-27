/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatedata;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Balreira
 * @version 1.00, 03 Jan 2019
 */
public class GenerateData {
    
    Zona z = new Zona();
    Est est = new Est();
    Lugar l = new Lugar();
    PrecoUser p = new PrecoUser();
    DetailsUser d = new DetailsUser();
    User u = new User();
    UserSaldo us = new UserSaldo();
    Veiculo v = new Veiculo();
    Avaliacaoapp a = new Avaliacaoapp();
    GeneralData g = new GeneralData();
    
    public void generateZonas() throws SQLException, IOException{
        g.setCodpostais();
        z.generateZonas();
        est.generateTable();
        l.generateTable();
        System.out.println("Os registos foram gerados com sucesso!");
    }
    
    public void generateUsers() throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
      //  p.generatePrecoUser();
        d.generateTable();
        u.generateTable();
        us.generateTable();
        v.generateTable();
        a.generateTable();
        System.out.println("Os registos foram gerados com sucesso!");
    }
    
    public static void main(String[] args) {
        GenerateData g = new GenerateData();
        try {
          //  g.generateZonas();
            try {
                g.generateUsers();
            } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(GenerateData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(GenerateData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
