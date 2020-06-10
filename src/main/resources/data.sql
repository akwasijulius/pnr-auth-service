insert into User (userName, password, role, enabled)
values ('user', 'password', 'ROLE_USER', true);

insert into User (userName, password, role, enabled)
values ('admin', 'password', 'ROLE_ADMIN', true);

/*
insert into authorities (username, authority)
    values('user', 'ROLE_USER');

insert into authorities (username, authority)
    values('admin', 'ROLE_ADMIN');
*/
