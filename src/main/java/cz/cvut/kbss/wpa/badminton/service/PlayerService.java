/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.MatchDTO;
import cz.cvut.kbss.wpa.badminton.dto.PlayerDTO;
import cz.cvut.kbss.wpa.badminton.model.Player;
import cz.cvut.kbss.wpa.badminton.model.User;
import cz.cvut.kbss.wpa.provider.HashProvider;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zdeněk
 */
@Service("schoolCenter")
public class PlayerService extends AbstractService implements IPlayerService, Serializable {    
    
    @Autowired
    private HashProvider hashProvider;
    
    
    public void createPlayer(PlayerDTO dto){
       Player p = new Player();
       p.setDateOfBirth(dto.getDateOfBirth());
       p.setHeight(dto.getHeight());
       p.setName(dto.getName());
       p.setUsername(dto.getUsername());
       p.setSurname(dto.getSurname());
       p.setPassword(dto.getPassword());
       genericDAO.saveOrUpdate(p);
    }

    public PlayerDTO getPlayer(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    public List<PlayerDTO> getAllPlayers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void enrollPlayerIntoLeague(Long playerId, Long leagueId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<MatchDTO> getPlayersMatches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    public boolean checkName(String name) {
         User u = genericDAO.getByPropertyUnique("name", name, User.class);
        return u == null;
    }
    
    
    
    
    
}
