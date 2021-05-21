/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hp
 */
public interface IAlien {
    
     public int getMaxIDfromAlien();
     
     public void SkapaAlien(int id, String regDatum, String losenord, String namn, String telefon, int plats, int ansvarigAgent);
     
     public ArrayList<Alien> getAllaAliens();
     
     public ArrayList<Alien> getAllaAliensFromPlats(int platsid);
     
     public void taBortAlien(String namn);
     
     public void taBortAlienFromRasTabell(int id, String rastabell);
     
     public ArrayList<Alien> getAllaAlienNamnFromRasTabell(String rasNamn);
     
     public void registreraAlienSomBOGLODITE(int id, int boogies);
     
     public void registreraAlienSomSQUID(int id, int antalArmar);
     
     public void registreraAlienSomWorm(int id);
     
     public Alien getAlienGenomNamn(String namn);
}
