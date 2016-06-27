CREATE TABLE user(
   id SERIAL PRIMARY KEY,
   username TEXT NOT NULL UNIQUE,
   password TEXT NOT NULL,
   enabled BOOLEAN,
   last_login TIMESTAMP
);

CREATE TABLE user_role(
   id SERIAL PRIMARY KEY,
   username TEXT NOT NULL UNIQUE  REFERENCES users (username),
   role TEXT NOT NULL
);

