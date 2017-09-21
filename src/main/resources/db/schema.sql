DROP TABLE IF EXISTS userslist;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE userslist
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  firstName   VARCHAR(15) NOT NULL,
  lastName    VARCHAR(30) NOT NULL,
  birthDay    TIMESTAMP NOT NULL,
  login       VARCHAR(10) NOT NULL,
  password    VARCHAR(10) NOT NULL,
  info         VARCHAR(200),
  adress       VARCHAR(30) NOT NULL
);
