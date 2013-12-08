/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.MatchDTO;
import cz.cvut.kbss.wpa.badminton.dto.PlayerDTO;
import cz.cvut.kbss.wpa.badminton.model.Player;
import java.util.List;

/**
 *
 * @author zdeněk
 */
public class PlayerService extends UserService implements IPlayerService {    
    
    public void createPlayer(PlayerDTO dto) {
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
