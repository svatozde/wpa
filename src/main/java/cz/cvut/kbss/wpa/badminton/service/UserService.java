/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.service;

import cz.cvut.kbss.wpa.badminton.dto.UserDTO;
import cz.cvut.kbss.wpa.badminton.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author jan
 */
@Service("userService")
public class UserService extends AbstractService implements IUserService{

    public void createUser(UserDTO user) {
        User u = new User();
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
        genericDAO.saveOrUpdate(u);
    }
    
    
    public boolean checkUsername(String name){
        User u = genericDAO.getByPropertyUnique("name", name, User.class);
        return u == null;
    }
    
}
