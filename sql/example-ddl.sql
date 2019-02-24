/**
 * Author:  jorgealfonsogarcia
 * Created: 02/24/2019
 */

-- -----------------------------------------------------------------------------
-- TABLE: country
-- -----------------------------------------------------------------------------

CREATE TABLE country
(
  code    CHAR(2)      NOT NULL,
  alpha_3 CHAR(3)      NOT NULL,
  name    VARCHAR(128) NOT NULL,
  PRIMARY KEY (code),
  UNIQUE (alpha_3)
);

-- -----------------------------------------------------------------------------
-- TABLE: author
-- -----------------------------------------------------------------------------

CREATE TABLE author
(
  id         BIGINT AUTO_INCREMENT NOT NULL,
  country    CHAR(2)               NOT NULL,
  first_name VARCHAR(128)          NOT NULL,
  last_name  VARCHAR(128)          NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (country) REFERENCES country (code)
);

-- -----------------------------------------------------------------------------
-- TABLE: publishing_house
-- -----------------------------------------------------------------------------

CREATE TABLE publishing_house
(
  id           BIGINT AUTO_INCREMENT NOT NULL,
  country      CHAR(2)               NOT NULL,
  name         VARCHAR(128)          NOT NULL,
  contact_name VARCHAR(128)          NULL,
  phone_number VARCHAR(32)           NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (country) REFERENCES country (code)
);

-- -----------------------------------------------------------------------------
-- TABLE: literary_genre
-- -----------------------------------------------------------------------------

CREATE TABLE literary_genre
(
  id          BIGINT AUTO_INCREMENT NOT NULL,
  name        VARCHAR(64)           NOT NULL,
  description VARCHAR(128)          NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------------------------------
-- TABLE: book
-- -----------------------------------------------------------------------------

CREATE TABLE book
(
  id               BIGINT AUTO_INCREMENT NOT NULL,
  isbn             VARCHAR(16)           NOT NULL,
  title            VARCHAR(128)          NOT NULL,
  author           BIGINT                NOT NULL,
  publishing_house BIGINT                NOT NULL,
  literary_genre   BIGINT                NOT NULL,
  description      VARCHAR(1024)         NULL,
  stock            INT                   NOT NULL DEFAULT 0,
  price            DOUBLE                NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE (isbn),
  FOREIGN KEY (author) REFERENCES author (id),
  FOREIGN KEY (publishing_house) REFERENCES publishing_house (id),
  FOREIGN KEY (literary_genre) REFERENCES literary_genre (id)
)