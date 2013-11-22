/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.model;

import cz.cvut.kbss.wpa.model.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author zdeněk
 */
@Entity
public class Proposal extends AbstractEntity{
    
    @ManyToOne
    private Place place;
    
    @ManyToOne
    private Match match;
    
    @ManyToOne        
    private Player player;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date propDate;

    /**
     * @return the place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * @return the match
     */
    public Match getMatch() {
        return match;
    }

    /**
     * @param match the match to set
     */
    public void setMatch(Match match) {
        this.match = match;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the propDate
     */
    public Date getPropDate() {
        return propDate;
    }

    /**
     * @param propDate the propDate to set
     */
    public void setPropDate(Date propDate) {
        this.propDate = propDate;
    }
}
