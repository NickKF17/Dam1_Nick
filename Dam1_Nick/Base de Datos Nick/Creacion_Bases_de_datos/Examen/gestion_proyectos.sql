Drop database if exists gestion_proyectos;
Create Database gestion_proyectos;
use gestion_proyectos;

Create table profesores(
id_profesor tinyint auto_increment,
dni char(9) unique not null,
nombre varchar(30) not null,
email varchar(50) unique not null,
especialidades Enum('REDES','SEGURIDAD','BBDD','SISTEMAS','HARDWARE') not null,
id_supervisor tinyint ,

constraint pk_profesores primary key(id_profesor),
constraint chk_dni check (char_length(dni)=9),
constraint chk_email check(email like '%@%'),
constraint fk_profesores_supervisor foreign key(id_supervisor)
references profesores(id_profesor)
);


create table alumnos(
nia tinyint,
dni varchar(9) unique not null,
nombre varchar(30) not null,
fecha_nacimiento date not null,

constraint pk_alumnos primary key (nia)
);

create table proyectos(
id_proyecto smallint auto_increment,
titulo varchar(45) unique not null,
fecha_inicio timestamp default now() ,
id_tutor tinyint not null,

constraint pk_proyectos primary key(id_proyecto),
constraint fk_proyectos_tutor foreign key (id_tutor)
references profesores(id_profesor)
);

create table alumno_proyecto(
nia tinyint,
id_proyecto smallint,
horas smallint,

constraint pk_alumno_proyecto  primary key (nia,id_proyecto),
constraint fk_alumno_proyecto_nia foreign key(nia)
references alumnos(nia)
on delete cascade,
constraint fk_alumno_proyectos_proyectos foreign key(id_proyecto)
references proyectos(id_proyecto)
on delete cascade,	
constraint chk_horas check(horas>0)
);
