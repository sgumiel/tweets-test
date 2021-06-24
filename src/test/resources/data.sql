CREATE TABLE IF NOT EXISTS user (
   id IDENTITY,
   name VARCHAR(30) NOT NULL,
   followers INT NOT NULL
);

CREATE TABLE IF NOT EXISTS tweet (
   id IDENTITY,
   user_id BIGINT NOT NULL,
   text VARCHAR(500) NOT NULL,
   lang VARCHAR(10) NOT NULL,
   longitude BIGINT,
   latitude BIGINT,
   validated BOOLEAN NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS hashtag (
    id IDENTITY,
    tag VARCHAR(135) NOT NULL,
    occurrences INT NOT NULL
);

INSERT INTO USER VALUES(8077212, 'FACUA', 269880);
INSERT INTO USER VALUES(14878835, 'Poprosa', 8317); 
INSERT INTO USER VALUES(23791197, 'Policia nacional', 3528907);
INSERT INTO USER VALUES(27890913, 'El Referente', 19119);           
INSERT INTO USER VALUES(31090827, '20minutos.es', 1451347);         
INSERT INTO USER VALUES(49474003, 'Abel Arandanos', 40722);
INSERT INTO USER VALUES(833109559, 'Gonzoo', 33984);
INSERT INTO USER VALUES(863433547, 'Un poco pesao', 3713);

INSERT INTO TWEET VALUES(1407999416011796481, 31090827, 'Aqu\u00ed tienes las opciones en las que hemos pensado \u00bfcu\u00e1l es tu favorito?  Te leemos \ud83e\uddd0\nhttps://t.co/TdotFEG9nt', 'es', NULL, NULL, FALSE);          
INSERT INTO TWEET VALUES(1408000259675103235, 49474003, 'Seguimos para bingo\n#GetReady #HolaQueTal https://t.co/lkmyqKGVBD', 'es', NULL, NULL, FALSE);               
INSERT INTO TWEET VALUES(1408000593604513795, 31090827, '\ud83e\udd14 #Opiniones | Actos debidos: \"Juan Carlos I y Felipe VI han sancionado algunas leyes cuyo contenido no les ha agradado individualmente a buen seguro (...), leyes aprobadas por derecha e izquierda con contenido antit\u00e9tico\". https://t.co/viwGn4kUbj Por @mariogarcessan', 'es', NULL, NULL, FALSE);    
INSERT INTO TWEET VALUES(1408000852158263297, 31090827, 'Se llamar\u00e1 #MadresParalelas y estar\u00e1 protagonizado por Pen\u00e9lope Cruz, Aitana S\u00e1nchez-Gij\u00f3n y Milena Smit https://t.co/UFMARDhXdE', 'es', NULL, NULL, FALSE);        
INSERT INTO TWEET VALUES(1408001703698321415, 23791197, '#egosurfing, \u00bfsabes qu\u00e9 es?\n\nConsiste en saber qu\u00e9 se dice de ti en #internet para que puedas proteger tu #huelladigital\n\nSi hay informaci\u00f3n en la #red sobre ti que no quieres que est\u00e9 publicada sigue estos pasos\ud83d\udc47\n\nhttps://t.co/mjCzTe9fFp', 'es', NULL, NULL, FALSE);         
INSERT INTO TWEET VALUES(1408002089490563076, 31090827, 'Investigan un brote de covid-19 entre alumnos vascos que fueron de viaje de fin de curso a Mallorca https://t.co/kt6yyQgOQ3', 'es', NULL, NULL, FALSE);    
INSERT INTO TWEET VALUES(1408002467279867905, 31090827, 'El \u00c1ngeles Alvari\u00f1o encuentra en el mar dos objetos que podr\u00edan ser de Tom\u00e1s, el padre de las ni\u00f1as de Tenerife https://t.co/NEzJ6jzc6Q https://t.co/2fd9HvYDdp', 'es', NULL, NULL, FALSE);         
INSERT INTO TWEET VALUES(1408003124506288134, 14878835, 'El programa ''Pasapalabra'', se\u00f1alado por maltratar a su p\u00fablico: \"Solo 9 euros por 13 horas, es denigrante\" https://t.co/BRbIuJNPnB https://t.co/DPEhMzJWuD', 'es', NULL, NULL, FALSE);         
INSERT INTO TWEET VALUES(1408003630918029313, 31090827, 'Expertos dudan si con el 70% vacunado habr\u00e1 inmunidad de grupo: \"Se basa m\u00e1s en la log\u00edstica que en la epidemiolog\u00eda\" https://t.co/1DVtBqLzyW', 'es', NULL, NULL, FALSE);              
INSERT INTO TWEET VALUES(1408005218550362112, 31090827, 'El titular sobre croquetas y las desternillantes reacciones que arrasan en las redes https://t.co/Q4rJq6Epbd', 'es', NULL, NULL, FALSE);   
INSERT INTO TWEET VALUES(1408006264823627783, 31090827, 'El emperador de Jap\u00f3n, preocupado por los posibles contagios en los Juegos Ol\u00edmpicos https://t.co/jW7L6HsJFn', 'es', NULL, NULL, FALSE);           
INSERT INTO TWEET VALUES(1408006836075253760, 14878835, 'El mene\u00edto de caderas de Lara \u00c1lvarez con \"papi\" en el descanso de ''Supervivientes'' que ha hipnotizado a todo Instagram https://t.co/WdCXjaVedE https://t.co/XEgXBNMNoh', 'es', NULL, NULL, FALSE);            
INSERT INTO TWEET VALUES(1408006848498876418, 31090827, '\u2b55\ufe0f#AMPLIACI\u00d3N | Encuentran en el fondo del mar dos botellas de ox\u00edgeno que podr\u00edan ser de Tom\u00e1s, el padre de las ni\u00f1as de Tenerife https://t.co/NEzJ6jzc6Q', 'es', NULL, NULL, FALSE);    
INSERT INTO TWEET VALUES(1408006901821022208, 27890913, '#Actualidad\ud83d\udcf0 \n\n@Health20Basque abre #convocatoria para que #startups e instituciones sanitarias presenten sus proyectos de innovaci\u00f3n en el XVII Congreso de la Sociedad Espa\u00f1ola del Dolor\n\n\ud83d\uddd3Plazo de presentaci\u00f3n finaliza el 20 de septiembre.\n\n\ud83d\udccdInfo\u2b07\ufe0f\nhttps://t.co/gxp7jl6rm2', 'es', NULL, NULL, FALSE);              
INSERT INTO TWEET VALUES(1408007200283496448, 863433547, 'RT @tableroglobal: EXCLUSIVA | Los comisarios JAG, Olivera y Villarejo ofrecieron a los imputados en G\u00fcrtel anular el caso por 12 millones\u2026', 'es', NULL, NULL, FALSE);           
INSERT INTO TWEET VALUES(1408007255736426496, 863433547, 'RT @AbreCesar23: -Majestad, si firma los indultos, le parto el cuello al corderito. https://t.co/7blpOhz2Tb', 'es', NULL, NULL, FALSE);   
INSERT INTO TWEET VALUES(1408007354797498372, 863433547, 'RT @oriolsabata: Tal d\u00eda como hoy, el 24 de junio de 1945, se realiza el primer Desfile de la Victoria en Mosc\u00fa para celebrar la victoria s\u2026', 'es', NULL, NULL, FALSE);     
INSERT INTO TWEET VALUES(1408008064876285955, 31090827, '\u00bfCu\u00e1ndo se podr\u00e1n vacunar las personas de 40 a\u00f1os en la Comunidad de Madrid? https://t.co/w523cZ2H77', 'es', NULL, NULL, FALSE);         
INSERT INTO TWEET VALUES(1408008299233095681, 31090827, '\u2b55 #Directo | Sigue el Consejo de Ministros que deja de hacer obligatoria la mascarilla y rebaja la factura de la luz https://t.co/McK47ObF9F', 'es', NULL, NULL, FALSE);
INSERT INTO TWEET VALUES(1408008319621644289, 863433547, 'RT @PanamaSuiza: Ana Pastor en la 1de TVE, \"En el Partido Popular esperamos q S\u00e1nchez dimita y q hayan Elecciones\",.. Sue\u00f1an con los 140.00\u2026', 'es', NULL, NULL, FALSE);   
INSERT INTO TWEET VALUES(1408008343260696580, 863433547, 'RT @tableroglobal: El CGPJ, cuyos magistrados fueron designados en su mayor\u00eda por el PP cuando ten\u00eda mayor\u00eda absoluta y siguen ah\u00ed m\u00e1s de 2\u2026', 'es', NULL, NULL, FALSE);      
INSERT INTO TWEET VALUES(1408008476136202248, 863433547, 'RT @CanoBombin: Ingenier\u00eda fascista: despide a 5.000 Profesores\u2026Los vuelve a contratar\u2026 y ha aumentado la contrataci\u00f3n a 10.000. Hahajjajja\u2026', 'es', NULL, NULL, FALSE);           
INSERT INTO TWEET VALUES(1408008538551619585, 863433547, 'RT @juan_mesia: Me gustar\u00eda que en la puerta del Bar en letras muy visibles aparte de la lista de precios figurase los contratos de sus emp\u2026', 'es', NULL, NULL, FALSE);          
INSERT INTO TWEET VALUES(1408008594092662788, 863433547, 'RT @skakeofanzine: D\u00edaz Ayuso, guionizada por el \u00ednclito borrach\u00edn Miguel \u00c1ngel Rodr\u00edguez, liderando la opini\u00f3n de la Ultraderecha. Vox se\u2026', 'es', NULL, NULL, FALSE);  
INSERT INTO TWEET VALUES(1408008784434376707, 31090827, '\ud83d\udce2 #\u00daltimaHora | El Gobierno recibe la licencia de obras de El Escorial para la exhumaci\u00f3n de v\u00edctimas en el Valle de los Ca\u00eddos https://t.co/PS9J4wNs5d https://t.co/GPdSasKz0L', 'es', NULL, NULL, FALSE);   
INSERT INTO TWEET VALUES(1408008804181102606, 863433547, 'RT @skakeofanzine: Sabemos que Don Felipe VI no hubiera firmao esos indultos de los traidore a Espa\u00f1ita. Sabemo que lo ha pose\u00eddo el Diablo\u2026', 'es', NULL, NULL, FALSE);     
INSERT INTO TWEET VALUES(1408008841552437258, 863433547, 'RT @peralvarezm: Si en vez de ser los fascistas los que llaman a Felipe de Borb\u00f3n #FelpudoVI fuese desde la izquierda, esos mismos fascista\u2026', 'es', NULL, NULL, FALSE);          
INSERT INTO TWEET VALUES(1408008970229460998, 863433547, 'RT @NicolsBote: El PP, toda una trama. https://t.co/MyqLEsIJAc', 'es', NULL, NULL, FALSE);
INSERT INTO TWEET VALUES(1408009160353058819, 863433547, 'RT @ErnestoSuidry: CGPJ \n\n-Deplorar, NO\n-Dimitir, SI\n\nQu\u00e9 ya llevan ustedes a\u00f1os okupando cargos que no le corresponden, \u00a1co\u00f1o ya!', 'es', NULL, NULL, FALSE);     
INSERT INTO TWEET VALUES(1408009242682986496, 863433547, 'RT @DaniGagoPhoto: La familia.\n\nhttps://t.co/D19sxN8DIy https://t.co/jGQDM1Y5Lt', 'es', NULL, NULL, FALSE);               
INSERT INTO TWEET VALUES(1408009854724214785, 863433547, 'El Ayuntamiento de Zaragoza desencalla operaciones inmobiliarias de la familia del alcalde https://t.co/Za08FxKh7P\nEsto es delito, no?', 'es', NULL, NULL, FALSE);         
INSERT INTO TWEET VALUES(1408009920285446148, 863433547, 'RT @Miquel_R: TORTURA: \"Le colgaron de la ventana y apagaron cigarrillos en sus brazos\"\n\nEl primer informe presentado en el Parlamento Vasc\u2026', 'es', NULL, NULL, FALSE);           
INSERT INTO TWEET VALUES(1408009985058119680, 31090827, 'No habr\u00e1 subida del impuesto de matriculaci\u00f3n: el Senado la paraliza hasta finales de a\u00f1o https://t.co/OL6FmqdZ9j', 'es', NULL, NULL, FALSE); 
INSERT INTO TWEET VALUES(1408010474982084609, 8077212, 'RT @RicardoGamaza: El tribunal de justicia de la UE condena a Espa\u00f1a por destruir #Do\u00f1ana. Tremendo e hist\u00f3rico varapalo judicial.', 'es', NULL, NULL, FALSE); 
INSERT INTO TWEET VALUES(1408010631022796807, 8077212, 'FACUA Madrid suscribe un acuerdo social por una Atenci\u00f3n Primaria de Salud de calidad.  La asociaci\u00f3n, junto al Observatorio Madrile\u00f1o de la Salud, ha solicitado a la Comunidad de Madrid medidas para recuperar esta parte esencial de la sanidad p\u00fablica. https://t.co/5H4AhiQmZj', 'es', NULL, NULL, FALSE);          
INSERT INTO TWEET VALUES(1408010754150776832, 833109559, 'El titular sobre croquetas y las desternillantes reacciones que arrasan en las redes https://t.co/Sn8Ll9POKf https://t.co/IB525RRSNo', 'es', NULL, NULL, FALSE);          
INSERT INTO TWEET VALUES(1408010763634106369, 23791197, 'Transportaban la droga oculta en ruedas de repuesto pero... \u00a1la hemos encontrado!\nIncautados 32 kg de coca\u00edna que viajaron desde #Fuerteventura a #Almer\u00eda alijados en una maquina de obra pesada que transportaba un cami\u00f3n y posteriormente camuflados en ruedas de repuesto\n\ud83d\udc40\ud83d\udcfd\u2935\u2935 https://t.co/TNg2SO1IpH', 'es', NULL, NULL, FALSE);
INSERT INTO TWEET VALUES(1408011076667596803, 31090827, '\u2b55 #Directo |  Ribera: \"Hay determinadas circunstancias que exceden de la capacidad de acci\u00f3n del Gobierno, como la evoluci\u00f3n de los precios de las materias primas\" https://t.co/McK47ObF9F\n#CMin https://t.co/MHzWOcy7Ye', 'es', NULL, NULL, FALSE);      
INSERT INTO TWEET VALUES(1408012043198812162, 863433547, 'RT @Laenredadera: \u00a1Al loro con esto del alcalde de #Zaragoza, Jorge Azc\u00f3n (PP) que se debe investigar a fondo en el Ayuntamiento!  \nEst\u00e1 el\u2026', 'es', NULL, NULL, FALSE);               
INSERT INTO TWEET VALUES(1408012086396047362, 863433547, 'RT @Miquel_R: Vecinas y vecinos del barrio norte de Val\u00e8ncia limpian, desbrozan, crean huertos urbanos y promueven plantaciones en zonas qu\u2026', 'es', NULL, NULL, FALSE);          
INSERT INTO TWEET VALUES(1408012103089262592, 863433547, 'RT @patricialopezl: #EXCLUSIVA de @publico_es \n\ud83d\udd34Los comisarios Gonz\u00e1lez, Olivera y Villarejo ofrecieron a los imputados en G\u00fcrtel anular el\u2026', 'es', NULL, NULL, FALSE);         
INSERT INTO TWEET VALUES(1408012231221157890, 31090827, 'Mark Hoppus, vocalista del grupo Blink-182, revela que le diagnosticaron c\u00e1ncer hace tres meses https://t.co/R97JPo5hAE', 'es', NULL, NULL, FALSE);     
INSERT INTO TWEET VALUES(1408012330944827392, 863433547, 'RT @skakeofanzine: Un Rey si no puede IMPONER la ideolog\u00eda de la ULTRADERECHA, sobra. Por eso mejor un Caudillo elegido a tiros. Donde va a\u2026', 'es', NULL, NULL, FALSE);          
INSERT INTO TWEET VALUES(1408012483722362882, 863433547, 'RT @CarlWinslou: Cyndi Lauper, icono de la m\u00fasica de los 80 ha cumplido 68 a\u00f1os. https://t.co/2uvOC6ekWc', 'es', NULL, NULL, FALSE);              
INSERT INTO TWEET VALUES(1408012548998406145, 31090827, 'Alessandro Lequio se emociona al hablar del c\u00e1ncer de Mila Xim\u00e9nez: \"Sigo sin entender esta enfermedad\" https://t.co/Ya5roMaSod', 'es', NULL, NULL, FALSE);      
INSERT INTO TWEET VALUES(1408012748592664581, 863433547, 'RT @Autillotwitt: Tiene que venir \"La Justicia europea\" a reprochar a #Espa\u00f1a que no proteja el Parque de Do\u00f1ana del expolio de agua, que p\u2026', 'es', NULL, NULL, FALSE);   
INSERT INTO TWEET VALUES(1408013779758161924, 31090827, '\u27a1 El camino de Espa\u00f1a hacia la final: \u00bfqu\u00e9 equipos le esperan si gana a Croacia? https://t.co/yUWqO5OPNw', 'es', NULL, NULL, FALSE);     
INSERT INTO TWEET VALUES(1408014155680989184, 31090827, '\u00c1ngel Mart\u00edn, sobre Mila Xim\u00e9nez en su informativo: \"Se tomaba con humor nuestras bromas en ''S\u00e9 lo que hicisteis''\" https://t.co/AnolYok1uL', 'es', NULL, NULL, FALSE);                         

INSERT INTO "PUBLIC"."HASHTAG" VALUES(1, 'Espa\u00f1a', 1);      
INSERT INTO "PUBLIC"."HASHTAG" VALUES(2, 'EXCLUSIVA', 1);      
INSERT INTO "PUBLIC"."HASHTAG" VALUES(3, 'Zaragoza,', 1);      
INSERT INTO "PUBLIC"."HASHTAG" VALUES(4, 'Directo', 2);        
INSERT INTO "PUBLIC"."HASHTAG" VALUES(5, 'CMin', 1);           
INSERT INTO "PUBLIC"."HASHTAG" VALUES(6, 'Fuerteventura', 1);  
INSERT INTO "PUBLIC"."HASHTAG" VALUES(7, 'Almer\u00eda', 1);     
INSERT INTO "PUBLIC"."HASHTAG" VALUES(8, 'Do\u00f1ana.', 1);     
INSERT INTO "PUBLIC"."HASHTAG" VALUES(9, 'FelpudoVI', 1);      
INSERT INTO "PUBLIC"."HASHTAG" VALUES(10, '\u00daltimaHora', 1); 
INSERT INTO "PUBLIC"."HASHTAG" VALUES(11, 'Actualidad\ud83d\udcf0', 1);          
INSERT INTO "PUBLIC"."HASHTAG" VALUES(12, 'convocatoria', 1);  
INSERT INTO "PUBLIC"."HASHTAG" VALUES(13, 'startups', 1);      
INSERT INTO "PUBLIC"."HASHTAG" VALUES(14, 'AMPLIACI\u00d3N', 1); 
INSERT INTO "PUBLIC"."HASHTAG" VALUES(15, 'egosurfing,', 1);   
INSERT INTO "PUBLIC"."HASHTAG" VALUES(16, 'internet', 1);      
INSERT INTO "PUBLIC"."HASHTAG" VALUES(17, 'huelladigital', 1); 
INSERT INTO "PUBLIC"."HASHTAG" VALUES(18, 'red', 1);           
INSERT INTO "PUBLIC"."HASHTAG" VALUES(19, 'MadresParalelas', 1);               
INSERT INTO "PUBLIC"."HASHTAG" VALUES(20, 'Opiniones', 1);     
INSERT INTO "PUBLIC"."HASHTAG" VALUES(21, 'GetReady', 1);      
INSERT INTO "PUBLIC"."HASHTAG" VALUES(22, 'HolaQueTal', 1);