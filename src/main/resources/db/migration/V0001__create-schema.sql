CREATE TABLE user (
   id IDENTITY,
   name VARCHAR(30) NOT NULL,
   followers INT NOT NULL
);

CREATE TABLE tweet (
   id IDENTITY,
   user_id BIGINT NOT NULL,
   text VARCHAR(500) NOT NULL,
   lang VARCHAR(10) NOT NULL,
   longitude BIGINT,
   latitude BIGINT,
   validated BOOLEAN NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE hashtag (
    id IDENTITY,
    tag VARCHAR(135) NOT NULL,
    occurrences INT NOT NULL
)