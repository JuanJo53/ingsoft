-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-10-29 18:57:41.489

-- tables
-- Table: area
CREATE TABLE area (
    area_id int NOT NULL AUTO_INCREMENT,
    name_area varchar(50) NOT NULL,
    creation_date date NOT NULL,
    CONSTRAINT area_pk PRIMARY KEY (area_id)
);

-- Table: bill
CREATE TABLE bill (
    bill_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    payment_plan_id int NOT NULL,
    card_id int NOT NULL,
    projects_id int NOT NULL,
    date date NOT NULL,
    billing_address varchar(50) NOT NULL,
    country varchar(20) NOT NULL,
    city varchar(20) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT bill_pk PRIMARY KEY (bill_id)
);

-- Table: card
CREATE TABLE card (
    card_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    card_name varchar(20) NOT NULL,
    card_number int NOT NULL,
    expiration_year int NOT NULL,
    expiration_month int NOT NULL,
    user_name varchar(50) NOT NULL,
    user_surname varchar(50) NOT NULL,
    CVC int NOT NULL,
    creation_date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT card_pk PRIMARY KEY (card_id)
);

-- Table: certificate
CREATE TABLE certificate (
    certificate_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    name varchar(100) NOT NULL,
    company varchar(200) NOT NULL,
    expedition_date date NOT NULL,
    credential_id varchar(100) NOT NULL,
    credential_url varchar(200) NOT NULL,
    date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT certificate_pk PRIMARY KEY (certificate_id)
);

-- Table: h_bill
CREATE TABLE h_bill (
    h_bill_id int NOT NULL AUTO_INCREMENT,
    bill_id int NOT NULL,
    user_id int NOT NULL,
    payment_plan_id int NOT NULL,
    card_id int NOT NULL,
    projects_id int NOT NULL,
    date date NOT NULL,
    billing_address varchar(50) NOT NULL,
    country varchar(20) NOT NULL,
    city varchar(20) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_bill_pk PRIMARY KEY (h_bill_id)
);

-- Table: h_card
CREATE TABLE h_card (
    h_card_id int NOT NULL AUTO_INCREMENT,
    card_id int NOT NULL,
    user_id int NOT NULL,
    card_name varchar(20) NOT NULL,
    card_number int NOT NULL,
    expiration_year int NOT NULL,
    expiration_month int NOT NULL,
    user_name varchar(50) NOT NULL,
    user_surname varchar(50) NOT NULL,
    CVC int NOT NULL,
    creation_date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_card_pk PRIMARY KEY (h_card_id)
);

-- Table: h_certificate
CREATE TABLE h_certificate (
    h_certificate_id int NOT NULL AUTO_INCREMENT,
    certificate_id int NOT NULL,
    user_id int NOT NULL,
    name varchar(100) NOT NULL,
    company varchar(200) NOT NULL,
    expedition_date date NOT NULL,
    credential_id varchar(100) NOT NULL,
    credential_url varchar(200) NOT NULL,
    date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_certificate_pk PRIMARY KEY (h_certificate_id)
);

-- Table: h_payment_plan
CREATE TABLE h_payment_plan (
    h_payment_plan_id int NOT NULL AUTO_INCREMENT,
    payment_plan_id int NOT NULL,
    plan varchar(50) NOT NULL,
    description text NOT NULL,
    cost numeric(10,4) NOT NULL,
    duration int NOT NULL,
    creation_date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_payment_plan_pk PRIMARY KEY (h_payment_plan_id)
);

-- Table: h_project_user
CREATE TABLE h_project_user (
    h_proyect_user_id int NOT NULL AUTO_INCREMENT,
    proyect_user_id int NOT NULL,
    user_id int NOT NULL,
    projects_id int NOT NULL,
    rol int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_project_user_pk PRIMARY KEY (h_proyect_user_id)
);

-- Table: h_projects
CREATE TABLE h_projects (
    h_projects_id int NOT NULL AUTO_INCREMENT,
    projects_id int NOT NULL,
    project_title varchar(50) NOT NULL,
    description text NOT NULL,
    abilities varchar(200) NOT NULL,
    benefits text NOT NULL,
    views int NOT NULL,
    status int NOT NULL,
    create_date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_projects_pk PRIMARY KEY (h_projects_id)
);

-- Table: h_user
CREATE TABLE h_user (
    h_user_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    username varchar(20) NOT NULL,
    email varchar(60) NOT NULL,
    password varchar(20) NOT NULL,
    description text NULL,
    image varchar(200) NULL,
    cellphone varchar(20) NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_user_pk PRIMARY KEY (h_user_id)
) COMMENT 'LLave primaria de la tabla user';

