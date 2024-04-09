create database agencia_fiscal;
use agencia_fiscal;

select * from personas;
select * from vehiculos;
delimiter $$
create procedure sp_insertar_personas()
begin
	declare cantidadRegistros int;
    select count(ID) into cantidadRegistros from personas;
    if cantidadRegistros=0 then
		insert into personas (rfc, nombre_completo, fecha_nacimiento, curp, telefono, tiene_discapacidad) values
			('MARP930101T23', 'Pedro Mares Ruiz', '1993-01-01', "MARP930101HDFRRD06",'1234567890',true),
			('LOPS9705122RQ', 'Sara López Pineda', '1997-05-12', "LOPS970512MDFPLR08",'2345678901',false),
			('MAMJ900515W4E', 'Julieta Mancinas Menchaca', '1990-05-15', "MAMJ900515MNLRRR07",'3456789012',true),
			('MARC880915K56', 'Carlos Martínez Ríos','1988-09-15', "MARC880915HPLRTS01", '4567890123',false),
			('RAML901225PL7', 'Luis Ramírez Miranda', '1990-12-25', "RAML901225HTJRRS03",'5678901234',false),
			('GALA850730M78', 'Alicia García Luna', '1985-07-30', "GALA850730MCHRRR09",'6789012345',false),
			('HEPP7811053VF', 'Pedro Hernández Pereira', '1978-11-05', "HEPP781105HMRNDR02",'7890123456',false),
			('DISO980415G9K', 'Olivia Díaz Soto', '1998-04-15', "DISO980415MHMRLS08",'8901234567',false),
			('TOVM8208109AS', 'Miguel Torres Vega', '1982-08-10', "TOVM820810HSLRRL05",'9012345678',false),
			('SALE700620W12', 'Elena Sánchez Lapizco', '1970-06-20', "SALE700620MAGRNL08",'0123456789',false),
			('RARF9302281Y2', 'Fernando Ramírez Romero', '1993-02-28', "RARF930228HGTMRN09",'1122334455',false),
			('RUAP870905HU3', 'Paola Ruiz Alarcón', '1987-09-05', "RUAP870905MCHPLA09",'2233445566',true),
			('GODA8011153O4', 'Alan Gómez Duarte', '1980-11-15', "GODA801115HMCRVD08",'3344556677',true),
			('MAML961210Z4A', 'Lucía Martín Minjarez', '1996-12-10', "MAML961210MMCNCR04",'4455667788',false),
			('CAER750530CB6', 'Roberto Castro Estrada', '1975-05-30', "CAER750530HSLLRT08",'5566778899',false),
			('VAZG910725HI7', 'Gabriela Vázquez Zúñiga', '1991-07-25', "VAZG910725MTCZLB01",'6677889900',false),
			('NUUR831020M78', 'Rosa Núñez Urías', '1983-10-20', "NUUR831020MTLXRR02",'7788990011',false),
			('LOJJ72040588E', 'Javier López Jimenez', '1972-04-05', "LOJJ720405HDGRPR05",'8899001122',true),
			('FOTM7908159LR', 'Martha Flores Torres', '1979-08-15', "FOTM790815MZRCLS08",'9900112233',false),
			('PEOD940101F01', 'Daniel Pérez Osuna', '1994-01-01', "PEOD940101HTMRLD02",'0011223344',false);
            
            call sp_insertar_autos_personas();
            
		end if;
        select * from personas;
end $$
delimiter ;

delimiter $$
create procedure sp_insertar_autos_personas()
begin
	insert into vehiculos (color, linea, marca, modelo, serie,id_persona) values
			('Rojo', 'Sedán', 'Toyota', 'Corolla', '1A1BCD12345678901',1),
			('Azul', 'SUV', 'Honda', 'CR-V', '2B2EFG23456789012',1),
			('Blanco', 'Pickup', 'Ford', 'F-150', '3C3HIJ34567890123',2),
			('Negro', 'Hatchback', 'Volkswagen', 'Golf', '4D4KLM45678901234',3),
			('Gris', 'Coupé', 'BMW', 'Serie 3', '5E5NOP56789012345',4),
			('Verde', 'Camioneta', 'Chevrolet', 'Traverse', '6F6QRS67890123456',4),
			('Plateado', 'Convertible', 'Audi', 'A5', '7G7TUV78901234567',5),
			('Amarillo', 'Minivan', 'Dodge', 'Grand Caravan', '8H8WXY89012345678',6),
			('Naranja', 'SUV', 'Jeep', 'Wrangler', '9I9ZAB90123456789',7),
			('Negro', 'Hatchback', 'Hyundai', 'Veloster', '1J1CDE01234567890',7),
			('Blanco', 'Pickup', 'Toyota', 'Tacoma', '2K2EFG12345678901',7),
			('Gris', 'Coupé', 'Ford', 'Mustang', '3L3HIJ23456789012',8),
			('Azul', 'Sedán', 'Honda', 'Accord', '4M4KLM34567890123',9),
			('Rojo', 'Crossover', 'Nissan', 'Rogue', '5N5NOP45678901234',10),
			('Negro', 'Hatchback', 'Volkswagen', 'Golf GTI', '6O6QRS56789012345',10),
			('Blanco', 'SUV', 'Kia', 'Sportage', '7P7TUV67890123456',11),
			('Verde', 'Pickup', 'Chevrolet', 'Silverado', '8Q8WXY78901234567',12),
			('Gris', 'Sedán', 'Audi', 'A4', '9R9ZAB89012345678',13),
			('Plateado', 'Coupé', 'BMW', 'Serie 4', '1S1CDE90123456789',14),
			('Azul', 'Hatchback', 'Mercedes-Benz', 'Clase A', '2T2EFG01234567890',15),
			('Negro', 'SUV', 'Ford', 'Escape', '3U3HIJ12345678901',16),
			('Blanco', 'Pickup', 'Ram', '1500', '4V4KLM23456789012',16),
			('Rojo', 'Coupé', 'Lexus', 'RC', '5W5NOP34567890123',17),
			('Gris', 'SUV', 'Infiniti', 'QX60', '6X6QRS45678901234',17),
			('Azul', 'Sedán', 'Subaru', 'Impreza', '7Y7TUV56789012345',18),
			('Negro', 'Crossover', 'Mazda', 'CX-5', '8Z8WXY67890123456',18),
			('Blanco', 'Pickup', 'GMC', 'Sierra', '9A9ZAB78901234567',18),
			('Plateado', 'Hatchback', 'Volkswagen', 'Polo', '1B1CDE89012345678',19),
			('Rojo', 'Coupé', 'Chevrolet', 'Camaro', '2C2EFG90123456789',20),
			('Azul', 'SUV', 'Toyota', 'Highlander', '3D3HIJ01234567890',20);
end $$
delimiter ;