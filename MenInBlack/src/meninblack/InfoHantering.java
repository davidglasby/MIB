/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meninblack;

import Models.Fordon;
import Models.IInfo;
import Models.IInfoDAL;
import Models.Omrade;
import Models.Plats;
import Models.Utrustning;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class InfoHantering implements IInfo{

    private IInfoDAL infodb;
    
    
    public InfoHantering(IInfoDAL infodb)
    {
        this.infodb = infodb;
    }

    @Override
    public ArrayList<Omrade> getAllaOmraden() {
        var omradeslista = infodb.getAllaOmraden();
        return omradeslista;
    }

    @Override
    public String getIDfromOmrade(String benamning) {
        
        String id = infodb.getIDfromOmrade(benamning);
        return id;
    }

    @Override
    public ArrayList<Plats> getAllaPlatser() {
        
        var platsLista = infodb.getAllaPlatser();
        return platsLista;
    }

    @Override
    public String getIDfromPlats(String benamning) {
       String id = infodb.getIDfromPlats(benamning);
       return id;
    }

    @Override
    public void andraOmradesChef(int omradesID, int agentID) {
        infodb.andraOmradesChef(omradesID, agentID);
    }

    @Override
    public void andraKontorsChef(int id) {
        infodb.andraKontorsChef(id);
    }

    @Override
    public ArrayList<Utrustning> getAllTillgangligUtrustning() {
        var utrustningsLista = infodb.getAllTillgangligUtrustning();
        if(utrustningsLista != null)
        {
            return utrustningsLista;
        }
        else
        {
            return null;
        }
    }

    @Override
    public ArrayList<Fordon> getAllaTillgangligaFordon() {
        var fordonsLista = infodb.getAllaTillgangligaFordon();
        if(fordonsLista != null)
        {
            return fordonsLista;
        }
        else
        {
            return null;
        }
    }

    @Override
    public int getUtrustningsIDfromBenamning(String benamning) {
        int utrustningsID = infodb.getUtrustningsIDfromBenamning(benamning);
        return utrustningsID;
    }

    @Override
    public void tilldelaAgentUtrustning(int utrustningsID, int agentID, String dagensDatum) {
        infodb.tilldelaAgentUtrustning(utrustningsID, agentID, dagensDatum);
    }

    @Override
    public int getMaxIDFromUtrustning() {
        int maxid = infodb.getMaxIDFromUtrustning();
        return maxid + 1;
    }

    @Override
    public void registreraNyUtrustning(int id, String benamning) {
        infodb.registreraNyUtrustning(id, benamning);
    }

    @Override
    public void registreraUtrustningSomVapen(int id, int kaliber) {
        infodb.registreraUtrustningSomVapen(id, kaliber);
    }

    @Override
    public void registreraUtrustningSomTeknik(int id, String kraftkalla) {
        infodb.registreraUtrustningSomTeknik(id, kraftkalla);
    }

    @Override
    public void registreraUtrustningSomKommunikation(int id, String overforingsTeknik) {
        infodb.registreraUtrustningSomKommunikation(id, overforingsTeknik);
    }

    @Override
    public String getOmradesChefGenomOmradesKontor(String omradeskontor) {
        var kontorschef = infodb.getOmradesChefGenomOmradesKontor(omradeskontor);
        if(kontorschef != null)
        {
            return kontorschef;
        }
        else
        {
            return null;
        }
        
    }

    @Override
    public ArrayList<Utrustning> getAllUtrustning() {
        var utrustningsLista = infodb.getAllUtrustning();
        return utrustningsLista;
    }

    @Override
    public ArrayList<Utrustning> getAllaVapen() {
        var vapenLista = infodb.getAllaVapen();
        return vapenLista;
    }

    @Override
    public ArrayList<Utrustning> getAllTeknik() {
        var teknikLista = infodb.getAllTeknik();
        return teknikLista;
    }

    @Override
    public ArrayList<Utrustning> getAllKommunikation() {
        var kommunikationLista = infodb.getAllKommunikation();
        return kommunikationLista;
    }

    @Override
    public void raderaFromUtrustning(int id) {
        infodb.raderaFromUtrustning(id);
    }

    @Override
    public void raderaFromVapenTeknikOrKommunikation(int utrustningsid, String tabellNamn) {
        infodb.raderaFromVapenTeknikOrKommunikation(utrustningsid, tabellNamn);
    }

    @Override
    public String getPlatsNamnFromID(int id) {
        String benamning = infodb.getPlatsNamnFromID(id);
        if(benamning != null)
        {
            return benamning;
        }
        else
        {
            return null;
        }
    }

    
}
