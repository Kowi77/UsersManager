/*Populating DB*/

DELETE FROM userslist;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO userslist (firstName, lastName, birthday, login, password, info, adress) VALUES
  ('Andrey', 'Kovalenko','1977-03-17', 'kowi',  'lightpass', 'smth info', 'Nsk'),
  ('Yulia', 'Kovalenko', '1980-07-24','iuly',  'StRoNgPaSs', 'interesting info', 'Berdsk'),
  ('Zlatan', 'Ibragimovich',  '1950-01-01', 'zlatan','no_pass', 'MU', 'Sweden');
