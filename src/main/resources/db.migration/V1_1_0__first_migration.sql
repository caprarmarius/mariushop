drop table if exists address_;
drop table if exists cart;
drop table if exists category;
drop table if exists location;
drop table if exists order_;
drop table if exists order_detail;
drop table if exists product;
drop table if exists revenue;
drop table if exists roles;
drop table if exists stock;
drop table if exists user;
create table address_ (id integer not null auto_increment, city varchar(255), country varchar(255), street varchar(255), primary key (id)) engine=InnoDB;
create table cart (id integer not null auto_increment, product_id integer, quantity integer, user_user_id integer, primary key (id)) engine=InnoDB;
create table category (product_category_id integer not null auto_increment, description varchar(255), name varchar(255), primary key (product_category_id)) engine=InnoDB;
create table location (id integer not null auto_increment, name varchar(255), address_id integer, primary key (id)) engine=InnoDB;
create table order_ (id integer not null auto_increment, created_at datetime, delivery_location_id integer, shipped_from_id integer, user_user_id integer, primary key (id)) engine=InnoDB;
create table order_detail (id integer not null auto_increment, product_id integer, quantity integer, order_id integer, primary key (id)) engine=InnoDB;
create table product (product_id integer not null auto_increment, description varchar(255), image varchar(255), name varchar(255), price decimal(19,2), weight double precision, product_category_product_category_id integer, primary key (product_id)) engine=InnoDB;
create table revenue (id integer not null auto_increment, local_date datetime, sum decimal(19,2), location_id integer, primary key (id)) engine=InnoDB;
create table roles (role_id integer not null auto_increment, role_name varchar(255), primary key (role_id)) engine=InnoDB;
create table stock (id integer not null auto_increment, quantity integer, location_id integer, product_product_id integer, primary key (id)) engine=InnoDB;
create table user (user_id integer not null auto_increment, email_address varchar(255), fist_name varchar(255), last_name varchar(255), password varchar(255), username varchar(255), role_role_id integer, primary key (user_id)) engine=InnoDB;
alter table cart add constraint FK45kh318jlvfel6pk3lwky6rqm foreign key (user_user_id) references user (user_id);
alter table location add constraint FK30md1a17fhkula64nmv91vja7 foreign key (address_id) references address_ (id);
alter table order_ add constraint FK91i0qaidj9m0g53ww6iab9df4 foreign key (delivery_location_id) references location (id);
alter table order_ add constraint FKf5oqqh9fkxnxoaccb3xixnxf3 foreign key (shipped_from_id) references location (id);
alter table order_ add constraint FKinclph479keyownc8nesxlpe1 foreign key (user_user_id) references user (user_id);
alter table order_detail add constraint FK4u34rkhbehcj1jbb1mc5m8ccs foreign key (order_id) references order_ (id);
alter table product add constraint FKdeb2o4e1j6k1ehuky2ht9te9l foreign key (product_category_product_category_id) references category (product_category_id);
alter table revenue add constraint FK6xukepd8ssa1ok6iakkhp83p7 foreign key (location_id) references location (id);
alter table stock add constraint FK6t3m0kaf6fubuus331gf7xmn8 foreign key (location_id) references location (id);
alter table stock add constraint FKrwdkwjf037066qtbpq0pg0h6n foreign key (product_product_id) references product (product_id);
alter table user add constraint FK4keqlw3ucfmfsbeu8r1ijdppf foreign key (role_role_id) references roles (role_id);

