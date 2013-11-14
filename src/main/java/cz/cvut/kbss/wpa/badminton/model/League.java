/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.model;

import cz.cvut.kbss.wpa.model.AbstractEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author zdeněk
 */
@Entity
public class League extends AbstractEntity {
    
    @OneToMany(mappedBy="league")
    private List<Match> matches;
    
    @ManyToMany
    @JoinTable(name="posible_places")
    private List<Place> places;
    
    @OneToMany(mappedBy = "league")
    private List<Enroll> enrolls;

    /**
     * @return the matches
     */
    public List<Match> getMatches() {
        return matches;
    }

    /**
     * @param matches the matches to set
     */
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    /**
     * @return the places
     */
    public List<Place> getPlaces() {
        return places;
    }

    /**
     * @param places the places to set
     */
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    /**
     * @return the enrolls
     */
    public List<Enroll> getEnrolls() {
        return enrolls;
    }

    /**
     * @param enrolls the enrolls to set
     */
    public void setEnrolls(List<Enroll> enrolls) {
        this.enrolls = enrolls;
    }
    
}
