select * 
from consumers 
;

create table consumers ( 
    id                             number not null constraint consumers_id_pk primary key, 
    c_email                        varchar2(255) not null, 
    c_pw                           varchar2(12) not null, 
    first_name                     varchar2(255) not null, 
    performer_id                   number 
) ;

create table hosts ( 
    id                             number not null constraint hosts_id_pk primary key, 
    first_name                     varchar2(255) not null, 
    h_email                        varchar2(255) not null, 
    h_pw                           varchar2(12) not null, 
    performer_id                   number 
) ;

create table performers ( 
    id                             number not null constraint performers_id_pk primary key, 
    band_name                      varchar2(255) not null, 
    p_email                        varchar2(255) not null, 
    p_pw                           varchar2(12) not null, 
    p_revenue                      integer, 
    date_available                 date 
) ;

create table venues ( 
    performer_id                   number 
                                   constraint venues_performer_id_fk 
                                   references performers on delete cascade, 
    id                             number not null constraint venues_id_pk primary key, 
    address                        varchar2(4000) not null, 
    capacity                       integer not null, 
    date_available                 date 
) ;

create table tickets ( 
    id                             number not null constraint tickets_id_pk primary key, 
    venue_id                       number 
                                   constraint tickets_venue_id_fk 
                                   references venues on delete cascade not null, 
    performer_id                   number 
                                   constraint tickets_performer_id_fk 
                                   references performers on delete cascade not null, 
    consumer_id                    number 
                                   constraint tickets_consumer_id_fk 
                                   references consumers on delete cascade, 
    the_date                       date not null, 
    price                          integer not null 
) ;

create table seating ( 
    ticket_id                      number 
                                   constraint seating_ticket_id_fk 
                                   references tickets on delete cascade not null, 
    id                             number not null constraint seating_id_pk primary key, 
    section                        integer 
) ;

create table friends ( 
    consumer_id                    number 
                                   constraint friends_consumer_id_fk 
                                   references consumers on delete cascade, 
    id                             number not null constraint friends_id_pk primary key 
) ;

create sequence consumers_seq;

create or replace trigger consumers_biu 
    before insert or update  
    on consumers 
    for each row 
begin 
    if :new.id is null then 
        :new.id := consumers_seq.nextval; 
    end if; 
end consumers_biu; 
/

create sequence hosts_seq;

create or replace trigger hosts_biu 
    before insert or update  
    on hosts 
    for each row 
begin 
    if :new.id is null then 
        :new.id := hosts_seq.nextval; 
    end if; 
end hosts_biu; 
/

create sequence performers_seq;

create or replace trigger performers_biu 
    before insert or update  
    on performers 
    for each row 
begin 
    if :new.id is null then 
        :new.id := performers_seq.nextval; 
    end if; 
end performers_biu; 
/

create sequence friends_seq;

create or replace trigger friends_biu 
    before insert or update  
    on friends 
    for each row 
begin 
    if :new.id is null then 
        :new.id := friends_seq.nextval; 
    end if; 
end friends_biu; 
/

create sequence seating_seq;

create or replace trigger seating_biu 
    before insert or update  
    on seating 
    for each row 
begin 
    if :new.id is null then 
        :new.id := seating_seq.nextval; 
    end if; 
end seating_biu; 
/

create sequence venues_seq;

create or replace trigger venues_biu 
    before insert or update  
    on venues 
    for each row 
begin 
    if :new.id is null then 
        :new.id := venues_seq.nextval; 
    end if; 
end venues_biu; 
/

create sequence tickets_seq;

create or replace trigger tickets_biu 
    before insert or update  
    on tickets 
    for each row 
begin 
    if :new.id is null then 
        :new.id := tickets_seq.nextval; 
    end if; 
end tickets_biu; 
/

create index friends_i1 on friends (consumer_id);

create index seating_i1 on seating (ticket_id);

create index tickets_i1 on tickets (consumer_id);

create index tickets_i2 on tickets (performer_id);

create index tickets_i3 on tickets (venue_id);

create index venues_i1 on venues (performer_id);

insert into consumers ( 
    id, 
    c_email, 
    c_pw, 
    first_name, 
    performer_id 
) values ( 
    1, 
    'gricelda.luebbers@aaab.com', 
    'In', 
    'Gricelda', 
    56 
);

insert into consumers ( 
    id, 
    c_email, 
    c_pw, 
    first_name, 
    performer_id 
) values ( 
    2, 
    'dean.bollich@aaac.com', 
    'Ex', 
    'Dean', 
    73 
);

insert into consumers ( 
    id, 
    c_email, 
    c_pw, 
    first_name, 
    performer_id 
) values ( 
    3, 
    'milo.manoni@aaad.com', 
    'Sit', 
    'Milo', 
    18 
);

insert into consumers ( 
    id, 
    c_email, 
    c_pw, 
    first_name, 
    performer_id 
) values ( 
    4, 
    'laurice.karl@aaae.com', 
    'Diam', 
    'Laurice', 
    78 
);

commit;

insert into hosts ( 
    id, 
    first_name, 
    h_email, 
    h_pw, 
    performer_id 
) values ( 
    1, 
    'Gricelda', 
    'gricelda.luebbers@aaab.com', 
    'Elementum', 
    71 
);

insert into hosts ( 
    id, 
    first_name, 
    h_email, 
    h_pw, 
    performer_id 
) values ( 
    2, 
    'Dean', 
    'dean.bollich@aaac.com', 
    'Mattis', 
    24 
);

