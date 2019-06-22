MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (1,'Aguacate','Bacon',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (2,'Aguacate','Carmen',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (3,'Aguacate','Ettinguer',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (4,'Aguacate','Fuerte',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (5,'Aguacate','Hass',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (6,'Aguacate','Lamb Hass',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (7,'Aguacate','Pinkerton',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (8,'Aguacate','Reed',true);
MERGE INTO tipo_cultivo (`cul_codigo`,`cul_nombre`,`cul_variedad`,`cul_estado`) VALUES (9,'Aguacate','Zutano',true);

MERGE INTO rol (`rol_codigo`,`rol_nombre`,`rol_estado`, `rol_tipo`) VALUES (1,'Administrador',true, 'ROLE_ADMIN');
MERGE INTO rol (`rol_codigo`,`rol_nombre`,`rol_estado`, `rol_tipo`) VALUES (2,'Productor',true, 'ROLE_USER');
MERGE INTO rol (`rol_codigo`,`rol_nombre`,`rol_estado`, `rol_tipo`) VALUES (3,'Almacenista',true, 'ROLE_USER');

Merge INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (1,'ppm');
Merge INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (2,'cmol/kg');
Merge INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (3,'kg/ha');
Merge INTO unidad(`uni_codigo`, `uni_nombre`) VALUES (4,'%');


MERGE INTO elementos VALUES (1, 'Nitr�geno', 14.006, 5); 
MERGE INTO elementos VALUES (2, 'F�sforo', 30.973, 5);
MERGE INTO elementos VALUES (3, 'Potasio', 39.102, 1);
MERGE INTO elementos VALUES (4, 'Calcio', 40.08, 2);
MERGE INTO elementos VALUES (5, 'Magnesio', 24.312, 2);
MERGE INTO elementos VALUES (6, 'Azufre', 32.064, 6);
MERGE INTO elementos VALUES (7, 'Boro', 10.811, 3);
MERGE INTO elementos VALUES (8, 'Cobre', 63.54, 1);
MERGE INTO elementos VALUES (9, 'Hierro', 55.847, 3);
MERGE INTO elementos VALUES (10, 'Manganeso', 54.938, 3);
MERGE INTO elementos VALUES (11, 'Molibdeno', 95.94, 6);
MERGE INTO elementos VALUES (12, 'Zinc', 65.37, 2); 
MERGE INTO requerimiento VALUES (1, 12.8, 1, true, 2, 3);
MERGE INTO requerimiento VALUES (2, 14, 1, true, 1, 3);
MERGE INTO requerimiento VALUES (3, 3.5, 1, true, 3, 3);
MERGE INTO tipo_fuente VALUES (1, 14.8, 1, 'true', 'Nitritos', 3);
MERGE INTO tipo_fuente VALUES (2, 13, 2, 'true', 'cloruro de potasio', 3);
MERGE INTO fuente VALUES (1, 1, true, 'Triple 15');
MERGE INTO fuente VALUES (2, 2, true, 'Cloruro');

MERGE INTO fuente VALUES (2, 2, true, 'Cloruro');
MERGE INTO usuario VALUES(1036926701, 'Sanchez', 1,'juan.sanchez@ceiba.com.co', 'Juan', 'juan123',6148084);
MERGE INTO usuario VALUES(1047969124, 'Alarcon', 1,'jessica.alarcon@ceiba.com.co', 'Jessica', 'jessica123',3233986371);
MERGE INTO analisis VALUES(1,1, Sysdate);
MERGE INTO parcela VALUES(1,10000,1,1,Sysdate);
MERGE INTO lugar VALUES(1,1036926701,'La Honda', 'Rio abajo');
MERGE INTO elementoxanalisis VALUES(1,4,1,1,1);
MERGE INTO elementoxanalisis VALUES(2,6,1,2,2);
MERGE INTO elementoxanalisis VALUES(3,8,1,3,1);
MERGE INTO recomendacion VALUES(1, 1, Sysdate);
MERGE INTO fuentexrecomendacion VALUES(1, 23.0, 1, 1, 1);
MERGE INTO Usuario_Seguridad (`id_usuario`, `nombre_usuario`,`password`,`estado`,`codigorol`) VALUES(1, 'Administrador', '$2a$10$OErv.iLt03pww2NcIyTgWu3kmUc5mapfOzrNTdEae9KKFfYOw.Kqa', true, 1);
MERGE INTO Usuario_Seguridad (`id_usuario`, `nombre_usuario`,`password`,`estado`,`codigorol`) VALUES(2, 1047969124, '$2a$10$Hn49HhvxMX.NWuyQM5iJ6.511X/g6f0fL0R3GJ4Wv0hrbn5J8ExQ.', true, 2);
