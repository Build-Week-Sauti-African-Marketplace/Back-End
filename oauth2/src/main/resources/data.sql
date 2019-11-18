INSERT INTO users (username, password, userid) VALUES ('test', 'test', 12);

INSERT INTO currencies (name, code, symbol, value_inusd) VALUES ('Dollars','USD', '$', 1);

INSERT INTO items (itemid, location, name, description, price, userid, code) VALUES (1, 'here', 'Milk', 'A gallon of milk', 2.45, 12, 'USD');

INSERT INTO categories (categoryid, type, itemid) VALUES (1, 'Produce', 1);