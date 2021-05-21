/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meninblack;

import DataLayer.UserDB;
import Models.Agent;
import Models.Alien;
import Models.IAgent;
import Models.IAgentDAL;
import Models.IUser;
import Models.IUserDAL;


/**
 *
 * @author hp
 */
public class AppHantering implements IUser {
   
    private IUserDAL userdb;
    
    public AppHantering(IUserDAL userdb)
    {
        this.userdb = userdb;
        
    }
    
   

    @Override
    public Agent inloggAgent(String username, String password) {
        
        var user = userdb.kontrolleraInloggAgent(username, password);
        if(user != null)
        {
            return user;
        }
        else
        {
            return null;
        } 
        
     
    }

    @Override
    public Alien inloggAlien(String username, String password) {
        
         var user = userdb.kontrolleraInloggAlien(username, password);
        if(user != null)
        {
            return user;
        }
        else
        {
            return null;
        } 
    }

    @Override
    public void andraLosenForAlien(Alien alien, String nyttLosen) {
        userdb.kontrolleraLosenAlien(alien, nyttLosen);
        alien.setLosenord(nyttLosen);
        
        
        
    }

    @Override
    public void andraLosenForAgent(Agent agent, String nyttLosen) {
        userdb.kontrolleraLosenAgent(agent, nyttLosen);
        agent.setLosenord(nyttLosen);
    }

    @Override
    public Agent visaInfoOmradesChef(int id) {
       var chef = userdb.hamtaInfo(id);
       return chef;
    }

    

   

    
   
}
