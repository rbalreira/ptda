/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userordinario;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author danie
 */
public class HistoricoDados {
    
    /*
    *campos necessários para poder ir buscar os campos
    *que se encontram na base de dados
    */
    private Time tempoinicio, tempofim;
    Date datainicio, datafim;
    private String rua, codpostal;
    private float valor;

    /*
    *construtor para a classe HistoricoDados
    *@params tempoinicio, tempofim, rua, codpostal, valor
    */
    public HistoricoDados(Time tempoinicio, Time tempofim, Date datainicio, Date datafim, String rua, String codpostal, float valor) {
        this.tempoinicio = tempoinicio;
        this.tempofim = tempofim;
        this.datainicio = datainicio;
        this.datafim = datafim;
        this.rua = rua;
        this.codpostal = codpostal;
        this.valor = valor;
    }

    /*
    *método getter para o campo tempoinicio
    */
    public Time getTempoinicio() {
        return tempoinicio;
    }

    /*
    *método getter para o campo tempofim
    */
    public Time getTempofim() {
        return tempofim;
    }

    /*
    *método getter para o campo datainicio
    */
    public Date getDatainicio() {
        return datainicio;
    }

    /*
    *método getter para o campo datafim
    */
    public Date getDatafim() {
        return datafim;
    }

    /*
    *método getter para o campo rua
    */
    public String getRua() {
        return rua;
    }

    /*
    *método getter para o campo codpostal
    */
    public String getCodpostal() {
        return codpostal;
    }

    /*
    *método getter para o campo valor
    */
    public float getValor() {
        return valor;
    }
    
}
