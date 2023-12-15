package nl.novi.les16jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private String rolename;

    /*
    Robert-Jan:
    Ja dat zijn twee manieren. Als de relatie geen eigen velden heeft (zoals in ons voorbeeld
    Course - Teacher) dan gebruik je simpelweg @ManyToMany.
    Als relatie wel velden heeft, dan moet je die velden ergens kwijt en maak je dus een
    tussen-entiteit (met deze velden) die je via 2 @OneToMany's koppelt.
    */

    // insert into users_roles(users_username, roles_rolename);
    @ManyToMany(mappedBy = "roles") // mappedBy, zie: https://github.com/Aphelion-im/Les-13-uitwerking-opdracht-tech-it-easy-relations/blob/main/src/main/java/nl/novi/techiteasy1121/models/Television.java
    private Collection<User> users;

    // Setters
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}