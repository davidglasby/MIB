/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meninblack;

import Models.Alien;
import Models.IAlien;
import Models.IAlienDAL;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class AlienHantering implements IAlien {
    
    private IAlienDAL aliendb;
    
    public AlienHantering(IAlienDAL aliendb)
    {
        this.aliendb = aliendb;
    }

    @Override
    public int getMaxIDfromAlien() {
         var maxid = aliendb.getMaxIDfromAlien();
         return maxid + 1;
    }

    @Override
    public void SkapaAlien(int id, String regDatum, String losenord, String namn, String telefon, int plats, int ansvarigAgent) {
        
        aliendb.SkapaAlien(id, regDatum, losenord, namn, telefon, plats, ansvarigAgent);
        
    }

    @Override
    public ArrayList<Alien> getAllaAliens() {
        var allaAliens = aliendb.getAllaAliens();
        return allaAliens;
    }

    @Override
    public ArrayList<Alien> getAllaAliensFromPlats(int platsid) {
        var aliensAvVissPlats = aliendb.getAllaAliensFromPlats(platsid);
        return aliensAvVissPlats;
    }

    @Override
    public void taBortAlien(String namn) {
        aliendb.taBortAlien(namn);
        
    }


    @Override
    public ArrayList getAllaAlienNamnFromRasTabell(String rasNamn) {
        var alienNamn = aliendb.getAllaAlienNamnFromRasTabell(rasNamn);
        return alienNamn;
    }

    @Override
    public void registreraAlienSomBOGLODITE(int id, int boogies) {
        aliendb.registreraAlienSomBOGLODITE(id, boogies);
    }

    @Override
    public void registreraAlienSomSQUID(int id, int antalArmar) {
        aliendb.registreraAlienSomSQUID(id, antalArmar);
    }

    @Override
    public void registreraAlienSomWorm(int id) {
        aliendb.registreraAlienSomWorm(id);
    }

    @Override
    public void taBortAlienFromRasTabell(int id, String rastabell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alien getAlienGenomNamn(String namn) {
        var alien = aliendb.getAlienGenomNamn(namn);
        if(alien != null)
        {
            return alien;
        }
        else
        {
            return null;
        }
    }
    
     
}
