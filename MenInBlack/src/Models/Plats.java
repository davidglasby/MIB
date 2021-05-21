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
public class Plats {
    
    private int platsID;
    private int finns_i;
    private String benamning;
    
    public Plats(int platsID, int finns_i, String benamning)
    {
        this.platsID = platsID;
        this.finns_i = finns_i;
        this.benamning = benamning;
    }
    
    public int getID()
    {
        return platsID;
    }
    
    public int getFinns_i()
    {
        return finns_i;
    }
    
    public String getBenamning()
    {
        return benamning;
    }
    
   
}
