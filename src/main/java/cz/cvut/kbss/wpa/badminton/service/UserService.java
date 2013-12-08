/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.UserDTO;
import cz.cvut.kbss.wpa.dao.GenericDAOIface;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jan
 */
public class UserService implements IUserService{
    
    @Autowired
    public GenericDAOIface genericDAOIface; 

    public void createUser(UserDTO user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
