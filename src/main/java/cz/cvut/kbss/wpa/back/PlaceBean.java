/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.back;

import cz.cvut.kbss.wpa.badminton.dto.PlaceDTO;
import cz.cvut.kbss.wpa.badminton.service.IPlaceService;
import java.util.List;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author jan
 */
@Component("place")
@Scope("application")
public class PlaceBean {
    
    @Autowired
    protected IPlaceService placeService;
    
    protected List<SelectItem> places;
    
    public List<SelectItem> getAllPlaces()
    {
        for (PlaceDTO item : placeService.getAllPlaces())
        {
            this.places.add(new SelectItem(item, item.getName()));
        }
        return this.places;
    }
    
}
