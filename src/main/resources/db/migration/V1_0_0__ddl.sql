CREATE TABLE `revinfo` (
    `rev` INT NOT NULL AUTO_INCREMENT,
    `revtstmp` BIGINT,
    PRIMARY KEY (`rev`)
) /*! ENGINE=InnoDB COLLATE=utf8mb4_general_ci */;

CREATE TABLE `account` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `enabled` BIT(1) NOT NULL DEFAULT 1,
    `account_non_expired` BIT(1) NOT NULL DEFAULT 1,
    `account_non_locked` BIT(1) NOT NULL DEFAULT 1,
    `credentials_non_expired` BIT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (`id`)
) /*! ENGINE=InnoDB COLLATE=utf8mb4_general_ci */;

CREATE TABLE `account_authority` (
    `user_id` INT NOT NULL,
    `authority_id` BIGINT NOT NULL,
    PRIMARY KEY (`user_id`, `authority_id`)
) /*! ENGINE=InnoDB COLLATE=utf8mb4_general_ci */;

CREATE TABLE `authority` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `role` SMALLINT NOT NULL,
    PRIMARY KEY (`id`)
) /*! ENGINE=InnoDB COLLATE=utf8mb4_general_ci */;

CREATE TABLE `category` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `created_by` INT,
    `last_modified_by` INT,
    `created_date` DATETIME NOT NULL,
    `last_modified_date` DATETIME,
    PRIMARY KEY (`id`)
) /*! ENGINE=InnoDB COLLATE=utf8mb4_general_ci */;

CREATE TABLE `category_aud` (
    `id` INT NOT NULL,
    `rev` INT NOT NULL,
    `revtype` TINYINT,
    `name` VARCHAR(100) NOT NULL,
    `created_by` INT,
    `last_modified_by` INT,
    `created_date` DATETIME NOT NULL,
    `last_modified_date` DATETIME,
    PRIMARY KEY (`id`, `rev`),
    FOREIGN KEY (`rev`) REFERENCES revinfo(`rev`)
) /*! ENGINE=InnoDB COLLATE=utf8mb4_general_ci */;

CREATE TABLE `item` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `category_id` INT NOT NULL,
    `created_by` INT,
    `last_modified_by` INT,
    `created_date` DATETIME NOT NULL,
    `last_modified_date` DATETIME,
    PRIMARY KEY (`id`)
) /*! ENGINE=InnoDB COLLATE=utf8mb4_general_ci */;