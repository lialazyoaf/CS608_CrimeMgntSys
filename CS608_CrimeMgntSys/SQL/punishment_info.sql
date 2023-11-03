create table Crime_Record_Management.Punishment_Info(
punishment_id varchar(10) not null,
From_date date not null,
From_time timestamp not null,
To_date date not null,
To_time timestamp not null,
Total_duration varchar(50) not null,
Type_punishment varchar(200) not null,
Punishment_des varchar(200) null,
Punishment_inc varchar(20) not null,
Reason_punishment_inc varchar(250) null,
Criminal_id varchar(10) not null,
Prison_id varchar(20) not null,
Judge_id varchar(10) not null,
Crime_id varchar(20) not null,
primary key(punishment_id),
foreign key(Criminal_id) references offender_Info(Criminal_id),
foreign key(Prison_id) references Prison_Info(Prison_id),
foreign key(Judge_id) references Judge_Info(Judge_id),
foreign key(Crime_id) references Crime_Info(Crime_id) 
);

select* from Crime_Record_Management.Punishment_Info