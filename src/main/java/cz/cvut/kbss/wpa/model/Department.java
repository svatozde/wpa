package cz.cvut.kbss.wpa.model;

import cz.cvut.kbss.wpa.dto.DepartmentDTO;
import java.util.List;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

@Entity
public class Department extends AbstractEntity {


    private String name;

    /**
     * Povsimnete si, u ktere relace je v tomto pripade umisten cizi klic
     */
    @OneToMany(mappedBy="department")
    private List<Teacher> members;
    
    public Department() {
    }
    
    public Department(DepartmentDTO dto) {
        super(dto.getId());
        this.name = dto.getName();
        
    }

    public String getName () {
        return name;
    }

    public void setName (String val) {
        this.name = val;
    }

    public List<Teacher> getMembers() {
        return members;
    }

    public void setMembers(List<Teacher> members) {
        this.members = members;
    }

}

