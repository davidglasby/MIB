/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public interface IInfoDAL {
    
    public ArrayList<Omrade> getAllaOmraden();
    
    public String getIDfromOmrade(String benamning);
    
    public ArrayList<Plats> getAllaPlatser();
    
    public String getIDfromPlats(String benamning);
    
    public String getPlatsNamnFromID(int id);
    
    public void andraOmradesChef(int omradesID, int agentID);
     
    public void andraKontorsChef(int id);
     
    public String getOmradesChefGenomOmradesKontor(String omradeskontor);
     
    public ArrayList<Utrustning> getAllUtrustning();
     
    public ArrayList<Utrustning> getAllTillgangligUtrustning();
     
    public ArrayList<Utrustning> getAllaVapen();
    
    public ArrayList<Utrustning> getAllTeknik();
    
    public ArrayList<Utrustning> getAllKommunikation();
     
    public void raderaFromUtrustning(int id);
     
    public void raderaFromVapenTeknikOrKommunikation(int utrustningsid, String tabellNamn);
     
    public int getUtrustningsIDfromBenamning(String benamning);
     
    public void tilldelaAgentUtrustning(int utrustningsID, int agentID, String dagensDatum);
     
    public int getMaxIDFromUtrustning();
     
    public void registreraNyUtrustning(int id, String benamning);
     
    public void registreraUtrustningSomVapen(int id, int kaliber);
    
    public void registreraUtrustningSomTeknik(int id, String kraftkalla);
    
    public void registreraUtrustningSomKommunikation(int id, String overforingsTeknik);
     
    public ArrayList<Fordon> getAllaTillgangligaFordon();
     
     
     
     
}
