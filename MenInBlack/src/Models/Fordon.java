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
public class Fordon {
    
    private String id;
    private String fordonsBeskrivning;
    private String arsmodell;
    
    public Fordon(String id, String fordonsBeskrivning, String arsmodell)
    {
        this.id = id;
        this.fordonsBeskrivning = fordonsBeskrivning;
        this.arsmodell = arsmodell;
    }
    
    public String getID()
    {
        return id;
    }
    
    public String getFordonsBeskrivning()
    {
        return fordonsBeskrivning;
    }
    
    public String getArsmodell()
    {
        return arsmodell;
    }
}
