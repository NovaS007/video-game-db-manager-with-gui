# This SQL script creates a database schema for managing information about video games,
# including their developers, publishers, and platforms.

# The key word 'IF NOT EXISTS' is used to prevent errors if the schema or tables already exist.
CREATE SCHEMA IF NOT EXISTS video_game_db;
#The key word 'USE' is used to select the database schema to work with.
USE video_game_db;

#==============================================================================================================#

CREATE TABLE IF NOT EXISTS developers (
    # This table stores information about video game developers
    id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

#=============================================================================================================#

CREATE TABLE IF NOT EXISTS publishers (
    # This table stores information about video game publishers
    id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

#=============================================================================================================#

CREATE TABLE IF NOT EXISTS video_games (
    # This table stores information about video games
    id           INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL
);

#=============================================================================================================#

CREATE TABLE IF NOT EXISTS platforms (
    # This table stores information about gaming platforms
    id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

#=============================================================================================================#

CREATE TABLE IF NOT EXISTS video_game_platform (
    # This table establishes a many-to-many relationship between video games and platforms
    video_game_id INT UNSIGNED NOT NULL,
    platform_id   INT UNSIGNED NOT NULL,

    PRIMARY KEY (video_game_id, platform_id),

    CONSTRAINT fkp_video_game_platform_video_game
        FOREIGN KEY (video_game_id)
            REFERENCES video_games(id) ON DELETE CASCADE,

    CONSTRAINT fkp_video_game_platform_platform
        FOREIGN KEY (platform_id)
            REFERENCES platforms(id) ON DELETE CASCADE
);

#=============================================================================================================#

CREATE TABLE IF NOT EXISTS video_game_publisher (
    # This table establishes a many-to-many relationship between video games and publishers
    video_game_id INT UNSIGNED NOT NULL,
    publisher_id  INT UNSIGNED NOT NULL,

    PRIMARY KEY (video_game_id, publisher_id),

    CONSTRAINT fkp_video_game_publisher_video_game
        FOREIGN KEY (video_game_id)
            REFERENCES video_games(id) ON DELETE CASCADE,

    CONSTRAINT fkp_video_game_publisher_publisher
        FOREIGN KEY (publisher_id)
            REFERENCES publishers(id) ON DELETE CASCADE
);

#=============================================================================================================#

CREATE TABLE IF NOT EXISTS video_game_developer (
    # This table establishes a many-to-many relationship between video games and developers
    video_game_id INT UNSIGNED NOT NULL,
    developer_id  INT UNSIGNED NOT NULL,

    PRIMARY KEY (video_game_id, developer_id),

    CONSTRAINT fkp_video_game_developer_video_game
        FOREIGN KEY (video_game_id)
            REFERENCES video_games(id) ON DELETE CASCADE,

    CONSTRAINT fkp_video_game_developer_developer
        FOREIGN KEY (developer_id)
            REFERENCES developers(id) ON DELETE CASCADE
);