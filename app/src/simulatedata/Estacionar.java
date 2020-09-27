package simulatedata;


import connection.Conexao;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cunha
 */
public class Estacionar {
        Matricula ma = new Matricula();
        Lugar lu = new Lugar();
        int i;
        Conexao connect = new Conexao();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Statement stmt = null; 
     
        /**
         * Invoca os Arrays criados nas classes 'Matricula' e 'Lugar'
         * @see Estacionar
         * @throws SQLException
         * @throws FileNotFoundException 
         */
    public Estacionar() throws SQLException, FileNotFoundException{
        ma.matriculas();
        lu.lugares();
    }
       /**
        * Método para actualizar o estado do lugar, isto é, coloca o estado a 1
        * no número de lugar que o carro ocupou
        * @see Estacionar
        * @param numlugar
        * @throws SQLException 
        */
     public void updatestado(int numlugar) throws SQLException{
         String sql = "update lugar set estado = 1 where numlugar = ?";
         conn = connect.connect();
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, numlugar);
         pstmt.executeUpdate();
         conn.close();
     }
     /**
      * Este método insere a matrícula da tabela lugar de modo a indicar que
      * o lugar ficou ocupado pela matrícula em questão.
      * @see Estacionar
      * @param matricula
      * @param numlugar
      * @throws SQLException 
      */
      public void insertmatricula(String matricula, int numlugar) throws SQLException{
          String sql = "UPDATE lugar SET \"veiculo_matricula\" = ? WHERE numlugar = ?";
          conn = connect.connect();
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, matricula);
          pstmt.setInt(2, numlugar);
          pstmt.executeUpdate();
          System.out.println("estacionado!");
          conn.close();
     }
      /**
       * Este método verifica quais os lugares que estão vazios
       * @see Estacionar
       * @throws SQLException 
       */
      public void checklugar() throws SQLException{
          String sql = "Select * from lugar where estado = 0";
          conn = connect.connect();
          stmt = conn.createStatement();
          stmt.executeQuery(sql);
      }
      /**
       * o metodo verestacionamento permite que as várias matrículas existentes no
       * ArrayList matriculas procurem por um estacionamento livre no ArrayList
       * que guarda os lugares de estacionamento. A condição if presente
       * identifica os lugares livres para estacionar e, caso não se verifique 
       * que o estacionamento está livre, este procura na linha seguinte.
       * Caso todos os estacionamentos estejam ocupado, este mostra a mensagem
       * "Não exitem lugares livres!"
       * 
       * @see Estacionar
       * @throws SQLException
       * @throws FileNotFoundException 
       */
       public void verestacionamento() throws SQLException, FileNotFoundException{
           // uma matricula a procurar um lugar para estacionar
           boolean ocupado = false;
           for(String m : ma.matriculas){    
               for(Lugar l: lu.lugar){
                   if(l.getEstado() == 0){
                       System.out.println("A estacionar!");
                       System.out.println(l.getNumlugar());
                       updatestado(l.getNumlugar());
                       insertmatricula(m, l.getNumlugar());
                       l.setEstado((short) 1);
                       ocupado = true;
                       break;
                   }
                }
               if(!ocupado){
                    System.out.println("Não exitem lugares livres!");
                    ocupado = true;
               }
             }
           
}
       public static void main(String[] args) {
            try {
                Estacionar v = new Estacionar();
                v.verestacionamento();
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(Estacionar.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}