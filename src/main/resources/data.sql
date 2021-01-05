INSERT INTO institution(name, description) VALUES ('Fundacja A', 'Pomagamy Pieskom');
INSERT INTO institution(name, description) VALUES ('Fundacja B', 'Pomagamy Kotkom');
INSERT INTO institution(name, description) VALUES ('Stowarzyszenie C', 'Zbieramy ciuchy');
INSERT INTO institution(name, description) VALUES ('Stowarzyszenie D', 'Zbieramy książki');
INSERT INTO institution(name, description) VALUES ('Stowarzyszenie E', 'Zbieramy Środki czystości');
INSERT INTO institution(name, description) VALUES ('Stowarzyszenie F', 'Fundujemy obiadki');
INSERT INTO institution(name, description) VALUES ('Stowarzyszenie G', 'Zbiórka żywności');
INSERT INTO category(name) VALUES ('Ciuchy');
INSERT INTO category(name) VALUES ('Jedzenie');
INSERT INTO category(name) VALUES ('Ksiązki');
INSERT INTO category(name) VALUES ('Zabawki');
INSERT INTO donation(city, quantity, institution_id) VALUES ('Wrocław', '5', 1);
INSERT INTO donation(city, quantity, institution_id) VALUES ('Poznań', '3', 4);
INSERT INTO donation(city, quantity, institution_id) VALUES ('Kraków', '7', 5);
INSERT INTO donation(city, quantity, institution_id) VALUES ('Katowice', '1', 5);
