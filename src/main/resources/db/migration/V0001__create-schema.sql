CREATE TABLE user (
   id IDENTITY,
   name VARCHAR(30) NOT NULL,
   followers INT NOT NULL
);

CREATE TABLE tweet (
   id IDENTITY,
   user_id INT NOT NULL,
   test VARCHAR(140) NOT NULL,
   location INT NOT NULL,
   validate BOOLEAN NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE hashtag (
    id IDENTITY,
    tag VARCHAR(135) NOT NULL,
    occurrences INT NOT NULL
)