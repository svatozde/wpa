/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.PlaceDTO;
import java.util.List;

/**
 *
 * @author jan
 */
public interface IPlaceService {
    
    public PlaceDTO createPlace(PlaceDTO place);
    
    public List<PlaceDTO> getAllPlaces();
    
}
