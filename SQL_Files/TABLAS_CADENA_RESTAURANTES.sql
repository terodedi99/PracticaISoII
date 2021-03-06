--GESTION CADENA DE RESTAURANTES

--MODULO RESERVA DE MESAS

--TABLA DE PASES CON LOS VALORES POR DEFECTO
CREATE TABLE PASES (
	ID_PASE INTEGER,
	NOMBRE_PASE VARCHAR2(30),
	CONSTRAINT PK_PASES PRIMARY KEY (ID_PASE));

INSERT INTO PASES VALUES (1, 'COMIDA');
INSERT INTO PASES VALUES (2, 'CENA');

--TABLA DE TURNOS CON LOS VALORES POR DEFECTO
CREATE TABLE TURNOS (
	ID_TURNO INTEGER,
	NOMBRE_TURNO VARCHAR2(30),
	ID_PASE INTEGER,
	CONSTRAINT PK_TURNOS PRIMARY KEY (ID_TURNO),
	CONSTRAINT FK_TURNOS_PASE FOREIGN KEY (ID_PASE) REFERENCES PASES(ID_PASE));
	
INSERT INTO TURNOS VALUES (1, '13:00', 1);
INSERT INTO TURNOS VALUES (2, '14:00', 1);
INSERT INTO TURNOS VALUES (3, '15:00', 1);
INSERT INTO TURNOS VALUES (4, '21:00', 2);
INSERT INTO TURNOS VALUES (5, '22:00', 2);
INSERT INTO TURNOS VALUES (6, '23:00', 2);

--TABLA DE RESTAURANTES CON LOS VALORES POR DEFECTO
CREATE TABLE RESTAURANTES (
	ID_RESTAURANTE INTEGER,
	NOMBRE_RESTAURANTE VARCHAR2(40),
	DIRECCION VARCHAR2(60),
	CIUDAD VARCHAR2(60),
	CONSTRAINT PK_RESTAURANTES PRIMARY KEY (ID_RESTAURANTE));
	
INSERT INTO RESTAURANTES VALUES (1, 'COMIDAS 6 CREDITOS', 'c/ Alegria, 19', 'Ciudad Real');
INSERT INTO RESTAURANTES VALUES (2, 'COMIDAS PREMIUM', 'c/ Robledo, 30', 'Ciudad Real');
INSERT INTO RESTAURANTES VALUES (3, 'COMIDAS BUENAS', 'c/ Toledo, 25', 'Manzanares');

--TABLA DE MESAS CON LOS VALORES POR DEFECTO
CREATE TABLE MESAS (
	ID_MESA INTEGER,
	NOMBRE_MESA VARCHAR2(50),
	ID_RESTAURANTE INTEGER,
	CONSTRAINT PK_MESAS PRIMARY KEY (ID_MESA),
	CONSTRAINT FK_MESAS_RESTAURANTES FOREIGN KEY (ID_RESTAURANTE) REFERENCES RESTAURANTES(ID_RESTAURANTE));

INSERT INTO MESAS VALUES (1, 'MESA 1', 1);
INSERT INTO MESAS VALUES (2, 'MESA 2', 1);
INSERT INTO MESAS VALUES (3, 'MESA 3', 1);
INSERT INTO MESAS VALUES (4, 'MESA 4', 1);

INSERT INTO MESAS VALUES (5, 'MESA 1', 2);
INSERT INTO MESAS VALUES (6, 'MESA 2', 2);
INSERT INTO MESAS VALUES (7, 'MESA 3', 2);
INSERT INTO MESAS VALUES (8, 'MESA 4', 2);

INSERT INTO MESAS VALUES (9, 'MESA 1', 3);
INSERT INTO MESAS VALUES (10, 'MESA 2', 3);
INSERT INTO MESAS VALUES (11, 'MESA 3', 3);
INSERT INTO MESAS VALUES (12, 'MESA 4', 3);

--TABLA DE EMPLEADOS CON LOS VALORES POR DEFECTO
CREATE TABLE EMPLEADOS (
	ID_EMPLEADO INTEGER,
	DNI VARCHAR2(9),
	NOMBRE VARCHAR2(50),
	APELLIDOS VARCHAR2(70),
    PASS VARCHAR2(40),
	TFNO_CONTACTO NUMBER(9,0),
	ROL VARCHAR2(20),
	ID_RESTAURANTE INTEGER,
	CONSTRAINT PK_EMPLEADOS PRIMARY KEY (ID_EMPLEADO),
	CONSTRAINT FK_EMPLEADOS_RESTAURANTES FOREIGN KEY (ID_RESTAURANTE) REFERENCES RESTAURANTES (ID_RESTAURANTE),
    CONSTRAINT CK_EMPLEADOS_ROL CHECK (ROL IN ('CAMARERO','CAMARERO_BARRA','COCINERO','JEFE_DE_SALA','ALMACEN','DIRECTIVO')));


