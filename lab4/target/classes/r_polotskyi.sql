create database if not exists polotskyi_lab3;
use polotskyi_lab3;

drop table if exists password;
drop table if exists fine;
drop table if exists rent;
drop table if exists car;
drop table if exists user;
drop table if exists station;

create table user (
	id bigint auto_increment primary key,
	first_name varchar(45) not null,
	last_name varchar(45) not null,
	birth_date date not null,
	phone_number varchar(15) not null,
	email varchar(320),
		passport_number varchar(45) not null,
	driver_license_number varchar(45) not null,
	license_exp_date date not null,
	status varchar(15) not null
) ENGINE = INNODB;

create table password (
	id bigint auto_increment primary key,
	password_sha256 varchar(64) not null,
	FK_user_password bigint unique not null
) ENGINE = INNODB;

create table fine (
	id bigint auto_increment primary key,
	date datetime not null,
	payment_due decimal(19, 2) not null,
	status varchar(15) not null,
	FK_user_fine bigint not null
) ENGINE = INNODB;

create table rent (
	id bigint auto_increment primary key,
	start_date datetime not null,
	price decimal(19, 2) not null,
	end_date datetime,
	status varchar(15) not null,
	FK_car_rent bigint not null,
	FK_user_rent bigint not null
) ENGINE = INNODB;

create table car (
	id bigint auto_increment primary key,
	brand varchar(45) not null,
	model varchar(45) not null,
	year year not null,
	plate_number varchar(45) not null,
	vin_number varchar(45) not null,
	status varchar(45) not null,
	FK_station_car bigint not null
) ENGINE = INNODB;

create table station (
	id bigint auto_increment primary key,
	name varchar(45) not null,
	address varchar(45) not null,
	city varchar(28) not null,
	country varchar(74) not null
) ENGINE = INNODB;


alter table password
	add constraint FK_user_password
	foreign key (FK_user_password)
	references user(id);
    
alter table fine
	add constraint FK_user_fine
	foreign key (FK_user_fine)
	references user(id);
	
alter table rent
	add constraint FK_car_rent
	foreign key (FK_car_rent)
	references car(id),
	
	add constraint FK_user_rent
	foreign key (FK_user_rent)
	references user(id);
	
alter table car
	add constraint FK_station_car
	foreign key (FK_station_car)
	references station(id);
    
create index idx_model_year on car (model, year);
create index idx_vin on car (vin_number);

create index idx_address_city on station (address, city);
create index idx_name on station (name);

create index idx_start_date on rent (start_date);
create index idx_status on rent (status);

create index idx_payment_due_status on fine (payment_due, status);


create index idx_driver_license_number_status on user (driver_license_number, status);
create index idx_birth_date on user (birth_date);
    
insert into user 
(id, first_name, last_name, birth_date, phone_number, email, passport_number, driver_license_number, license_exp_date, status)
values
(1, 'Elwin', 'Measures', '1995-07-06', '766-258-2233', 'emeasures0@com.com', 'l38v9h17', 'ds34832', '2026-10-08', 'active'),
(2, 'Ramona', 'Hambers', '1978-05-19', '512-884-4088', 'rhambers1@yandex.ru', 'q63d8b90', 'dz11319', '2032-02-15', 'active'),
(3, 'Kittie', 'Morter', '1977-10-14', '888-699-8139', 'kmorter2@tuttocitta.it', 'q36q8y43', 'jr96173', '2037-09-16', 'active'),
(4, 'Megan', 'Hymers', '1984-10-06', '983-347-7958', 'mhymers3@google.ru', 't60j4w17', 'dc85087', '2028-07-23', 'active'),
(5, 'Krissy', 'Reddie', '1983-04-10', '970-711-2550', 'kreddie4@clickbank.net', 's84e3q17', 'cz78866', '2045-10-23', 'active'),
(6, 'Fayre', 'Coleborn', '1996-05-05', '731-436-6919', 'fcoleborn5@imdb.com', 'l57v8a46', 'ip69371', '2033-09-16', 'active'),
(7, 'Willy', 'Covet', '1985-06-15', '789-444-8479', 'wcovet6@feedburner.com', 'w47r2n74', 'nj51905', '2032-03-07', 'active'),
(8, 'Angus', 'Boulden', '1997-03-15', '214-485-3573', 'aboulden7@weebly.com', 'd05g2r02', 'yb33432', '2026-12-15', 'active'),
(9, 'Lenee', 'Gianiello', '1985-05-05', '381-828-0163', 'lgianiello8@sun.com', 's23j4n33', 'yl71374', '2025-09-16', 'active'),
(10, 'Delly', 'Albisser', '1983-12-31', '849-607-1246', 'dalbisser9@boston.com', 'c62x9b66', 'ef46821', '2044-07-29', 'inactive'),
(11, 'Hebert', 'Strathman', '1976-04-08', '963-505-0344', 'hstrathmana@free.fr', 'v99o1i51', 'bk82724', '2041-05-22', 'active'),
(12, 'Packston', 'Koppe', '1977-04-17', '748-396-9761', 'pkoppeb@phpbb.com', 'i03a0i85', 'lz03435', '2043-04-20', 'inactive'),
(13, 'Clark', 'Allsworth', '1984-11-05', '895-919-1070', 'callsworthc@ehow.com', 'y65o0g96', 'ln15658', '2031-05-02', 'active'),
(14, 'Maximo', 'Full', '1989-04-03', '854-804-2807', 'mfulld@nba.com', 'b79l1w66', 'pu83251', '2043-04-15', 'active'),
(15, 'Jessie', 'Wenzel', '1993-04-10', '963-975-8981', 'jwenzele@unblog.fr', 'x12o7r29', 'pk58548', '2024-06-19', 'active');