-- Table: media
CREATE TABLE media (
    media_id int NOT NULL AUTO_INCREMENT,
    projects_id int NOT NULL,
    status int NOT NULL,
    url varchar(200) NOT NULL,
    type int NOT NULL,
    creation_date date NOT NULL,
    CONSTRAINT media_pk PRIMARY KEY (media_id)
);

-- Table: notification
CREATE TABLE notification (
    notification_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    date timestamp NOT NULL,
    title varchar(20) NOT NULL,
    message varchar(50) NOT NULL,
    status int NOT NULL COMMENT '0: UNSEEN
1: SEEN',
    CONSTRAINT notification_pk PRIMARY KEY (notification_id)
);

-- Table: payment_plan
CREATE TABLE payment_plan (
    payment_plan_id int NOT NULL AUTO_INCREMENT,
    plan varchar(50) NOT NULL,
    description text NOT NULL,
    cost numeric(10,4) NOT NULL,
    duration int NOT NULL,
    creation_date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT payment_plan_pk PRIMARY KEY (payment_plan_id)
);

-- Table: project_user
CREATE TABLE project_user (
    project_user_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    projects_id int NOT NULL,
    rol int NOT NULL COMMENT '1: OWNER
2: PARTICIPANT',
    status int NOT NULL COMMENT '0: PUBLIC
1: PRIVATE
2: DELETED
3: ARCHIVED
',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT project_user_pk PRIMARY KEY (project_user_id)
);

-- Table: projects
CREATE TABLE projects (
    projects_id int NOT NULL AUTO_INCREMENT,
    project_title varchar(50) NOT NULL,
    description text NOT NULL,
    abilities varchar(200) NOT NULL,
    benefits text NOT NULL,
    views int NOT NULL,
    status int NOT NULL COMMENT '0: PUBLIC
1: PRIVATE
2: DELETED
3: ARCHIVED',
    create_date date NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT projects_pk PRIMARY KEY (projects_id)
);

-- Table: projects_area
CREATE TABLE projects_area (
    projects_area_id int NOT NULL AUTO_INCREMENT,
    area_id int NOT NULL,
    projects_id int NOT NULL,
    CONSTRAINT projects_area_pk PRIMARY KEY (projects_area_id)
);

-- Table: projects_tags
CREATE TABLE projects_tags (
    projects_tags_id int NOT NULL AUTO_INCREMENT,
    tags_id int NOT NULL,
    projects_id int NOT NULL,
    CONSTRAINT projects_tags_pk PRIMARY KEY (projects_tags_id)
);

-- Table: tags
CREATE TABLE tags (
    tags_id int NOT NULL AUTO_INCREMENT,
    name_tags varchar(20) NOT NULL,
    verified int NOT NULL COMMENT '0: UNVERIFIED
1: VERIFIED',
    CONSTRAINT tags_pk PRIMARY KEY (tags_id)
);

-- Table: transaction
CREATE TABLE transaction (
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_ud int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (tx_id)
);

-- Table: user
CREATE TABLE user (
    user_id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    username varchar(20) NOT NULL,
    email varchar(60) NOT NULL,
    password varchar(20) NOT NULL,
    description text NULL,
    image varchar(200) NULL,
    cellphone varchar(20) NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
) COMMENT 'LLave primaria de la tabla user';

-- Table: user_tags
CREATE TABLE user_tags (
    user_tags_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    tags_id int NOT NULL,
    CONSTRAINT user_tags_pk PRIMARY KEY (user_tags_id)
);

-- foreign keys
-- Reference: Bill_User (table: bill)
ALTER TABLE bill ADD CONSTRAINT Bill_User FOREIGN KEY Bill_User (user_id)
    REFERENCES user (user_id);

-- Reference: Certificate_User (table: certificate)
ALTER TABLE certificate ADD CONSTRAINT Certificate_User FOREIGN KEY Certificate_User (user_id)
    REFERENCES user (user_id);

-- Reference: bill_card (table: bill)
ALTER TABLE bill ADD CONSTRAINT bill_card FOREIGN KEY bill_card (card_id)
    REFERENCES card (card_id);

-- Reference: bill_payment_plan (table: bill)
ALTER TABLE bill ADD CONSTRAINT bill_payment_plan FOREIGN KEY bill_payment_plan (payment_plan_id)
    REFERENCES payment_plan (payment_plan_id);

-- Reference: bill_projects (table: bill)
ALTER TABLE bill ADD CONSTRAINT bill_projects FOREIGN KEY bill_projects (projects_id)
    REFERENCES projects (projects_id);

