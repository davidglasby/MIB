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
public class Agent {
    
    private int id;
    private String namn;
    private String telefon;
    private String anstallningsDatum;
    private String admin;
    private String losenord;
    
    public Agent(int id, String namn, String telefon, String anstallningsDatum, String admin, String losenord)
    {
        this.id = id;
        this.namn = namn;
        this.telefon = telefon;
        this.anstallningsDatum = anstallningsDatum;
        this.admin = admin;
        this.losenord = losenord;
    }
    
    public String getNamn()
    {
        return namn;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getLosenord()
    {
        return losenord;           
    }
    
    public String getAnstDatum()
    {
        return anstallningsDatum;
    }
    
    public String getTelefon()
    {
        return telefon;
    }
    
    public String isAdmin()
    {
        return admin;
    }
    
    public void setLosenord(String losen)
    {
        this.losenord = losen;
    }
}
