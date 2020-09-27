/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashdata;
import org.apache.commons.codec.binary.Hex;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;


/**
 *
 * @author Balreira
 * @version 1.00, 28 Dec 2018
 */
public class HashData {
    
    private final String salt = "1234";
    private final int iterations = 1000, keyLength = 128;
    private final byte[] saltBytes = salt.getBytes();
        
    /**
     * método getter que retorna byte que faz o hash a uma string dada como parâmetro
     * @see HashData
     * @param data
     * @return (res) retorna do tipo byte a chave codificada
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * SecretKeyFactory -> representa um conjunto de chaves secretas (secret keys)
     * PBKDF2 (Password-based-Key-Derivative-Function) -> implementa funções pseudoaleatórias (ex: hash, HMAC)
     * HMAC (Keyed-Hash Message Authentication Code) -> tipo mais específico do MAC. Envolve cryptographic hash function e secret cryptographic key
     * SHA1 (Secure Hash Algorithm) -> hashing function
     * SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512") -> cria uma instância dessa classe pelo algoritmo PBKDF2WithHmacSHA512
     * PBEKeySpect (Password-Based Encryption) -> resulta uma cryptographic key
     * SecretKey -> interface que agrupa de forma segura todas as secret keys
     * 
     */
    private byte[] byteHashData(String data) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec spec = new PBEKeySpec(data.toCharArray(), saltBytes, iterations, keyLength );
        SecretKey key = skf.generateSecret(spec);
        byte[] res = key.getEncoded( );
        return res;
    }
    
    /**
     * método getter que retorna string que converte o hash data para string
     * @see HashData
     * @param data
     * @return (hashedString) retorna do tipo String os dados codificados
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public String getHashData(String data) throws NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] hashedBytes = byteHashData(data);
        String hashedString = Hex.encodeHexString(hashedBytes);
        return hashedString;
    }
}
