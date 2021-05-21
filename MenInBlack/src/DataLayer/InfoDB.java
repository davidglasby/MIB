 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Models.Fordon;
import Models.IInfoDAL;
import Models.Omrade;
import Models.Plats;
import Models.Utrustning;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author hp
 */
public class InfoDB implements IInfoDAL {

    @Override
    public ArrayList<Omrade> getAllaOmraden() {
        try
        {
            var omradesLista = new ArrayList<Omrade>();
            var sq = "SELECT * FROM OMRADE";
            var datas = DatabaseAcces.getIdb().fetchRows(sq);
            
            for(HashMap<String, String> data : datas)
            {
                var id = Integer.parseInt(data.get("OMRADES_ID"));
                var benamning = data.get("BENAMNING");
                
                var omrade = new Omrade(id, benamning);
                omradesLista.add(omrade);
            }
            return omradesLista;
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        return null;
        
    }

    @Override
    public String getIDfromOmrade(String benamning) {
        
       try
       {
            var sq = "SELECT OMRADES_ID FROM OMRADE WHERE BENAMNING=" +"'" + benamning + "'";
            var omradesidString = DatabaseAcces.getIdb().fetchSingle(sq);
             
            return omradesidString;
       }
       
       catch (InfException undantag)
       {
           System.out.println(undantag);
       }
       return null;
        
    }

    @Override
    public ArrayList<Plats> getAllaPlatser() {
        try
        {
            var platsLista = new ArrayList<Plats>();
            var sq = "SELECT * FROM PLATS";
            var datas = DatabaseAcces.getIdb().fetchRows(sq);
            
            for(HashMap<String, String> data : datas)
            {
                var id = Integer.parseInt(data.get("PLATS_ID"));
                var finns_i = Integer.parseInt(data.get("FINNS_I"));
                var benamning = data.get("BENAMNING");
                
                var plats = new Plats(id, finns_i, benamning);
                platsLista.add(plats);
            }
            return platsLista;
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        return null;
    }

    @Override
    public String getIDfromPlats(String benamning) {
        try
       {
            var sq = "SELECT PLATS_ID FROM PLATS WHERE BENAMNING=" +"'" + benamning + "'";
            var platsIdString = DatabaseAcces.getIdb().fetchSingle(sq);
             
            return platsIdString;
       }
       
       catch (InfException undantag)
       {
           System.out.println(undantag);
       }
       return null;
    }

    @Override
    public void andraOmradesChef(int omradesID, int agentID) {
        
        try
        {
            var sqResetAgent = "UPDATE OMRADESCHEF SET AGENT_ID=NULL WHERE AGENT_ID=" + agentID;
            DatabaseAcces.getIdb().update(sqResetAgent);
            var sq = "UPDATE OMRADESCHEF SET AGENT_ID=" + agentID + " WHERE OMRADE=" + omradesID;
            DatabaseAcces.getIdb().update(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void andraKontorsChef(int id) {
        
        try
        {
            var sq = "UPDATE KONTORSCHEF SET AGENT_ID=" + id;
            DatabaseAcces.getIdb().update(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
            
    }

    @Override
    public ArrayList<Utrustning> getAllTillgangligUtrustning() {
        
        try
        {
            var utrustningsLista = new ArrayList<Utrustning>();
            var sq = "SELECT * FROM UTRUSTNING WHERE UTRUSTNINGS_ID NOT IN(SELECT UTRUSTNINGS_ID FROM INNEHAR_UTRUSTNING)";
            var allUtrustning = DatabaseAcces.getIdb().fetchRows(sq);
            if(allUtrustning != null)
            {
                for(HashMap<String, String> utrustning : allUtrustning)
                {
                    var id = Integer.parseInt(utrustning.get("UTRUSTNINGS_ID"));
                    var benamning = utrustning.get("BENAMNING");
                
                    var ur = new Utrustning(id, benamning);
                    utrustningsLista.add(ur);
                }
                return utrustningsLista;
            }
            else
            {
                return null;
            }
        }
            catch (InfException undantag)
            {
                System.out.println(undantag);
                return null;
            }
    }

    @Override
    public ArrayList<Fordon> getAllaTillgangligaFordon() {
        
        try
        {
            var fordonsLista = new ArrayList<Fordon>();
            var sq = "SELECT * FROM FORDON WHERE FORDONS_ID NOT IN(SELECT FORDONS_ID FROM INNEHAR_FORDON)";
            var allaFordon = DatabaseAcces.getIdb().fetchRows(sq);
            if(allaFordon != null)
            {
                for(HashMap<String, String> fordon : allaFordon)
                {
                    var id = fordon.get("FORDONS_ID");
                    var fordonsBeskrivning = fordon.get("FORDONSBESKRIVNING");
                    var registreringsDatum = fordon.get("REGISTRERINGSDATUM");
                    var arsmodell = fordon.get("ARSMODELL");
                
                    var fd = new Fordon(id, fordonsBeskrivning, arsmodell);
                    fordonsLista.add(fd);
                }
                return fordonsLista;
            }
            else
            {
                return null;
            }
            
            
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            return null;
        }
    }

    @Override
    public int getUtrustningsIDfromBenamning(String benamning) {
        try
        {
            var sq = "SELECT UTRUSTNINGS_ID FROM UTRUSTNING WHERE BENAMNING=" + "'" + benamning + "'";
            var utrustningsIdString = DatabaseAcces.getIdb().fetchSingle(sq);
            int utrustningsID = Integer.parseInt(utrustningsIdString);
            return utrustningsID;
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            return 0;
        }
    }

    @Override
    public void tilldelaAgentUtrustning(int utrustningsID, int agentID, String dagensDatum) {
        try
        {
            
            var sq = "INSERT INTO INNEHAR_UTRUSTNING(AGENT_ID, UTRUSTNINGS_ID, UTKVITTERINGSDATUM) VALUES (" + agentID + "," + utrustningsID + "," + "'" + dagensDatum + "'" + ")";
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        
    }

    @Override
    public int getMaxIDFromUtrustning() {
        try
        {
            var sq = "SELECT MAX(UTRUSTNINGS_ID) FROM UTRUSTNING";
            var maxid = Integer.parseInt(DatabaseAcces.getIdb().fetchSingle(sq));
            
            return maxid;
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            return 0;
        }
    }

    @Override
    public void registreraNyUtrustning(int id, String benamning) {
        try 
        {
            var sq = "INSERT INTO UTRUSTNING VALUES(" + id + "," + "'" + benamning + "'" + ")";
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        
    }

    @Override
    public void registreraUtrustningSomVapen(int id, int kaliber) {
        try
        {
            var sq = "INSERT INTO VAPEN VALUES(" + id + "," + kaliber + ")";
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void registreraUtrustningSomTeknik(int id, String kraftkalla) {
        try
        {
            var sq = "INSERT INTO TEKNIK VALUES(" + id + "," + "'" + kraftkalla + "'" + ")";
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void registreraUtrustningSomKommunikation(int id, String overforingsTeknik) {
        try
        {
            var sq = "INSERT INTO KOMMUNIKATION VALUES(" + id + "," + "'" + overforingsTeknik + "'" + ")";
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public String getOmradesChefGenomOmradesKontor(String omradeskontor) {
        try
        {
            var sq = "SELECT NAMN FROM AGENT WHERE AGENT_ID IN(SELECT AGENT_ID FROM OMRADESCHEF WHERE OMRADE IN(SELECT OMRADES_ID FROM OMRADE WHERE BENAMNING=" + "'" + omradeskontor + "'" + "))";
            var omradeschef = DatabaseAcces.getIdb().fetchSingle(sq);
            if(omradeschef != null)
            {
                return omradeschef;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Det finns ingen områdeschef i " + omradeskontor);
                return null;
            }
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            return null;
        }
    }

    @Override
    public ArrayList<Utrustning> getAllUtrustning() {
        try
        {
            var utrustningsLista = new ArrayList<Utrustning>();
            var sq = "SELECT * FROM UTRUSTNING";
            var resultat = DatabaseAcces.getIdb().fetchRows(sq);
            if(resultat != null)
            {
                for(HashMap<String, String> utrustning : resultat)
                {
                    int utrustningsID = Integer.parseInt(utrustning.get("UTRUSTNINGS_ID"));
                    String benamning = utrustning.get("BENAMNING");
                    
                    var utr = new Utrustning(utrustningsID, benamning);
                    utrustningsLista.add(utr);
                }
                return utrustningsLista;
            }
                
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            
        }
        return null;
    }

    @Override
    public ArrayList<Utrustning> getAllaVapen() {
        //Denna metod hämtar all utrustning vars id är referensnyckel i vapen-tabellen
        
        try
        {
            var vapenLista = new ArrayList<Utrustning>();
            var sq = "SELECT * FROM UTRUSTNING WHERE UTRUSTNINGS_ID IN (SELECT UTRUSTNINGS_ID FROM VAPEN)";
            var resultat = DatabaseAcces.getIdb().fetchRows(sq);
            if(resultat != null)
            {
                for(HashMap<String, String> vapen : resultat)
                {
                    int utrustningsid = Integer.parseInt(vapen.get("UTRUSTNINGS_ID"));
                    String benamning = vapen.get("BENAMNING");
                    
                    var utr = new Utrustning(utrustningsid, benamning);
                    vapenLista.add(utr);   
                }
                return vapenLista;
            }
            else
            {
                return null;
            }
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        return null;
                
    }

    @Override
    public ArrayList<Utrustning> getAllTeknik() {
        //Denna metod hämtar all utrustning vars id är referensnyckel i teknik-tabellen
        
        try
        {
            var teknikLista = new ArrayList<Utrustning>();
            var sq = "SELECT * FROM UTRUSTNING WHERE UTRUSTNINGS_ID IN (SELECT UTRUSTNINGS_ID FROM TEKNIK)";
            var resultat = DatabaseAcces.getIdb().fetchRows(sq);
            if(resultat != null)
            {
                for(HashMap<String, String> teknik : resultat)
                {
                    int utrustningsid = Integer.parseInt(teknik.get("UTRUSTNINGS_ID"));
                    String benamning = teknik.get("BENAMNING");
                    
                    var utr = new Utrustning(utrustningsid, benamning);
                    teknikLista.add(utr);   
                }
                return teknikLista;
            }
            else
            {
                return null;
            }
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        return null;
    }

    @Override
    public ArrayList<Utrustning> getAllKommunikation() {
        //Denna metod hämtar all utrustning vars id är referensnyckel i kommunikation-tabellen
        
        try
        {
            var kommunikationLista = new ArrayList<Utrustning>();
            var sq = "SELECT * FROM UTRUSTNING WHERE UTRUSTNINGS_ID IN (SELECT UTRUSTNINGS_ID FROM KOMMUNIKATION)";
            var resultat = DatabaseAcces.getIdb().fetchRows(sq);
            if(resultat != null)
            {
                for(HashMap<String, String> kommunikation : resultat)
                {
                    int utrustningsid = Integer.parseInt(kommunikation.get("UTRUSTNINGS_ID"));
                    String benamning = kommunikation.get("BENAMNING");
                    
                    var utr = new Utrustning(utrustningsid, benamning);
                    kommunikationLista.add(utr);   
                }
                return kommunikationLista;
            }
            else
            {
                return null;
            }
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        return null;
    }

    @Override
    public void raderaFromVapenTeknikOrKommunikation(int utrustningsid, String tabellNamn) {
        try
        {
           var sq = "DELETE FROM " + tabellNamn + " WHERE UTRUSTNINGS_ID=" + utrustningsid;
           DatabaseAcces.getIdb().delete(sq);
           
        }
        catch(InfException undantag)
        {
            System.out.println(undantag);
            JOptionPane.showMessageDialog(null, "Det gick inte att radera från " + tabellNamn);
        }
    }

    @Override
    public void raderaFromUtrustning(int id) {
        try
        {
            var sq = "DELETE FROM UTRUSTNING WHERE UTRUSTNINGS_ID=" + id;
            DatabaseAcces.getIdb().delete(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            JOptionPane.showMessageDialog(null, "Det gick inte att radera vald utrustning");
        }
    }

    @Override
    public String getPlatsNamnFromID(int id) {
        try
        {
            var sq = "SELECT BENAMNING FROM PLATS WHERE PLATS_ID=" + id;
            String benamning = DatabaseAcces.getIdb().fetchSingle(sq);
            if(benamning != null)
            {
                return benamning;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Kunde inte hämta benämning");
                return null;
                
            }
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            return null;
        }
        
    }

    

    
}