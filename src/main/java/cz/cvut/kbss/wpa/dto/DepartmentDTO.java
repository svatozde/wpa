/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.dto;

/**
 *
 * @author marek
 */
public class DepartmentDTO extends AbstractDTO {
    
    private String name;

    public DepartmentDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
