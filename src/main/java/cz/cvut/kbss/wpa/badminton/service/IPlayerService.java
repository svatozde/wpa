/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.MatchDTO;
import cz.cvut.kbss.wpa.badminton.dto.PlayerDTO;
import java.util.List;

/**
 *
 * @author zdeněk
 */
public interface IPlayerService extends IUserService{
    
    public void createPlayer(PlayerDTO player);
    
    public PlayerDTO getPlayer(Long id);
    
    public List<PlayerDTO> getAllPlayers();
    
    public void enrollPlayerIntoLeague(Long playerId, Long leagueId);
    
    public List<MatchDTO> getPlayersMatches();
    
    
}
