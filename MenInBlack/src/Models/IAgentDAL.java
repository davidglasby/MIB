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
public interface IAgentDAL {
    
    public void registreraAgent(int id, String namn, String telefon, String anstDatum, String admin, String losenord, int omrade);
    
    public int getMaxAgentID();
    
    public ArrayList<Agent> getAllaAgenter();
    
    public String getAgentNamn();
    
    public String getIDfromNamn(String namn);
    
    public String getNamnFromID(int id);
    
    public void RaderaAgent(String namn);
    
    public void GorAgentTillAdmin(String namn);
    
    public String getAdminStatusFromNamn(String namn);
    
    public void registreraFaltAgent(int id);
    
     public void taBortAgentIDFranUtrustning(int id);
    
    public void taBortAgentIDFranFordon(int id);
    
    public void taBortAgentIDFranFaltAgent(int id);
}
