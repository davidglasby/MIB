/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author hp
 */
public class Utrustning {
    
    private int id;
    private String benamning;
    
    public Utrustning(int id, String benamning)
    {
        this.id = id;
        this.benamning = benamning;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getBenamning()
    {
        return benamning;
    }
}
