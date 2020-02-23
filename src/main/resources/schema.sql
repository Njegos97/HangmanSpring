create table if not exists Users(
	id bigint primary key auto_increment,
	username varchar(50) not null,
    email varchar(100) not null,
	password varchar(150) not null,
	enabled boolean not null
);

create table if not exists Authorities(
	username varchar(50) not null,
	authority varchar(50) not null
);

alter table Authorities 
	add foreign key (username) references Users(username);

create table if not exists Words(
id bigint primary key auto_increment,
name varchar(20) not null
);
