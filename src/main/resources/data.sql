INSERT INTO users (username, email) VALUES ('admin', 'admin@test.com');
INSERT INTO users (username, email) VALUES ('developer', 'dev@test.com');
INSERT INTO users (username, email) VALUES ('tester', 'tester@test.com');

INSERT INTO software_products (name, responsible_id) VALUES ('MyApp', 1);

INSERT INTO development_tasks (product_id, assignee_id, version, status) VALUES (1, 2, '1.0', 'DONE');
INSERT INTO development_tasks (product_id, assignee_id, version, status) VALUES (1, 3, '1.0', 'DONE');
