/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.dto;

import cz.cvut.kbss.wpa.dto.AbstractDTO;
import java.util.List;

/**
 *
 * @author zdeněk
 */
public class MatchDTO extends AbstractDTO{
    
    private PlayerDTO player1;
    
    private PlayerDTO player2;
    
    private List<SetDTO> sets;
    
    
    
}
