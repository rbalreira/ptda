/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userordinario;
import connection.Conexao;
import encryptdata.EncryptData;
import hashdata.HashData;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author Daniel
 * @author Balreira 08 Jan 2019
 */
public class UserOrdinario {
    
    Conexao connect = new Conexao();
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    CallableStatement cstmt = null;
    HashData h = new HashData();
    EncryptData e = new EncryptData();
    public ArrayList<Ests> ests;
    public ArrayList<Zona> zonas;
    public ArrayList<Veiculo> veiculos;
    private String com;
    private short nota;

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public short getNota() {
        return nota;
    }

    public void setNota(short nota) {
        this.nota = nota;
    }

    
    
    public UserOrdinario(){
        ests = new ArrayList();
        zonas = new ArrayList();
        veiculos = new ArrayList();
    }
    
    /**
     * método setter que faz o registo do utilizador na aplicação
     * @see UserOrdinario
     * @param bi
     * @param nif
     * @param datanasc
     * @param email
     * @param nome
     * @param morada
     * @param codpostal
     * @param telemovel
     * @param pass
     * @param codtipo
     * @param numcartaomb
     * @param saldo
     * @param metodopag
     * @param matricula
     * @param marca
     * @param modelo
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public void insertUser(String bi, String nif, Date datanasc, String email, String nome, 
    String morada, String codpostal, String telemovel, String pass, short codtipo, String numcartaomb, 
    float saldo, char metodopag, String matricula, String marca, String modelo) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        String query = "SELECT * FROM registaruser (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, h.getHashData(bi)); pstmt.setString(2, h.getHashData(nif));
        pstmt.setObject(3, convertToLocalDate(datanasc)); pstmt.setString(4, email);
        pstmt.setString(5, nome); pstmt.setString(6, morada);
        pstmt.setString(7, codpostal); pstmt.setString(8, h.getHashData(telemovel));
        pstmt.setString(9, h.getHashData(pass)); pstmt.setShort(10, codtipo);
        pstmt.setString(11, h.getHashData(numcartaomb)); pstmt.setFloat(12, saldo);
        pstmt.setString(13, Character.toString(metodopag)); pstmt.setString(14, e.encryptData(matricula));
        pstmt.setString(15, marca); pstmt.setString(16, modelo);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * Método Getter que retorna o preco para o upgrade de conta ordinaria
     * para conta premium
     * @see UserOrdinario 
     * @return
     * @throws SQLException 
     */
    public float getPreco() throws SQLException{
        String query = "SELECT preco FROM precoutilizador WHERE codtipo = 1;";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        rs.next();
        return rs.getFloat(1);
    }
    
    /**
     * Método getter que retorna o saldo que o utilizador tem
     * @see UserOrdinario
     * @param userid
     * @return
     * @throws SQLException 
     */
    public boolean checkSaldo(int userid) throws SQLException{
        String query = "SELECT saldo FROM utilizadorsaldo WHERE \"utilizador_detalhesutilizador_userid\" = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setInt(1, userid);
        rs = pstmt.executeQuery();
        rs.next();
        return rs.getFloat(1) > getPreco();
    }
    
