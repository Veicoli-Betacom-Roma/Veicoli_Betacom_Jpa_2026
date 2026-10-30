
    set client_min_messages = WARNING;

    alter table if exists bici 
       drop constraint if exists FKra4pq79y6t94qnygjmhto1d2f;

    alter table if exists macchina 
       drop constraint if exists FKlinll7qwn6u0njwsg3l9la5ue;

    alter table if exists moto 
       drop constraint if exists FKt01inn1jct6p6irfuar0pt15d;

    alter table if exists veicoli 
       drop constraint if exists FKco4oqnepc21ccscsq9b74l65k;

    alter table if exists veicoli 
       drop constraint if exists FKnww9rxyy22j7xcrwqpp8l3d00;

    alter table if exists veicoli 
       drop constraint if exists FKaqvw30msi0rmronc8rcj6wsdr;

    drop table if exists alimentazione cascade;

    drop table if exists bici cascade;

    drop table if exists categoria cascade;

    drop table if exists colore cascade;

    drop table if exists macchina cascade;

    drop table if exists moto cascade;

    drop table if exists veicoli cascade;
