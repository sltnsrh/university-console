INSERT INTO degrees (degree_name) VALUES ('ASSISTANT'),
                                         ('ASSOCIATE_PROFESSOR'),
                                         ('PROFESSOR');

INSERT INTO lectors (first_name, last_name, degree_id, salary)
VALUES ('John', 'Richard', 1, 1000.00),
       ('Roy', 'Chan', 3, 3500.00),
       ('Bob', 'Alison', 2, 2300.00),
       ('Claudia', 'Jackson', 1, 1100.00),
       ('Tonny', 'Clinton', 2, 2500.00),
       ('Juli', 'Boson', 3, 3300.00);

INSERT INTO departments (name, lector_id) VALUES ('Economics', 1),
                                      ('Philosophy', 3),
                                      ('Mathematics', 4),
                                      ('Ecological', 2),
                                      ('Historical', 6);

INSERT INTO lectors_departments (lector_id, department_id) VALUES (1, 1),
                                                                  (1, 2),
                                                                  (2, 3),
                                                                  (2, 1),
                                                                  (3, 5),
                                                                  (4, 4),
                                                                  (5, 1),
                                                                  (5, 3),
                                                                  (6, 2),
                                                                  (6, 5),
                                                                  (6, 4);
