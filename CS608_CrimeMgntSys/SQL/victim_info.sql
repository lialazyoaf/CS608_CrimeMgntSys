create table Crime_Record_Management.Victim_Info(
Victim_id varchar(20) not null,
First_name varchar(50) not null,
Last_name varchar(50) not null,
age int,
Nationality varchar(50) not null,
Address varchar(200) not null,
Phone_no varchar(20) not null,
Alternate_phone_no varchar(20) null,
Judge_id varchar(10) not null,
Court_id varchar(20) not null,
primary key(Victim_id),
foreign key(Judge_id) references Judge_Info(Judge_id),
foreign key(Court_id) references Court_Info(Court_id) 
);
