Use prueba;

Create table personas (
id_persona int Not null auto_Increment,
nombre varchar(40),
apellido varchar(55),
edad int,
fech_acc date,
UNIQUE(id_persona),
Primary KEy(id_persona),
check (edad>=18)
);

ALTER table personas
ADD email varchar(100);
ALTER table personas 
REname column apellido to descripcion;
Alter table personas
MODIFY COLUMN descripcion varchar(250);

Create Table dni (
id_dni int Auto_Increment not null Primary KEY,
numero_dni varchar(9) NOT NULL,
id_persona int,
Unique(id_dni,numero_dni),
Foreign Key(id_persona) REferences personas(id_persona)
);

Alter table dni 
add id_persona int,
ADD Constraint fk_persona 
Foreign Key (id_persona) references personas(id_persona);

Create table empresa(
id_empresa int not null auto_increment primary key,
nombre varchar(30) not null
);
Alter table personas
ADD id_empresa varchar(25);

ALter table personas 
Modify column id_empresa int not null;

Alter table personas
add constraint fk_empresa
foreign key (id_empresa) references empresa(id_empresa);

create table lenguajes(
id_lenguaje int auto_increment primary key,
name varchar(20) not null );

create table persona_lenguajes(
id_persona int,
id_lenguaje int, 
Foreign key (id_persona) references personas(id_persona) on delete cascade on update cascade,
foreign key (id_lenguaje)references lenguajes(id_lenguaje),
Unique (id_persona,id_lenguaje)
); 

Insert into dni (numero_dni,id_persona) Values ("11111111A",1);