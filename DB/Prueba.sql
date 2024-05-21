create database Prueba;
use Prueba;

create table Persona(
	id int not null,
    nombre varchar(20) not null,
    paterno varchar(20) not null,
    materno varchar(20) not null,
    fecha_nacimiento date not null,
	numero_celular numeric(8,0) not null,
    primary key (id)
);

insert into Persona (id,nombre,paterno,materno,fecha_nacimiento,numero_celular) 
values(8343043,"Jaime Ignacio","Huaycho","Clavel","2005-04-16",64177602);

update Persona set fecha_nacimiento="2005-04-16" where id=8343043;

delete from Persona where id=8343043;

select * from Persona;