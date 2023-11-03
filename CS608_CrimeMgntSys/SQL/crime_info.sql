create table Crime_Record_Management.Crime_Info(
Crime_id varchar(20) not null,
Crime_type varchar(100) not null,
Weapon_used varchar(200) null,
Crime_date date not null,
Crime_time timestamp not null,
crime_location varchar(200) not null,
Criminal_id varchar(10) not null,
Victim_id varchar(10) not null,
primary key(Crime_id),
foreign key(Criminal_id) references offender_Info(Criminal_id),
foreign key(Victim_id) references offender_Info(Victim_id)
);