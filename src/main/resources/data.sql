INSERT INTO degrees (degree_name) VALUES ('ASSISTANT'),
                                         ('ASSOCIATE_PROFESSOR'),
                                         ('PROFESSOR');

INSERT INTO lectors (first_name, last_name, degree_id) VALUES ('John', 'Richard', 1),
                                                              ('Roy', 'Chan', 3),
                                                              ('Bob', 'Alison', 2),
                                                              ('Claudia', 'Jackson', 1),
                                                              ('Tonny', 'Clinton', 2),
                                                              ('Juli', 'Boson', 3);

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
