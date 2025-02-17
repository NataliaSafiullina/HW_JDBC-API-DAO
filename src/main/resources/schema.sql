-- mysql --

CREATE TABLE IF NOT EXISTS `netology`.`customers` (
    `id`INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `surname` VARCHAR(255) NOT NULL,
    `age` INT NOT NULL CHECK (`age`>= 0),
    `phone_number` VARCHAR(20),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `netology`.`orders` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `date` DATE NOT NULL,
    `customer_id` INT UNSIGNED,
    `product_name` VARCHAR(255),
    `amount` DECIMAL(9,2),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`customer_id`) REFERENCES `netology`.`customers`(`id`)

);