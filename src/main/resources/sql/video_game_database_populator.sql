# Description: This SQL script populates the video_game_db database with initial data
# for developers, publishers, platforms, and video games, along with their relationships.

# The keyword 'USE' is used to select the database context for the operations.
USE video_game_db;

#==============================================================================================================#
# Developers
#==============================================================================================================#

INSERT INTO developers (id, name) VALUES
    (1,  'Monolith Soft'),
    (2,  'Nintendo EPD'),
    (3,  'Game Freak'),
    (4,  'FromSoftware'),
    (5,  'Square Enix Creative Business Unit 3'),
    (6,  'Intelligent Systems'),
    (7,  'PlatinumGames'),
    (8,  'Atlus'),
    (9,  'CD Projekt Red'),
    (10, 'Capcom'),
    (11, 'Insomniac Games'),
    (12, 'Guerrilla Games'),
    (13, '343 Industries'),
    (14, 'Mojang Studios'),
    (15, 'Toby Fox'),
    (16, 'Supergiant Games'),
    (17, 'Sonic Team'),
    (18, 'Bandai Namco Studios'),
    (19, 'Sora Ltd.'),
    (20, 'Next Level Games'),
    (21, 'MercurySteam'),
    (22, 'Artdink'),
    (23, 'Acquire'),
    (24, 'HAL Laboratory'),
    (25, 'Retro Studios'),
    (26, 'Tantalus Media'),
    (27, 'Nintendo EAD'),
    (28, 'Square'),
    (29, 'Team Cherry'),
    (30, 'Maddy Makes Games'),
    (31, 'ConcernedApe'),
    (32, 'Larian Studios'),
    (33, 'Bethesda Game Studios'),
    (34, 'Rockstar North'),
    (35, 'Rare'),
    (36, 'id Software');

# Reset AUTO_INCREMENT so that new entries continue from the correct ID
ALTER TABLE developers AUTO_INCREMENT = 37;

#==============================================================================================================#
# Publishers
#==============================================================================================================#

INSERT INTO publishers (id, name) VALUES
    (1,  'Nintendo'),
    (2,  'Square Enix'),
    (3,  'Bandai Namco Entertainment'),
    (4,  'Sony Interactive Entertainment'),
    (5,  'Xbox Game Studios'),
    (6,  'Activision'),
    (7,  'Capcom'),
    (8,  'SEGA'),
    (9,  'CD PROJEKT'),
    (10, 'Indie'),
    (11, 'Team Cherry'),
    (12, 'Maddy Makes Games'),
    (13, 'ConcernedApe'),
    (14, 'Bethesda Softworks'),
    (15, 'Rockstar Games'),
    (16, 'Larian Studios'),
    (17, 'Atlus');

# Reset AUTO_INCREMENT so that new entries continue from the correct ID
ALTER TABLE publishers AUTO_INCREMENT = 18;

#==============================================================================================================#
# Platforms
#==============================================================================================================#

INSERT INTO platforms (id, name) VALUES
    (1,  'Nintendo Switch'),
    (2,  'PlayStation 5'),
    (3,  'PlayStation 4'),
    (4,  'Xbox Series X|S'),
    (5,  'Xbox One'),
    (6,  'PC'),
    (7,  'Nintendo 3DS'),
    (8,  'Wii U'),
    (9,  'Nintendo Entertainment System'),
    (10, 'Super Nintendo Entertainment System'),
    (11, 'Nintendo 64'),
    (12, 'Nintendo GameCube'),
    (13, 'Wii'),
    (14, 'Game Boy'),
    (15, 'Game Boy Color'),
    (16, 'Game Boy Advance'),
    (17, 'Nintendo DS'),
    (18, 'PlayStation'),
    (19, 'PlayStation 2'),
    (20, 'PlayStation 3'),
    (21, 'Xbox 360'),
    (22, 'PlayStation Vita'),
    (23, 'PlayStation Portable');

# Reset AUTO_INCREMENT so that new entries continue from the correct ID
ALTER TABLE platforms AUTO_INCREMENT = 24;

#==============================================================================================================#
# Video Games
# (id, title, release_date)
#==============================================================================================================#

