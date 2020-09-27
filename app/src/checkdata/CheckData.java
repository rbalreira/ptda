/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdata;
import org.apache.commons.validator.routines.EmailValidator;
/**
 *
 * @author Balreira
 * @version 1.00, 28 Dec 2018
 */
public class CheckData {
    
    private final int max = 9;
    private boolean isLetter, isDigit;
    
    /**
     * método getter que retorna boolean que verifica se o BI é ou não válido
     * @see CheckData
     * @param bi
     * @return (true) se for um BI válido; (false) se for um BI inválido
     * converte o número para string
     * retorna true se o length do número for = max e maior 0
     */
    public boolean check_BI(String bi){
        return bi.matches("^[0-9]{8}$") && bi.length() == 8 && Integer.parseInt(bi) > 0;
    }
    
    /**
     * método getter que retorna boolean que verifica se o NIF é ou não válido
     * @see CheckData
     * @param nif
     * @return (true) se for um NIF válido; (false) se for um NIF inválido
     * converte o número para string
     * verifica se o length é menor que max e se o número é menor que 0
     * multiplica o 1º dígito por 9, o 2º dígito por 8, o 3º dígito por 7...
     * calcula o resto da divisão por 11 e subtrai por 11
     * se o resto for maior ou igual 10, o dígito de controlo fica = 0
     * retorna true se o dígito de controlo for igual ao último dígito do número
     */
    public boolean check_NIF(String nif){
        if(!nif.matches("^[0-9]{9}$") || nif.length() < max || Integer.parseInt(nif) < 0) return false;
        int checkSum = 0;
        for(int i = 0; i < max - 1; i++)
            checkSum += (nif.charAt(i) - '0') * (max - i);
        int checkDigit = 11 - (checkSum % 11);
	if (checkDigit >= 10) checkDigit = 0;
        return checkDigit == nif.charAt(max - 1) - '0';
    }
    
    /**
     * método getter que retorna boolean que verifica se o número de MultiBanco é ou não válido
     * @see CheckData
     * @param num
     * @return (true) se for um número válido; (false) se for um número inválido
     * retorna true se o número contém obrigatoriamente, 16 dígitos entre 0 e 9
     * ^ : indica ínicio da string
     * [0-9]{16} : contém, obrigatoriamente, 16 dígitos entre 0 e 9
     * $ : indica fim da string
     */
    public boolean check_numMB(String num){
        return num.matches("^[0-9]{16}$");
    }
    
    /**
     * método getter que retorna boolean que verifica se a matrícula cumpre ou não as normas
     * @see CheckData
     * @param x
     * @return (true) se for uma matrícula válido; (false) se for um matrícula inválida
     * verifica se a matrícula cumpre um dos modelos seguintes: AA-00-00, 00-00-AA, 00-AA-00, AA-00-AA
     * ^ : indica ínicio da string
     * [a-zA-Z]{2} : contém, obrigatoriamente, 2 letras de a-z ou A-Z
     * [0-9]{2} : contém, obrigatoriamente, 2 dígitos de 0 a 9
     * $ : indica fim da string
     */
    public boolean check_matricula(String x){
        return x.matches("^[a-zA-Z]{2}-[0-9]{2}-[0-9]{2}$") || x.matches("^[0-9]{2}-[0-9]{2}-[a-zA-Z]{2}$") ||
        x.matches("^[0-9]{2}-[a-zA-Z]{2}-[0-9]{2}$") || x.matches("^[a-zA-Z]{2}-[0-9]{2}-[a-zA-Z]{2}$");
    }
    
    /**
     * método getter que retorna boolean que verifica se o número telemóvel é ou não válido
     * @see CheckData
     * @param num
     * @return (true) se o número for válido; (false) se o número for inválido
     * converte para o número para string
     * verifica se o length é = max
     * verifica se os primeiros 2 dígitos são = 91, 96 ou 93
     * verifica se os primeiros 3 dígitos são = 921, 925, 927 ou 929
     * verifica se os primeiros 4 dígitos são = 9240, 9244, 9220 ou 9222
     * caso cumpra a 1ª condição e uma das 3 últimas retorna true
     */
    public boolean check_telemovel(String num){
        return num.length() == max && (num.substring(0, 2).matches("91|96|93") || 
        num.substring(0, 3).matches("921|925|927|929") || num.substring(0, 4).matches("9240|9244|9220|9222"));
    }
    
