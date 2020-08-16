CREATE DATABASE dits CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE dits.`Answer` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `description` varchar(255) NOT NULL,
                          `correct` BOOLEAN NOT NULL,
                          `question_id` INT NOT NULL,
                          PRIMARY KEY (`id`)
);

CREATE TABLE dits.`Question` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `description` varchar(255) NOT NULL,
                            `test_id` INT DEFAULT NULL,
                            PRIMARY KEY (`id`)
);

CREATE TABLE dits.`Literature` (
                              `id` INT NOT NULL AUTO_INCREMENT,
                              `description` varchar(255) NOT NULL,
                              `question_id` INT(255) NOT NULL,
                              PRIMARY KEY (`id`)
);

CREATE TABLE dits.`Link` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `link` varchar(255) NOT NULL,
                        `literature_id` INT NOT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE dits.`Test` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        `description` varchar(255) NOT NULL,
                        `topic_id` INT NOT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE dits.`Topic` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `description` varchar(255) NOT NULL,
                         `name` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE dits.`Statistic` (
                             `id` INT NOT NULL AUTO_INCREMENT,
                             `date` DATETIME(6) NOT NULL,
                             `correct` BOOLEAN NOT NULL,
                             `question_id` INT NOT NULL,
                             `user_id` INT NOT NULL,
                             PRIMARY KEY (`id`)
);

CREATE TABLE dits.`User` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(255) NOT NULL,
                        `middle_name` varchar(255) NOT NULL,
                        `last_name` varchar(255) NOT NULL,
                        `login` varchar(255) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `email` varchar(255) NOT NULL,
                        `role_id` INT NOT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE dits.`Role` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL UNIQUE,
                        PRIMARY KEY (`id`)
);

ALTER TABLE `Answer` ADD CONSTRAINT `Answer_fk0` FOREIGN KEY (`question_id`) REFERENCES `Question`(`id`);

ALTER TABLE `Question` ADD CONSTRAINT `Question_fk0` FOREIGN KEY (`test_id`) REFERENCES `Test`(`id`);

ALTER TABLE `Literature` ADD CONSTRAINT `Literature_fk0` FOREIGN KEY (`question_id`) REFERENCES `Question`(`id`);

ALTER TABLE `Link` ADD CONSTRAINT `Link_fk0` FOREIGN KEY (`literature_id`) REFERENCES `Literature`(`id`);

ALTER TABLE `Test` ADD CONSTRAINT `Test_fk0` FOREIGN KEY (`topic_id`) REFERENCES `Topic`(`id`);

ALTER TABLE `Statistic` ADD CONSTRAINT `Statistic_fk0` FOREIGN KEY (`question_id`) REFERENCES `Question`(`id`);

ALTER TABLE `Statistic` ADD CONSTRAINT `Statistic_fk1` FOREIGN KEY (`user_id`) REFERENCES `User`(`id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`role_id`) REFERENCES `Role`(`id`);