INSERT INTO EMPLEADOS VALUES (1, '11111111A', 'CAMARERO', '1', standard_hash('1234', 'MD5'), 926123456, 'CAMARERO', 1);
INSERT INTO EMPLEADOS VALUES (2, '22222222B', 'CAMARERO', '2', standard_hash('1234', 'MD5'), 926123457, 'CAMARERO', 1);
INSERT INTO EMPLEADOS VALUES (3, '33333333C', 'JEFE', 'DE SALA', standard_hash('1234', 'MD5'), 926123458, 'JEFE_DE_SALA', 1);
INSERT INTO EMPLEADOS VALUES (4, '44444444D', 'CAMARERO', 'DE BARRA', standard_hash('1234', 'MD5'), 926123459, 'CAMARERO_BARRA', 1);
INSERT INTO EMPLEADOS VALUES (5, '55555555E', 'COCINERO', '1', standard_hash('1234', 'MD5'), 926123450, 'COCINERO', 1);
INSERT INTO EMPLEADOS VALUES (6, '66666666F', 'ALMACEN', '1', standard_hash('1234', 'MD5'), 926123451, 'ALMACEN', 1);
INSERT INTO EMPLEADOS VALUES (7, '77777777G', 'DIRECTIVO', '1',  standard_hash('1234', 'MD5'), 926123452, 'DIRECTIVO', 1);

--TABLA DE SERVICIOS CON LOS VALORES POR DEFECTO
CREATE TABLE SERVICIOS (
	ID_SERVICIO INTEGER,
	FECHA_SERVICIO DATE,
	NUM_COMENSALES INTEGER,
	COMENTARIOS VARCHAR2(120),
	ESTADO VARCHAR2(20),
	ID_MESA INTEGER,
	ID_TURNO INTEGER,
	CONSTRAINT PK_SERVICIOS PRIMARY KEY (ID_SERVICIO),
	CONSTRAINT FK_SERVICIOS_MESAS FOREIGN KEY (ID_MESA) REFERENCES MESAS(ID_MESA),
	CONSTRAINT FK_SERVICIOS_TURNOS FOREIGN KEY (ID_TURNO) REFERENCES TURNOS(ID_TURNO),
    CONSTRAINT CK_SERVICIOS_ESTADO CHECK (ESTADO IN ('LIBRE','RESERVADA','OCUPADA','PIDIENDO','EN_ESPERA_DE_COMIDA','SERVIDOS','ESPERANDO_LA_CUENTA','PAGANDO','EN_PREPARACION','FINALIZADA'))
);

CREATE SEQUENCE SEQ_ID_SERVICIOS
    START WITH 1
    INCREMENT BY 1;

--TABLA DE SERVICIOS_CAMAREROS CON SECUENCIA
CREATE TABLE SERVICIOS_CAMAREROS (
	ID_SERVICIOS_CAMAREROS INTEGER,
	ID_SERVICIO INTEGER,
	ID_CAMARERO INTEGER,
	CONSTRAINT PK_SERVICIOS_CAMAREROS PRIMARY KEY (ID_SERVICIOS_CAMAREROS),
	CONSTRAINT FK_SC_SERVICIOS FOREIGN KEY (ID_SERVICIO) REFERENCES SERVICIOS (ID_SERVICIO),
	CONSTRAINT FK_SC_CAMAREROS FOREIGN KEY (ID_CAMARERO) REFERENCES EMPLEADOS (ID_EMPLEADO));
	
CREATE SEQUENCE SEQ_ID_SERVICIOS_CAMAREROS
	START WITH 1
	INCREMENT BY 1;
     
COMMIT;

--TABLA DE METODO PAGO
CREATE TABLE METODOS_PAGO (
	ID_METODO_PAGO INTEGER,
	DESCRIPCION_METODO VARCHAR2(50),
	CONSTRAINT PK_METODOS_PAGO PRIMARY KEY (ID_METODO_PAGO));
	
