INSERT INTO cliente VALUES ("0001","sebas@email.com",0,"2022/05/05","sebas","passw1","ruta");
INSERT INTO cliente VALUES ("0002","santiago@email.com",1,"2022/05/05","santiago","passw2","ruta");
INSERT INTO cliente VALUES ("0003","ana@email.com",0,"2022/05/05","ana","passw3","ruta");
INSERT INTO cliente VALUES ("0004","elizabeth@email.com",1,"2022/05/05","elizabeth","passw4","ruta");
INSERT INTO cliente VALUES ("0005","carlos@email.com",0,"2022/05/05","carlos","passw5","ruta");

INSERT INTO telefono VALUES ("3126641882","0001");
INSERT INTO telefono VALUES ("3186641882","0001");
INSERT INTO telefono VALUES ("3108810158","0002");
INSERT INTO telefono VALUES ("3215489556","0003");
INSERT INTO telefono VALUES ("3005464546","0004");
INSERT INTO telefono VALUES ("3115466798","0005");

INSERT INTO ciudad values (1,"Armenia");
INSERT INTO ciudad values (2,"Pereira");
INSERT INTO ciudad values (3,"Manizales");
INSERT INTO ciudad values (4,"Bogota");
INSERT INTO ciudad values (5,"Cali");
INSERT INTO ciudad values (6,"Medellin");

INSERT INTO administrador values ("1","sara@email.com","sara123");
INSERT INTO administrador values ("2","daniel@email.com","dn123");
INSERT INTO administrador values ("3","maria@email.com","maria123");
INSERT INTO administrador values ("4","roberto@email.com","roberto123");
INSERT INTO administrador values ("5","sebas@email.com","sebas123");



INSERT INTO administrador_teatro values ("5","juana@email.com","jinua23");
INSERT INTO administrador_teatro values ("6","jorge@email.com","jotg123");
INSERT INTO administrador_teatro values ("7","angel@email.com","anh231");
INSERT INTO administrador_teatro values ("8","sonia@email.com","soinia123");
INSERT INTO administrador_teatro values ("9","raquel@email.com","raquel123");


INSERT INTO pelicula values ("1",1,"amor prohibido","leonardo dicaprio,ana maria celis","pelicula para adultos","rutaimg","rutatrailer");
INSERT INTO pelicula values ("2",1,"rapidos y furiosos","luis fonseca,roberta","pelicula para la familia ","rutaimg","rutatrailer");
INSERT INTO pelicula values ("3",1,"sacry movie","carlos,ana","pelicula para reir en familia","rutaimg","rutatrailer");
INSERT INTO pelicula values ("4",1,"anabelle","jenniffer,sara","pelicula para no poder dormir","rutaimg","rutatrailer");
INSERT INTO pelicula values ("5",1,"anabelle y chuky","jenniffer,sara","pelicula para no poder dormir","rutaimg","rutatrailer");

INSERT INTO pelicula_generos values (1,"ACCION");
INSERT INTO pelicula_generos values (2,"COMEDIA");
INSERT INTO pelicula_generos values (3,"ACCION");
INSERT INTO pelicula_generos values (4,"ROMANTICA");
INSERT INTO pelicula_generos values (5,"TERROR");

INSERT INTO horario values ("1","sabado","2022/05/05","7:00","2022/05/05");
INSERT INTO horario values ("2","lunes","2022/05/05","10:00","2022/05/05");
INSERT INTO horario values ("3","martes","2022/05/05","3:00","2022/05/05");
INSERT INTO horario values ("4","viernes","2022/05/05","4:00","2022/05/05");
INSERT INTO horario values ("5","sabado","2022/05/05","10:00","2022/05/05");


INSERT INTO silla values ("1","1","esq","1","12000.0");
INSERT INTO silla values ("2","3","esq","2","11000.0");
INSERT INTO silla values ("3","4","esq","1","11000.0");
INSERT INTO silla values ("4","1","eqs","4","12000.0");
INSERT INTO silla values ("5","2","eqs","1","10000.0");


INSERT INTO teatro values (1,"calle 15 #12-33","teatro1","3117641882",5,1);
INSERT INTO teatro values (2,"calle 11 #12-3","teatro2","3006641882",6,1);
INSERT INTO teatro values (3,"calle 1 #11-23","teatro3","3126691882",7,4);
INSERT INTO teatro values (4,"calle 3 #1-22","teatro4","3006689882",8,5);
INSERT INTO teatro values (5,"calle 2 #6-23","teatro5","3006679882",9,6);


INSERT INTO sala values ("1","sala1","1","1");
INSERT INTO sala values ("2","sala2","2","2");
INSERT INTO sala values ("3","sala3","3","3");
INSERT INTO sala values ("4","sala4","4","4");
INSERT INTO sala values ("5","sala5","5","5");


INSERT INTO funcion values (1,1,1,1);
INSERT INTO funcion values (2,2,2,2);
INSERT INTO funcion values (3,3,3,3);
INSERT INTO funcion values (4,4,4,4);
INSERT INTO funcion values (5,5,4,4);


INSERT INTO compra values (1,"2022/05/21","MASTERCARD","50000","0001","1");
INSERT INTO compra values (2,"2022/04/08","PSE","60000","0002","2");
INSERT INTO compra values (3,"2022/06/05","VISA","30000","0001","4");
INSERT INTO compra values (4,"2022/01/23","VISA","50000","0004","1");
INSERT INTO compra values (5,"2022/01/11","PSE","50000","0004","5");


INSERT INTO confiteria values (1,"combo dos crispetas dos gaseosas","combo amigos",25000,"urlimagen");
INSERT INTO confiteria values (2,"chocolatina jumbo grande con mani","jumbo",5000,"urlimagen");
INSERT INTO confiteria values (3,"crispeta mediana salada","crispeta mediana",11000,"urlimagen");
INSERT INTO confiteria values (4,"combo dos perros dos gaseosas","combo perruno",20000,"urlimagen");
INSERT INTO confiteria values (5,"combo dos hamburguesas dos gaseosas","combo h",11000,"urlimagen");


INSERT INTO compra_confiteria values (1,50000,2,1,1);
INSERT INTO compra_confiteria values (2,30000,3,2,2);
INSERT INTO compra_confiteria values (3,30000,1,3,3);
INSERT INTO compra_confiteria values (4,50000,1,4,4);
INSERT INTO compra_confiteria values (5,12500,4,5,5);


INSERT INTO cupon values (1,"valido hasta el 20 de diciembre","15%","activo","2022/12/20");
INSERT INTO cupon values (2,"valido hasta el 30 de diciembre","55%","activo","2022/12/30");
INSERT INTO cupon values (3,"valido hasta el 1 de octubre","5%","activo","2022/01/10");
INSERT INTO cupon values (4,"valido hasta el 2 de noviembre","10%","activo","2022/02/11");
INSERT INTO cupon values (5,"valido hasta el 11 de noviembre","11%","activo","2022/06/9");


INSERT INTO cupon_cliente values (1,"activo","0001",1,4);
INSERT INTO cupon_cliente values (2,"activo","0002",2,2);
INSERT INTO cupon_cliente values (3,"activo","0003",3,2);
INSERT INTO cupon_cliente values (4,"activo","0004",4,1);
INSERT INTO cupon_cliente values (5,"activo","0005",5,5);


INSERT INTO entrada values (1,1,1);
INSERT INTO entrada values (2,2,2);
INSERT INTO entrada values (3,3,3);
INSERT INTO entrada values (4,4,4);
INSERT INTO entrada values (5,5,5);


















