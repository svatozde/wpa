/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.back;

import cz.cvut.kbss.wpa.badminton.dto.PlayerDTO;
import cz.cvut.kbss.wpa.badminton.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author zdeněk
 */
@Component("signin")
@Scope("request")
public class SignInBean {
    
    @Autowired
    private IPlayerService pService;
    
    private PlayerDTO player = new PlayerDTO();

    /**
     * @return the playerDto
     */
    public PlayerDTO getPlayerDto() {
        return getPlayer();
    }

    /**
     * @param playerDto the playerDto to set
     */
    public void setPlayerDto(PlayerDTO playerDto) {
        this.setPlayer(playerDto);
    }

    /**
     * @return the player
     */
    public PlayerDTO getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }
    
    
}