    /**
     * Método setter que actualiza o estado do utilizador de ordinario para premium
     * e retira o custo da actualização ao saldo do utilizador
     * @see UserOrdinario
     * @param login
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public void setPremiumConta(String login) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM setpremiumconta (?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * Método getter que verifica se o utilizador é maior de idade
     * @see UserOrdinario
     * @param datebirth
     * @return
     * @throws ParseException 
     */
    public int check_data(Date datebirth) throws ParseException{
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date today = new Date();
        Date current = formatter.parse(formatter.format(today));
        
        Calendar a = getCalendar(datebirth);
        Calendar b = getCalendar(current);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) || (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) diff--;
        return diff;
    }
    
    /**
     * Método getter que retorna a 
     * @see UserOrdinario
     * @param date
     * @return 
     */
    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.UK);
        cal.setTime(date);
        return cal;
    }
    
    /**
     * Método getter que retorna o número de BI do utilizador, caso exista
     * @see UserOrdinario
     * @param bi
     * @return
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean check_bi(String bi) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        String query = "SELECT bi FROM detalhesutilizador WHERE bi = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, h.getHashData(bi));
        rs = pstmt.executeQuery();
        return rs.next();
    }
    
    /**
     * método getter que retorna o NIF do utilizador, caso exista
     * @see UserOrdinario
     * @param nif
     * @return
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean check_nif(String nif) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        String query = "SELECT nif FROM detalhesutilizador WHERE nif = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, h.getHashData(nif));
        rs = pstmt.executeQuery();
        return rs.next();
    }
    
    /**
     * método getter que retorna a matricula do utilizador caso exista
     * @see UserOrdinario
     * @param m
     * @return
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean check_matricula(String m) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        String x = h.getHashData(m);
        String query = "SELECT matricula FROM veiculo WHERE matricula = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, x);
        rs = pstmt.executeQuery();
        return rs.next();
    }
    
    /**
     * método getter que converte letras minúsculas para maiúsculas
     * @see UserOrdinario
     * @param m
     * @return 
     */
    public String uppercaseMatricula(String m){
        return m.toUpperCase();
    }
    
    /**
     * método getter que converte o tipo de dados para localdate
     * @see UserOrdinario
     * @param d
     * @return 
     */
    private LocalDate convertToLocalDate(Date d){
        return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    /**
     * método getter que retorna o número de telemóvel do utilizador
     * @see UserOrdinario
     * @param tele
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public boolean checkTelemovel(String tele) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        String query = "SELECT telemovel FROM utilizador WHERE telemovel = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, h.getHashData(tele));
        rs = pstmt.executeQuery();
        return rs.next();
    }
    
    /**
     * método getter que retorna a password do utilizador
     * @see UserOrdinario
     * @param pass
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    private boolean checkPass(String pass) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        String query = "SELECT password FROM utilizador WHERE password = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, h.getHashData(pass));
        rs = pstmt.executeQuery();
        return rs.next();
    }
    
    /**
     * método getter que retorna o email do utilizador
     * @see UserOrdinario
     * @param e
     * @return
     * @throws SQLException 
     */
    private boolean checkEmail(String e) throws SQLException{
        String query = "SELECT email FROM detalhesutilizador WHERE email = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, e);
        rs = pstmt.executeQuery();
        return rs.next();
    }
    
    /**
     * método getter que faz a verificação do login
     * @see UserOrdinario
     * @param user
     * @param pass
     * @return
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean checkLogin(String user, String pass) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        return (checkEmail(user) || checkTelemovel(user)) && checkPass(pass);
    }
    
    /**
     * Método setter que devolve todos os estacionamentos com mais de 6 lugares livres
     * @see UserOrdinario
     * @throws SQLException 
     */
    public void getLugaresLivres() throws SQLException{
        String query = "SELECT rua, codpostal, totallugareslivres FROM afluencialocal WHERE totallugareslivres > 6;";
        Ests es;
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        while(rs.next()){
            es = new Ests();
            es.setRua(rs.getString("rua")); es.setCodpostal(rs.getString("codpostal"));
           es.setTotallugareslivres(rs.getLong("totallugareslivres"));
           ests.add(es);
        }
        conn.close();
    }
    
    /**
     * método setter que guarda o tipozona, custoordinario e custopremium da
     * tabela zona num ArrayList
     * @see UserOrdinario
     * @throws SQLException 
     */
    public void getZonas() throws SQLException{
        String query = "SELECT tipozona, custoordinario, custopremium FROM zona;";
        conn = connect.connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        Zona z;
        while(rs.next()){
            z = new Zona();
            z.setTipozona(rs.getString("tipozona")); z.setCustoordinario(rs.getFloat("custoordinario"));
            z.setCustopremium(rs.getFloat("custopremium"));
            zonas.add(z);
        }
        conn.close();
    }
    
    /**
     * método setter que seleciona todos os dados da tabela verdados do utilizador
     * @see UserOrdinario
     * @param login
     * @param p
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public void getDadosPerfil(String login, PerfilUser p) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        String query = "SELECT * FROM verdados WHERE email = ? OR telemovel = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, login); pstmt.setString(2, h.getHashData(login));
        rs = pstmt.executeQuery();
        rs.next();
        p.setNome(rs.getString("nome")); p.setDataNasc(rs.getDate("datanasc").toString());
        p.setMorada(rs.getString("morada")); p.setCodPostal(rs.getString("codpostal")); p.setEmail(rs.getString("email"));
        p.setIban(rs.getString("iban")); p.setMetodopag(rs.getString("metodopag").charAt(0));
        p.setTelemovel(rs.getString("telemovel")); p.setPass(rs.getString("password"));
        conn.close();
    }

    /**
     * método getter que retorna o tipo de zona
     * @param t
     * @return 
     */
    public String getTipozona(char t){
        return t == 'n' || t == 'N' ? "NORTE" : t == 's' || t == 'S' ? "SUL" : t == 'c' || t == 'C' 
        ? "CENTRO" : t == 'e' || t == 'E' ? "ESTE" : "OESTE";
    }
    
    /**
     * Método que converte a String "Norte", "Sul", "Este", "Oeste" e "Centro
     * para o respetivo caracter
     * @see UserOrdinario
     * @param t
     * @return 
     */
    public char getTipozona(String t){
        return t.equals("Norte") ? 'n' : t.equals("Sul") ? 's' : t.equals("Centro")
        ? 'c' : t.equals("Este") ? 'e' : 'o';
    }

    /**
     * método getter que retorna o método de pagamento 
     * @see UserOrdinario
     * @param m
     * @return 
     */
    public String getMetodoPag(char m){
        return m == 'm' || m == 'M' ? "MultiBanco" : "PayPal";
    }
    
    /**
     * método getter que converte "Multibanco" ou "Paypal" para o respectivo caracter
     * @param m
     * @return 
     */
    public char getMetodoPag(String m){
        return m.equals("MultiBanco") ? 'm' : 'p';
    }
    
    /**
     * método setter que permite ao utilizador actualizar o seu código postal
     * @see UserOrdinario
     * @param c
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updateCodPostal(String c, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updatecodpostal(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, c); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * método setter que permite ao utilizador actualizar o seu nome
     * @see UserOrdinario
     * @param n
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updateNome(String n, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updatenome(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, n); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * método setter que permite ao utilizador actualizar a sua morada
     * @see UserOrdinario
     * @param m
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updateMorada(String m, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updatemorada(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, m); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * método setter que permite ao utilizador actualizar o seu email
     * @see UserOrdinario
     * @param e
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updateEmail(String e, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updateemail(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, e); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * método setter que permite ao utilizador actualizar o seu número de conta
     * @see UserOrdinario
     * @param i
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updateIban(String i, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updateiban(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, h.getHashData(i)); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * Método setter que permite ao utilizador alterar o modo de pagamento
     * @see UserOrdinario
     * @param m
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updateMetodoPag(String m, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updatemetodopag(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, Character.toString(getMetodoPag(m))); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * Método setter que permite actualizar a password do utilizador
     * @see UserOrdinario
     * @param p
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updatePass(String p, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updatepass(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, h.getHashData(p)); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * Método setter que permite actualizar o número de telemóvel do utilizador
     * @see UserOrdinario
     * @param t
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void updateTelemovel(String t, String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * FROM updatetele(?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, h.getHashData(t)); pstmt.setString(2, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * método setter que permite eliminar o registo do utilizador
     * @see UserOrdinario
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void removeUser(String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * from removeuser (?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, login);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * método getter que retorna o saldo do utilizador 
     * @see UserOrdinario
     * @param login
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    private float getSaldo(String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        conn = connect.connect();
        cstmt = conn.prepareCall("{ ? = call getsaldo( ? ) }");
        
        cstmt.registerOutParameter(1, Types.REAL);
        cstmt.setString(2, login);
        cstmt.execute();
        return cstmt.getFloat(1);
    }
    
    /**
     * 
     * método getter 
     * @see UserOrdinario
     * @param login
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public boolean checkSaldoPremium(String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        return getSaldo(login) >= getPreco();
    }
    
    /**
     * método setter que obtém o veículo do utilizador 
     * @see UserOrdinario
     * @param login
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public void getVeiculos(String login) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        String query = "SELECT matricula, marca, modelo FROM getmatriculas WHERE email = ? OR telemovel = ?;";
        Veiculo v;
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, login); pstmt.setString(2, h.getHashData(login));
        rs = pstmt.executeQuery();
        while(rs.next()){
            v = new Veiculo();
            v.setMatricula(e.decryptData(rs.getString("matricula"))); v.setMarca(rs.getString("marca"));
            v.setModelo(rs.getString("modelo"));
            veiculos.add(v);
        }
        conn.close();
    }
    
    /**
     * método setter que actualiza um ou mais carros na tabela veículo
     * @see UserOrdinario
     * @param login
     * @param oldMatr
     * @param newMatr
     * @param marca
     * @param modelo
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public void updateMatricula(String login, String oldMatr, String newMatr, String marca, String modelo) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * from updatematricula (?,?,?,?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, login); pstmt.setString(2, e.encryptData(oldMatr));
        pstmt.setString(3, e.encryptData(newMatr)); pstmt.setString(4, marca);
        pstmt.setString(5, modelo);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * 
     * método setter que adiciona um veículo do utilizador à tabela veículo
     * @see UserOrdinario
     * @param login
     * @param matr
     * @param marca
     * @param modelo
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public void addMatricula(String login, String matr, String marca, String modelo) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * from addmatricula (?,?,?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, login); pstmt.setString(2, e.encryptData(matr));
        pstmt.setString(3, marca); pstmt.setString(4, modelo);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * 
     * método setter que elimina a matrícula escolhida da tabela veículo
     * @see UserOrdinario
     * @param matr
     * @throws SQLException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public void deleteMatricula(String matr) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
        String query = "DELETE FROM veiculo WHERE matricula = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, e.encryptData(matr));
        pstmt.executeUpdate();
        conn.close();
    }
    
    /**
     * Método setter que utiliza a função addavaliarapp de modo a adicionar na tabela 
     * classificacaoapp as avaliações e comentários dos utilizadores 
     * @see UserOrdinario
     * @param login
     * @param nota
     * @param comment
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SQLException 
     */
    public void avaliarApp(String login, short nota, String comment) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException{
        if(checkTelemovel(login)) login = h.getHashData(login);
        String query = "SELECT * from addavaliarapp (?,?,?);";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, login); pstmt.setShort(2, nota);
        pstmt.setString(3, comment);
        rs = pstmt.executeQuery();
        conn.close();
    }
    
    /**
     * método getter que retorna todos os dados da vista getavalicações
     * @see UserOrdinario
     * @param login
     * @return
     * @throws SQLException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public boolean checkAvaliacao(String login) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException{
        String query = "SELECT * FROM getavaliacoes WHERE email = ? OR telemovel = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(query);
        
        pstmt.setString(1, login); pstmt.setString(2, h.getHashData(login));
        rs = pstmt.executeQuery();
        return rs.next();
    }
    
    /**
     * Método getter que retorna o valor ordinário de uma zona em pesquisa
     * @see UserOrdinario
     * @param tipozona
     * @return
     * @throws SQLException 
     */
    public float getPrecoZonaOrdinario(char tipozona) throws SQLException{
        String sql = "SELECT custoordinario FROM zona WHERE tipozona = ?;";
        conn = connect.connect();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Character.toString(tipozona));
        rs = pstmt.executeQuery();
        rs.next();
        return rs.getFloat(1);
    }
}
