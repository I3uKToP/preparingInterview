CREATE TABLE film
(
    id       serial primary key,
    name     varchar(255) not null, -- название
    duration int          not null  -- длительность
);

CREATE TABLE ticket
(
    ticket_id serial primary key,
    cost      varchar(255) not null,      -- стоимость
    id_film   integer,-- айди фильма
    FOREIGN KEY (id_film) REFERENCES film (Id)
);


CREATE TABLE session
(
    id      serial primary key,
    time    time,                             -- время начала
    id_film int not null references film (id) -- какой фильм
);

insert into film (name, duration) values ('Гарри Поттер', 120);
insert into film (name, duration) values ('Властелин колец', 120);
insert into film (name, duration) values ('Иван Васильевич меняет профессию', 90);
insert into film (name, duration) values ('С легким паром', 90);
insert into film (name, duration) values ('Операция Ы', 60);


insert into session (time, id_film) values ('10:00:00', 1);
insert into session (time, id_film) values ('11:00:00', 3);
insert into session (time, id_film) values ('15:00:00', 5);


insert into ticket (cost, id_film) VALUES (100, 1);
insert into ticket (cost, id_film) VALUES (120, 3);
insert into ticket (cost, id_film) VALUES (150, 5);


with intervals as(
    select session.id_film,
           session.id,
           film.name,
           session.time,
           date_add(session.time, interval film.duration MINUTE) as end_time
    from session
    inner join film f on session.id_film = f.id
)
select I1.session_id, I2.session_id,
       I1.name, I1.time, I1.end_time,
       I2.name, I2time, I2.end_time
from intervals I1
    inner join intervals I2 on I1.time <I2.time and
                               I1.end_time >I2.time and
                               I1.session_id <> I2.session_id and
                               I1.session_id < I2.session_id;

with intervals as(
    select session.id_film,
           session.id,
           film.name,
           session.time,
           date_add(session.time, interval film.duration MINUTE) as end_time
    from session
             inner join film f on session.id_film = f.id
)
select I1.name, I1.time, I1.end_time,
       I2.name, I2.time, I2.end_time,
       (I1.start - I2.end_time) as duration
from intervals I1
inner join intervals I2 on I1.end_time <I2.time;
