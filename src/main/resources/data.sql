INSERT INTO peliculas(ID, NOMBRE, FECHA_ESTRENO, STOCK, STOCK_INICIAL, IMAGE_URL, SINOPSIS)
VALUES (10, 'Matrix', '21/05/1999', 7, 7, 'https://imgc.allpostersimages.com/img/print/u-g-F4S5W20.jpg?w=550&h=550&p=0', 'La película plantea que en el futuro, casi todos los seres humanos han sido esclavizados, tras una dura guerra, por las máquinas y las inteligencias artificiales creadas.');

INSERT INTO peliculas(ID, NOMBRE, FECHA_ESTRENO, STOCK, STOCK_INICIAL, IMAGE_URL, SINOPSIS)
VALUES (20, 'Matrix Reloaded', '07/05/2003', 7,  8,'https://images-na.ssl-images-amazon.com/images/I/51ewJPAhObL._AC_.jpg', 'La película comienza por mostrar a Trinity, quien está realizando una misión en la cual es asesinada por uno de los agentes quien esta persiguiéndola.');

INSERT INTO peliculas(ID, NOMBRE, FECHA_ESTRENO, STOCK, STOCK_INICIAL, IMAGE_URL, SINOPSIS)
VALUES (30, 'Matrix Revolutions', '27/10/2003', 10, 10, 'https://i.pinimg.com/originals/50/ed/ab/50edab75986d7a1a1020f517c6e5b662.jpg', 'Siguiendo los hechos de The Matrix Reloaded: la flota de Sion destruida casi por completo (solo quedan dos naves, la Hammer y la Logos).');

INSERT INTO peliculas(ID, NOMBRE, FECHA_ESTRENO, STOCK, STOCK_INICIAL, IMAGE_URL, SINOPSIS)
VALUES (40, 'Wonder Woman 1984', '10/05/2020', 4, 4, 'https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/93303.jpg', 'En el actual París, Diana recibe una placa fotográfica de Empresas Wayne de ella y cuatro hombres tomados durante la Primera Guerra Mundial.');

INSERT INTO peliculas(ID, NOMBRE, FECHA_ESTRENO, STOCK, STOCK_INICIAL, IMAGE_URL, SINOPSIS)
VALUES (50, 'Justice League The Snyder cut', '07/10/2020', 2, 2, 'https://i1.wp.com/plexmx.info/wp-content/uploads/2020/05/SnyderCutJL_5ec57ded842c44.35138827.jpg?ssl=1', 'Hace miles de años, el conquistador planetario Steppenwolf y sus legiones de Parademonios, criaturas con forma de múrcielago, alimentadas por miedo, intentaron apoderarse de la Tierra.');


INSERT INTO alquiler(ID, ID_PELICULA, FECHA_DEVOLUCION, VALOR_ALQUILER, ESTADO_ALQUILER)
VALUES (105, 20, '21/10/2020', 5000, 'A');

