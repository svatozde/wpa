/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.LeagueDTO;

/**
 *
 * @author jan
 */
public interface ILeagueService {
    
    public LeagueDTO createLeague(LeagueDTO league);
    
}
