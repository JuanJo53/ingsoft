-- Inserts for area table
INSERT INTO area VALUES (null, "Startup de tecnologia",now(),1,1,"192.168.1.1",1,now());
INSERT INTO area VALUES (null, "Videogames",now(),1,2,"192.168.1.1",2,now());

-- Inserts for bill table
INSERT INTO bill VALUES (null,1,1,1,1,now(),"c/Azul Nro. 123","Bolivia","Tarija",1,1,"192.168.1.1",1, now());
INSERT INTO bill VALUES (null,2,2,2,2,now(),"c/La Flores Nro. 968","Bolivia","La Paz",1,2,"192.168.1.1",2, now());

-- Inserts for card table
INSERT INTO card VALUES (null,1,"Tarjeta personal", 134568, 2020, 02,359,now(),1,1,"192.168.1.1",1, now());
INSERT INTO card VALUES (null,2,"Tarjeta Antonio", 123781, 2021, 04,242,now(),1,2,"192.168.1.1",2, now());

-- Inserts for certificate table
INSERT INTO certificate VALUES (null, 1, "Curso Python Basico", "Udemy","2015-02-10","2016-02-26","c9dd7d32e6548e9a3aa3669","https://udemy.com/@albert/certificados/curso-python",1,1,"192.168.1.1",1, now());
INSERT INTO certificate VALUES (null, 2, "Curso programacion en java", "edX","2018-12-10","2020-12-20","a8hh9j12h134s9sss0988","https://www.edx.org/es/certificados/programacion-en-java",1,2,"192.168.1.1",2, now());

-- Inserts for media table
INSERT INTO media VALUES (null,1,"Screenshot","http://photos.com/super.png",1,now(),1,1,"192.168.1.1",1,now());
INSERT INTO media VALUES (null,2,"Imagen de PROY","http://photos.com/image.png",1,now(),1 ,2,"192.168.1.1",2,now());

-- Inserts for notification table
INSERT INTO notification VALUES (null,1,1,"Nuevo interesado","Un usario esta interesado en tu proyecto",now(),2,1,"192.168.1.1",1, now());
INSERT INTO notification VALUES (null,2,1,"Pago de publicidad","Se vence el plazo para tu pago",now(),2,2,"192.168.1.1",1, now());

-- Inserts for payment_plan table
INSERT INTO payment_plan VALUES (null,"Plan 1","Plan por publicidad por un mes para tu proyecto",100.0,1,1,1,"192.168.1.1",1, now());
INSERT INTO payment_plan VALUES (null,"Plan 3","Plan por publicidad por dos meses para tu proyecto",250.0,2,1,2,"192.168.1.1",2, now());

-- Inserts for project_user table
INSERT INTO project_user VALUES (null,1,1,0,0,1,"192.168.1.1",1, now());
INSERT INTO project_user VALUES (null,2,2,0,0,2,"192.168.1.1",1, now());

-- Inserts for projects table
INSERT INTO projects VALUES (null,"Media Mart App","Aplicacion para obtener multimedia mas facilmente","Se requiere programador backend y programador frontend experimentados en tecnologias web","2% en acciones a los que se unan a nuestro equipo",0,"2010-11-11",1,1,"192.168.1.1",1, now());
INSERT INTO projects VALUES (null,"Arcade Videogames","Aplicacion para descargar juegos arcades","Se requiere programadores juniors","5% en acciones a los que se unan a nuestro equipo",0,"2019-12-04",1,2,"192.168.1.1",2, now());

-- Inserts for projects_area table
INSERT INTO projects_area VALUES (null,1,1);
INSERT INTO projects_area VALUES (null,2,2);

-- Inserts for projects_skills table
INSERT INTO projects_skills VALUES (null,1,1);
INSERT INTO projects_skills VALUES (null,2,2);

-- Inserts for projects_tags table
INSERT INTO projects_tags VALUES (null,1,1);
INSERT INTO projects_tags VALUES (null,2,2);

-- Inserts for skills table
INSERT INTO skills VALUES (null, "Programacion Backend con DJango",1,1,1,"192.168.1.1",1,now());
INSERT INTO skills VALUES (null, "Diseño de Interfaces Web",1,1,2,"192.168.1.1",2,now());

-- Inserts for tags table
INSERT INTO tags VALUES (null, "python",1,1,1,"192.168.1.1",1,now());
INSERT INTO tags VALUES (null, "java",2,1,2,"192.168.1.1",2,now());

-- Inserts for user table
INSERT INTO user VALUES (null, "Albert", "Molina", "@almola","moli147@gmail.com","c9dd7d32e8e9","estudiante de ingenieria","profile1.png","74569310",1,1,"192.168.1.1",1, now());
INSERT INTO user VALUES (null, "Lucas", "Gutierrez", "@aLuck","luck.gt@gmail.com","a8hh9j12h13h","estudiante","profile.png","60185633",1,2,"192.168.1.1",2, now());

-- Inserts for user_skill table
INSERT INTO user_skill VALUES (null,1,1);
INSERT INTO user_skill VALUES (null,2,2);

-- Inserts for user_tags table
INSERT INTO user_tags VALUES (null,1,1);
INSERT INTO user_tags VALUES (null,2,2);