insert into category (product_category_id, description, name) values (1, 'Venereal disease NEC', 'Laptops');
insert into category (product_category_id, description, name) values (2, 'Disloc metacarpophaln-cl', 'Accessories');
insert into category (product_category_id, description, name) values (3, 'Simple microphthalmos', 'Flat Screen Monitors');
insert into category (product_category_id, description, name) values (4, 'Carbuncle of trunk', 'Printers');
insert into category (product_category_id, description, name) values (5, 'Dislocation jaw-closed', 'Multifunction Printers');
insert into category (product_category_id, description, name) values (6, 'Soft tissue disorder NEC', 'Mice');
insert into category (product_category_id, description, name) values (7, 'Open wound of palate', 'Keyboards');
insert into category (product_category_id, description, name) values (8, 'Inf mcrg rstn oth drg ml', 'Mousepads');
insert into category (product_category_id, description, name) values (9, 'Abn ftl hrt rate/rhy-uns', 'Computer System Accessories');
insert into category (product_category_id, description, name) values (10, 'Opn brain lac-brief coma', 'Graphic Cards');
insert into category (product_category_id, description, name) values (11, 'Opn brain lac-brief coma', 'Scanners');
insert into category (product_category_id, description, name) values (12, 'Opn brain lac-brief coma', 'Speakers');
insert into category (product_category_id, description, name) values (13, 'Opn brain lac-brief coma', 'Software');

insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (51, 2.8, 'Notebook Basic 15', 1,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1000.jpg', 956,
        'Notebook Basic 15 with 2,80 GHz quad core, 15" LCD, 4 GB DDR3 RAM, 500 GB Hard Disc, Windows 8 Pro');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (1, 4.1, 'Notebook Basic 17', 1,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1001.jpg', 1249,
        'Notebook Basic 17 with 2,80 GHz quad core, 17" LCD, 4 GB DDR3 RAM, 500 GB Hard Disc, Windows 8 Pro');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (2, 2.6, 'Notebook Basic 18', 1,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1002.jpg', 1570,
        'Notebook Basic 18 with 2,80 GHz quad core, 18" LCD, 8 GB DDR3 RAM, 1000 GB Hard Disc, Windows 8 Pro');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (3, 5.2, 'Notebook Basic 19', 1,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1003.jpg', 1650,
        'Notebook Basic 19 with 2,80 GHz quad core, 19" LCD, 8 GB DDR3 RAM, 1000 GB Hard Disc, Windows 8 Pro');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (4, 1.3, 'ITelO Vault', 2,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1007.jpg', 299,
        'Digital Organizer with State-of-the-Art Storage Encryption');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (5, 5.0, 'Notebook Professional 15', 2,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1010.jpg', 1999,
        'Notebook Professional 15 with 2,80 GHz quad core, 15" Multitouch LCD, 8 GB DDR3 RAM, 500 GB SSD - DVD-Writer (DVD-R/+R/-RW/-RAM),Windows 8 Pro');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (6, 6.0, 'Notebook Professional 17', 1,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1011.jpg', 2299,
        'Notebook Professional 17 with 2,80 GHz quad core, 17" Multitouch LCD, 8 GB DDR3 RAM, 500 GB SSD - DVD-Writer (DVD-R/+R/-RW/-RAM),Windows 8 Pro');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (7, 3.0, 'ITelO Vault Net', 2,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1020.jpg', 459,
        'Digital Organizer with State-of-the-Art Encryption for Storage and Network Communications');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (8, 3.6, 'ITelO Vault SAT', 2,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1021.jpg', 149,
        'Digital Organizer with State-of-the-Art Encryption for Storage and Secure Stellite Link');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (9, 7.8, 'Comfort Easy', 2,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1022.jpg', 1679,
        '32 GB Digital Assistant with high-resolution color screen');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (10, 2.2, 'Comfort Senior', 2,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1023.jpg', 512,
        '64 GB Digital Assistant with high-resolution color screen and synthesized voice output');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (11, 3.3, 'Ergo Screen E-I', 3,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1030.jpg', 230,
        'Optimum Hi-Resolution max. 1920 x 1080 @ 85Hz, Dot Pitch: 0.27mm');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (12, 7.8, 'Ergo Screen E-II', 3,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1031.jpg', 285,
        'Optimum Hi-Resolution max. 1920 x 1200 @ 85Hz, Dot Pitch: 0.26mm');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (13, 9.1, 'Ergo Screen E-III', 3,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1032.jpg', 345,
        'Optimum Hi-Resolution max. 2560 x 1440 @ 85Hz, Dot Pitch: 0.25mm');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (14, 4.6, 'Flat Basic', 3,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1035.jpg', 399,
        'Optimum Hi-Resolution max. 1600 x 1200 @ 85Hz, Dot Pitch: 0.24mm');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (15, 5.4, 'Flat Future', 3,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1036.jpg', 430,
        'Optimum Hi-Resolution max. 2048 x 1080 @ 85Hz, Dot Pitch: 0.26mm');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (16, 3.5, 'Flat XL', 3,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1037.jpg', 1230,
        'Optimum Hi-Resolution max. 2016 x 1512 @ 85Hz, Dot Pitch: 0.24mm');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (17, 7.9, 'Laser Professional Eco', 4,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1040.jpg', 830,
        'Print 2400 dpi image quality color documents at speeds of up to 32 ppm (color) or 36 ppm (monochrome), letter/A4. Powerful 500 MHz processor, 512MB of memory');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (18, 6.1, 'Laser Basic', 4,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1041.jpg', 490,
        'Up to 22 ppm color or 24 ppm monochrome A4/letter, powerful 500 MHz processor and 128MB of memory');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (19, 10., 'Laser Allround', 4,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1042.jpg', 349,
        'Print up to 25 ppm letter and 24 ppm A4 color or monochrome, with Available first-page-out-time of less than 13 seconds for monochrome and less than 15 seconds for color');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (20, 7.4, 'Ultra Jet Super Color', 4,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1050.jpg', 139,
        '4800 dpi x 1200 dpi - up to 35 ppm (mono) / up to 34 ppm (color) - capacity: 250 sheets - Hi-Speed USB, Ethernet');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (21, 5.5, 'Ultra Jet Mobile', 4,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1051.jpg', 99,
        '1000 dpi x 1000 dpi - up to 35 ppm (mono) / up to 34 ppm (color) - capacity: 250 sheets - Hi-Speed USB - excellent dimensions for the small office');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (22, 9.4, 'Ultra Jet Super Highspeed', 4,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1052.jpg', 170,
        '4800 dpi x 1200 dpi - up to 35 ppm (mono) / up to 34 ppm (color) - capacity: 250 sheets - Hi-Speed USB2.0, Ethernet');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (23, 8.7, 'Multi Print', 5,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1055.jpg', 99,
        '1000 dpi x 1000 dpi - up to 16 ppm (mono) / up to 15 ppm (color)- capacity 80 sheets - scanner (216 x 297 mm, 1200dpi x 2400dpi)');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (24, 8.2, 'Multi Color', 5,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1056.jpg', 119,
        '1200 dpi x 1200 dpi - up to 25 ppm (mono) / up to 24 ppm (color)- capacity 80 sheets - scanner (216 x 297 mm, 2400dpi x 4800dpi, high resolution)');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (25, 4.8, 'Cordless Mouse', 6,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1060.jpg', 9,
        'Cordless Optical USB Mice, Laptop, Color: Black, Plug&Play');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (26, 4.1, 'Speed Mouse', 6,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1061.jpg', 7,
        'Optical USB, PS/2 Mouse, Color: Blue, 3-button-functionality (incl. Scroll wheel)');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (27, 1.7, 'Track Mouse', 6,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1062.jpg', 11,
        'Optical USB Mouse, Color: Red, 5-button-functionality(incl. Scroll wheel), Plug&Play');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (28, 7.8, 'Ergonomic Keyboard', 7,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1063.jpg', 14,
        'Ergonomic USB Keyboard for Desktop, Plug&Play');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (29, 3.6, 'Internet Keyboard', 7,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1064.jpg', 16,
        'Corded Keyboard with special keys for Internet Usability, USB');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (30, 2.1, 'Media Keyboard', 7,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1065.jpg', 26,
        'Corded Ergonomic Keyboard with special keys for Media Usability, USB');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (31, 8.4, 'Mousepad', 8,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1066.jpg', 6,
        'Nice mouse pad with ITelO Logo');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (32, 7.8, 'Ergo Mousepad', 8,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1067.jpg', 8,
        'Ergonomic mouse pad with ITelO Logo');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (33, 8.0, 'Designer Mousepad', 8,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1068.jpg', 12,
        'ITelO Mousepad Special Edition');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (34, 9.8, 'Universal card reader', 9,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1069.jpg', 14,
        'Universal card reader');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (35, 8.8, 'Proctra X', 10,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1070.jpg', 70,
        'Proctra X: PCI-E GDDR5 3072MB');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (36, 2.7, 'Gladiator MX', 10,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1071.jpg', 81,
        'Gladiator XLN: PCI-E GDDR5 3072MB DVI Out, TV Out low-noise');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (37, 8.4, 'Hurricane GX', 10,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1072.jpg', 101,
        'Hurricane GX: PCI-E 691 GFLOPS game-optimized');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (38, 7.0, 'Hurricane GX/LN', 10,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1073.jpg', 139,
        'Hurricane GX/LN: PCI-E 691 GFLOPS game-optimized, low-noise.');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (39, 10., 'Photo Scan', 11,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1080.jpg', 129,
        'Flatbed scanner - 9.600 × 9.600 dpi - 216 x 297 mm - Hi-Speed USB - Bluetooth');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (40, 7.8, 'Power Scan', 11,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1081.jpg', 89,
        'Flatbed scanner - 9.600 × 9.600 dpi - 216 x 297 mm - SCSI for backward compatibility');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (41, 9.7, 'Jet Scan Professional', 11,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1082.jpg', 169,
        'Flatbed scanner - Letter - 2400 dpi x 2400 dpi - 216 x 297 mm - add-on module');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (42, 9.7, 'Jet Scan Professional', 11,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1083.jpg', 189,
        'Flatbed scanner - A4 - 2400 dpi x 2400 dpi - 216 x 297 mm - add-on module');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (43, 8.2, 'Copymaster', 5,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1085.jpg', 1499,
        'Copymaster');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (44, 4.0, 'Surround Sound', 12,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1090.jpg', 39,
        'PC multimedia speakers - 5 Watt (Total)');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (45, 9.2, 'Blaster Extreme', 12,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1091.jpg', 26,
        'PC multimedia speakers - 10 Watt (Total) - 2-way');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (46, 6.4, 'Sound Booster', 12,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1092.jpg', 45,
        'PC multimedia speakers - optimized for Blutooth/A2DP');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (47, 6.9, 'Smart Office', 13,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1100.jpg', 89,
        'Complete package, 1 User, Office Applications (word processing, spreadsheet, presentations)');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (48, 1.4, 'Smart Design', 13,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1101.jpg', 79,
        'Complete package, 1 User, Image editing, processing');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (49, 1.1, 'Smart Network', 13,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1102.jpg', 69,
        'Complete package, 1 User, Network Software Utilities, Useful Applications and Documentation');
