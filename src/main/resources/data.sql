INSERT INTO `netology`.`customers`
(`name`, `surname`, `age`, `phone_number`)
VALUES
('Natasha','Wolf',33,'+75555555555'),
('Natasha','Rabbit',24,'+75553337777'),
('John','Impala',30,'+75556664433'),
('James','Hetfield',61,'+04564567744'),
('Jared','Leto',53,'+01234567899'),
('Alexey','Ivanov',15,'+71472583315'),
('Alexey','Petrov',25,'+71472583325'),
('Alexey','Sidorov',45,'+71472583345');

INSERT INTO `netology`.`orders`
SET
    date='2025-02-06',
    customer_id=(select id from netology.customers where surname = 'Wolf'),
    product_name='ice cream',
    amount=3;

INSERT INTO `netology`.`orders`
SET
    date='2025-02-05',
    customer_id=(select id from netology.customers where surname = 'Rabbit'),
    product_name='tomato',
    amount=5.5;

INSERT INTO `netology`.`orders`
SET
    date='2025-02-07',
    customer_id=(select id from netology.customers where surname = 'Ivanov'),
    product_name='milk',
    amount=5;

INSERT INTO `netology`.`orders`
SET
    date='2025-02-08',
    customer_id=(select id from netology.customers where surname = 'Petrov'),
    product_name='bread',
    amount=2;

INSERT INTO `netology`.`orders`
SET
    date='2025-02-08',
    customer_id=(select id from netology.customers where surname = 'Sidorov'),
    product_name='butter',
    amount=1;