package nl.novi.les16jwt.dto;

public class UserDto {
    public String username;

    public String password;

    public String[] roles;
}

/* Postman:
{
    "username": "Admin",
    "password": "password",
    "roles": [
        "USER",
        "ADMIN"
    ]
}
*/

