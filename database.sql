-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-11-10 20:37:35.827

-- tables
-- Table: area
CREATE TABLE area (
    area_id int NOT NULL AUTO_INCREMENT,
    name_area varchar(50) NOT NULL,
    creation_date date NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT area_pk PRIMARY KEY (area_id)
);

-- Table: bill
CREATE TABLE bill (
    bill_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    payment_plan_id int NOT NULL,
    card_id int NOT NULL,
    projects_id int NOT NULL,
    buy_date date NOT NULL,
    billing_address varchar(50) NULL,
    country varchar(20) NOT NULL,
    city varchar(20) NOT NULL,
    status int NOT NULL,
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
    CVC int NOT NULL,
    creation_date date NOT NULL,
    status int NOT NULL,
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
    certificate_name varchar(100) NOT NULL,
    company varchar(200) NOT NULL,
    expedition_date date NOT NULL,
    expiration_date date NULL,
    credential_id varchar(100) NOT NULL,
    credential_url varchar(200) NOT NULL,
    status int NOT NULL,
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
    buy_date date NOT NULL,
    billing_address varchar(50) NULL,
    country varchar(20) NOT NULL,
    city varchar(20) NOT NULL,
    status int NOT NULL,
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
    CVC int NOT NULL,
    creation_date date NOT NULL,
    status int NOT NULL,
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
    certificate_name varchar(100) NOT NULL,
    company varchar(200) NOT NULL,
    expedition_date date NOT NULL,
    expiration_date date NOT NULL,
    credential_id varchar(100) NOT NULL,
    credential_url varchar(200) NOT NULL,
    status int NOT NULL,
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
    description text NULL,
    cost numeric(10,4) NOT NULL,
    duration int NOT NULL,
    status int NOT NULL,
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
    abilities varchar(200) NULL,
    benefits text NULL,
    views int NOT NULL,
    create_date date NOT NULL,
    status int NOT NULL,
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
    status int NOT NULL,
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
    url varchar(200) NOT NULL,
    type int NOT NULL,
    creation_date date NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT media_pk PRIMARY KEY (media_id)
);

-- Table: notification
CREATE TABLE notification (
    notification_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    title varchar(20) NOT NULL,
    message varchar(50) NOT NULL,
    date timestamp NOT NULL,
    status int NOT NULL COMMENT '0: UNSEEN
1: SEEN',
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT notification_pk PRIMARY KEY (notification_id)
);

-- Table: payment_plan
CREATE TABLE payment_plan (
    payment_plan_id int NOT NULL AUTO_INCREMENT,
    plan varchar(50) NOT NULL,
    description text NULL,
    cost numeric(10,4) NOT NULL,
    duration int NOT NULL,
    status int NOT NULL,
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
    abilities varchar(200) NULL,
    benefits text NULL,
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
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT tags_pk PRIMARY KEY (tags_id)
);

-- Table: transaction
CREATE TABLE transaction (
    tx_id int NOT NULL AUTO_INCREMENT,
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
    status int NOT NULL,
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

