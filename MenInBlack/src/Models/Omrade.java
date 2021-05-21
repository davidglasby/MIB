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
public class Omrade {
    
    private int omradesid;
    private String benamning;
    
    public Omrade(int id, String benamning)
    {
        this.omradesid = id;
        this.benamning = benamning;
    }
    
    public int getOmradesID()
    {
        return omradesid;
    }
    
    public String getBenamning()
    {
        return benamning;
    }
}
