INSERT IGNORE INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (1,'ppm');
INSERT IGNORE INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (2,'cmol/kg');
INSERT IGNORE INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (3,'kg/ha');
INSERT IGNORE INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (4,'%')
;
INSERT IGNORE INTO elementos VALUES (1, 'Nitr�geno', 14.006, 5); 
INSERT IGNORE INTO elementos VALUES (2, 'F�sforo', 30.973, 5);
INSERT IGNORE INTO elementos VALUES (3, 'Potasio', 39.102, 1);
INSERT IGNORE INTO elementos VALUES (4, 'Calcio', 40.08, 2);
INSERT IGNORE INTO elementos VALUES (5, 'Magnesio', 24.312, 2);
INSERT IGNORE INTO elementos VALUES (6, 'Azufre', 32.064, 6);
INSERT IGNORE INTO elementos VALUES (7, 'Boro', 10.811, 3);
INSERT IGNORE INTO elementos VALUES (8, 'Cobre', 63.54, 1);
INSERT IGNORE INTO elementos VALUES (9, 'Hierro', 55.847, 3);
INSERT IGNORE INTO elementos VALUES (10, 'Manganeso', 54.938, 3);
INSERT IGNORE INTO elementos VALUES (11, 'Molibdeno', 95.94, 6);
INSERT IGNORE INTO elementos VALUES (12, 'Zinc', 65.37, 2);

INSERT IGNORE INTO rol (`rol_codigo`,`rol_nombre`,`rol_estado`, `rol_tipo`) VALUES (1,'Administrador',false, 'ROLE_ADMIN');
INSERT IGNORE INTO rol (`rol_codigo`,`rol_nombre`,`rol_estado`, `rol_tipo`) VALUES (2,'Productor',true, 'ROLE_USER');
INSERT IGNORE INTO rol (`rol_codigo`,`rol_nombre`,`rol_estado`, `rol_tipo`) VALUES (3,'Almacenista',true, 'ROLE_USER');

INSERT IGNORE INTO Usuario_Seguridad (`id_usuario`, `nombre_usuario`,`password`,`estado`,`codigorol`) VALUES(1, 'Administrador', '$2a$10$OErv.iLt03pww2NcIyTgWu3kmUc5mapfOzrNTdEae9KKFfYOw.Kqa', true, 1);


