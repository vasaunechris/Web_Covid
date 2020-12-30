-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS CovidContact_BDD;
CREATE DATABASE CovidContact_BDD;
USE CovidContact_BDD;


-- -----------------------------------------------------------------------------
-- - Construction de la table des utilisateurs                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE Utilisateur (
	Genre				int(1),
	Id					int(4)		PRIMARY KEY AUTO_INCREMENT,
	Nom					varchar(50) NOT NULL,
	Prenom				varchar(50) NOT NULL,
	Utilisateur			varchar(50)	NOT NULL,
	Password			varchar(50)	NOT NULL,
	Mail				varchar(50) NOT NULL,
	Date				DATETIME NOT NULL ,
	Adresse				varchar(50)	NOT NULL,
	Pays				varchar(50)	NOT NULL,
	Ville				varchar(50)	NOT NULL,
 	UNIQUE ( Mail ),
 	UNIQUE ( Utilisateur )
) ENGINE = InnoDB;

INSERT INTO Utilisateur (Genre,Nom, Prenom, Utilisateur, Password, Mail, Date, Adresse, Pays, Ville) VALUES ( 1,'Anderson',	'Neo','aze','aze','aze@aze.fr',NOW(),'aazeaze','azeazeaze','azeazeaze' );
SELECT * from Utilisateur where (Mail='azee@aze.fr' and Password='aze') or (Utilisateur ='aze' and  Password='aze') ;
SELECT * FROM Utilisateur;

-- -----------------------------------------------------------------------------
-- - Construction de la table des administrateurs                            ---
-- -----------------------------------------------------------------------------

CREATE TABLE T_Admins (
	IdUser				int(4)		NOT NULL REFERENCES T_Users(IdUser),
	Rights				varchar(10) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Admins VALUES ( 1, "-RWX------" );
INSERT INTO T_Admins VALUES ( 5, "-RWK------" );

-- -----------------------------------------------------------------------------
-- - Construction de la tables des articles en vente                         ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Articles (
	IdArticle			int(4)		PRIMARY KEY AUTO_INCREMENT,
	Description			varchar(30)	NOT NULL,
	Brand				varchar(30)	NOT NULL,
	UnitaryPrice		float(8)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Souris',					'Logitoch',				65 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Clavier',					'Microhard',			49.5 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Systeme d''exploitation',	'Fenetres Vistouille',	150 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Tapis souris', 			'Chapeau Bleu',			5 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Cle USB 8 To', 			'Syno',					8 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Laptop', 					'PH',					1199 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'CD x 500', 				'CETME',				250 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD-R x 100', 			'CETME',				99 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD+R x 100', 			'CETME',				105 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Batterie Laptop', 		'PH',					80 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Casque Audio', 			'Syno',					105 );
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'WebCam', 					'Logitoch',				755 );

SELECT * FROM T_Articles;

-- -----------------------------------------------------------------------------
-- - Construction de la tables des commandes                                 ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Commands (
	IdCommand		int(4)		PRIMARY KEY AUTO_INCREMENT,
	IdUser			int(4)		NOT NULL REFERENCES T_Users(IdUser),
    CommandDate     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB;

CREATE TABLE T_CommandLines (
	IdCommandLine	int(4)		PRIMARY KEY AUTO_INCREMENT,
	IdCommand		int(4)		NOT NULL REFERENCES T_Commands(IdCommand),
	IdArticle		int(4)		NOT NULL REFERENCES T_Articles(IdCommand),
	Quantity		int(4) 		NOT NULL
) ENGINE = InnoDB;

-- Une première commande
INSERT INTO T_Commands (IdUser, CommandDate) VALUES ( 2, now() ); 
INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (1, 1, 5); 
INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (1, 3, 3);

-- Une seconde commande, pour un admin
INSERT INTO T_Commands (IdUser, CommandDate) VALUES ( 1, now() ); 
INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (2, 2, 4); 
INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (2, 3, 1);
INSERT INTO T_CommandLines (IdCommand, IdArticle, Quantity) VALUES (2, 4, 1);