insert into product (product_id, weight, name, product_category_product_category_id, image, price, description)
values (50, 1.4, 'Smart Multimedia', 13,
        'https://sapui5.hana.ondemand.com/test-resources/sap/ui/documentation/sdk/images/HT-1103.jpg', 77,
        'Complete package, 1 User, different Multimedia applications, playing music, watching DVDs, only with this Smart package');

        insert into shop.adresa (id, city, country, street) values (1, 'Watuagung', 'Indonesia', '5 Meadow Valley Point');
        insert into shop.adresa (id, city, country, street) values (2, 'Ibirataia', 'Brazil', '86 Holy Cross Avenue');
        insert into shop.adresa (id, city, country, street) values (3, 'Bayt Ta‘mar', 'Palestinian Territory', '395 Ronald Regan Avenue');
        insert into shop.adresa (id, city, country, street) values (4, 'Borek', 'Poland', '45808 Vahlen Street');
        insert into shop.adresa (id, city, country, street) values (5, 'Mouzáki', 'Greece', '871 Bunker Hill Alley');
        insert into shop.adresa (id, city, country, street) values (6, 'Nangong', 'China', '662 Sherman Street');
        insert into shop.adresa (id, city, country, street) values (7, 'Mandalgovi', 'Mongolia', '43025 Kenwood Plaza');
        insert into shop.adresa (id, city, country, street) values (8, 'Bunog', 'Philippines', '269 Laurel Street');
        insert into shop.adresa (id, city, country, street) values (9, 'Jinji', 'China', '7834 Susan Pass');
        insert into shop.adresa (id, city, country, street) values (10, 'Sobotín', 'Czech Republic', '30 Erie Hill');
        insert into shop.adresa (id, city, country, street) values (11, 'Kabin Buri', 'Thailand', '652 Sheridan Pass');
        insert into shop.adresa (id, city, country, street) values (12, 'Buenos Aires', 'Peru', '731 Dwight Pass');
        insert into shop.adresa (id, city, country, street) values (13, 'Nezvěstice', 'Czech Republic', '6503 Parkside Circle');
        insert into shop.adresa (id, city, country, street) values (14, 'Paraíso', 'Portugal', '65706 Katie Point');
        insert into shop.adresa (id, city, country, street) values (15, 'Ngadri', 'Indonesia', '009 Moose Alley');
        insert into shop.adresa (id, city, country, street) values (16, 'Kasama', 'Japan', '0 Arrowood Lane');
        insert into shop.adresa (id, city, country, street) values (17, 'Khorramdarreh', 'Iran', '81 Monument Point');
        insert into shop.adresa (id, city, country, street) values (18, 'Cassilândia', 'Brazil', '548 Debra Terrace');
        insert into shop.adresa (id, city, country, street) values (19, 'Jebba', 'Nigeria', '6483 Daystar Trail');
        insert into shop.adresa (id, city, country, street) values (20, 'Emiliano Zapata', 'Mexico', '14 Southridge Alley');

        insert into shop.location (id, name, address_id) values (1, 'Kwinu', 1);
        insert into shop.location (id, name, address_id) values (2, 'Zoomzone', 2);
        insert into shop.location (id, name, address_id) values (3, 'Bluejam', 3);
        insert into shop.location (id, name, address_id) values (4, 'Yata', 4);
        insert into shop.location (id, name, address_id) values (5, 'Fivebridge', 5);
        insert into shop.location (id, name, address_id) values (6, 'Yakijo', 6);
        insert into shop.location (id, name, address_id) values (7, 'Avamm', 7);
        insert into shop.location (id, name, address_id) values (8, 'Pixoboo', 8);
        insert into shop.location (id, name, address_id) values (9, 'Photojam', 9);
        insert into shop.location (id, name, address_id) values (10, 'Zoomdog', 10);
        insert into shop.location (id, name, address_id) values (11, 'Devshare', 11);
        insert into shop.location (id, name, address_id) values (12, 'Wordpedia', 12);
        insert into shop.location (id, name, address_id) values (13, 'Gabtune', 13);
        insert into shop.location (id, name, address_id) values (14, 'Viva', 14);
        insert into shop.location (id, name, address_id) values (15, 'Meeveo', 15);
        insert into shop.location (id, name, address_id) values (16, 'Zoomdog', 16);
        insert into shop.location (id, name, address_id) values (17, 'Jayo', 17);
        insert into shop.location (id, name, address_id) values (18, 'Janyx', 18);
        insert into shop.location (id, name, address_id) values (19, 'Realbuzz', 19);
        insert into shop.location (id, name, address_id) values (20, 'Shufflebeat', 20);

