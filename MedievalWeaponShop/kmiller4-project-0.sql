--Project 0 SQL

SET SCHEMA 'bank';

CREATE TABLE app_users (
	user_id SERIAL PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    pass VARCHAR(20) NOT NULL,
	firstname VARCHAR(20) NOT NULL UNIQUE,
    lastname VARCHAR(20) NOT NULL
);


CREATE TABLE accounts (
	 userId INTEGER REFERENCES app_users(user_id),
	 accountId SERIAL PRIMARY KEY,
	 balance INTEGER
);

"INSERT INTO accounts (accountId, balance, user_id) VALUES (?,?,?)"

"SELECT * FROM accounts WHERE user_id=?"

"SELECT balance FROM accounts WHERE userid =  ?"

"UPDATE accounts SET balance = ?  WHERE userid =  ?"