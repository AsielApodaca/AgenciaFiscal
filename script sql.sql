use agencia_fiscal;

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
		end if;
        select * from personas;
end $$
delimiter ;