--Triggers for payment_plan
delimiter |
CREATE TRIGGER tr_h_payment_plan
AFTER INSERT ON payment_plan
for each row
BEGIN
	Insert into `h_payment_plan` (`payment_plan_id`,`plan`,`description`,`cost`,`duration`,`creation_date`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.payment_plan_id, new.plan,new.description,new.cost,new.duration,new.creation_date,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

delimiter |
CREATE TRIGGER tr_h_update_payment_plan
AFTER UPDATE ON payment_plan
for each row
BEGIN
Insert into `h_payment_plan` (`payment_plan_id`,`plan`,`description`,`cost`,`duration`,`creation_date`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.payment_plan_id, new.plan,new.description,new.cost,new.duration,new.creation_date,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

--Triggers for certificate
delimiter |
CREATE TRIGGER tr_h_certificate
AFTER INSERT ON certificate
for each row
BEGIN
	Insert into `h_certificate` (`certificate_id`,`user_id`,`name`,`company`,`expedition_date`,`credential_id`,`credential_url`,`expiration_date`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.certificate_id, new.user_id,new.name,new.company,new.expedition_date,new.credential_id,new.credential_url,new.expiration_date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

delimiter |
CREATE TRIGGER tr_h_update_certificate
AFTER UPDATE ON certificate
for each row
BEGIN
	Insert into `h_certificate` (`certificate_id`,`user_id`,`name`,`company`,`expedition_date`,`credential_id`,`credential_url`,`expiration_date`,`status`,`tx_id`,`tx_host`,`tx_user_id`,`tx_date`) values(new.certificate_id, new.user_id,new.name,new.company,new.expedition_date,new.credential_id,new.credential_url,new.expiration_date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
delimiter ;

--Triggers for project_user
delimiter |
CREATE TRIGGER tr_h_project_user
AFTER INSERT ON project_user
for each row
BEGIN
    Insert into h_project_user (project_user_id,user_id,projects_id,rol,status,tx_id,tx_host,tx_user_id,tx_date)
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
    Insert into h_project_user (project_user_id,user_id,projects_id,rol,status,tx_id,tx_host,tx_user_id,tx_date)
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
