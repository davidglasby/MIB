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
public class Alien {
    
    private int id;
    private String regDatum;
    private String losenord;
    private String namn;
    private String telefon;
    private int plats;
    private int ansvarigAgent;
    
    public Alien(int id, String regDatum, String losenord, String namn, String telefon, int plats, int ansvarigAgent)
    {
       this.id = id;
       this.regDatum= regDatum;
       this.losenord = losenord;
       this.namn = namn;
       this.telefon = telefon;
       this.plats = plats;
       this.ansvarigAgent = ansvarigAgent;
              
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getName()
    {
        return namn;
    }
    
    public int getPlats()
    {
        return plats;
    }
    
    public String getTelefon()
    {
        return telefon;
    }
    
    public String getLosenord()
    {
        return losenord;
    }
    
    public String getRegDatum()
    {
        return regDatum;
    }
    
    public int getAnsvarigAgentID()
    {
        return ansvarigAgent;
    }
    
    public void setLosenord(String losen)
    {
        this.losenord = losen;
    }
            
}
