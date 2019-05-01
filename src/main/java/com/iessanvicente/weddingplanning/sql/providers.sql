CREATE TABLE proveedores (
  id int( 11 ) NOT NULL AUTO_INCREMENT,
  nombre varchar( 50 ) DEFAULT NULL,
  direccion varchar( 50 ) DEFAULT NULL,
  poblacion varchar( 50 ) DEFAULT NULL,
  provincia varchar( 50 ) DEFAULT NULL,
  cp varchar( 10 ) DEFAULT NULL,
  telefono varchar( 25 ) DEFAULT NULL,
  movil varchar( 25 ) DEFAULT NULL,
  email varchar( 50 ) DEFAULT NULL,
  password varchar( 50 ) DEFAULT NULL,
  cif varchar( 10 ) DEFAULT NULL,
  PRIMARY KEY ( id )
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8