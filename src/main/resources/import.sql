INSERT INTO usuarios (id_usuario,nombre,apellidos,clave,email,tlf,dni,linea_1,linea_2,localidad,cp,provincia) VALUES (1,'Pepe','Perez Perez','12345678','pepe@gmail.com','8386-73-16','79017498D','Calle Mateo, 799','9º C','Madrid','44365','Madrid');
INSERT INTO usuarios (id_usuario,nombre,apellidos,clave,email,tlf,dni,linea_1,linea_2,localidad,cp,provincia) VALUES (2,'Carlos','Ruano Salvador','1234abcd','carusa86@hotmail.com','14(81)622-01-53','89930199S','Plaça Naiara, 709','1º D','Teruel','30940','Teruel');
INSERT INTO usuarios (id_usuario,nombre,apellidos,clave,email,tlf,dni,linea_1,linea_2,localidad,cp,provincia) VALUES (3,'Cristina ','Gómez Puerta','abcd1234','cris65@gmail.com','7(864)021-41-72','43042177T','Rúa Anna, 13','6º C','Sevilla','25957','Sevilla');


INSERT INTO mascotas (id_mascota, id_usuario, Foto, Nombre, Especie, Edad, Raza, Descripcion, Chip, Genero) VALUES(1, 2, "https://pbs.twimg.com/media/FS5PnB7WYAEfEos?format=jpg&name=large","Vane", "perro", 3, "chucho","enano",724111111111111, "Femenino" );
INSERT INTO mascotas (id_mascota, id_usuario, Foto, Nombre, Especie, Edad, Raza, Descripcion, Chip, Genero) VALUES(2, 1, "https://pbs.twimg.com/media/FS5PnB7WYAEfEos?format=jpg&name=large","Vane", "perro", 3, "chucho","enano",724111111111111, "Femenino" );
INSERT INTO mascotas (id_mascota, id_usuario, Foto, Nombre, Especie, Edad, Raza, Descripcion, Chip, Genero) VALUES(3, 2, "https://pbs.twimg.com/media/FS5PnB7WYAEfEos?format=jpg&name=large","Vane", "perro", 3, "chucho","enano",724111111111111, "Femenino" );
INSERT INTO mascotas (id_mascota, id_usuario, Foto, Nombre, Especie, Edad, Raza, Descripcion, Chip, Genero) VALUES(4, 2, "https://pbs.twimg.com/media/FS5PnB7WYAEfEos?format=jpg&name=large","Vane", "perro", 3, "chucho","enano",724111111111111, "Femenino" );

INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (1, 'julian', 'rodriguez', 'jrod@gmail.com' );
INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (2, 'pepe', 'rodriguez', 'jrod@gmail.com' );
INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (3, 'manuel', 'rodriguez', 'jrod@gmail.com' );
INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (4, 'maria', 'rodriguez', 'jrod@gmail.com' );

INSERT INTO especialidades (id_especialidad, nombre_esp) VALUES (1, 'Aves');
INSERT INTO especialidades (id_especialidad, nombre_esp) VALUES (2, 'Roedores');

INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (1, 'clinica virgen del rocio', 'calle roduela', '3', 'sevilla', 'sevilla', '11134', '69584858', '57848545', '65858545', 'B123123123','vdlr@vet.com',  'abc1234', 'L-V 8:00-14:00','30');
INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (2, 'vet almeria', 'calle roduela', '3', 'sevilla', 'sevilla', '11134', '69584858', '57848545', '65858545', 'B123123123','vdlr1@vet.com',  'abc1234', 'L-V 8:00-14:00','30');
INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (3, 'veterinaria malaga', 'calle roduela', '3', 'sevilla', 'sevilla', '11134', '69584858', '57848545', '65858545', 'B123123123','vdlr2@vet.com',  'abc1234', 'L-V 8:00-14:00','30');

INSERT INTO opiniones (id_opinion, id_clinica, id_usuario, comentario,  puntuacion) VALUES (1,  2,  2, 'muy bien','5');
INSERT INTO opiniones (id_opinion, id_clinica, id_usuario, comentario,  puntuacion) VALUES (2,  1, 3, 'mal', '1');

INSERT INTO tratamientos (id_tratamiento, id_mascota, id_veterinario, medicamento, posologia, fecha_inicio, fecha_fin) VALUES (1, 2, 2, 'ibuprofeno', 'cada 8 horas', '2009-02-12','2010-01-01');
INSERT INTO tratamientos (id_tratamiento, id_mascota, id_veterinario, medicamento, posologia, fecha_inicio, fecha_fin) VALUES (2, 1, 1, 'ibuprofeno', 'cada 8 horas', '2009-02-12','2010-01-01');