INSERT INTO video_games (id, title, release_date) VALUES
    (1,  'The Legend of Zelda: Breath of the Wild',                          '2017-03-03'),
    (2,  'Xenoblade Chronicles 3',                                           '2022-07-29'),
    (3,  'Xenoblade Chronicles 2',                                           '2017-12-01'),
    (4,  'Super Mario Odyssey',                                              '2017-10-27'),
    (5,  'Pokémon Sword',                                                    '2019-11-15'),
    (6,  'Pokémon Shield',                                                   '2019-11-15'),
    (7,  'Fire Emblem: Three Houses',                                        '2019-07-26'),
    (8,  'NieR: Automata',                                                   '2017-02-23'),
    (9,  'Persona 5 Royal',                                                  '2019-10-31'),
    (10, 'The Witcher 3: Wild Hunt',                                         '2015-05-19'),
    (11, 'Elden Ring',                                                       '2022-02-25'),
    (12, 'Halo Infinite',                                                    '2021-12-08'),
    (13, 'Hades',                                                            '2020-09-17'),
    (14, 'Minecraft',                                                        '2011-11-18'),
    (15, 'Marvel''s Spider-Man 2',                                           '2023-10-20'),
    (16, 'Horizon Forbidden West',                                           '2022-02-18'),
    (17, 'Splatoon 3',                                                       '2022-09-09'),
    (18, 'Bayonetta 3',                                                      '2022-10-28'),
    (19, 'Monster Hunter: World',                                            '2018-01-26'),
    (20, 'Sonic Frontiers',                                                  '2022-11-08'),
    (21, 'Undertale',                                                        '2015-09-15'),
    (22, 'Super Smash Bros. Ultimate',                                       '2018-12-07'),
    (23, 'Mario Kart 8 Deluxe',                                              '2017-04-28'),
    (24, 'Animal Crossing: New Horizons',                                    '2020-03-20'),
    (25, 'Luigi''s Mansion 3',                                               '2019-10-31'),
    (26, 'Metroid Dread',                                                    '2021-10-08'),
    (27, 'Fire Emblem Engage',                                               '2023-01-20'),
    (28, 'The Legend of Zelda: Tears of the Kingdom',                        '2023-05-12'),
    (29, 'Triangle Strategy',                                                '2022-03-04'),
    (30, 'Octopath Traveler',                                                '2018-07-13'),
    (31, 'Octopath Traveler II',                                             '2023-02-24'),
    (32, 'Xenoblade Chronicles: Definitive Edition',                         '2020-05-29'),
    (33, 'Astral Chain',                                                     '2019-08-30'),
    (34, 'Pokémon Legends: Arceus',                                          '2022-01-28'),
    (35, 'Pokémon Scarlet',                                                  '2022-11-18'),
    (36, 'Pokémon Violet',                                                   '2022-11-18'),
    (37, 'Kirby and the Forgotten Land',                                     '2022-03-25'),
    (38, 'Splatoon 2',                                                       '2017-07-21'),
    (39, 'The Legend of Zelda: Skyward Sword HD',                            '2021-07-16'),
    (40, 'Paper Mario: The Origami King',                                    '2020-07-17'),
    (41, 'Metroid Prime Remastered',                                         '2023-02-08'),
    (42, 'The Legend of Zelda',                                              '1986-02-21'),
    (43, 'Zelda II: The Adventure of Link',                                  '1987-01-14'),
    (44, 'The Legend of Zelda: A Link to the Past',                          '1991-11-21'),
    (45, 'The Legend of Zelda: Link''s Awakening',                           '1993-06-06'),
    (46, 'The Legend of Zelda: Ocarina of Time',                             '1998-11-21'),
    (47, 'The Legend of Zelda: Majora''s Mask',                              '2000-04-27'),
    (48, 'The Legend of Zelda: The Wind Waker',                              '2002-12-13'),
    (49, 'The Legend of Zelda: Twilight Princess',                           '2006-11-19'),
    (50, 'Super Mario Bros.',                                                '1985-09-13'),
    (51, 'Super Mario Bros. 3',                                              '1988-10-23'),
    (52, 'Super Mario World',                                                '1990-11-21'),
    (53, 'Super Mario 64',                                                   '1996-06-23'),
    (54, 'Super Mario Sunshine',                                             '2002-07-19'),
    (55, 'Super Mario Galaxy',                                               '2007-11-01'),
    (56, 'Super Mario Galaxy 2',                                             '2010-05-23'),
    (57, 'Metroid',                                                          '1986-08-06'),
    (58, 'Super Metroid',                                                    '1994-03-19'),
    (59, 'Metroid Prime',                                                    '2002-11-17'),
    (60, 'Fire Emblem Awakening',                                            '2012-04-19'),
    (61, 'Fire Emblem Fates',                                                '2015-06-25'),
    (62, 'Fire Emblem Echoes: Shadows of Valentia',                          '2017-04-20'),
    (63, 'Pokémon Red',                                                      '1996-02-27'),
    (64, 'Pokémon Blue',                                                     '1996-10-15'),
    (65, 'Pokémon Gold',                                                     '1999-11-21'),
    (66, 'Pokémon Silver',                                                   '1999-11-21'),
    (67, 'Pokémon Ruby',                                                     '2002-11-21'),
    (68, 'Pokémon Sapphire',                                                 '2002-11-21'),
    (69, 'Pokémon Diamond',                                                  '2006-09-28'),
    (70, 'Pokémon Pearl',                                                    '2006-09-28'),
    (71, 'Star Fox 64',                                                      '1997-04-27'),
    (72, 'Donkey Kong Country',                                              '1994-11-21'),
    (73, 'Donkey Kong Country 2: Diddy''s Kong Quest',                       '1995-11-20'),
    (74, 'Donkey Kong 64',                                                   '1999-11-24'),
    (75, 'Kirby Super Star',                                                 '1996-03-21'),
    (76, 'Kirby''s Dream Land',                                              '1992-04-27'),
    (77, 'Kirby: Planet Robobot',                                            '2016-04-28'),
    (78, 'Chrono Trigger',                                                   '1995-03-11'),
    (79, 'Final Fantasy VI',                                                 '1994-04-02'),
    (80, 'Final Fantasy VII',                                                '1997-01-31'),
    (81, 'Dragon Quest XI S: Echoes of an Elusive Age - Definitive Edition', '2019-09-27'),
    (82, 'Kingdom Hearts',                                                   '2002-03-28'),
    (83, 'NieR Replicant ver.1.22474487139...',                              '2021-04-22'),
    (84, 'Shin Megami Tensei V',                                             '2021-11-11'),
    (85, 'Persona 4 Golden',                                                 '2012-06-14'),
    (86, 'Persona 3 Portable',                                               '2009-11-01'),
    (87, 'Hollow Knight',                                                    '2017-02-24'),
    (88, 'Celeste',                                                          '2018-01-25'),
    (89, 'Stardew Valley',                                                   '2016-02-26'),
    (90, 'Monster Hunter Rise',                                              '2021-03-26'),
    (91, 'Monster Hunter Generations Ultimate',                              '2017-03-18'),
    (92, 'Sonic Mania',                                                      '2017-08-15'),
    (93, 'Sonic Generations',                                                '2011-11-01'),
    (94, 'The Elder Scrolls V: Skyrim',                                      '2011-11-11'),
    (95, 'Grand Theft Auto V',                                               '2013-09-17'),
    (96, 'Dark Souls',                                                       '2011-09-22'),
    (97, 'Dark Souls III',                                                   '2016-03-24'),
    (98, 'Baldur''s Gate 3',                                                 '2023-08-03'),
    (99, 'Divinity: Original Sin 2',                                         '2017-09-14'),
    (100,'Doom (2016)',                                                      '2016-05-13'),
    (101,'Xenoblade Chronicles X',                                           '2015-04-29'),
    (102,'Xenoblade Chronicles',                                             '2010-06-10'),
    (103,'Pikmin 3 Deluxe',                                                  '2020-10-30'),
    (104,'Pikmin 4',                                                         '2023-07-21'),
    (105,'Fire Emblem: Path of Radiance',                                    '2005-04-20'),
    (106,'Fire Emblem: Radiant Dawn',                                        '2007-02-22'),
    (107,'Pokémon Emerald',                                                  '2004-09-16'),
    (108,'Pokémon Platinum',                                                 '2008-09-13'),
    (109,'Pokémon Black',                                                    '2010-09-18'),
    (110,'Pokémon White',                                                    '2010-09-18'),
    (111,'Pokémon Black 2',                                                  '2012-06-23'),
    (112,'Pokémon White 2',                                                  '2012-06-23'),
    (113,'Pokémon HeartGold',                                                '2009-09-12'),
    (114,'Pokémon SoulSilver',                                               '2009-09-12'),
    (115,'Metroid Prime 2: Echoes',                                          '2004-11-15'),
    (116,'Metroid Prime 3: Corruption',                                      '2007-08-27'),
    (117,'The Legend of Zelda: Phantom Hourglass',                           '2007-06-23'),
    (118,'The Legend of Zelda: Spirit Tracks',                               '2009-12-07'),
    (119,'The Legend of Zelda: A Link Between Worlds',                       '2013-11-22'),
    (120,'The Legend of Zelda: The Minish Cap',                              '2004-11-04'),
    (121,'Super Mario 3D World',                                             '2013-11-21'),
    (122,'Super Mario 3D World + Bowser''s Fury',                            '2021-02-12'),
    (123,'New Super Mario Bros. Wii',                                        '2009-11-12'),
    (124,'New Super Mario Bros. U',                                          '2012-11-18'),
    (125,'New Super Mario Bros.',                                            '2006-05-15'),
    (126,'Banjo-Kazooie',                                                    '1998-06-29'),
    (127,'Banjo-Tooie',                                                      '2000-11-20'),
    (128,'GoldenEye 007',                                                    '1997-08-25'),
    (129,'Perfect Dark',                                                     '2000-05-22'),
    (130,'Splatoon',                                                         '2015-05-28'),
    (131,'Resident Evil 2 (2019)',                                           '2019-01-25'),
    (132,'Resident Evil 4',                                                  '2005-01-11'),
    (133,'Monster Hunter 4 Ultimate',                                        '2014-10-11'),
    (134,'Monster Hunter 3 Ultimate',                                        '2013-03-19'),
    (135,'Cyberpunk 2077',                                                   '2020-12-10'),
    (136,'Fallout 4',                                                        '2015-11-10'),
    (137,'Red Dead Redemption 2',                                            '2018-10-26'),
    (138,'Doom Eternal',                                                     '2020-03-20'),
    (139,'The Elder Scrolls IV: Oblivion',                                   '2006-03-20'),
    (140,'The Elder Scrolls III: Morrowind',                                 '2002-05-01'),
    (141,'Grand Theft Auto IV',                                              '2008-04-29'),
    (142,'Dragon Quest VIII: Journey of the Cursed King',                    '2004-11-27'),
    (143,'Dragon Quest IX: Sentinels of the Starry Skies',                   '2009-07-11'),
    (144,'Kingdom Hearts II',                                                '2005-12-22'),
    (145,'Final Fantasy X',                                                  '2001-07-19'),
    (146,'Final Fantasy IX',                                                 '2000-07-07'),
    (147,'Shin Megami Tensei III: Nocturne',                                 '2003-02-20'),
    (148,'Persona 5',                                                        '2016-09-15'),
    (149,'Persona 5 Strikers',                                               '2020-02-20'),
    (150,'Tales of Arise',                                                   '2021-09-10');

