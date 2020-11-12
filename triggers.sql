--Triggers for payment_plan
delimiter |
CREATE TRIGGER tr_h_payment_plan
AFTER INSERT ON payment_plan
for each row
BEGIN
	Insert into `h_payment_plan` (`payment_plan_id`,`plan`,`description`,`cost`,`duration`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.payment_plan_id,new.plan,new.description,new.cost,new.duration,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

delimiter |
CREATE TRIGGER tr_h_update_payment_plan
AFTER UPDATE ON payment_plan
for each row
BEGIN
Insert into `h_payment_plan` (`payment_plan_id`,`plan`,`description`,`cost`,`duration`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.payment_plan_id, new.plan,new.description,new.cost,new.duration,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

--Triggers for bill
delimiter |
CREATE  TRIGGER tr_h_bill
AFTER INSERT  ON bill
for each row
BEGIN
    Insert into `h_bill` (`bill_id`,`user_id`,`payment_plan_id`,`card_id`,`projects_id`,`buy_date`,`billing_address`,`country`,`city`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.bill_id, new.user_id,new.payment_plan_id,new.card_id,new.projects_id,new.buy_date,new.billing_address,new.country,new.city,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

--Triggers for card
delimiter |
CREATE  TRIGGER tr_h_card
AFTER INSERT  ON card
for each row
BEGIN
    Insert into `h_card` (`card_id`,`user_id`,`card_name`,`card_number`,`expiration_year`,`expiration_month`,`CVC`,`creation_date`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.card_id, new.user_id,new.card_name,new.card_number,new.expiration_year,new.expiration_month,new.CVC,new.creation_date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

delimiter |
CREATE TRIGGER tr_h_update_card
AFTER UPDATE ON card
for each row
BEGIN
	    Insert into `h_card` (`card_id`,`user_id`,`card_name`,`card_number`,`expiration_year`,`expiration_month`,`CVC`,`creation_date`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.card_id, new.user_id,new.card_name,new.card_number,new.expiration_year,new.expiration_month,new.CVC,new.creation_date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

--Triggers for certificate
delimiter |
CREATE TRIGGER tr_h_certificate
AFTER INSERT ON certificate
for each row
BEGIN
	Insert into `h_certificate` (`certificate_id`,`user_id`,`certificate_name`,`company`,`expedition_date`,`expiration_date`,`credential_id`,`credential_url`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.certificate_id, new.user_id,new.certificate_name,new.company,new.expedition_date,new.expiration_date,new.credential_id,new.credential_url,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

delimiter |
CREATE TRIGGER tr_h_update_certificate
AFTER UPDATE ON certificate
for each row
BEGIN
	Insert into `h_certificate` (`certificate_id`,`user_id`,`certificate_name`,`company`,`expedition_date`,`expiration_date`,`credential_id`,`credential_url`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.certificate_id, new.user_id,new.certificate_name,new.company,new.expedition_date,new.expiration_date,new.credential_id,new.credential_url,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

--Triggers for project_user
delimiter |
CREATE TRIGGER tr_h_project_user
AFTER INSERT ON project_user
for each row
BEGIN
    Insert into h_project_user (proyect_user_id,user_id,projects_id,rol,status,tx_id,tx_host,tx_user_id,tx_date)
    values(new.project_user_id, new.user_id,new.projects_id,new.rol
    ,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);

END;
|
delimiter ;

delimiter |
CREATE TRIGGER tr_update_h_project_user
AFTER UPDATE ON project_user
for each row
BEGIN
    Insert into h_project_user (proyect_user_id,user_id,projects_id,rol,status,tx_id,tx_host,tx_user_id,tx_date)
    values(new.project_user_id, new.user_id,new.projects_id,new.rol
    ,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);

END;
|
delimiter ;

--Triggers for user

delimiter |
CREATE TRIGGER tr_h_user
AFTER INSERT ON user
for each row
BEGIN
    Insert into h_user (user_id,name,surname,username,email,password,description,image,cellphone,tx_id,tx_host,tx_user_id,tx_date)
    values(new.user_id, new.name,new.surname,new.username,new.email,new.password,new.description,new.image,new.cellphone,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);

END;
|
delimiter ;

delimiter |
CREATE TRIGGER tr_update_h_user
AFTER UPDATE ON user
for each row
BEGIN
    Insert into h_user (user_id,name,surname,username,email,password,description,image,cellphone,tx_id,tx_host,tx_user_id,tx_date)
    values(new.user_id, new.name,new.surname,new.username,new.email,new.password,new.description,new.image,new.cellphone,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);

END;
|
delimiter ;
