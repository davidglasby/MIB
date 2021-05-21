/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Models.Agent;
import Models.Alien;
import Models.IAlienDAL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author hp
 */
public class AlienDB implements IAlienDAL {

    @Override
    public int getMaxIDfromAlien() {
        try
        {
            var sq = "SELECT MAX(ALIEN_ID) FROM ALIEN";
            var maxid = DatabaseAcces.getIdb().fetchSingle(sq);
        
            
            return Integer.parseInt(maxid);
        } 
        
         catch (InfException undantag)
        {
            System.out.println(undantag);
            
        }
        return 0;
    }

    @Override
    public void SkapaAlien(int id, String regDatum, String losenord, String namn, String telefon, int plats, int ansvarigAgent) {
        try
        {
            var sq = "INSERT INTO ALIEN VALUES(" + id + "," + "'" + regDatum + "'" + "," + "'" + losenord + "'" + "," + "'" + namn + "'" + "," + "'" + telefon + "'" + "," + plats + "," + ansvarigAgent + ")"; 
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            
        }
    }

    @Override
    public ArrayList<Alien> getAllaAliens() {
          try
          {
            var allaAliens = new ArrayList<Alien>();
            var sq = "SELECT * FROM ALIEN";
            var aliens = DatabaseAcces.getIdb().fetchRows(sq);
            
               for(HashMap<String, String> alien : aliens)
               {
                    int id = Integer.parseInt(alien.get("ALIEN_ID"));
                    String regDatum = alien.get("REGISTRERINGSDATUM");
                    String losenord = alien.get("LOSENORD");
                    String namn = alien.get("NAMN");
                    String telefon = alien.get("TELEFON");
                    int plats = Integer.parseInt(alien.get("PLATS"));
                    int ansvarigAgent = Integer.parseInt(alien.get("ANSVARIG_AGENT"));
                    
                    var al = new Alien(id, regDatum, losenord, namn, telefon, plats, ansvarigAgent);
                    allaAliens.add(al);
               }
               return allaAliens;
           
            }
                catch (InfException undantag)
                {
                    System.out.println(undantag);
                }
                return null;
        }

    @Override
    public ArrayList<Alien> getAllaAliensFromPlats(int platsid) {
        
        try
        {
            var allaAliensFranPlats = new ArrayList<Alien>();
            var sq = "SELECT * FROM ALIEN WHERE PLATS=" + platsid;
            var aliens = DatabaseAcces.getIdb().fetchRows(sq);
            if(aliens != null)
            {
                for(HashMap<String, String> alien : aliens)
                {
                    int id = Integer.parseInt(alien.get("ALIEN_ID"));
                    String regDatum = alien.get("REGISTRERINGSDATUM");
                    String losenord = alien.get("LOSENORD");
                    String namn = alien.get("NAMN");
                    String telefon = alien.get("TELEFON");
                    int plats = Integer.parseInt(alien.get("PLATS"));
                    int ansvarigAgent = Integer.parseInt(alien.get("ANSVARIG_AGENT"));
                    
                    var al = new Alien(id, regDatum, losenord, namn, telefon, plats, ansvarigAgent);
                    allaAliensFranPlats.add(al);
                }
                    return allaAliensFranPlats;
            } else
            {
                JOptionPane.showMessageDialog(null, "Det finns inga aliens registrerade på denna plats");
            }
        } 
                catch (InfException undantag)
            {
                System.out.println(undantag);
            }
        return null;
    }

    @Override
    public void taBortAlien(String namn) {
        try
        {
            var sq = "DELETE FROM ALIEN WHERE NAMN=" + "'" + namn + "'";
            DatabaseAcces.getIdb().delete(sq);
        } catch (InfException undantag)
        {
            System.out.println(undantag);
            JOptionPane.showMessageDialog(null, "något gick fel i databasen, kunde ej radera Alien");
        }
    }

    

    

    @Override
    public ArrayList<Alien> getAllaAlienNamnFromRasTabell(String rasNamn) {
        
        try
        {
            var allaAliensFranPlats = new ArrayList<Alien>();
            var sq = "SELECT * FROM ALIEN WHERE ALIEN_ID IN(SELECT ALIEN_ID FROM " + rasNamn + ")";
            var aliens = DatabaseAcces.getIdb().fetchRows(sq);
            for(HashMap<String, String> alien : aliens)
                {
                    int id = Integer.parseInt(alien.get("ALIEN_ID"));
                    String regDatum = alien.get("REGISTRERINGSDATUM");
                    String losenord = alien.get("LOSENORD");
                    String namn = alien.get("NAMN");
                    String telefon = alien.get("TELEFON");
                    int plats = Integer.parseInt(alien.get("PLATS"));
                    int ansvarigAgent = Integer.parseInt(alien.get("ANSVARIG_AGENT"));
                    
                    var al = new Alien(id, regDatum, losenord, namn, telefon, plats, ansvarigAgent);
                    allaAliensFranPlats.add(al);
                }
            return allaAliensFranPlats;
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            return null;
        }
    }

    @Override
    public void registreraAlienSomBOGLODITE(int id, int boogies) {
        try
        {
           var sq = "INSERT INTO BOGLODITE VALUES(" + id + "," + boogies + ")";
           DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void registreraAlienSomSQUID(int id, int antalArmar) {
        try
        {
           var sq = "INSERT INTO SQUID VALUES(" + id + "," + antalArmar + ")";
           DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void registreraAlienSomWorm(int id) {
        try
        {
           var sq = "INSERT INTO BOGLODITE VALUES(" + id + ")";
           DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public Alien getAlienGenomNamn(String namn) {
        try
        {
            var sq = "SELECT * FROM ALIEN WHERE NAMN=" + "'" + namn + "'";
            var alien = DatabaseAcces.getIdb().fetchRow(sq);
            
            if(alien != null)
            {
                int id = Integer.parseInt(alien.get("ALIEN_ID"));
                String registreringsdatum = alien.get("REGISTRERINGSDATUM");
                String losenord = alien.get("LOSENORD");
                String alienNamn = alien.get("NAMN");
                String telefon = alien.get("TELEFON");
                int plats = Integer.parseInt(alien.get("PLATS"));
                int ansvarigAgent = Integer.parseInt(alien.get("ANSVARIG_AGENT"));
                
                var al = new Alien(id, registreringsdatum, losenord, alienNamn, telefon, plats, ansvarigAgent);
                return al;
            }
            
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            
        }
        return null;
    }

    @Override
    public void taBortAlienFromRasTabell(int id, String rastabell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
