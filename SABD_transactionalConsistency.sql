USE AIBulb;

CREATE TABLE Applications (
  idApplication INT NOT NULL,
  category VARCHAR(255) NOT NULL,
  description TEXT,
  PRIMARY KEY (idApplication)
);

CREATE TABLE Users (
  idUser INT NOT NULL,
  username VARCHAR(255) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (idUser),
);

CREATE TABLE Reviews (
  idReview INT NOT NULL,
  idApplication INT NOT NULL,
  idUser INT NOT NULL,
  rating INT NOT NULL,
  comment TEXT,
  PRIMARY KEY (idReview),
  FOREIGN KEY (idApplication) REFERENCES Applications(idApplication) ON DELETE CASCADE,
  FOREIGN KEY (idUser) REFERENCES Users(idUser) ON DELETE CASCADE
);

CREATE TABLE Transactions (
  idTransaction INT NOT NULL,
  idUser INT NOT NULL,
  idApplication INT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  transactionDate DATETIME NOT NULL,
  PRIMARY KEY (idTransaction),
  FOREIGN KEY (idUser) REFERENCES Users(idUser) ON DELETE CASCADE,
  FOREIGN KEY (idApplication) REFERENCES Applications(idApplication) ON DELETE CASCADE
);

SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;