CREATE TABLE albums (
  id INT NOT NULL AUTO_INCREMENT,
  release_year INT,
  title VARCHAR(255),
  artist VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE artists (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE genres (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE album_genres (
  album_id INT,
  genre_id INT,
  PRIMARY KEY (album_id, genre_id),
  FOREIGN KEY (album_id) REFERENCES albums(id),
  FOREIGN KEY (genre_id) REFERENCES genres(id)
);

ALTER TABLE albums ADD COLUMN genre VARCHAR(255);