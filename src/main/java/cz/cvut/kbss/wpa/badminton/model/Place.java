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

/**
 *
 * @author zdeněk
 */
@Entity
public class Place extends AbstractEntity {
    
    @ManyToMany
    @JoinTable(name="posible_places")
    private List<League> leagues;
    
}
