create database agencia_fiscal;
use agencia_fiscal;

delimiter $$
create procedure sp_insertar_personas()
begin
	declare cantidadRegistros int;
    select count(ID) into cantidadRegistros from personas;
    if cantidadRegistros=0 then
		insert into personas (rfc, nombre_completo, fecha_nacimiento, curp, telefono, tiene_discapacidad) values
			('MARP930101T23', 'Pedro Mares Ruiz', '1993-01-01', "MARP930101HDFRRD06",'wNX0popNGsRcwdggcBzRhA==',true),
			('LOPS9705122RQ', 'Sara López Pineda', '1997-05-12', "LOPS970512MDFPLR08",'ifCAbRv9l61n9OHdAfZegw==',false),
			('MAMJ900515W4E', 'Julieta Mancinas Menchaca', '1990-05-15', "MAMJ900515MNLRRR07",'6/vgrFmXrR3breX9gvzziQ==',true),
			('MARC880915K56', 'Carlos Martínez Ríos','1988-09-15', "MARC880915HPLRTS01", 'zurI3tVX+nSnhLkz35Ez1g==',false),
			('RAML901225PL7', 'Luis Ramírez Miranda', '1990-12-25', "RAML901225HTJRRS03",'/VHkzYBRrbsqnek/C8Z8aw==',false),
			('GALA850730M78', 'Alicia García Luna', '1985-07-30', "GALA850730MCHRRR09",'F3q49Qj2K+XMgJK9oMBtBA==',false),
			('HEPP7811053VF', 'Pedro Hernández Pereira', '1978-11-05', "HEPP781105HMRNDR02",'nXYj1dtyJF9FrU+53kfPVw==',false),
			('DISO980415G9K', 'Olivia Díaz Soto', '1998-04-15', "DISO980415MHMRLS08",'rm2Js/cBSxjgQwEq5Jffuw==',false),
			('TOVM8208109AS', 'Miguel Torres Vega', '1982-08-10', "TOVM820810HSLRRL05",'AmZu85gYLxFzsuvm9qQ7Jg==',false),
			('SALE700620W12', 'Elena Sánchez Lapizco', '1970-06-20', "SALE700620MAGRNL08",'vJCjY7SkI5x2I4nrT5Xglw==',false),
			('RARF9302281Y2', 'Fernando Ramírez Romero', '1993-02-28', "RARF930228HGTMRN09",'6yISnBTIboNNMOtV9ddrPA==',false),
			('RUAP870905HU3', 'Paola Ruiz Alarcón', '1987-09-05', "RUAP870905MCHPLA09",'wII+0AL9jyFqHKurPGSFdw==',true),
			('GODA8011153O4', 'Alan Gómez Duarte', '1980-11-15', "GODA801115HMCRVD08",'64o7QhKgZxQLg/9A17cJDg==',true),
			('MAML961210Z4A', 'Lucía Martín Minjarez', '1996-12-10', "MAML961210MMCNCR04",'l/lzkFgITfbZqwWQaof4yA==',false),
			('CAER750530CB6', 'Roberto Castro Estrada', '1975-05-30', "CAER750530HSLLRT08",'Ar1aFeq80Pv7X783n17mGA==',false),
			('VAZG910725HI7', 'Gabriela Vázquez Zúñiga', '1991-07-25', "VAZG910725MTCZLB01",'Y+YUZS8CEvtbfxBAwi1zrQ==',false),
			('NUUR831020M78', 'Rosa Núñez Urías', '1983-10-20', "NUUR831020MTLXRR02",'uOAyu9CEZJ39hjUsNfT+IQ==',false),
			('LOJJ72040588E', 'Javier López Jimenez', '1972-04-05', "LOJJ720405HDGRPR05",'RQvuqNv908iiUynvmh6dKQ==',true),
			('FOTM7908159LR', 'Martha Flores Torres', '1979-08-15', "FOTM790815MZRCLS08",'jOWYyYGDwIQB1YaHi3mtEw==',false),
			('PEOD940101F01', 'Daniel Pérez Osuna', '1994-01-01', "PEOD940101HTMRLD02",'xyXrxDSUNxXqEK/w4O6zEQ==',false);
            
            call sp_insertar_autos_personas();
            
		end if;
        select * from personas;
