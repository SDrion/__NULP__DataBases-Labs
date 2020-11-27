create database if not exists polotskyi_lab3;
use polotskyi_lab3;

drop table if exists fine;
drop table if exists rent;
drop table if exists car;
drop table if exists user;
drop table if exists station;

create table user (
	id bigint auto_increment primary key,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	phone_number varchar(15) not null,
	email varchar(320),
	passport_number varchar(45) not null,
	driver_license_number varchar(45) not null,
	status varchar(15) not null,
    password_sha256 varchar(64) not null
) ENGINE = INNODB;

create table fine (
	id bigint auto_increment primary key,
	payment_due decimal(19, 2) not null,
	status varchar(15) not null,
	user_id bigint not null
) ENGINE = INNODB;

create table rent (
	id bigint auto_increment primary key,
	price decimal(19, 2) not null,
	status varchar(15) not null,
	car_id bigint not null,
	user_id bigint not null
) ENGINE = INNODB;

create table car (
	id bigint auto_increment primary key,
	brand varchar(45) not null,
	model varchar(45) not null,
	year year not null,
	plate_number varchar(45) not null,
	vin_number varchar(45) not null,
	status varchar(45) not null,
	station_id bigint not null
) ENGINE = INNODB;

create table station (
	id bigint auto_increment primary key,
	name varchar(45) not null,
	address varchar(45) not null,
	city varchar(28) not null
) ENGINE = INNODB;


alter table fine
	add constraint FK_user_fine
	foreign key (user_id)
	references user(id)
    on delete cascade;
	
alter table rent
	add constraint FK_car_rent
	foreign key (car_id)
	references car(id)
    on delete cascade,
	
	add constraint FK_user_rent
	foreign key (user_id)
	references user(id)
    on delete cascade;
	
alter table car
	add constraint FK_station_car
	foreign key (station_id)
	references station(id)
    on delete cascade;

insert into user 
(id, first_name, last_name, phone_number, email, passport_number, driver_license_number, status, password_sha256)
values
(1, 'Elwin', 'Measures', '766-258-2233', 'emeasures0@com.com', 'l38v9h17', 'ds34832', 'active', 'add95f9ed0e738cd3391a6841a938d16660750b9489bb63769241901d8033903'),
(2, 'Ramona', 'Hambers', '512-884-4088', 'rhambers1@yandex.ru', 'q63d8b90', 'dz11319', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(3, 'Kittie', 'Morter', '888-699-8139', 'kmorter2@tuttocitta.it', 'q36q8y43', 'jr96173', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(4, 'Megan', 'Hymers', '983-347-7958', 'mhymers3@google.ru', 't60j4w17', 'dc85087', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(5, 'Krissy', 'Reddie', '970-711-2550', 'kreddie4@clickbank.net', 's84e3q17', 'cz78866', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(6, 'Fayre', 'Coleborn', '731-436-6919', 'fcoleborn5@imdb.com', 'l57v8a46', 'ip69371', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(7, 'Willy', 'Covet', '789-444-8479', 'wcovet6@feedburner.com', 'w47r2n74', 'nj51905', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(8, 'Angus', 'Boulden', '214-485-3573', 'aboulden7@weebly.com', 'd05g2r02', 'yb33432', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(9, 'Lenee', 'Gianiello', '381-828-0163', 'lgianiello8@sun.com', 's23j4n33', 'yl71374', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(10, 'Delly', 'Albisser', '849-607-1246', 'dalbisser9@boston.com', 'c62x9b66', 'ef46821', 'inactive', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(11, 'Hebert', 'Strathman', '963-505-0344', 'hstrathmana@free.fr', 'v99o1i51', 'bk82724', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(12, 'Packston', 'Koppe', '748-396-9761', 'pkoppeb@phpbb.com', 'i03a0i85', 'lz03435', 'inactive', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(13, 'Clark', 'Allsworth', '895-919-1070', 'callsworthc@ehow.com', 'y65o0g96', 'ln15658', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(14, 'Maximo', 'Full', '854-804-2807', 'mfulld@nba.com', 'b79l1w66', 'pu83251', 'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1'),
(15, 'Jessie', 'Wenzel', '963-975-8981', 'jwenzele@unblog.fr', 'x12o7r29', 'pk58548', 	'active', '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1');

insert into station (name, address, city)
values
('Rice Group', '2470 Gina Junction', 'Youngstown'),
('Price LLC', '99 Bonner Road', 'Houston'),
('Klocko and Sons', '3602 Bonner Place', 'Dallas'),
('Boehm-Sipes', '3 Forest Run Pass', 'Nashville'),
('OReilly, Bartoletti and Jacobi', '92141 Buena Vista Avenue', 'Oklahoma City');


insert into car (brand, model, year, plate_number, vin_number, status, station_id)
values
('Aston Martin', 'V8 Vantage', 2012, 'EV1546ZR', 'WA1LMAFE0CD920146', 'available', 1),
('Chevrolet', 'Suburban 1500', 2001, 'KE6930FJ', 'JH4DC54843C556934', 'rented', 1),
('Ford', 'Five Hundred', 2006, 'ZE9163RW', 'WBAKG1C53CJ629037', 'available', 2),
('BMW', '3 Series', 2002, 'CS6907PX', '5XYKT3A15CG373235', 'available', 2),
('Mercedes-Benz', 'SL-Class', 1998, 'ZN0519DC', 'JM1NC2PFXF0376989', 'available', 3),
('Oldsmobile', 'Bravada', 1993, 'ET8324EK', '3C4PDDAG9FT278235', 'rented', 3),
('Mercury', 'Villager', 1999, 'EL2880SX', 'JTHBP5C29E5891042', 'available', 4),
('Oldsmobile', 'Regency', 1998, 'TV2279LV', 'WAUWMAFC4EN204765', 'available', 4),
('Honda', 'CR-X', 1988, 'MV7719HP', 'WAUMF68P86A826731', 'rented', 5),
('Honda', 'Prelude', 1996, 'UD4266TV', 'TRUB3AFK2C1868343', 'available', 5),
('BMW', 'Z4', 2004, 'YF7717NQ', 'WBAUU3C52AA757408', 'available', 3),
('Porsche', 'Cayman', 2010, 'GF9483KZ', '3D7TP2CT4BG341500', 'available', 2);

insert into rent (price, status, car_id, user_id)
values
(101.38, 'finished', 4, 6),
(288.81, 'finished', 5, 11),
(917.8, 'finished', 9, 1),
(224.18, 'finished', 7, 9),
(869.56, 'finished', 12, 2);

insert into fine (payment_due, status, user_id)
values
(50.23, 'paid', 6);