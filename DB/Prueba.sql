create database Prueba;
use Prueba;

create table Usuario(
	id_usuario numeric(10,0) not null,
    nombre varchar(20) not null,
    apellido varchar(20) not null,
    edad int not null,
    primary key(id_usuario)
);

select * from Usuario;
insert into Usuario (id_usuario,nombre,apellido,edad) 
values (8343043,"jaime","huaycho",19);