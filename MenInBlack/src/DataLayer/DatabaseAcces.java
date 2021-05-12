
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DatabaseAcces {
    
    private static InfDB idb;
    
    public static void Uppkoppling()
    {
        try
        {
            if(idb == null)
                idb = new InfDB("C:\\db\\BloggApplication\\drivrutin\\MIBDB.FDB");
        }
        catch(InfException undantaget)
        {
            System.out.println(undantaget.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte koppla till databas");
        }
    }
    
    public static InfDB getIdb()
    {
        return idb;
       
    }
}
