-- Inserts for area table
INSERT INTO area VALUES (null, "Startup de tecnologia",now());
INSERT INTO area VALUES (null, "Videogames",now());

-- Inserts for bill table
INSERT INTO bill VALUES (null,1,1,1,1,now(),"c/Azul Nro. 123","Bolivia","Tarija",1,"192.168.1.1",1, now());
INSERT INTO bill VALUES (null,2,2,2,2,now(),"c/La Flores Nro. 968","Bolivia","La Paz",2,"192.168.1.1",2, now());

-- Inserts for card table
INSERT INTO card VALUES (null,1,"Tarjeta personal", 13456898453, 2020, 02, "Juan", "Perez",359,now(),1,"192.168.1.1",1, now());
INSERT INTO card VALUES (null,2,"Tarjeta Antonio", 12378964521, 2021, 04, "Antonio", "Rodriguez",242,now(),2,"192.168.1.1",2, now());

-- Inserts for certificate table
INSERT INTO certificate VALUES (null, 1, "Curso Python Basico", "Udemy","10-02-2015","c9dd7d32e6548e9a3aa3669","https://udemy.com/@albert/certificados/curso-python",now(),1,1,"192.168.1.1",1, now());
INSERT INTO certificate VALUES (null, 2, "Curso programacion en java", "edX","10-12-2018","a8hh9j12h134s9sss0988","https://www.edx.org/es/certificados/programacion-en-java",1,now(),2,"192.168.1.1",2, now());

-- Inserts for media table
INSERT INTO media VALUES (null,1,1,"http://photos.com/super.png", 2,now());
INSERT INTO media VALUES (null,2,2,"http://photos.com/image.png", 2,now());

-- Inserts for notification table
INSERT INTO notification VALUES (null,1,now(),"Nuevo interesado","Un usario esta interesado en tu proyecto",5);
INSERT INTO notification VALUES (null,2,now(),"Pago de publicidad","Se vence el plazo para tu pago",5);

-- Inserts for payment_plan table
INSERT INTO payment_plan VALUES (null,"Plan 1","Plan por publicidad por un mes para tu proyecto",100.0,5,now(),1,"192.168.1.1",1, now());
INSERT INTO payment_plan VALUES (null,"Plan 3","Plan por publicidad por un año para tu proyecto",250.0,6,now(),1,"192.168.1.1",1, now());

-- Inserts for project_user table
INSERT INTO project_user VALUES (null,1,1,0,0,1,"192.168.1.1",1, now());
INSERT INTO project_user VALUES (null,2,2,0,0,2,"192.168.1.1",1, now());

-- Inserts for projects table
INSERT INTO projects VALUES (null,"Media Mart App","Aplicacion para obtener multimedia mas facilmente","Se requiere programador backend y programador frontend experimentados en tecnologias web","2% en acciones a los que se unan a nuestro equipo",0,0,now(),1,"192.168.1.1",1, now());
INSERT INTO projects VALUES (null,"Arcade Videogames","Aplicacion para descargar juegos arcades","Se requiere programadores juniors","5% en acciones a los que se unan a nuestro equipo",0,0,now(),1,"192.168.1.1",1, now());

-- Inserts for projects_area table
INSERT INTO projects_area VALUES (null,1,1);
INSERT INTO projects_area VALUES (null,2,2);

-- Inserts for projects_tags table
INSERT INTO projects_tags VALUES (null,1,1);
INSERT INTO projects_tags VALUES (null,2,2);

-- Inserts for tags table
INSERT INTO tags VALUES (null, "python",1);
INSERT INTO tags VALUES (null, "java",2);

-- Inserts for user table
INSERT INTO user VALUES (null, "Albert", "Molina", "@almola","moli147@gmail.com","c9dd7d32e8e9a3aa3669","","","",1,"192.168.1.1",1, now());
INSERT INTO user VALUES (null, "Lucas", "Gutierrez", "@aLuck","luck.gt@gmail.com","a8hh9j12h134s9sss0988","","","",1,"192.168.1.1",1, now());

-- Inserts for user_tags table
INSERT INTO user_tags VALUES (null,1,1);
INSERT INTO user_tags VALUES (null,2,2);
