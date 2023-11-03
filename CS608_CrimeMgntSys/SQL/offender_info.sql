-- create database Crime_Record_Management;

/*create table Crime_Record_Management.Offender_Info(
Criminal_id varchar(10) not null,
First_name varchar(20) not null,
Last_name varchar(20) null,
Gender varchar(20) not null,
Age varchar(20) not null,
Nationality varchar(50) not null,
Address varchar(200) not null,
Phone_no varchar(20) not null,
Alternate_phone_no varchar(20) null,
Offense_type varchar(200) not null,
Bail_status varchar(20) not null,
Jail_terms varchar(50) not null,
Prison_location varchar(50) not null,
Prison_guard varchar(50) not null,
Victim_id varchar(20) not null,
Judge_id varchar(10) not null,
Court_id varchar(20) not null,
primary key(Criminal_id),
foreign key(Victim_id) references Victim_Info(Victim_id),
foreign key(Judge_id) references Judge_Info(Judge_id),
foreign key(Court_id) references Court_Info(Court_id) 
);*/

select* from Crime_Record_Management.Offender_Info;

-- drop table Crime_Record_Management.Offender_Info;