INSERT INTO METODOS_PAGO VALUES (1, 'EN EFECTIVO');
INSERT INTO METODOS_PAGO VALUES (2, 'TARJETA');

--TABLA DE COMANDAS CON SECUENCIA
CREATE TABLE COMANDAS (
	ID_COMANDA INTEGER,
	TOTAL NUMBER(10,2),
	PAGADO NUMBER(1,0),
	ID_SERVICIO INTEGER,
	CONSTRAINT PK_COMANDAS PRIMARY KEY (ID_COMANDA),
	CONSTRAINT FK_COMANDAS_SERVICIOS FOREIGN KEY (ID_SERVICIO) REFERENCES SERVICIOS (ID_SERVICIO));

CREATE SEQUENCE SEQ_ID_COMANDA
	START WITH 1
	INCREMENT BY 1;
	
--TABLA DE COMANDAS_METODOS_PAGO
CREATE TABLE COMANDAS_METODOS_PAGO (
	ID_COMANDAS_METODOS_PAGO INTEGER,
	ID_COMANDA INTEGER,
	ID_METODO_PAGO INTEGER,
	CONSTRAINT PK_ID_COMANDAS_METODOS_PAGO PRIMARY KEY (ID_COMANDAS_METODOS_PAGO),
	CONSTRAINT FK_COMANDAS_METODOS_ID_COMANDA FOREIGN KEY (ID_COMANDA) REFERENCES COMANDAS (ID_COMANDA),
	CONSTRAINT FK_COMANDAS_METODOS_ID_METODO_PAGO FOREIGN KEY (ID_METODO_PAGO) REFERENCES METODOS_PAGO (ID_METODO_PAGO));

CREATE SEQUENCE SEQ_ID_COMANDAS_METODOS_PAGO
	START WITH 1
	INCREMENT BY 1;

--TABLA DE INGREDIENTES
CREATE TABLE INGREDIENTES (
	ID_INGREDIENTE INTEGER,
	DESCRIPCION_INGREDIENTE VARCHAR2(80),
	CANTIDAD NUMBER(38,2),
	UNIDAD VARCHAR2(20),
	STOCK_IDEAL NUMBER(38,2),
	CONSTRAINT PK_INGREDIENTES PRIMARY KEY (ID_INGREDIENTE));

INSERT INTO INGREDIENTES VALUES (1, 'CERVEZA', 50, 'LITROS', 10);
INSERT INTO INGREDIENTES VALUES (2, 'VINO YUNTERO 1 L', 50, 'BOTELLAS', 5);
INSERT INTO INGREDIENTES VALUES (3, 'BOTELLA AGUA 1.5 L', 50, 'BOTELLAS', 5);
INSERT INTO INGREDIENTES VALUES (4, 'POLLO', 10, 'KG', 1);
INSERT INTO INGREDIENTES VALUES (5, 'PATATAS', 30, 'KG', 3);
INSERT INTO INGREDIENTES VALUES (6, 'TERNERA', 25, 'KG', 4);
INSERT INTO INGREDIENTES VALUES (7, 'BACALAO', 15, 'KG', 1);
INSERT INTO INGREDIENTES VALUES (8, 'HELADO NATA', 15, 'LITROS', 3);
INSERT INTO INGREDIENTES VALUES (9, 'TARTA CHOCOLATE', 20, 'PORCIONES', 4);
INSERT INTO INGREDIENTES VALUES (10,'HUEVOS', 96, 'UNIDADES', 24);
INSERT INTO INGREDIENTES VALUES (11,'MIGA DE PAN', 5, 'KG', 1);
INSERT INTO INGREDIENTES VALUES (12,'FIDEOS', 5, 'KG', 1);
INSERT INTO INGREDIENTES VALUES (13,'ESPAGUETIS', 6, 'KG', 2);
	
-- TABLA DE PRODUCTOS
CREATE TABLE PRODUCTOS (
	ID_PRODUCTO INTEGER,
	DESCRIPCION_PRODUCTO VARCHAR2(80),
	TIPO_PRODUCTO VARCHAR2(80),
	PRECIO NUMBER(38,2),
	CONSTRAINT PK_PRODUCTOS PRIMARY KEY (ID_PRODUCTO),
	CONSTRAINT CK_TIPO_PRODUCTO CHECK (TIPO_PRODUCTO IN ('BEBIDA','PRIMER PLATO','SEGUNDO PLATO','POSTRE')));
	
