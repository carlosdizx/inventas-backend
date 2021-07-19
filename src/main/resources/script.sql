INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles (nombre) VALUES ('ROLE_USER');

INSERT INTO usuarios (password, habilitado, username,nombres,apellidos,celular) VALUES ('$2a$10$tbQ3uxIa6kdEgg3jX5z8IuBZpze5fcOWNLZjOfG8uimrT57MVt2ly',true,'admin','Don Carlos','Díaz',3163930876);
INSERT INTO usuarios (password, habilitado, username,nombres,apellidos,celular) VALUES ('$2a$10$ru4fk//smz.PhkaU3wzAjux8rsPh.BA/mIeM6hWNY6eGKMf20L37e',true,'carlos','Carlos','Díaz',3165772023);

INSERT INTO roleados (usuario_id, rol_id) VALUES (1,1);
INSERT INTO roleados (usuario_id, rol_id) VALUES (1,2);
INSERT INTO roleados (usuario_id, rol_id) VALUES (2,2);

INSERT INTO clientes (celular, documento, fecha, nombres) VALUES('3000xxxxx',2222222,'2000-01-1','Cliente 22');
INSERT INTO clientes (celular, documento, fecha, nombres) VALUES('3163930876',1082749257,'1998-01-13','Carlos Díaz');
INSERT INTO clientes (celular, documento, fecha, nombres) VALUES('3165772023',27156864,'1974-09-26','Jackeline Basante');

INSERT INTO productos (fecha, nombre, precio_compra, precio_venta) VALUES (now(),'Salchipapa BBQ',6000,8000);
INSERT INTO productos (fecha, nombre, precio_compra, precio_venta) VALUES (now(),'Salchipapa Mixta',6500,9000);
INSERT INTO productos (fecha, nombre, precio_compra, precio_venta) VALUES (now(),'Perro caliente sencillo',4000,5500);
INSERT INTO productos (fecha, nombre, precio_compra, precio_venta) VALUES (now(),'Gasesosa cigarra 500ml',1200,1800);
INSERT INTO productos (fecha, nombre, precio_compra, precio_venta) VALUES (now(),'Jugo Hit 450ml',1500,2200);

