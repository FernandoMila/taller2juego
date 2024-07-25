create database taller2;
use taller2;

DROP TABLE IDENTIFICA;
DROP TABLE CRIMINAL;
DROP TABLE OBTIENE;
DROP TABLE PISTA;
DROP TABLE PROXIMO;
DROP TABLE LUGAR;
DROP TABLE CIUDAD;

CREATE TABLE CRIMINAL (
idCriminal INTEGER NOT NULL,
nombreCriminal varchar(50) NOT NULL,
hobbie VARCHAR(50) NOT NULL,
sexo enum ('Femenino', 'Masculino', 'Otro') NOT NULL,
colorPelo VARCHAR(50) NOT NULL,
ocupacion varchar(50) NOT NULL,
vehiculo VARCHAR(50) NOT NULL,
caracteristicas VARCHAR(50) NOT NULL,
PRIMARY KEY (idCriminal)
);

CREATE TABLE PISTA (
idPista INTEGER,
descripcion VARCHAR(255) NOT NULL,
PRIMARY KEY (idPista)
);


CREATE TABLE IDENTIFICA (
idPista INTEGER,
idCriminal INTEGER,
foreign key (idPista) references pista (idPista),
foreign key (idCriminal) references criminal (idCriminal),
primary key (idPista, idCriminal)
);


CREATE TABLE CIUDAD (
idCiudad integer,
nombre varchar (50) Not Null,
descripcion varchar (255) Not Null,
imagen varchar (255) Not Null,
primary key (idCiudad)
);


CREATE TABLE LUGAR (
idLugar INTEGER,
idCiudad integer,
nombre varchar (50) Not Null,
descripcion varchar (255) Not Null,
imagen varchar (255) Not Null,
foreign key (idCiudad) references ciudad (idCiudad),
primary key (idLugar, idCiudad)
);


CREATE TABLE PROXIMOS (
idCiudad integer,
idCiudadProximo integer,
foreign key (idCiudad) references ciudad (idCiudad),
foreign key (idCiudadProximo) references ciudad (idCiudad),
primary key (idCiudad, idCiudadProximo)
);

create table OBTIENE (
idLugar integer,
idPista integer,
foreign key (idLugar) references Lugar (idLugar),
foreign key (idPista) references Pista (idPista),
primary key (idLugar, idPista)
);




