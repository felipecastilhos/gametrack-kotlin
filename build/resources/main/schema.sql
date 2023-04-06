CREATE TABLE IF NOT EXISTS Users (
                       id          VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
                       username    VARCHAR(255)    NOT NULL
);

CREATE TABLE IF NOT EXISTS Games (
                       id                  VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
                       gamename            VARCHAR(255)        NOT NULL,
                       gamelength          INT                 NOT NULL,
                       description         TEXT,
                       thumbnail           VARCHAR(255)        NOT NULL
);

CREATE TABLE IF NOT EXISTS PlayedGames (
                             id                 VARCHAR(36)  DEFAULT RANDOM_UUID() PRIMARY KEY,
                             gameId              VARCHAR(36) NOT NULL,
                             userId              VARCHAR(36) NOT NULL,
                             playingStatus       INT         NOT NULL,
                             howMuchLikedScore   INT         NOT NULL,
                             expectation         INT         NOT NULL,
                             beated              VARCHAR(10) NOT NULL,
                             FOREIGN KEY (gameId) REFERENCES Games(id),
                             FOREIGN KEY (userId) REFERENCES Users(id)
);