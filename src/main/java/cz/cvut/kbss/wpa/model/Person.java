package cz.cvut.kbss.wpa.model;

import cz.cvut.kbss.wpa.dto.PersonDTO;
import cz.cvut.kbss.wpa.model.AbstractEntity;
import cz.cvut.kbss.wpa.provider.HashProvider;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorOptions(force=true)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.STRING,name="groupname", length=20)
@DiscriminatorValue(value="person")
@Configurable(preConstruction=true) // Trida bude instrumentovana a bude mozne do ni injektovat (preconstruction zajisti, ze injektovane property budou pouzitelne jiz v konstruktoru)
public class Person extends AbstractEntity {
    
    private long birthNumber;
    
    @Basic(optional=false)
    private String firstName;

    private String surname;

    // anotace Column je volitelna
    @Column(length=40, nullable=false)
    private String password;
    
    //@Column(length=40, nullable=false)
    //private String salt;
    
    @Column(nullable=false, unique=true)
    private String username;
    
    @Autowired
    private transient HashProvider provider;
    
    
    public Person () {
    }
    
    public Person(Long id, String username, String firstName, String surname, String password) {
        super(id);
        //this.salt = provider.computeHash(System.currentTimeMillis() + "");
        setPassword(password);
        this.username = username;
        this.firstName = firstName;
        this.surname = surname;
    }

    public Person(PersonDTO dto, String password){
        this(dto.getId(), dto.getUsername(), dto.getFirstName(), dto.getSurname(), password);
    }
    

    public long getBirthNumber () {
        return birthNumber;
    }

    public void setBirthNumber (long val) {
        this.birthNumber = val;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String val) {
        this.firstName = val;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String val) {
        this.surname = val;
    }

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        //this.password = provider.computeHash(password + salt + "140f719caed134b571a857d72c5ca251072e7c3b");
        if (password == null) {return;}
        this.password = provider.computeHash(password);
    }

    /*public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
}