    /**
     * método getter do tipo int que testa se a password é forte (tem pelo menos 1 dígito e 1 letra ou fraca (tem apenas 1 dos 2)
     * @see CheckData
     * @param pass
     * @return (1) caso a password contenha pelo menos 1 letra e 1 dígito; (0)
     * caso não contenha nenhum dos 2
     * guarda numa String a substring a partir do índice 1 da password atual
     * guarda em int os valores 1 e 0:  1 é Password forte     0 é Password fraca
     * guarda num char o caractere da posição 0 da password
     * guarda em boolean se o caractere da posição 0 é uma letra ou dígito
     * caso a password atinja o length = 1 verifica o seguinte:
     * digit || letter ? (isLetter e isDigit ? forte : fraca) : fraca no caso de que seja dígito ou letra
     * verifica se ambos os boolean são = true
     * caso sejam, retorna a msg de password forte; senão retorna fraco. Se o caractere não for dígito nem letra
     * retorna fraco
     * se o caractere atual for um dígito ou letra, muda o boolean respetivo para = true e chama a função recursiva
     * caso não seja letra nem dígito, invoca a função recursiva
     * 
     */
    public int password_strength(String pass){
        int score = 0;
        
        if( pass.length() < 8 ) return 0;
        else if( pass.length() >= 10 ) score += 2;
        else score += 1;
        
        //if it contains one digit, add 2 to total score
        if(pass.matches("(?=.*[0-9]).*")) score += 2;
        
        //if it contains one lower case letter, add 2 to total score
        if(pass.matches("(?=.*[a-z]).*")) score += 2;
        
        //if it contains one upper case letter, add 2 to total score
        if(pass.matches("(?=.*[A-Z]).*")) score += 2;    
        
        //if it contains one special character, add 2 to total score
        if(pass.matches("(?=.*[~!@#$%^&*()_-]).*")) score += 2;
        
        return score;
    }
    
    /**
     * método getter que retorna boolean que verifica se o código-postal é ou não válido
     * @see CheckData
     * @param cod
     * @return (true) caso o código cumpra o modelo 0000-000 e os primeiros 4 dígitos sejam entre 1000 e 9999
     * e os últimos 3 dígitos sejam entre 100 e 999; (false) caso não cumpra nenhuma destas condições
     * ^ : indica ínicio da string
     * [0-9]{4} : contém, obrigatoriamente, 4 dígitos entre 0 e 9
     * [0-9]{3} : contém, obrigatoriamente, 3 dígitos entre 0 e 9
     * $ : indica fim da string
     * between(Integer.parseInt(cod.substring(0, 4)), 1000, 9999) : verifica se o conjunto dos primeiros 4 dígitos
     * está entre 1000 e 9999
     * between(Integer.parseInt(cod.substring(5, 9)), 100, 999) : verifica se o conjunto dos últimos 3 dígitos
     * está entre 100 e 999
     */
    public boolean check_codPostal(String cod){
        return cod.matches("^[0-9]{4}-[0-9]{3}$") && between(Integer.parseInt(cod.substring(0, 4)), 1000, 9999)
        && between(Integer.parseInt(cod.substring(5, 8)), 100, 999);
    }
    
    /**
     * método getter que retorna boolean que verifica se o dado parâmetro x está entre os parâmetros min e max
     * @see CheckData
     * @param x
     * @param min
     * @param max
     * @return (true) caso o parâmetro x esteja entre o parâmetro min e max; (false) se o parâmetro não esteja
     * entre o parâmetro min e max
     */
    private boolean between(int x, int min, int max){
        return x >= min && x <= max;
    }
    
    /**
     * método getter que retorna boolean que verifica se o dado valor é ou não maior ou igual a 0
     * @see CheckData
     * @param num
     * @return (true) caso o número seja maior ou igual a 0; (false) se o número for menor do que 0
     */
    public boolean valor(float num){
        return num >= 0;
    }
    
    /**
     * método getter que retorna boolean que verifica se o dado charactere é ou não = n,s,c,e,o,N,S,C,E ou O
     * @see CheckData
     * @param z
     * @return (true) caso o charactere seja = n,s,c,e,o,N,S,C,E ou O; (false) caso o charactere não seja = a
     * n,s,c,e,o,N,S,C,E ou O
     * (?i) : ativa o modo case-insensitive
     * (?i)n|s|c|e|o : contém n,s,c,e ou o, aceitando também case-insensitive (N,S,C,E ou O)
     */
    public boolean check_tipoZona(char z){
        return Character.toString(z).matches("(?i)n|s|c|e|o");
    }
    
    /**
     * método getter que retorna boolean que verifica se a avaliação é entre 0 e 5
     * @see CheckData
     * @param a
     * @return (true) se o número for entre 0 e 5; (false) se o número for diferente entre o intervalo 0-5
     */
    public boolean check_avaliacaoApp(short a){
        return a == 0 || a == 1 || a == 2 || a == 3 || a == 4 || a == 5;
    }
    
    /**
     * método getter que retorna boolean que verifica se o email é ou não válido
     * @see CheckData
     * @param e
     * @return (true) caso o email cumpra os requisitos da classe EmailValidator; (false) se o email for inválido
     * cria uma instância da classe EmailValidator
     * retorna true ou false caso email seja válido pelo método isValid()
     */
    public boolean check_email(String e){
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(e);
    }
}