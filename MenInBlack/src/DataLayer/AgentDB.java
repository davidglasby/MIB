/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Models.Agent;
import Models.IAgentDAL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author hp
 */
public class AgentDB implements IAgentDAL{

    @Override
    public void registreraAgent(int id, String namn, String telefon, String dagensDatum, String admin, String losenord, int omrade) {
        
        try
        {
            
            
            var sq = "INSERT INTO AGENT VALUES(" + id + "," + "'" + namn + "'" + "," + "'" + telefon + "'" + "," + "'" + dagensDatum + "'" + "," + "'" + admin + "'" + "," + "'" + losenord + "'" + "," + omrade + ")"; 
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
            
        }
    }
    
    

    @Override
    public int getMaxAgentID() {
        try
        {
            var sq = "SELECT MAX(AGENT_ID) FROM AGENT";
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
    public ArrayList<Agent> getAllaAgenter() {
        
       try
       {
            var allaAgenter = new ArrayList<Agent>();
            var sq = "SELECT * FROM AGENT";
            var agenter = DatabaseAcces.getIdb().fetchRows(sq);
           
               for(HashMap<String, String> agent : agenter)
               {
                    int id = Integer.parseInt(agent.get("AGENT_ID"));
                    String namn = agent.get("NAMN");
                    String losenord = agent.get("LOSENORD");
                    String telefon = agent.get("TELEFON");
                    String anstDatum = agent.get("ANSTALLNINGSDATUM");
                    String admin = agent.get("ADMINISTRATOR");
                    var omrade = Integer.parseInt(agent.get("OMRADE"));
                    
                    var ag = new Agent(id, namn, telefon, anstDatum, admin, losenord, omrade);
                    allaAgenter.add(ag);
               }
               return allaAgenter;
                   
            
       }
       catch (InfException undantag)
       {
           System.out.println(undantag);
       }
        return null;
    }

    @Override
    public String getAgentNamn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIDfromNamn(String namn) {
        try
       {
            var sq = "SELECT AGENT_ID FROM AGENT WHERE NAMN=" +"'" + namn + "'";
            var agentIdString = DatabaseAcces.getIdb().fetchSingle(sq);
             
            return agentIdString;
       }
       
       catch (InfException undantag)
       {
           System.out.println(undantag);
       }
       return null;
    }

    @Override
    public void RaderaAgent(String namn) {
        try
        {
           
            var sq = "DELETE FROM AGENT WHERE NAMN=" + "'" + namn + "'";
            DatabaseAcces.getIdb().delete(sq);
        } catch (InfException undantag)
        {
            System.out.println(undantag);
            JOptionPane.showMessageDialog(null, "något gick fel i databasen, kunde ej radera agent");
        }
    }

    @Override
    public void GorAgentTillAdmin(String namn) {
        
        try
        {
            String isadmin = "J";
            var sq1 = "SELECT ADMINISTRATOR FROM AGENT WHERE NAMN=" +"'" + namn + "'";
            var result = DatabaseAcces.getIdb().fetchSingle(sq1);
            if (result.equals(isadmin))
            {
                JOptionPane.showMessageDialog(null, namn + " har redan administratörsstatus");
            }
            else
            {
                var sq2 = "UPDATE AGENT SET ADMINISTRATOR='J' WHERE NAMN=" + "'" + namn + "'";
                DatabaseAcces.getIdb().update(sq2);
            }
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public String getAdminStatusFromNamn(String namn) {
        
        try
        {
            var sq = "SELECT ADMINISTRATOR FROM AGENT WHERE NAMN=" + "'" + namn + "'";
            var adminstatus = DatabaseAcces.getIdb().fetchSingle(sq);
            return adminstatus;
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        return null;
    }

    @Override
    public void registreraFaltAgent(int id) {
        try
        {
            var sq = "INSERT INTO FALTAGENT(AGENT_ID) VALUES(" + id + ")";
            DatabaseAcces.getIdb().insert(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void taBortAgentIDFranUtrustning(int id) {
        
        try
        {
            var sq = "DELETE FROM INNEHAR_UTRUSTNING WHERE AGENT_ID=" + id;
            DatabaseAcces.getIdb().delete(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void taBortAgentIDFranFordon(int id) {
        
        try
        {
            var sq = "DELETE FROM INNEHAR_FORDON WHERE AGENT_ID=" + id;
            DatabaseAcces.getIdb().delete(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
    }

    @Override
    public void taBortAgentIDFranFaltAgent(int id) {
        try
        {
            var sq = "DELETE FROM FALTAGENT WHERE AGENT_ID=" + id;
            DatabaseAcces.getIdb().delete(sq);
        }
        catch (InfException undantag)
        {
            System.out.println(undantag);
        }
        
    }

    @Override
    public String getNamnFromID(int id) {
        try
        {
            var sq = "SELECT NAMN FROM AGENT WHERE AGENT_ID =" + id;
            String namn = DatabaseAcces.getIdb().fetchSingle(sq);
            if(namn != null)
            {
                return namn;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Det gick ej att hämta agentens namn");
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
