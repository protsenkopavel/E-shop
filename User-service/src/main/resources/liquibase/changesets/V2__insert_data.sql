insert into users (name, email, password, address)
values ('Pavel Protsenko', 'demo@mail.ru', '$2a$10$stxObPgS3GO5yMLWXuSGDuLtD7Iy2KxHTJcZdxzUqvq9.5qnF5nCy', 'demo address');

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER');