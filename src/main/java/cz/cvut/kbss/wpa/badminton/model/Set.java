/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.model;

import cz.cvut.kbss.wpa.model.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author zdeněk
 */
@Entity
public class Set extends AbstractEntity {
   
 
    @ManyToOne
    private Note note;
    
    
    
    private int score;

   

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

 
    
}
