package nl.novi.les16jwt.controller;

import nl.novi.les16jwt.dto.UserDto;
import nl.novi.les16jwt.model.Role;
import nl.novi.les16jwt.model.User;
import nl.novi.les16jwt.repository.RoleRepository;
import nl.novi.les16jwt.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepos;
    private final RoleRepository roleRepos;
    private final PasswordEncoder encoder;

    public UserController(UserRepository userRepos, RoleRepository roleRepos, PasswordEncoder encoder) {
        this.userRepos = userRepos;
        this.roleRepos = roleRepos;
        this.encoder = encoder;
    }

    // Les 16 (2023/02) video@2h34m:
    // Deze method geeft in Postman een (encrypted) password terug: Dat is niet de bedoeling!
    // Daarom opsplitsen in een UserInputDto en een UserOutputDto.
    // In UserOutputDto laat je dan het password weg.
    // RJ komt over dat voor de eindopdracht er niet heel streng naar gekeken gaat worden door de examinator, maar het is beter van wel
    @GetMapping("/users")
    public List getUsers() {
        Iterable<User> users = userRepos.findAll();
        List<User> userList = new ArrayList<>();

        for(User user : users) {
            userList.add(user);
        }
        return userList;
    }



    // Moet hier een URI uri?: Ja, Garage heeft dat ook
    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.username);
        newUser.setPassword(encoder.encode(userDto.password));

        List<Role> userRoles = new ArrayList<>();
        for (String rolename : userDto.roles) {
            Optional<Role> or = roleRepos.findById("ROLE_" + rolename);

            userRoles.add(or.get());
        }
        newUser.setRoles(userRoles);

        userRepos.save(newUser);

        return "Done";
    }
}
