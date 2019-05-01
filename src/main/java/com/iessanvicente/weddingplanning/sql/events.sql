CREATE TABLE proyectobd.eventos (
  id int( 11 ) NOT NULL AUTO_INCREMENT,
  nombre varchar( 50 ) DEFAULT NULL,
  fecha int( 11 ) DEFAULT NULL,
  activo tinyint( 1 ) DEFAULT 0,
  PRIMARY KEY ( id )
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8