# Reset AUTO_INCREMENT so that new entries continue from the correct ID
ALTER TABLE video_games AUTO_INCREMENT = 151;

#==============================================================================================================#
# Video Game ↔ Developer (many-to-many)
#==============================================================================================================#

INSERT INTO video_game_developer (video_game_id, developer_id) VALUES
    (1,  2),   # BotW                                          - Nintendo EPD
    (2,  1),   # XC3                                           - Monolith Soft
    (3,  1),   # XC2                                           - Monolith Soft
    (4,  2),   # Odyssey                                       - Nintendo EPD
    (5,  3),   # Pokémon Sword                                 - Game Freak
    (6,  3),   # Pokémon Shield                                - Game Freak
    (7,  6),   # FE: Three Houses                              - Intelligent Systems
    (7,  2),   # FE: Three Houses                              - Nintendo EPD (co-dev style)
    (8,  7),   # NieR: Automata                                - PlatinumGames
    (9,  8),   # Persona 5 Royal                               - Atlus
    (10, 9),   # The Witcher 3                                 - CD Projekt Red
    (11, 4),   # Elden Ring                                    - FromSoftware
    (12, 13),  # Halo Infinite                                 - 343 Industries
    (13, 16),  # Hades                                         - Supergiant Games
    (14, 14),  # Minecraft                                     - Mojang Studios
    (15, 11),  # Spider-Man 2                                  - Insomniac Games
    (16, 12),  # Horizon FW                                    - Guerrilla Games
    (17, 2),   # Splatoon 3                                    - Nintendo EPD
    (18, 7),   # Bayonetta 3                                   - PlatinumGames
    (19, 10),  # Monster Hunter: World                         - Capcom
    (20, 17),  # Sonic Frontiers                               - Sonic Team
    (21, 15),  # Undertale                                     - Toby Fox
    (22, 18),  # Super Smash Bros. Ultimate                    - Bandai Namco Studios
    (22, 19),  # Super Smash Bros. Ultimate                    - Sora Ltd.
    (23, 2),   # Mario Kart 8 Deluxe                           - Nintendo EPD
    (24, 2),   # Animal Crossing: New Horizons                 - Nintendo EPD
    (25, 20),  # Luigi's Mansion 3                             - Next Level Games
    (26, 21),  # Metroid Dread                                 - MercurySteam
    (26, 2),   # Metroid Dread                                 - Nintendo EPD (co-dev)
    (27, 6),   # Fire Emblem Engage                            - Intelligent Systems
    (28, 2),   # The Legend of Zelda: TotK                     - Nintendo EPD
    (29, 22),  # Triangle Strategy                             - Artdink
    (29, 5),   # Triangle Strategy                             - Square Enix CBU3
    (30, 23),  # Octopath Traveler                             - Acquire
    (30, 5),   # Octopath Traveler                             - Square Enix CBU3
    (31, 23),  # Octopath Traveler II                          - Acquire
    (31, 5),   # Octopath Traveler II                          - Square Enix CBU3
    (32, 1),   # Xenoblade Chronicles: DE                      - Monolith Soft
    (33, 7),   # Astral Chain                                  - PlatinumGames
    (34, 3),   # Pokémon Legends: Arceus                       - Game Freak
    (35, 3),   # Pokémon Scarlet                               - Game Freak
    (36, 3),   # Pokémon Violet                                - Game Freak
    (37, 24),  # Kirby and the Forgotten Land                  - HAL Laboratory
    (38, 2),   # Splatoon 2                                    - Nintendo EPD
    (39, 26),  # The Legend of Zelda: Skyward Sword HD         - Tantalus Media
    (40, 6),   # Paper Mario: The Origami King                 - Intelligent Systems
    (41, 25),  # Metroid Prime Remastered                      - Retro Studios
    (42, 27),  # The Legend of Zelda                           - Nintendo EAD
    (43, 27),  # Zelda II                                      - Nintendo EAD
    (44, 27),  # A Link to the Past                            - Nintendo EAD
    (45, 27),  # Link's Awakening                              - Nintendo EAD
    (46, 27),  # Ocarina of Time                               - Nintendo EAD
    (47, 27),  # Majora's Mask                                 - Nintendo EAD
    (48, 27),  # Wind Waker                                    - Nintendo EAD
    (49, 27),  # Twilight Princess                             - Nintendo EAD
    (50, 27),  # Super Mario Bros.                             - Nintendo EAD
    (51, 27),  # Super Mario Bros. 3                           - Nintendo EAD
    (52, 27),  # Super Mario World                             - Nintendo EAD
    (53, 27),  # Super Mario 64                                - Nintendo EAD
    (54, 27),  # Super Mario Sunshine                          - Nintendo EAD
    (55, 27),  # Super Mario Galaxy                            - Nintendo EAD
    (56, 27),  # Super Mario Galaxy 2                          - Nintendo EAD
    (57, 27),  # Metroid                                       - Nintendo EAD/R&D1
    (58, 27),  # Super Metroid                                 - Nintendo EAD/R&D1
    (59, 25),  # Metroid Prime                                 - Retro Studios
    (59, 27),  # Metroid Prime                                 - Nintendo EAD (support)
    (60, 6),   # Fire Emblem Awakening                         - Intelligent Systems
    (61, 6),   # Fire Emblem Fates                             - Intelligent Systems
    (62, 6),   # Fire Emblem Echoes                            - Intelligent Systems
    (63, 3),   # Pokémon Red                                   - Game Freak
    (64, 3),   # Pokémon Blue                                  - Game Freak
    (65, 3),   # Pokémon Gold                                  - Game Freak
    (66, 3),   # Pokémon Silver                                - Game Freak
    (67, 3),   # Pokémon Ruby                                  - Game Freak
    (68, 3),   # Pokémon Sapphire                              - Game Freak
    (69, 3),   # Pokémon Diamond                               - Game Freak
    (70, 3),   # Pokémon Pearl                                 - Game Freak
    (71, 27),  # Star Fox 64                                   - Nintendo EAD
    (72, 35),  # Donkey Kong Country                           - Rare
    (73, 35),  # Donkey Kong Country 2                         - Rare
    (74, 35),  # Donkey Kong 64                                - Rare
    (75, 24),  # Kirby Super Star                              - HAL Laboratory
    (76, 24),  # Kirby's Dream Land                            - HAL Laboratory
    (77, 24),  # Kirby: Planet Robobot                         - HAL Laboratory
    (78, 28),  # Chrono Trigger                                - Square
    (79, 28),  # Final Fantasy VI                              - Square
    (80, 28),  # Final Fantasy VII                             - Square
    (81, 5),   # Dragon Quest XI S                             - Square Enix CBU3 (approx)
    (82, 28),  # Kingdom Hearts                                - Square
    (83, 28),  # NieR Replicant ver.1.224...                   - Square (approx)
    (84, 8),   # Shin Megami Tensei V                          - Atlus
    (85, 8),   # Persona 4 Golden                              - Atlus
    (86, 8),   # Persona 3 Portable                            - Atlus
    (87, 29),  # Hollow Knight                                 - Team Cherry
    (88, 30),  # Celeste                                       - Maddy Makes Games
    (89, 31),  # Stardew Valley                                - ConcernedApe
    (90, 10),  # Monster Hunter Rise                           - Capcom
    (91, 10),  # Monster Hunter Generations Ultimate           - Capcom
    (92, 17),  # Sonic Mania                                   - Sonic Team (approx)
    (93, 17),  # Sonic Generations                             - Sonic Team
    (94, 33),  # Skyrim                                        - Bethesda Game Studios
    (95, 34),  # GTA V                                         - Rockstar North
    (96, 4),   # Dark Souls                                    - FromSoftware
    (97, 4),   # Dark Souls III                                - FromSoftware
    (98, 32),  # Baldur's Gate 3                               - Larian Studios
    (99, 32),  # Divinity: Original Sin 2                      - Larian Studios
    (100,36),  # Doom (2016)                                   - id Software
    (101,1),   # Xenoblade Chronicles X                        - Monolith Soft
    (102,1),   # Xenoblade Chronicles                          - Monolith Soft
    (103,2),   # Pikmin 3 Deluxe                               - Nintendo EPD
    (104,2),   # Pikmin 4                                      - Nintendo EPD
    (105,6),   # Fire Emblem: Path of Radiance                 - Intelligent Systems
    (106,6),   # Fire Emblem: Radiant Dawn                     - Intelligent Systems
    (107,3),   # Pokémon Emerald                               - Game Freak
    (108,3),   # Pokémon Platinum                              - Game Freak
    (109,3),   # Pokémon Black                                 - Game Freak
    (110,3),   # Pokémon White                                 - Game Freak
    (111,3),   # Pokémon Black 2                               - Game Freak
    (112,3),   # Pokémon White 2                               - Game Freak
    (113,3),   # Pokémon HeartGold                             - Game Freak
    (114,3),   # Pokémon SoulSilver                            - Game Freak
    (115,25),  # Metroid Prime 2: Echoes                       - Retro Studios
    (116,25),  # Metroid Prime 3: Corruption                   - Retro Studios
    (117,27),  # Phantom Hourglass                             - Nintendo EAD
    (118,27),  # Spirit Tracks                                 - Nintendo EAD
    (119,27),  # A Link Between Worlds                         - Nintendo EAD
    (120,10),  # The Minish Cap                                - Capcom
    (121,27),  # Super Mario 3D World                          - Nintendo EAD
    (122,2),   # Super Mario 3D World + Bowser's Fury          - Nintendo EPD
    (123,27),  # New Super Mario Bros. Wii                     - Nintendo EAD
    (124,27),  # New Super Mario Bros. U                       - Nintendo EAD
    (125,27),  # New Super Mario Bros.                         - Nintendo EAD
    (126,35),  # Banjo-Kazooie                                 - Rare
    (127,35),  # Banjo-Tooie                                   - Rare
    (128,35),  # GoldenEye 007                                 - Rare
    (129,35),  # Perfect Dark                                  - Rare
    (130,27),  # Splatoon                                      - Nintendo EAD
    (131,10),  # Resident Evil 2 (2019)                        - Capcom
    (132,10),  # Resident Evil 4                               - Capcom
    (133,10),  # Monster Hunter 4 Ultimate                     - Capcom
    (134,10),  # Monster Hunter 3 Ultimate                     - Capcom
    (135,9),   # Cyberpunk 2077                                - CD Projekt Red
    (136,33),  # Fallout 4                                     - Bethesda Game Studios
    (137,34),  # Red Dead Redemption 2                         - Rockstar North
    (138,36),  # Doom Eternal                                  - id Software
    (139,33),  # TES IV: Oblivion                              - Bethesda Game Studios
    (140,33),  # TES III: Morrowind                            - Bethesda Game Studios
    (141,34),  # GTA IV                                        - Rockstar North
    (142,28),  # DQ VIII                                       - Square
    (143,5),   # DQ IX                                         - Square Enix CBU3
    (144,28),  # Kingdom Hearts II                             - Square
    (145,28),  # Final Fantasy X                               - Square
    (146,28),  # Final Fantasy IX                              - Square
    (147,8),   # SMT III: Nocturne                             - Atlus
    (148,8),   # Persona 5                                     - Atlus
    (149,8),   # Persona 5 Strikers                            - Atlus
    (150,18);  # Tales of Arise                                - Bandai Namco Studios

