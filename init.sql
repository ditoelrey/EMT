create table users (
                       username varchar(255) primary key,
                       password varchar(255),
                       name varchar(255),
                       surname varchar(255),
                       is_account_non_expired boolean default true,
                       is_account_non_locked boolean default true,
                       is_credentials_non_expired boolean default true,
                       is_enabled boolean default true,
                       role varchar(50)
);

create table country (
                         id bigserial primary key,
                         name varchar(255),
                         continent varchar(255)
);

create table guest (
                       id bigserial primary key,
                       name varchar(255),
                       surname varchar(255),
                       country_id bigint references country
);

create table host (
                      id bigserial primary key,
                      name varchar(255),
                      surname varchar(255),
                      country_id bigint references country
);

create table host_guests (
                             guest_id bigint references guest on delete cascade,
                             host_id bigint references host on delete cascade,
                             primary key (guest_id, host_id)
);

create table accommodation (
                               id bigserial primary key,
                               name varchar(255),
                               num_rooms integer,
                               host_id bigint references host,
                               category varchar(50),
                               rented boolean default false
);

create table reservation (
                             id bigserial primary key,
                             user_username varchar(255) references users,
                             accommodation_id bigint references accommodation,
                             confirmed boolean
);