/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import Models.Agent;
import Models.Alien;
import Models.IUserDAL;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author hp
 */
public class UserDB implements IUserDAL {
    
   /* public Agent inlogg(String username, String password)
    {
      try
      { 
          var sq = "SELECT * FROM AGENT WHERE NAMN =" + "'" + username + "'" + "AND LOSENORD =" + "'" + password + "'";
          var resultat = DatabaseAcces.getIdb().fetchRow(sq);
          if(resultat != null)
          {
              int id = Integer.parseInt(resultat.get("ID"));
              String namn = resultat.get("NAMN");
              String losenord = resultat.get("LOSENORD");
              String telefon = resultat.get("TELEFON");
              String anstDatum = resultat.get("ANSTALLNINGSDATUM");
              String admin = resultat.get("ADMINISTRATOR");
              var omrade = resultat.get("OMRADE");
              
              var agent = new Agent(id, namn, telefon, anstDatum, admin, losenord);
                      
              return agent;
          }
          else
          {
              JOptionPane.showMessageDialog(null, "Du angav fel inlogg");
              return null;
          }
          
          
      }
      catch(InfException undantag)
      {
          
      }
      return null;
         
    } */
@Override
    public Agent kontrolleraInloggAgent(String username, String password) {
        try
      { 
          var sq = "SELECT * FROM AGENT WHERE NAMN =" + "'" + username + "'" + "AND LOSENORD =" + "'" + password + "'";
          var resultat = DatabaseAcces.getIdb().fetchRow(sq);
          if(resultat != null)
          {
              
              int id = Integer.parseInt(resultat.get("AGENT_ID"));
              String namn = resultat.get("NAMN");
              String losenord = resultat.get("LOSENORD");
              String telefon = resultat.get("TELEFON");
              String anstDatum = resultat.get("ANSTALLNINGSDATUM");
              String admin = resultat.get("ADMINISTRATOR");
              var omrade = Integer.parseInt(resultat.get("OMRADE"));
              
              var agent = new Agent(id, namn, telefon, anstDatum, admin, losenord, omrade);
                      
              return agent;
          }
          else
          {
              JOptionPane.showMessageDialog(null, "Du angav fel inlogg");
              return null;
          }
          
          
      }
      catch(InfException undantag)
      {
          System.out.println(undantag);
      }
      return null;
        
    }

    @Override
    public Alien kontrolleraInloggAlien(String username, String password) {
         try
      { 
          var sq = "SELECT * FROM ALIEN WHERE NAMN =" + "'" + username + "'" + "AND LOSENORD =" + "'" + password + "'";
          var resultat = DatabaseAcces.getIdb().fetchRow(sq);
          if(resultat != null)
          {
              int id = Integer.parseInt(resultat.get("ALIEN_ID"));
              String regDatum = resultat.get("REGISTRERINGSDATUM");
              String losenord = resultat.get("LOSENORD");
              String namn = resultat.get("NAMN");
              String telefon = resultat.get("TELEFON");
              var plats = Integer.parseInt(resultat.get("PLATS"));
              var ansvarigAgent = Integer.parseInt(resultat.get("ANSVARIG_AGENT"));
              
              var alien = new Alien(id, regDatum, losenord, namn, telefon, plats, ansvarigAgent);
                      
              return alien;
          }
          else
          {
              JOptionPane.showMessageDialog(null, "Du angav fel inlogg");
              return null;
          }
          
          
      }
      catch(InfException undantag)
      {
          System.out.println(undantag);
      }
      return null;
        
    }

    @Override
    public void kontrolleraLosenAlien(Alien alien, String nyttLosen) {
        
     try
     {
        String name = alien.getName();
        String currentPassword = alien.getLosenord();
        var sq = "UPDATE ALIEN SET LOSENORD= " + "'" + nyttLosen + "'" + "WHERE NAMN=" + "'" + name + "'";
        if(nyttLosen != currentPassword)
        {
            DatabaseAcces.getIdb().update(sq);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Du använder redan detta lösenord");
            return;
        }
        
    } 
     catch (InfException undantag)
    {
        JOptionPane.showMessageDialog(null, "Något gick felfel");
        System.out.println(undantag);
    }
     
    }

    @Override
    public void kontrolleraLosenAgent(Agent agent, String nyttLosen) {
        
        try
        { 
            String name = agent.getNamn();
            String currentPassword = agent.getLosenord();
        
            var sq = "UPDATE AGENT SET LOSENORD=" + "'" + nyttLosen + "'" + "WHERE NAMN=" + "'" + name + "'";
            if(nyttLosen != currentPassword)
            {
                DatabaseAcces.getIdb().update(sq);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Du använder redan detta lösenord");
                return;
            }
        }
        catch (InfException undantag)
        {
            JOptionPane.showMessageDialog(null, "Något gick felfel");
            System.out.println(undantag);
        }
        
    }

    @Override
    public Agent hamtaInfo(int platsID) {
      
        try
        {
            var sq = "SELECT * FROM AGENT WHERE AGENT_ID IN(SELECT OMRADESCHEF.AGENT_ID FROM OMRADESCHEF WHERE OMRADESCHEF.OMRADE IN(SELECT PLATS.FINNS_I FROM PLATS WHERE PLATS.PLATS_ID=" + platsID + "))";
            var resultat = DatabaseAcces.getIdb().fetchRow(sq);
            if(resultat != null)
            {
                int id = Integer.parseInt(resultat.get("AGENT_ID"));
                String namn = resultat.get("NAMN");
                String telefon = resultat.get("TELEFON");
                String anstDatum = resultat.get("ANSTALLNINGSDATUM");
                String admin = resultat.get("ADMINISTRATOR");
                String losenord = resultat.get("LOSENORD");
                var omrade = Integer.parseInt(resultat.get("OMRADE"));
                
                
                var agent = new Agent(id, namn, telefon, anstDatum, admin, losenord, omrade);
                return agent;
                
            }
            
        }  catch (InfException undantag)
        {
            System.out.println(undantag);
            JOptionPane.showMessageDialog(null, "Gick ej att hämta agent");
        }
       return null;
    }

    
           
}
