INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO roles (nombre) VALUES ('ROLE_USER');

INSERT INTO usuarios (password, habilitado, username) VALUES ('$2a$10$tbQ3uxIa6kdEgg3jX5z8IuBZpze5fcOWNLZjOfG8uimrT57MVt2ly',true,'admin');
INSERT INTO usuarios (password, habilitado, username) VALUES ('$2a$10$ru4fk//smz.PhkaU3wzAjux8rsPh.BA/mIeM6hWNY6eGKMf20L37e',true,'carlos');

INSERT INTO roleados (usuario_id, rol_id) VALUES (1,1);
INSERT INTO roleados (usuario_id, rol_id) VALUES (1,2);
INSERT INTO roleados (usuario_id, rol_id) VALUES (2,2);

INSERT INTO clientes (celular, documento, fecha, nombres) VALUES('3163930876',1082749257,'1998-01-13','Carlos Díaz');
INSERT INTO clientes (celular, documento, fecha, nombres) VALUES('3165772023',27156864,'1974-09-26','Jackeline Basante');