insert into hosts ( 
    id, 
    first_name, 
    h_email, 
    h_pw, 
    performer_id 
) values ( 
    3, 
    'Milo', 
    'milo.manoni@aaad.com', 
    'Mattis', 
    100 
);

insert into hosts ( 
    id, 
    first_name, 
    h_email, 
    h_pw, 
    performer_id 
) values ( 
    4, 
    'Laurice', 
    'laurice.karl@aaae.com', 
    'Nonmolestie', 
    25 
);

commit;

insert into performers ( 
    id, 
    band_name, 
    p_email, 
    p_pw, 
    p_revenue, 
    date_available 
) values ( 
    1, 
    'Mac Prevention', 
    'gricelda.luebbers@aaab.com', 
    'Semper', 
    92, 
    sysdate - 76 
);

insert into performers ( 
    id, 
    band_name, 
    p_email, 
    p_pw, 
    p_revenue, 
    date_available 
) values ( 
    2, 
    'Personal Information Security Review', 
    'dean.bollich@aaac.com', 
    'Dictum', 
    47, 
    sysdate - 79 
);

insert into performers ( 
    id, 
    band_name, 
    p_email, 
    p_pw, 
    p_revenue, 
    date_available 
) values ( 
    3, 
    'Employee Automation', 
    'milo.manoni@aaad.com', 
    'Diam', 
    45, 
    sysdate - 30 
);

insert into performers ( 
    id, 
    band_name, 
    p_email, 
    p_pw, 
    p_revenue, 
    date_available 
) values ( 
    4, 
    'Deadlock Detection Review', 
    'laurice.karl@aaae.com', 
    'Lorem', 
    78, 
    sysdate - 55 
);

commit;

insert into venues ( 
    id, 
    performer_id, 
    address, 
    capacity, 
    date_available 
) values ( 
    1, 
    2, 
    '618 Mendota Heights Ave', 
    35, 
    sysdate - 83 
);

insert into venues ( 
    id, 
    performer_id, 
    address, 
    capacity, 
    date_available 
) values ( 
    2, 
    4, 
    '492 Nickerson Street', 
    59, 
    sysdate - 2 
);

insert into venues ( 
    id, 
    performer_id, 
    address, 
    capacity, 
    date_available 
) values ( 
    3, 
    3, 
    '538 Yardville Street', 
    9, 
    sysdate - 84 
);

insert into venues ( 
    id, 
    performer_id, 
    address, 
    capacity, 
    date_available 
) values ( 
    4, 
    3, 
    '553 Batavia Street', 
    37, 
    sysdate - 87 
);

commit;

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    1, 
    1, 
    sysdate - 58, 
    78, 
    4, 
    4 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    2, 
    2, 
    sysdate - 47, 
    56, 
    3, 
    1 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    3, 
    2, 
    sysdate - 91, 
    65, 
    4, 
    2 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    4, 
    4, 
    sysdate - 96, 
    65, 
    2, 
    3 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    5, 
    1, 
    sysdate - 18, 
    23, 
    3, 
    1 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    6, 
    1, 
    sysdate - 23, 
    64, 
    2, 
    1 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    7, 
    2, 
    sysdate - 12, 
    97, 
    2, 
    2 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    8, 
    3, 
    sysdate - 14, 
    17, 
    1, 
    4 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    9, 
    1, 
    sysdate - 60, 
    95, 
    2, 
    3 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    10, 
    1, 
    sysdate - 14, 
    59, 
    4, 
    1 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    11, 
    1, 
    sysdate - 39, 
    68, 
    1, 
    3 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    12, 
    1, 
    sysdate - 7, 
    45, 
    1, 
    3 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    13, 
    4, 
    sysdate - 71, 
    96, 
    1, 
    4 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    14, 
    2, 
    sysdate - 28, 
    14, 
    1, 
    4 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    15, 
    1, 
    sysdate - 59, 
    60, 
    2, 
    4 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    16, 
    4, 
    sysdate - 34, 
    80, 
    4, 
    1 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    17, 
    2, 
    sysdate - 20, 
    68, 
    4, 
    1 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    18, 
    2, 
    sysdate - 31, 
    28, 
    1, 
    2 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    19, 
    4, 
    sysdate - 7, 
    9, 
    2, 
    3 
);

insert into tickets ( 
    id, 
    venue_id, 
    the_date, 
    price, 
    performer_id, 
    consumer_id 
) values ( 
    20, 
    2, 
    sysdate - 26, 
    49, 
    2, 
    2 
);

commit;

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    1, 
    5, 
    62 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    2, 
    4, 
    16 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    3, 
    13, 
    1 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    4, 
    2, 
    57 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    5, 
    11, 
    65 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    6, 
    18, 
    70 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    7, 
    11, 
    73 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    8, 
    18, 
    44 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    9, 
    18, 
    63 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    10, 
    7, 
    82 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    11, 
    6, 
    25 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    12, 
    1, 
    35 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    13, 
    15, 
    40 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    14, 
    19, 
    11 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    15, 
    7, 
    86 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    16, 
    5, 
    97 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    17, 
    5, 
    64 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    18, 
    8, 
    64 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    19, 
    4, 
    30 
);

insert into seating ( 
    id, 
    ticket_id, 
    section 
) values ( 
    20, 
    3, 
    86 
);

commit;

insert into friends ( 
    id, 
    consumer_id 
) values ( 
    1, 
    2 
);

insert into friends ( 
    id, 
    consumer_id 
) values ( 
    2, 
    4 
);

commit;

select * 
from consumers;

select * 
from hosts;

select * 
from venue;

select * 
from venues;

select * 
from tickets;