#==============================================================================================================#
# Video Game ↔ Publisher (many-to-many)
#==============================================================================================================#

INSERT INTO video_game_publisher (video_game_id, publisher_id) VALUES
    (1,  1),   # BotW                                           - Nintendo
    (2,  1),   # XC3                                            - Nintendo
    (3,  1),   # XC2                                            - Nintendo
    (4,  1),   # Odyssey                                        - Nintendo
    (5,  1),   # Pokémon Sword                                  - Nintendo
    (6,  1),   # Pokémon Shield                                 - Nintendo
    (7,  1),   # FE: Three Houses                               - Nintendo
    (8,  2),   # NieR: Automata                                 - Square Enix
    (9,  8),   # Persona 5 Royal                                - SEGA
    (10, 9),   # The Witcher 3                                  - CD PROJEKT
    (11, 3),   # Elden Ring                                     - Bandai Namco
    (12, 5),   # Halo Infinite                                  - Xbox Game Studios
    (13, 10),  # Hades                                          - Indie
    (14, 5),   # Minecraft                                      - Xbox Game Studios
    (15, 4),   # Spider-Man 2                                   - Sony Interactive
    (16, 4),   # Horizon FW                                     - Sony Interactive
    (17, 1),   # Splatoon 3                                     - Nintendo
    (18, 1),   # Bayonetta 3                                    - Nintendo
    (19, 7),   # Monster Hunter: World                          - Capcom
    (20, 8),   # Sonic Frontiers                                - SEGA
    (21, 10),  # Undertale                                      - Indie
    (22, 1),   # Super Smash Bros. Ultimate                     - Nintendo
    (23, 1),   # Mario Kart 8 Deluxe                            - Nintendo
    (24, 1),   # Animal Crossing: New Horizons                  - Nintendo
    (25, 1),   # Luigi's Mansion 3                              - Nintendo
    (26, 1),   # Metroid Dread                                  - Nintendo
    (27, 1),   # Fire Emblem Engage                             - Nintendo
    (28, 1),   # The Legend of Zelda: TotK                      - Nintendo
    (29, 2),   # Triangle Strategy                              - Square Enix
    (30, 2),   # Octopath Traveler                              - Square Enix
    (31, 2),   # Octopath Traveler II                           - Square Enix
    (32, 1),   # Xenoblade Chronicles: DE                       - Nintendo
    (33, 1),   # Astral Chain                                   - Nintendo
    (34, 1),   # Pokémon Legends: Arceus                        - Nintendo
    (35, 1),   # Pokémon Scarlet                                - Nintendo
    (36, 1),   # Pokémon Violet                                 - Nintendo
    (37, 1),   # Kirby and the Forgotten Land                   - Nintendo
    (38, 1),   # Splatoon 2                                     - Nintendo
    (39, 1),   # The Legend of Zelda: Skyward Sword HD          - Nintendo
    (40, 1),   # Paper Mario: The Origami King                  - Nintendo
    (41, 1),   # Metroid Prime Remastered                       - Nintendo
    (42, 1),   # The Legend of Zelda                            - Nintendo
    (43, 1),   # Zelda II                                       - Nintendo
    (44, 1),   # A Link to the Past                             - Nintendo
    (45, 1),   # Link's Awakening                               - Nintendo
    (46, 1),   # Ocarina of Time                                - Nintendo
    (47, 1),   # Majora's Mask                                  - Nintendo
    (48, 1),   # Wind Waker                                     - Nintendo
    (49, 1),   # Twilight Princess                              - Nintendo
    (50, 1),   # Super Mario Bros.                              - Nintendo
    (51, 1),   # Super Mario Bros. 3                            - Nintendo
    (52, 1),   # Super Mario World                              - Nintendo
    (53, 1),   # Super Mario 64                                 - Nintendo
    (54, 1),   # Super Mario Sunshine                           - Nintendo
    (55, 1),   # Super Mario Galaxy                             - Nintendo
    (56, 1),   # Super Mario Galaxy 2                           - Nintendo
    (57, 1),   # Metroid                                        - Nintendo
    (58, 1),   # Super Metroid                                  - Nintendo
    (59, 1),   # Metroid Prime                                  - Nintendo
    (60, 1),   # Fire Emblem Awakening                          - Nintendo
    (61, 1),   # Fire Emblem Fates                              - Nintendo
    (62, 1),   # Fire Emblem Echoes                             - Nintendo
    (63, 1),   # Pokémon Red                                    - Nintendo
    (64, 1),   # Pokémon Blue                                   - Nintendo
    (65, 1),   # Pokémon Gold                                   - Nintendo
    (66, 1),   # Pokémon Silver                                 - Nintendo
    (67, 1),   # Pokémon Ruby                                   - Nintendo
    (68, 1),   # Pokémon Sapphire                               - Nintendo
    (69, 1),   # Pokémon Diamond                                - Nintendo
    (70, 1),   # Pokémon Pearl                                  - Nintendo
    (71, 1),   # Star Fox 64                                    - Nintendo
    (72, 1),   # Donkey Kong Country                            - Nintendo
    (73, 1),   # Donkey Kong Country 2                          - Nintendo
    (74, 1),   # Donkey Kong 64                                 - Nintendo
    (75, 1),   # Kirby Super Star                               - Nintendo
    (76, 1),   # Kirby's Dream Land                             - Nintendo
    (77, 1),   # Kirby: Planet Robobot                          - Nintendo
    (78, 2),   # Chrono Trigger                                 - Square/Square Enix
    (79, 2),   # Final Fantasy VI                               - Square/Square Enix
    (80, 2),   # Final Fantasy VII                              - Square/Square Enix
    (81, 2),   # Dragon Quest XI S                              - Square Enix
    (82, 2),   # Kingdom Hearts                                 - Square Enix
    (83, 2),   # NieR Replicant ver.1.224...                    - Square Enix
    (84, 17),  # Shin Megami Tensei V                           - Atlus
    (85, 17),  # Persona 4 Golden                               - Atlus
    (86, 17),  # Persona 3 Portable                             - Atlus
    (87, 11),  # Hollow Knight                                  - Team Cherry
    (88, 12),  # Celeste                                        - Maddy Makes Games
    (89, 13),  # Stardew Valley                                 - ConcernedApe
    (90, 7),   # Monster Hunter Rise                            - Capcom
    (91, 7),   # Monster Hunter Generations Ultimate            - Capcom
    (92, 8),   # Sonic Mania                                    - SEGA
    (93, 8),   # Sonic Generations                              - SEGA
    (94, 14),  # Skyrim                                         - Bethesda Softworks
    (95, 15),  # GTA V                                          - Rockstar Games
    (96, 3),   # Dark Souls                                     - Bandai Namco
    (97, 3),   # Dark Souls III                                 - Bandai Namco
    (98, 16),  # Baldur's Gate 3                                - Larian Studios
    (99, 16),  # Divinity: Original Sin 2                       - Larian Studios
    (100,14),  # Doom (2016)                                    - Bethesda Softworks
    (101,1),   # Xenoblade Chronicles X                         - Nintendo
    (102,1),   # Xenoblade Chronicles                           - Nintendo
    (103,1),   # Pikmin 3 Deluxe                                - Nintendo
    (104,1),   # Pikmin 4                                       - Nintendo
    (105,1),   # Fire Emblem: PoR                               - Nintendo
    (106,1),   # Fire Emblem: RD                                - Nintendo
    (107,1),   # Pokémon Emerald                                - Nintendo
    (108,1),   # Pokémon Platinum                               - Nintendo
    (109,1),   # Pokémon Black                                  - Nintendo
    (110,1),   # Pokémon White                                  - Nintendo
    (111,1),   # Pokémon Black 2                                - Nintendo
    (112,1),   # Pokémon White 2                                - Nintendo
    (113,1),   # Pokémon HeartGold                              - Nintendo
    (114,1),   # Pokémon SoulSilver                             - Nintendo
    (115,1),   # Metroid Prime 2                                - Nintendo
    (116,1),   # Metroid Prime 3                                - Nintendo
    (117,1),   # Phantom Hourglass                              - Nintendo
    (118,1),   # Spirit Tracks                                  - Nintendo
    (119,1),   # A Link Between Worlds                          - Nintendo
    (120,1),   # The Minish Cap                                 - Nintendo
    (121,1),   # Super Mario 3D World                           - Nintendo
    (122,1),   # SM3DW + Bowser's Fury                          - Nintendo
    (123,1),   # New Super Mario Bros. Wii                      - Nintendo
    (124,1),   # New Super Mario Bros. U                        - Nintendo
    (125,1),   # New Super Mario Bros.                          - Nintendo
    (126,1),   # Banjo-Kazooie                                  - Nintendo
    (127,1),   # Banjo-Tooie                                    - Nintendo
    (128,1),   # GoldenEye 007                                  - Nintendo
    (129,1),   # Perfect Dark                                   - Nintendo
    (130,1),   # Splatoon                                       - Nintendo
    (131,7),   # Resident Evil 2 (2019)                         - Capcom
    (132,7),   # Resident Evil 4                                - Capcom
    (133,7),   # Monster Hunter 4 Ultimate                      - Capcom
    (134,7),   # Monster Hunter 3 Ultimate                      - Capcom
    (135,9),   # Cyberpunk 2077                                 - CD PROJEKT
    (136,14),  # Fallout 4                                      - Bethesda Softworks
    (137,15),  # Red Dead Redemption 2                          - Rockstar Games
    (138,14),  # Doom Eternal                                   - Bethesda Softworks
    (139,14),  # TES IV: Oblivion                               - Bethesda Softworks
    (140,14),  # TES III: Morrowind                             - Bethesda Softworks
    (141,15),  # GTA IV                                         - Rockstar Games
    (142,2),   # Dragon Quest VIII                              - Square Enix
    (143,2),   # Dragon Quest IX                                - Square Enix
    (144,2),   # Kingdom Hearts II                              - Square Enix
    (145,2),   # Final Fantasy X                                - Square Enix
    (146,2),   # Final Fantasy IX                               - Square Enix
    (147,17),  # SMT III: Nocturne                              - Atlus
    (148,17),  # Persona 5                                      - Atlus
    (149,8),   # Persona 5 Strikers                             - SEGA
    (150,3);   # Tales of Arise                                 - Bandai Namco

