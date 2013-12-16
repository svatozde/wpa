/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.kbss.wpa.badminton.exception;

/**
 *
 * @author zdeněk
 */
public enum WPAExceptionCode {
    
    E00("Unknown");
    
   private String message;
   
   WPAExceptionCode(String message){
       this.message = message;
   }
}