-- Reference: card_user (table: card)
ALTER TABLE card ADD CONSTRAINT card_user FOREIGN KEY card_user (user_id)
    REFERENCES user (user_id);

-- Reference: media_projects (table: media)
ALTER TABLE media ADD CONSTRAINT media_projects FOREIGN KEY media_projects (projects_id)
    REFERENCES projects (projects_id);

-- Reference: notification_user (table: notification)
ALTER TABLE notification ADD CONSTRAINT notification_user FOREIGN KEY notification_user (user_id)
    REFERENCES user (user_id);

-- Reference: projects_area_projects (table: projects_area)
ALTER TABLE projects_area ADD CONSTRAINT projects_area_projects FOREIGN KEY projects_area_projects (projects_id)
    REFERENCES projects (projects_id);

-- Reference: projects_tags_projects (table: projects_tags)
ALTER TABLE projects_tags ADD CONSTRAINT projects_tags_projects FOREIGN KEY projects_tags_projects (projects_id)
    REFERENCES projects (projects_id);

-- Reference: projects_tags_tags (table: projects_tags)
ALTER TABLE projects_tags ADD CONSTRAINT projects_tags_tags FOREIGN KEY projects_tags_tags (tags_id)
    REFERENCES tags (tags_id);

-- Reference: proyect_user_projects (table: project_user)
ALTER TABLE project_user ADD CONSTRAINT proyect_user_projects FOREIGN KEY proyect_user_projects (projects_id)
    REFERENCES projects (projects_id);

-- Reference: proyect_user_user (table: project_user)
ALTER TABLE project_user ADD CONSTRAINT proyect_user_user FOREIGN KEY proyect_user_user (user_id)
    REFERENCES user (user_id);

-- Reference: user_area_area (table: projects_area)
ALTER TABLE projects_area ADD CONSTRAINT user_area_area FOREIGN KEY user_area_area (area_id)
    REFERENCES area (area_id);

-- Reference: user_tags_tags (table: user_tags)
ALTER TABLE user_tags ADD CONSTRAINT user_tags_tags FOREIGN KEY user_tags_tags (tags_id)
    REFERENCES tags (tags_id);

-- Reference: user_tags_user (table: user_tags)
ALTER TABLE user_tags ADD CONSTRAINT user_tags_user FOREIGN KEY user_tags_user (user_id)
    REFERENCES user (user_id);

-- End of file.

-- Inserts for area table
INSERT INTO area VALUES (null, "Startup de tecnologia",now());

-- Inserts for bill table
INSERT INTO bill VALUES (null,1,1,1,1,now(),"c/Azul Nro. 123","Bolivia","Tarija",1,"192.168.1.1",1, now());

-- Inserts for card table
INSERT INTO card VALUES (null,1,"Tarjeta personal", 13456898453, 2020, 02, "Juan", "Perez",359,now(),1,"192.168.1.1",1, now());

-- Inserts for certificate table
INSERT INTO certificate VALUES (null, 1, "Curso Python Basico", "Udemy","10-02-2015","c9dd7d32e6548e9a3aa3669","https://udemy.com/@albert/certificados/curso-python",now(),1,"192.168.1.1",1, now());

-- Inserts for media table
INSERT INTO media VALUES (null,1,1,"http://photos.com/super.png", 2,now());

-- Inserts for notification table
INSERT INTO notification VALUES (null,1,now(),"Nuevo interesado","Un usario esta interesado en tu proyecto",5);

-- Inserts for payment_plan table
INSERT INTO payment_plan VALUES (null,"Plan 1","Plan por publicidad por un mes para tu proyecto",100.0,5,now(),1,"192.168.1.1",1, now());

-- Inserts for project_user table
INSERT INTO project_user VALUES (null,1,1,0,0,1,"192.168.1.1",1, now());

-- Inserts for projects table
INSERT INTO projects VALUES (null,"Media Mart App","Aplicacion para obtener multimedia mas facilmente","Se requiere programador backend y programador frontend experimentados en tecnologias web","2% en acciones a los que se unan a nuestro equipo",0,0,now(),1,"192.168.1.1",1, now());

-- Inserts for projects_area table
INSERT INTO projects_area VALUES (null,1,1);

-- Inserts for projects_tags table
INSERT INTO projects_tags VALUES (null,1,1);

-- Inserts for tags table
INSERT INTO tags VALUES (null, "python",1);

-- Inserts for user table
INSERT INTO user VALUES (null, "Albert", "Molina", "@almola","moli147@gmail.com","c9dd7d32e8e9a3aa3669","","","",1,"192.168.1.1",1, now());

-- Inserts for user_tags table
INSERT INTO user_tags VALUES (null,1,1);