insert into password
(id, password_sha256, FK_user_password)
values
(1, 'add95f9ed0e738cd3391a6841a938d16660750b9489bb63769241901d8033903', 1),
(2, '4199b80b3d3e621530109ebbc9a12b833eb4d6ed645d8a54623cb4401ac71bb1', 2),
(3, '6afbca459d79f683c94ed016cd0abe50293caf0c903c4d53ee69ccc12e52ca66', 3),
(4, 'e8d3e66245294a40000da738c6503d71a2bf9b3f1a2dd92ce7e1d4694e1b58ce', 4),
(5, '207aebde48b18fc87c269626bc75f7078d3e565d0948e1d0333e638d15a5a351', 5),
(6, '4e199b1dc4df5eccc29b1558a5676ed7a0908f7da69995e68d0c09a083de7442', 6),
(7, '0cf409ae80e7d44490280faeb356623a67ba28780e8fda730e6d13abeeba2981', 7),
(8, '1ee8ee762ddf613ec7cdf4fdc376356c4e1e6e7863425e5a27d907aeafa0c8b1', 8),
(9, '051c2bf39b78295515988aea0f7db4004dccc2f41b77778b8b4322ba899e34ae', 9),
(10, '92b40ed4fbaf6461bc00ef1b3fd296ad6186854ace936af2527928f84a5f89f5', 10),
(11, 'ff4769e9951f9143a00e33b94957438da4969d0a3023edb659691e4e5212b992', 11),
(12, '7d459e416b9f714fdce09ec3d5d8944acd811fd292cfbeed073587f733b13046', 12),
(13, '672cf6c744921b282d61b81152d0123e34b6e8520cade76613cc38b75604e087', 13),
(14, '95dd0d54cf30556d9a7edaa3ceacb54f3e76445c1f5f9d825002589f29f33ab6', 14),
(15, 'f2d71bd98ba6c80e57edd7ddba938a3c9dcf18f652f4660b2dfb848f391768b1', 15);

insert into station (name, address, city, country)
values
('Rice Group', '2470 Gina Junction', 'Youngstown', 'United States'),
('Price LLC', '99 Bonner Road', 'Houston', 'United States'),
('Klocko and Sons', '3602 Bonner Place', 'Dallas', 'United States'),
('Boehm-Sipes', '3 Forest Run Pass', 'Nashville', 'United States'),
('OReilly, Bartoletti and Jacobi', '92141 Buena Vista Avenue', 'Oklahoma City', 'United States');


insert into car (brand, model, year, plate_number, vin_number, status, FK_station_car)
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

insert into rent (start_date, price, end_date, status, FK_car_rent, FK_user_rent)
values
('2019-03-04 03:31:28', 101.38, '2019-03-06 03:31:28', 'finished', 4, 6),
('2020-01-17 19:16:48', 288.81, '2020-01-20 19:16:48', 'finished', 5, 11),
('2019-07-19 16:10:46', 917.8, '2019-07-29 16:10:46', 'finished', 9, 1),
('2020-06-23 10:55:52', 224.18, '2020-06-28 10:55:52', 'finished', 7, 9),
('2020-08-19 14:03:11', 869.56, '2020-08-30 14:03:11', 'finished', 12, 2);

insert into fine (date, payment_due, status, FK_user_fine, FK_rent_fine)
values
('2019-03-06 02:23:19', 50.23, 'paid', 6, 1);