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
public interface IUser {
    
    public Agent inloggAgent(String username, String password);
    
    public Alien inloggAlien(String username, String password);
    
    public void andraLosenForAlien(Alien alien, String nyttLosen);
    
    public void andraLosenForAgent(Agent agent, String nyttLosen);
    
    public Agent visaInfoOmradesChef(int id);
    
}