INSERT INTO PRODUCTOS VALUES (1, 'JARRA DE CERVEZA', 'BEBIDA', 3.50);
INSERT INTO PRODUCTOS VALUES (2, 'BOTELLA VINO YUNTERO', 'BEBIDA', 5.95);
INSERT INTO PRODUCTOS VALUES (3, 'AGUA 1.5 L', 'BEBIDA', 2.00);
INSERT INTO PRODUCTOS VALUES (4, 'POLLO EMPANADO CON PATATAS', 'SEGUNDO PLATO', 6.25);
INSERT INTO PRODUCTOS VALUES (5, 'HAMBURGUESA CON HUEVO Y PATATAS','SEGUNDO PLATO', 7.50);
INSERT INTO PRODUCTOS VALUES (6, 'BACALAO A LA PLANCHA','SEGUNDO PLATO', 8.00);
INSERT INTO PRODUCTOS VALUES (7, 'HELADO CON SIROPE', 'POSTRE', 3.50);
INSERT INTO PRODUCTOS VALUES (8, 'TROZO DE TARTA DE CHOCOLATE', 'POSTRE', 4.00);
INSERT INTO PRODUCTOS VALUES (9, 'CALDO DE POLLO CON FIDEOS', 'PRIMER PLATO', 3.50);
INSERT INTO PRODUCTOS VALUES (10,'ESPAGUETIS A LA BOLOÑESA', 'PRIMER PLATO', 4.50);
	
-- TABLA DE PRODUCTOS INGREDIENTES
CREATE TABLE ELABORACIONES (
	ID_ELABORACION INTEGER,
	ID_PRODUCTO INTEGER,
	ID_INGREDIENTE INTEGER,
	CANTIDAD_ELABORACION NUMBER(38,2),
	CONSTRAINT PK_ELABORACIONES PRIMARY KEY (ID_ELABORACION),
    CONSTRAINT FK_ELABORACIONES_PRODUCTOS FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO),
    CONSTRAINT FK_ELABORACIONES_INGREDIENTES FOREIGN KEY (ID_INGREDIENTE) REFERENCES INGREDIENTES(ID_INGREDIENTE));
	
CREATE SEQUENCE SEQ_ID_ELABORACION
	START WITH 1
	INCREMENT BY 1;

INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 1, 1, 0.5);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 2, 2, 1);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 3, 3, 1);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 4, 4, 0.25);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 4, 5, 0.20);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 4, 10, 2);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 4, 11, 0.25);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 5, 6, 0.25);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 5, 10, 1);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 5, 5, 0.20);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 6, 7, 0.4);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 7, 8, 0.25);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 8, 9, 1);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 9, 4, 0.5);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 9, 12, 0.25);
INSERT INTO ELABORACIONES VALUES (SEQ_ID_ELABORACION.NEXTVAL, 10, 13, 0.25);

-- TABLA DE LINEAS COMANDAS
CREATE TABLE LINEAS_COMANDAS (
	ID_LINEA_COMANDA INTEGER,
	CANTIDAD INTEGER,
	PRECIOVENTA NUMBER(38,2),
	SERVIDO INTEGER,
	ID_COMANDA INTEGER,
	ID_PRODUCTO INTEGER,
	CONSTRAINT PK_ID_LINEA_COMANDA PRIMARY KEY (ID_LINEA_COMANDA),
	CONSTRAINT FK_LINEAS_COMANDA_ID_COMANDA FOREIGN KEY (ID_COMANDA) REFERENCES COMANDAS (ID_COMANDA),
	CONSTRAINT FK_LINEAS_COMANDA_ID_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS (ID_PRODUCTO));
	
CREATE SEQUENCE SEQ_ID_LINEA_COMANDA
	START WITH 1
	INCREMENT BY 1;
	
ALTER TABLE INGREDIENTES DROP COLUMN CANTIDAD;

