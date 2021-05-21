/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meninblack;

import Models.Agent;
import Models.IAgent;
import Models.IAgentDAL;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class AgentHantering implements IAgent {

    private IAgentDAL agentdb;
    
    public AgentHantering(IAgentDAL agentdb)
    {
        this.agentdb = agentdb;
    }
    
    @Override
    public void skapaAgent(int id, String namn, String telefon, String anstDatum, String admin, String losenord, int omrade) {
       
        agentdb.registreraAgent(id, namn, telefon, anstDatum, admin, losenord, omrade);
        
    }

    @Override
    public ArrayList<Agent> getAllaAgenter() {
        var agentLista = agentdb.getAllaAgenter();
        return agentLista;
    }

    @Override
    public int getMaxAgentID() {
        
        var maxID = agentdb.getMaxAgentID();
        return maxID + 1;
        
    }

    @Override
    public String getIDfromNamn(String namn) {
       String id = agentdb.getIDfromNamn(namn);
       return id;
    }

    @Override
    public void RaderaAgent(String namn) {
        agentdb.RaderaAgent(namn);
    }

    @Override
    public void GorAgentTillAdmin(String namn) {
        
        agentdb.GorAgentTillAdmin(namn);
    }

    @Override
    public String getAdminStatusFromNamn(String namn) {
        var adminstatus = agentdb.getAdminStatusFromNamn(namn);
        return adminstatus;
    }

    @Override
    public void registreraFaltAgent(int id) {
        agentdb.registreraFaltAgent(id);
    }

    @Override
    public void taBortAgentIDFranUtrustning(int id) {
        agentdb.taBortAgentIDFranUtrustning(id);
    }

    @Override
    public void taBortAgentIDFranFordon(int id) {
        agentdb.taBortAgentIDFranFordon(id);
    }

    @Override
    public void taBortAgentIDFranFaltAgent(int id) {
        agentdb.taBortAgentIDFranFaltAgent(id);
    }

    @Override
    public String getNamnFromID(int id) {
       String namn = agentdb.getNamnFromID(id);
       if(namn != null)
       {
           return namn;
       }
       else
       {
           return null;
       }
    }
    
}
