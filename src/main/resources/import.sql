INSERT INTO usuarios (id_usuario,nombre,apellidos,clave,email,tlf,dni,linea_1,linea_2,localidad,cp,provincia) VALUES (1,'Pepe','Perez Perez','12345678','pepe@gmail.com','8386-73-16','79017498D','Calle Mateo, 799','9º C','Madrid','44365','Madrid');
INSERT INTO usuarios (id_usuario,nombre,apellidos,clave,email,tlf,dni,linea_1,linea_2,localidad,cp,provincia) VALUES (2,'Carlos','Ruano Salvador','1234abcd','carusa86@hotmail.com','14(81)622-01-53','89930199S','Plaça Naiara, 709','1º D','Teruel','30940','Teruel');
INSERT INTO usuarios (id_usuario,nombre,apellidos,clave,email,tlf,dni,linea_1,linea_2,localidad,cp,provincia) VALUES (3,'Cristina ','Gómez Puerta','abcd1234','cris65@gmail.com','7(864)021-41-72','43042177T','Rúa Anna, 13','6º C','Sevilla','25957','Sevilla');


INSERT INTO mascotas (id_mascota, id_usuario, foto, nombre, especie, edad, raza, descripcion, chip, genero) VALUES (1, 2, 'https://pbs.twimg.com/media/FS5PnB7WYAEfEos?format=jpg&name=large', 'Vane', 'Perro', 3, 'Pomerania', 'Marron y pequeño', '724123123123123', 'Hembra');
INSERT INTO mascotas (id_mascota, id_usuario, foto, nombre, especie, edad, raza, descripcion, chip, genero) VALUES (2, 1, 'https://i.gyazo.com/ea2b4a89270e6c6cecf3ef8c2765fd5e.png', 'Grumpy', 'Gato', 3, 'Persa', 'Blanco y marrón y ojos azules', '724112223344434', 'Macho');
INSERT INTO mascotas (id_mascota, id_usuario, foto, nombre, especie, edad, raza, descripcion, chip, genero) VALUES (3, 2, 'https://i.gyazo.com/abd96b28cb0181e2e14071f7930b8bc6.jpg', 'Geckardo de Rivia', 'Reptil exótico', 3, 'Gecko', 'Anaranjado y blanco con motas', 'No tiene', 'Macho');
INSERT INTO mascotas (id_mascota, id_usuario, foto, nombre, especie, edad, raza, descripcion, chip, genero) VALUES (4, 2, 'https://i.gyazo.com/c75a3273fcffae6e37d4b458e999b063.jpg', 'Paco', 'Ave exótica', 1, 'Agaporni', 'Amarillo blanco y verde', 'No tiene', 'Hembra');

INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (1, 'Julian', 'Rodriguez', 'jrod@vetmail.com' );
INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (2, 'María', 'González', 'mariagonz@vetmail.com' );
INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (3, 'Manuel', 'Pérez', 'manper@vetmail.com' );
INSERT INTO veterinarios (id_veterinario, nombre, apellidos, email) VALUES (4, 'Gema', 'Martín', 'gemmar@vetmail.com' );

INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (1, 'Clinica Virgen del Rocio', 'Calle Amor de Dios', '3', 'Sevilla', 'Sevilla', '41002', '69584858', '57848545', '65858545', 'C39393939','vdlr@vetmail.com',  'abc1234', 'L-V 8:00-14:00','30');
INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (2, 'Vet Málaga', 'Calle Bénitez', '2', 'Mijas', 'Málaga', '11134', '69584858', '57848545', '65858545', 'B123123123','vetmalaga@vet.com',  'abc1234', 'L-V 8:00-14:00','30');
INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (3, 'Veterinaria San Fernando', 'Carretera Ronda', '6', 'San Fernando', 'Cádiz', '11132', '69584858', '57848545', '65858545', 'B123123123','clinsanfer2@vetmail.com',  'abc1234', 'L-V 8:00-14:00','30');
INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (4, 'Veterinaria Dos Hermanas', 'Calle Roduela', '3', 'Dos Hermanas', 'Sevilla', '11134', '69584858', '57848545', '65858545', 'B123123123','doshervet@vetmail.com',  'abc1234', 'L-V 8:00-14:00','30');
INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (5, 'Clínica P. Umbría', 'Calle Gustavo Adolfo Bécquer', '5', 'Punta Umbría', 'Huelva', '13134', '69584858', '57848545', '65858545', 'B123123123','pumbria@vetmail.com',  'abc1234', 'L-V 8:00-14:00','30');
INSERT INTO clinicas(id_clinica, nombre, direccion1, direccion2, localidad, provincia, cp, tlf1, tlf2, tlf_urgencia, cif, email,  clave, horario, granularidad ) VALUES (6, 'Veterinaria Chiclana', 'Calle Ancha', '7', 'Chiclana', 'Cádiz', '11130', '685458585', '685458586', '685458587', 'B123123123','vetchiclana@vetmail.com',  'abc1234', 'L-V 8:00-14:00','30');

INSERT INTO opiniones (id_opinion, id_clinica, id_usuario, comentario,  puntuacion) VALUES (1,  2,  2, 'Muy bien','5');
INSERT INTO opiniones (id_opinion, id_clinica, id_usuario, comentario,  puntuacion) VALUES (2,  1, 3, 'Mal', '1');
INSERT INTO opiniones (id_opinion, id_clinica, id_usuario, comentario,  puntuacion) VALUES (3,  3,  2, 'Muy contenta','4');
INSERT INTO opiniones (id_opinion, id_clinica, id_usuario, comentario,  puntuacion) VALUES (4,  4, 3, 'No está mal', '3');

INSERT INTO historial_veterinario (id_historialVet, procedimiento, id_mascotas, id_veterinario) VALUES(1, 'Curas presenciales en clínica', 1, 2 );
INSERT INTO historial_veterinario (id_historialVet, procedimiento, id_mascotas, id_veterinario) VALUES(2, 'radiografía', 2, 2 );
INSERT INTO historial_veterinario (id_historialVet, procedimiento, id_mascotas, id_veterinario) VALUES(3, 'Pedicura/Peluqueria', 3, 2 );

INSERT INTO tratamientos (id_tratamiento, id_mascota, id_veterinario, medicamento, posologia, fecha_inicio, fecha_fin, id_historialvet) VALUES (1, 2, 2, 'Collar antipulgas', 'Durante dos semanas', '2009-02-12','2010-01-01', 1);
INSERT INTO tratamientos (id_tratamiento, id_mascota, id_veterinario, medicamento, posologia, fecha_inicio, fecha_fin, id_historialvet) VALUES (2, 1, 1, 'Champú antigarrapatas', 'Cada 2 días', '2009-02-12','2010-01-01', 2);
INSERT INTO tratamientos (id_tratamiento, id_mascota, id_veterinario, medicamento, posologia, fecha_inicio, fecha_fin, id_historialvet) VALUES (3, 3, 2, 'Epatosil 100 / 10 kg', 'Cada 4 horas', '2009-02-12','2010-01-01', 1);
INSERT INTO tratamientos (id_tratamiento, id_mascota, id_veterinario, medicamento, posologia, fecha_inicio, fecha_fin, id_historialvet) VALUES (4, 1, 1, 'Medicina estomacal ', 'Cada 8 horas', '2009-02-12','2010-01-01', 2);

INSERT INTO citas (id_cita, id_clinica, id_mascota, id_usuario, id_veterinario, Fecha, Hora) VALUES (1, 1, 2, 1, 2, '22/06/2022', '12:00');
INSERT INTO citas (id_cita, id_clinica, id_mascota, id_usuario, id_veterinario, Fecha, Hora) VALUES (2, 2, 2, 1, 1, '02/06/2022', '13:00');
INSERT INTO citas (id_cita, id_clinica, id_mascota, id_usuario, id_veterinario, Fecha, Hora) VALUES (3, 2, 4, 2, 1, '05/06/2022', '19:00');