#==============================================================================================================#
# Video Game ↔ Platform (many-to-many)
#==============================================================================================================#

INSERT INTO video_game_platform (video_game_id, platform_id) VALUES
    # 1: BotW
    (1, 1),  # Switch
    (1, 8),  # Wii U

    # 2: XC3
    (2, 1), # Switch

    # 3: XC2
    (3, 1), # Switch

    # 4: Odyssey
    (4, 1), # Switch

    # 5: Pokémon Sword
    (5, 1), # Switch

    # 6: Pokémon Shield
    (6, 1), # Switch

    # 7: FE: Three Houses
    (7, 1), # Switch

    # 8: NieR: Automata
    (8, 1),  # Switch
    (8, 3),  # PS4
    (8, 5),  # Xbox One
    (8, 6),  # PC

    # 9: Persona 5 Royal
    (9, 1),  # Switch
    (9, 2),  # PS5
    (9, 3),  # PS4
    (9, 4),  # Xbox Series X|S
    (9, 5),  # Xbox One
    (9, 6),  # PC

    # 10: The Witcher 3
    (10, 3), # PS4
    (10, 5), # Xbox One
    (10, 6), # PC
    (10, 1), # Switch

    # 11: Elden Ring
    (11, 2), # PS5
    (11, 3), # PS4
    (11, 4), # Xbox Series X|S
    (11, 5), # Xbox One
    (11, 6), # PC

    # 12: Halo Infinite
    (12, 4), # Xbox Series X|S
    (12, 5), # Xbox One
    (12, 6), # PC

    # 13: Hades
    (13, 1), # Switch
    (13, 3), # PS4
    (13, 5), # Xbox One
    (13, 6), # PC

    # 14: Minecraft
    (14, 1), # Switch
    (14, 2), # PS5
    (14, 3), # PS4
    (14, 4), # Xbox Series X|S
    (14, 5), # Xbox One
    (14, 6), # PC
    (14, 7), # 3DS
    (14, 8), # Wii U

    # 15: Marvel's Spider-Man 2
    (15, 2), # PS5

    # 16: Horizon Forbidden West
    (16, 2), # PS5
    (16, 3), # PS4

    # 17: Splatoon 3
    (17, 1), # Switch

    # 18: Bayonetta 3
    (18, 1), # Switch

    # 19: Monster Hunter: World
    (19, 3), # PS4
    (19, 5), # Xbox One
    (19, 6), # PC

    # 20: Sonic Frontiers
    (20, 1), # Switch
    (20, 2), # PS5
    (20, 3), # PS4
    (20, 4), # Xbox Series X|S
    (20, 5), # Xbox One
    (20, 6), # PC

    # 21: Undertale
    (21, 1), # Switch
    (21, 3), # PS4
    (21, 5), # Xbox One
    (21, 6), # PC

    # 22: Super Smash Bros. Ultimate
    (22, 1),  # Switch

    # 23: Mario Kart 8 Deluxe
    (23, 1),  # Switch

    # 24: Animal Crossing: New Horizons
    (24, 1),  # Switch

    # 25: Luigi's Mansion 3
    (25, 1),  # Switch

    # 26: Metroid Dread
    (26, 1),  # Switch

    # 27: Fire Emblem Engage
    (27, 1),  # Switch

    # 28: The Legend of Zelda: Tears of the Kingdom
    (28, 1),  # Switch

    # 29: Triangle Strategy
    (29, 1),  # Switch
    (29, 6),  # PC (Windows)

    # 30: Octopath Traveler
    (30, 1),  # Switch
    (30, 3),  # PlayStation 4
    (30, 5),  # Xbox One
    (30, 6),  # PC (Windows)

    # 31: Octopath Traveler II
    (31, 1),  # Switch
    (31, 2),  # PlayStation 5
    (31, 3),  # PlayStation 4
    (31, 6),  # PC (Windows)

    # 32: Xenoblade Chronicles: Definitive Edition
    (32, 1),  # Switch

    # 33: Astral Chain
    (33, 1),  # Switch

    # 34: Pokémon Legends: Arceus
    (34, 1),  # Switch

    # 35: Pokémon Scarlet
    (35, 1),  # Switch

    # 36: Pokémon Violet
    (36, 1),  # Switch

    # 37: Kirby and the Forgotten Land
    (37, 1),  # Switch

    # 38: Splatoon 2
    (38, 1),  # Switch

    # 39: The Legend of Zelda: Skyward Sword HD
    (39, 1),  # Switch

    # 40: Paper Mario: The Origami King
    (40, 1),  # Switch

    # 41: Metroid Prime Remastered
    (41, 1),  # Switch

    # 42–49: Classic Zeldas
    (42, 9),   # The Legend of Zelda    - NES
    (43, 9),   # Zelda II               - NES
    (44, 10),  # A Link to the Past     - SNES
    (45, 14),  # Link's Awakening       - Game Boy
    (45, 1),   # Link's Awakening       - Switch (Remake)
    (46, 11),  # Ocarina of Time        - N64
    (47, 11),  # Majora's Mask          - N64
    (48, 12),  # Wind Waker             - GameCube
    (48, 8),   # Wind Waker             - Wii U
    (49, 12),  # Twilight Princess      - GameCube
    (49, 13),  # Twilight Princess      - Wii
    (49, 8),   # Twilight Princess      - Wii U

    # 50–56: Classic Mario platformers & 3D entries
    (50, 9),   # Super Mario Bros.      - NES
    (51, 9),   # Super Mario Bros. 3    - NES
    (52, 10),  # Super Mario World      - SNES
    (53, 11),  # Super Mario 64         - N64
    (53, 1),   # Super Mario 64         - Switch
    (54, 12),  # Super Mario Sunshine   - GameCube
    (54, 1),   # Super Mario Sunshine   - Switch
    (55, 13),  # Super Mario Galaxy     - Wii
    (55, 1),   # Super Mario Galaxy     - Switch
    (56, 13),  # Super Mario Galaxy 2   - Wii
    (56, 1),   # Super Mario Galaxy 2   - Switch

    # 57–59: Metroid series
    (57, 9),   # Metroid                - NES
    (58, 10),  # Super Metroid          - SNES
    (59, 12),  # Metroid Prime          - GameCube

    # 60–62: Fire Emblem 3DS era
    (60, 7),   # FE Awakening - 3DS
    (61, 7),   # FE Fates - 3DS
    (62, 7),   # FE Echoes - 3DS

    # 63–70: Pokémon mainline
    (63, 14),  # Red - Game Boy
    (64, 14),  # Blue - Game Boy
    (65, 15),  # Gold - Game Boy Color
    (66, 15),  # Silver - Game Boy Color
    (67, 16),  # Ruby - GBA
    (68, 16),  # Sapphire - GBA
    (69, 17),  # Diamond - DS
    (70, 17),  # Pearl - DS

    # 71–77: Star Fox, Donkey Kong, Kirby
    (71, 11),  # Star Fox 64 - N64
    (72, 10),  # DKC - SNES
    (73, 10),  # DKC2 - SNES
    (74, 11),  # DK64 - N64
    (75, 10),  # Kirby Super Star - SNES
    (76, 14),  # Kirby's Dream Land - Game Boy
    (77, 7),   # Kirby: Planet Robobot - 3DS

    # 78–83: Square(-Enix) RPGs
    (78, 10),  # Chrono Trigger - SNES
    (79, 10),  # Final Fantasy VI - SNES
    (80, 18),  # Final Fantasy VII - PlayStation
    (81, 1),   # Dragon Quest XI S - Switch
    (82, 19),  # Kingdom Hearts - PS2
    (83, 3),   # NieR Replicant ver.1.224... - PS4
    (83, 5),   # NieR Replicant ver.1.224... - Xbox One
    (83, 6),   # NieR Replicant ver.1.224... - PC

    # 84–86: Atlus RPGs
    (84, 1),   # SMT V - Switch
    (85, 22),  # Persona 4 Golden - PS Vita
    (86, 23),  # Persona 3 Portable - PSP

    # 87–89: Indies
    (87, 6),   # Hollow Knight - PC
    (87, 1),   # Hollow Knight - Switch
    (87, 3),   # Hollow Knight - PS4
    (87, 5),   # Hollow Knight - Xbox One

    (88, 6),   # Celeste - PC
    (88, 1),   # Celeste - Switch
    (88, 3),   # Celeste - PS4
    (88, 5),   # Celeste - Xbox One

    (89, 6),   # Stardew Valley - PC
    (89, 1),   # Stardew Valley - Switch
    (89, 3),   # Stardew Valley - PS4
    (89, 5),   # Stardew Valley - Xbox One

    # 90–91: Monster Hunter
    (90, 1),   # Monster Hunter Rise - Switch
    (90, 6),   # Monster Hunter Rise - PC
    (91, 1),   # MH Generations Ultimate - Switch
    (91, 7),   # MH Generations Ultimate (XX) - 3DS

    # 92–93: Sonic
    (92, 1),   # Sonic Mania - Switch
    (92, 3),   # Sonic Mania - PS4
    (92, 5),   # Sonic Mania - Xbox One
    (92, 6),   # Sonic Mania - PC

    (93, 20),  # Sonic Generations - PS3
    (93, 21),  # Sonic Generations - Xbox 360
    (93, 6),   # Sonic Generations - PC

    # 94–97: Big AAAs
    (94, 3),   # Skyrim - PS4
    (94, 5),   # Skyrim - Xbox One
    (94, 6),   # Skyrim - PC
    (94, 21),  # Skyrim - Xbox 360

    (95, 20),  # GTA V - PS3
    (95, 21),  # GTA V - Xbox 360
    (95, 3),   # GTA V - PS4
    (95, 5),   # GTA V - Xbox One
    (95, 6),   # GTA V - PC

    (96, 20),  # Dark Souls - PS3
    (96, 21),  # Dark Souls - Xbox 360
    (96, 6),   # Dark Souls - PC

    (97, 3),   # Dark Souls III - PS4
    (97, 5),   # Dark Souls III - Xbox One
    (97, 6),   # Dark Souls III - PC

    # 98–100: Modern CRPG & shooter
    (98, 6),   # Baldur's Gate 3 - PC
    (98, 2),   # Baldur's Gate 3 - PS5
    (98, 4),   # Baldur's Gate 3 - Xbox Series X|S

    (99, 6),   # Divinity: Original Sin 2 - PC
    (99, 3),   # Divinity: Original Sin 2 - PS4
    (99, 5),   # Divinity: Original Sin 2 - Xbox One
    (99, 1),   # Divinity: Original Sin 2 - Switch

    (100, 3),  # Doom (2016) - PS4
    (100, 5),  # Doom (2016) - Xbox One
    (100, 6),  # Doom (2016) - PC
    (100, 1),  # Doom (2016) - Switch port

    # 101–104: Xenoblade X, XC, Pikmin 3 DX, Pikmin 4
    (101, 8),  # Xenoblade Chronicles X - Wii U
    (102, 13), # Xenoblade Chronicles   - Wii
    (103, 1),  # Pikmin 3 Deluxe        - Switch
    (104, 1),  # Pikmin 4               - Switch

    # 105–114: FE GCN/Wii and Pokémon GBA/DS
    (105, 12), # FE: Path of Radiance   - GameCube
    (106, 13), # FE: Radiant Dawn       - Wii
    (107, 16), # Pokémon Emerald        - GBA
    (108, 17), # Pokémon Platinum       - DS
    (109, 17), # Pokémon Black          - DS
    (110, 17), # Pokémon White          - DS
    (111, 17), # Pokémon Black 2        - DS
    (112, 17), # Pokémon White 2        - DS
    (113, 17), # Pokémon HeartGold      - DS
    (114, 17), # Pokémon SoulSilver     - DS

    # 115–120: Metroid Prime sequels & more Zelda
    (115, 12), # Metroid Prime 2: Echoes        - GameCube
    (116, 13), # Metroid Prime 3: Corruption    - Wii
    (117, 17), # Phantom Hourglass              - DS
    (118, 17), # Spirit Tracks                  - DS
    (119, 7),  # A Link Between Worlds          - 3DS
    (120, 16), # The Minish Cap                 - GBA

    # 121–125: 3D World & NSMB line
    (121, 8),  # Super Mario 3D World           - Wii U
    (122, 1),  # SM3DW + Bowser's Fury          - Switch
    (123, 13), # New Super Mario Bros. Wii      - Wii
    (124, 8),  # New Super Mario Bros. U        - Wii U
    (125, 17), # New Super Mario Bros.          - DS

    # 126–130: Rare classics & Splatoon
    (126, 11), # Banjo-Kazooie                  - N64
    (127, 11), # Banjo-Tooie                    - N64
    (128, 11), # GoldenEye 007                  - N64
    (129, 11), # Perfect Dark                   - N64
    (130, 8),  # Splatoon                       - Wii U

    # 131–134: RE remakes & MH
    (131, 3),  # Resident Evil 2 (2019) - PS4
    (131, 5),  # Resident Evil 2 (2019) - Xbox One
    (131, 6),  # Resident Evil 2 (2019) - PC

    (132, 12), # Resident Evil 4         - GameCube
    (132, 19), # Resident Evil 4         - PS2

    (133, 7),  # Monster Hunter 4 Ultimate   - 3DS
    (134, 7),  # Monster Hunter 3 Ultimate   - 3DS
    (134, 8),  # Monster Hunter 3 Ultimate   - Wii U

    # 135–138: Cyberpunk, Fallout 4, RDR2, Doom Eternal
    (135, 6),  # Cyberpunk 2077 - PC
    (135, 3),  # Cyberpunk 2077 - PS4
    (135, 5),  # Cyberpunk 2077 - Xbox One
    (135, 2),  # Cyberpunk 2077 - PS5
    (135, 4),  # Cyberpunk 2077 - Xbox Series X|S

    (136, 6),  # Fallout 4 - PC
    (136, 3),  # Fallout 4 - PS4
    (136, 5),  # Fallout 4 - Xbox One

    (137, 3),  # RDR2 - PS4
    (137, 5),  # RDR2 - Xbox One
    (137, 6),  # RDR2 - PC

    (138, 6),  # Doom Eternal - PC
    (138, 3),  # Doom Eternal - PS4
    (138, 5),  # Doom Eternal - Xbox One
    (138, 1),  # Doom Eternal - Switch

    # 139–141: Elder Scrolls & GTA IV
    (139, 6),  # TES IV: Oblivion - PC
    (139, 21), # TES IV: Oblivion - Xbox 360
    (139, 20), # TES IV: Oblivion - PS3

    (140, 6),  # TES III: Morrowind - PC

    (141, 20), # GTA IV - PS3
    (141, 21), # GTA IV - Xbox 360
    (141, 6),  # GTA IV - PC

    # 142–147: Dragon Quest & FF/SMT
    (142, 19), # DQ VIII - PS2
    (142, 7),  # DQ VIII - 3DS

    (143, 17), # DQ IX - DS

    (144, 19), # KH2 - PS2

    (145, 19), # FFX - PS2

    (146, 18), # FFIX - PlayStation

    (147, 19), # SMT III: Nocturne - PS2

    # 148–150: Persona 5 line & Tales of Arise
    (148, 20), # Persona 5 - PS3
    (148, 3),  # Persona 5 - PS4

    (149, 1),  # P5 Strikers - Switch
    (149, 3),  # P5 Strikers - PS4
    (149, 6),  # P5 Strikers - PC

    (150, 3),  # Tales of Arise - PS4
    (150, 2),  # Tales of Arise - PS5
    (150, 5),  # Tales of Arise - Xbox One
    (150, 4),  # Tales of Arise - Xbox Series X|S
    (150, 6);  # Tales of Arise - PC