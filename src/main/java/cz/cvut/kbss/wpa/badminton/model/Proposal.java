/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.model;

import cz.cvut.kbss.wpa.model.AbstractEntity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author zdeněk
 */
@Entity
public class Proposal extends AbstractEntity{
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date propDate;
}