CREATE TABLE INGREDIENTES_RESTAURANTES (
	ID_INGREDIENTES_RESTAURANTES INTEGER,
	ID_INGREDIENTE INTEGER,
	ID_RESTAURANTE INTEGER,
	CANTIDAD NUMBER(38,2),
	CONSTRAINT PK_INGREDIENTES_RESTAURANTES PRIMARY KEY (ID_INGREDIENTES_RESTAURANTES),
	CONSTRAINT FK_INGREDIENTES_RESTAURANTES_ID_INGREDIENTE FOREIGN KEY (ID_INGREDIENTE) REFERENCES INGREDIENTES (ID_INGREDIENTE),
	CONSTRAINT FK_INGREDIENTES_RESTAURANTES_ID_RESTAURANTE FOREIGN KEY (ID_RESTAURANTE) REFERENCES RESTAURANTES (ID_RESTAURANTE));
	
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (1, 1, 1, 50);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (2, 2, 1, 50);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (3, 3, 1, 50);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (4, 4, 1, 10);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (5, 5, 1, 30);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (6, 6, 1, 25);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (7, 7, 1, 15);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (8, 8, 1, 15);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (9, 9, 1, 20);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (10, 10, 1, 96);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (11, 11, 1, 5);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (12, 12, 1, 5);
INSERT INTO INGREDIENTES_RESTAURANTES VALUES (13, 13, 1, 6);

CREATE TABLE ESTADISTICAS (
    ID_ESTADISTICA INTEGER,
    ID_SERVICIO INTEGER,
    ESTADO VARCHAR2(20),
    FECHA_CAMBIO DATE,
    CONSTRAINT PK_ESTADISTICAS PRIMARY KEY (ID_ESTADISTICA),
    CONSTRAINT FK_ESTADISTICAS_SERVICIOS FOREIGN KEY (ID_SERVICIO) REFERENCES SERVICIOS (ID_SERVICIO));

CREATE SEQUENCE SEQ_ID_ESTADISTICA
    START WITH 1
    INCREMENT BY 1;
	
CREATE OR REPLACE VIEW TIEMPO_TOMA_COMANDAS AS
    SELECT S.ID_SERVICIO "ID_SERVICIO", S.ID_MESA "ID_MESA", (E.FECHA_CAMBIO - (SELECT E1.FECHA_CAMBIO FROM ESTADISTICAS E1 WHERE E1.ESTADO = 'PIDIENDO' AND E1.ID_SERVICIO = E.ID_SERVICIO))/S.NUM_COMENSALES "TOMA_COMANDAS"
        FROM ESTADISTICAS E, SERVICIOS S
        WHERE E.ESTADO = 'EN_ESPERA_DE_COMIDA' 
            AND E.ID_SERVICIO = S.ID_SERVICIO;

CREATE OR REPLACE VIEW TIEMPO_PREPARACION_COMIDA AS  
SELECT S.ID_SERVICIO "ID_SERVICIO", S.ID_MESA "ID_MESA", (E.FECHA_CAMBIO - (SELECT E1.FECHA_CAMBIO FROM ESTADISTICAS E1 WHERE E1.ESTADO = 'EN_ESPERA_DE_COMIDA' AND E1.ID_SERVICIO = E.ID_SERVICIO))/S.NUM_COMENSALES "PREPARACION_COMIDA"
        FROM ESTADISTICAS E, SERVICIOS S
        WHERE E.ESTADO = 'SERVIDOS' 
            AND E.ID_SERVICIO = S.ID_SERVICIO;

CREATE OR REPLACE VIEW TIEMPO_ENTREGA_NOTA AS
SELECT S.ID_SERVICIO "ID_SERVICIO", S.ID_MESA "ID_MESA", (E.FECHA_CAMBIO - (SELECT E1.FECHA_CAMBIO FROM ESTADISTICAS E1 WHERE E1.ESTADO = 'ESPERANDO_LA_CUENTA' AND E1.ID_SERVICIO = E.ID_SERVICIO))/S.NUM_COMENSALES "ENTREGA_NOTA"
        FROM ESTADISTICAS E, SERVICIOS S
        WHERE E.ESTADO = 'PAGANDO' 
            AND E.ID_SERVICIO = S.ID_SERVICIO;

CREATE OR REPLACE VIEW TIEMPO_PREPARACION_MESA AS          
SELECT S.ID_SERVICIO "ID_SERVICIO", S.ID_MESA "ID_MESA", (E.FECHA_CAMBIO - (SELECT E1.FECHA_CAMBIO FROM ESTADISTICAS E1 WHERE E1.ESTADO = 'EN_PREPARACION' AND E1.ID_SERVICIO = E.ID_SERVICIO))/S.NUM_COMENSALES "PREPARACION_MESA"
        FROM ESTADISTICAS E, SERVICIOS S
        WHERE E.ESTADO = 'FINALIZADA' 
            AND E.ID_SERVICIO = S.ID_SERVICIO;

COMMIT;