insert into shop.stock (id, quantity, location_id, product_product_id) values (1, 67, 7, 14);
insert into shop.stock (id, quantity, location_id, product_product_id) values (2, 57, 14, 43);
insert into shop.stock (id, quantity, location_id, product_product_id) values (3, 63, 4, 45);
insert into shop.stock (id, quantity, location_id, product_product_id) values (4, 76, 20, 16);
insert into shop.stock (id, quantity, location_id, product_product_id) values (5, 80, 4, 27);
insert into shop.stock (id, quantity, location_id, product_product_id) values (6, 13, 4, 17);
insert into shop.stock (id, quantity, location_id, product_product_id) values (7, 98, 16, 44);
insert into shop.stock (id, quantity, location_id, product_product_id) values (8, 54, 10, 39);
insert into shop.stock (id, quantity, location_id, product_product_id) values (9, 51, 16, 6);
insert into shop.stock (id, quantity, location_id, product_product_id) values (10, 1, 16, 16);
insert into shop.stock (id, quantity, location_id, product_product_id) values (11, 100, 15, 23);
insert into shop.stock (id, quantity, location_id, product_product_id) values (12, 57, 7, 7);
insert into shop.stock (id, quantity, location_id, product_product_id) values (13, 9, 17, 43);
insert into shop.stock (id, quantity, location_id, product_product_id) values (14, 40, 10, 7);
insert into shop.stock (id, quantity, location_id, product_product_id) values (15, 92, 18, 22);
insert into shop.stock (id, quantity, location_id, product_product_id) values (16, 90, 8, 7);
insert into shop.stock (id, quantity, location_id, product_product_id) values (17, 17, 6, 14);
insert into shop.stock (id, quantity, location_id, product_product_id) values (18, 32, 7, 24);
insert into shop.stock (id, quantity, location_id, product_product_id) values (19, 91, 2, 5);
insert into shop.stock (id, quantity, location_id, product_product_id) values (20, 59, 14, 22);
insert into shop.stock (id, quantity, location_id, product_product_id) values (21, 15, 2, 25);
insert into shop.stock (id, quantity, location_id, product_product_id) values (22, 85, 6, 5);
insert into shop.stock (id, quantity, location_id, product_product_id) values (23, 51, 7, 34);
insert into shop.stock (id, quantity, location_id, product_product_id) values (24, 28, 4, 44);
insert into shop.stock (id, quantity, location_id, product_product_id) values (25, 86, 11, 35);
insert into shop.stock (id, quantity, location_id, product_product_id) values (26, 26, 10, 16);
insert into shop.stock (id, quantity, location_id, product_product_id) values (27, 95, 11, 48);
insert into shop.stock (id, quantity, location_id, product_product_id) values (28, 77, 4, 32);
insert into shop.stock (id, quantity, location_id, product_product_id) values (29, 13, 20, 43);
insert into shop.stock (id, quantity, location_id, product_product_id) values (30, 95, 5, 18);
insert into shop.stock (id, quantity, location_id, product_product_id) values (31, 15, 2, 2);
insert into shop.stock (id, quantity, location_id, product_product_id) values (32, 85, 6, 1);
insert into shop.stock (id, quantity, location_id, product_product_id) values (33, 51, 7, 4);
insert into shop.stock (id, quantity, location_id, product_product_id) values (34, 28, 4, 3);
insert into shop.stock (id, quantity, location_id, product_product_id) values (35, 86, 11, 20);
insert into shop.stock (id, quantity, location_id, product_product_id) values (36, 26, 10, 16);
insert into shop.stock (id, quantity, location_id, product_product_id) values (37, 95, 11, 48);
insert into shop.stock (id, quantity, location_id, product_product_id) values (38, 77, 4, 32);
insert into shop.stock (id, quantity, location_id, product_product_id) values (39, 13, 20, 43);

insert into roles (role_id, role_name) values (1,'Admin');
insert into roles (role_id, role_name) values (2,'Customer');
