/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.MatchDTO;
import cz.cvut.kbss.wpa.badminton.dto.PlayerDTO;
import cz.cvut.kbss.wpa.badminton.model.Player;
import cz.cvut.kbss.wpa.dao.GenericDAOIface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author zdeněk
 */
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    public GenericDAOIface genericDAOIface; 
    
    
    public void createPlayerDTO(PlayerDTO dto) {
       Player p = new Player();
       genericDAOIface.saveOrUpdate(p);
       
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
    
}
