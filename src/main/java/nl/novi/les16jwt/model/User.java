package nl.novi.les16jwt.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id // Lijkt er op dat @Id al standaard/impliciet nullable = false en unique is.
    @Column(nullable = false, unique = true) //  Expliciet
    private String username;

    @Column(name = "password") // De specificaties van de kolom aanpassen.
    private String password;

    // insert into users_roles(users_username, roles_rolename);
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles; // Zowel Role en User gebruiken Collection.


    // Wel alle Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
