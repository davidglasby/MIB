/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author hp
 */
public interface IUserDAL {
    
    public Agent kontrolleraInloggAgent(String username, String password);
    
    public Alien kontrolleraInloggAlien(String username, String password);
    
    public void kontrolleraLosenAlien (Alien alien, String nyttLosen);
    
    public void kontrolleraLosenAgent (Agent agent, String nyttLosen);
    
    public Agent hamtaInfo(int id);
}