end $$
delimiter ;

delimiter $$
create procedure sp_buscar_personas_nombre(in nombre varchar(100))
begin
    set @pat=concat('%',nombre,'%');
	select * from personas where nombre_completo like @pat;
end $$
delimiter ;

delimiter $$
create procedure sp_buscar_personas_curp(in curpB varchar(100))
begin
    set @pat=concat('%',curpB,'%');
	select * from personas where curp like @pat;
end $$
delimiter ;

delimiter $$
create procedure sp_buscar_personas_anio(in anioNacimiento int)
begin
    set @pat=concat(anioNacimiento,'%');
	select * from personas where fecha_nacimiento like @pat;
end $$
delimiter ;

delimiter $$
create procedure sp_insertar_autos_personas()
begin
	insert into vehiculos (serie, marca, linea, color, modelo, id_persona) values
		('ABC-123', 'Honda', 'Civic', 'Negro', '2003', 1),
		('DEF-456', 'Toyota', 'Corolla', 'Rojo', '2005', 2),
		('GHI-789', 'Ford', 'Fiesta', 'Azul', '2010', 3),
		('JKL-012', 'Chevrolet', 'Camaro', 'Blanco', '2015', 4),
		('MNO-345', 'Nissan', 'Sentra', 'Plata', '2012', 5),
		('PQR-678', 'Volkswagen', 'Jetta', 'Gris', '2008', 6),
		('STU-901', 'Hyundai', 'Accent', 'Verde', '2017', 7),
		('VWX-234', 'Mazda', '3', 'Azul', '2019', 8),
		('YZA-567', 'Kia', 'Rio', 'Negro', '2014', 9),
		('BCD-890', 'Subaru', 'Outback', 'Rojo', '2016', 10),
		('EFG-123', 'Audi', 'A4', 'Blanco', '2018', 11),
		('HIJ-456', 'Mercedes-Benz', 'Clase C', 'Plateado', '2020', 12),
		('KLM-789', 'BMW', 'Serie 3', 'Negro', '2013', 13),
		('NOP-012', 'Volvo', 'S60', 'Gris', '2011', 14),
		('PQR-345', 'Lexus', 'IS', 'Rojo', '2017', 15),
		('STU-678', 'Infiniti', 'Q50', 'Negro', '2015', 16),
		('VWX-901', 'Tesla', 'Model S', 'Azul', '2019', 17),
		('YZA-234', 'Porsche', '911', 'Blanco', '2021', 18),
		('BCD-567', 'Jaguar', 'XE', 'Gris', '2014', 19),
		('EFG-890', 'Land Rover', 'Range Rover', 'Negro', '2016', 20),
		('HIJ-123', 'Ferrari', '488', 'Rojo', '2020', 1),
		('KLM-456', 'Lamborghini', 'Huracan', 'Amarillo', '2018', 2),
		('NOP-789', 'McLaren', '720S', 'Naranja', '2019', 3),
		('PQR-012', 'Bugatti', 'Chiron', 'Azul', '2021', 4),
		('STU-345', 'Rolls-Royce', 'Phantom', 'Blanco', '2020', 5),
		('VWX-678', 'Bentley', 'Continental GT', 'Negro', '2017', 6),
		('YZA-901', 'Aston Martin', 'DB11', 'Gris', '2018', 7),
		('BCD-234', 'Fiat', '500', 'Rojo', '2015', 8),
		('EFG-567', 'Alfa Romeo', 'Giulia', 'Blanco', '2019', 9);
end $$
delimiter ;