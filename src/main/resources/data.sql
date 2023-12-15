insert into roles(rolename)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

-- Login: Andre/password
--@Table(name="users")
-- Dummy data password encrypten via Postman
insert into users(username, password)
values ('Andre', '$2a$10$7ymopcO8xirFr0/A7jq/GuhcgfTfWwxfKFHe4D2w4mfQANs5KN2W2');

-- Wel nieuwe Bearer token invoeren!
-- User & Role: many-to-many
insert into users_roles(users_username, roles_rolename)
values ('Andre', 'ROLE_ADMIN'),
       ('Andre', 'ROLE_USER');