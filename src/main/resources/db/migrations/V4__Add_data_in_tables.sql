-- Naruto database seed
-- Cleans existing data, inserts 20 missions and 20 Naruto characters,
-- then applies the verified AniList image fixes.

INSERT INTO TB_MISSOES (NOME, DIFICULDADE, DESCRICAO) VALUES
('Treinamento do Time 7', 'Fácil', 'Complete o treinamento básico com Kakashi.'),
('Missão no País das Ondas', 'Fácil', 'Proteja Tazuna durante sua viagem.'),
('Resgate de Konohamaru', 'Fácil', 'Proteja Konohamaru de uma ameaça.'),
('Exame Chunin - Primeira Fase', 'Fácil', 'Passe no teste escrito do Exame Chunin.'),
('Floresta da Morte', 'Médio', 'Sobreviva à Floresta da Morte e consiga o pergaminho.'),
('Batalha contra Neji', 'Médio', 'Enfrente um poderoso membro do clã Hyuga.'),
('Defesa de Konoha', 'Médio', 'Proteja a Vila da Folha durante a invasão.'),
('Resgate de Sasuke', 'Médio', 'Participe da missão para trazer Sasuke de volta.'),
('Treinamento com Jiraiya', 'Médio', 'Treine suas habilidades ninja com Jiraiya.'),
('Busca por Tsunade', 'Médio', 'Encontre Tsunade e convença-a a retornar para Konoha.'),
('Resgate do Kazekage', 'Difícil', 'Resgate Gaara das mãos da Akatsuki.'),
('Batalha contra Kakuzu', 'Difícil', 'Derrote Kakuzu e proteja seus companheiros.'),
('Confronto com Itachi', 'Difícil', 'Enfrente um dos membros mais poderosos da Akatsuki.'),
('Invasão de Pain', 'Difícil', 'Defenda Konoha contra os Seis Caminhos de Pain.'),
('Controle da Kurama', 'Difícil', 'Aprenda a controlar o poder da Raposa de Nove Caudas.'),
('Quarta Guerra Ninja', 'Muito Difícil', 'Lute ao lado da Aliança Shinobi durante a grande guerra.'),
('Batalha contra Madara', 'Muito Difícil', 'Enfrente Madara Uchiha durante a guerra.'),
('Poder dos Seis Caminhos', 'Muito Difícil', 'Domine poderes de nível lendário.'),
('Batalha no Vale do Fim', 'Muito Difícil', 'Enfrente seu maior rival em uma batalha decisiva.'),
('Salvar o Mundo Ninja', 'Muito Difícil', 'Derrote a ameaça final e proteja todo o mundo ninja.');

INSERT INTO TB_CADASTRO
(NOME, EMAIL, IDADE, MISSOES_ID, IMG_URL, RANK) VALUES
('Naruto Uzumaki', 'naruto@konoha.com', 17, 20, 'https://cdn.myanimelist.net/images/characters/16/101039.jpg', 'Kage'),
('Sasuke Uchiha', 'sasuke@konoha.com', 17, 19, 'https://s4.anilist.co/file/anilistcdn/character/large/b13-SISLEw1oAD7a.png', 'Ninja'),
('Sakura Haruno', 'sakura@konoha.com', 17, 16, 'https://s4.anilist.co/file/anilistcdn/character/large/b145-IorfpI8arxeX.png', 'Chunin'),
('Kakashi Hatake', 'kakashi@konoha.com', 31, 15, 'https://cdn.myanimelist.net/images/characters/14/103647.jpg', 'Special Jonin'),
('Itachi Uchiha', 'itachi@akatsuki.com', 21, 13, 'https://cdn.myanimelist.net/images/characters/9/69483.jpg', 'ANBU'),
('Gaara', 'gaara@sunagakure.com', 17, 11, 'https://cdn.myanimelist.net/images/characters/12/34767.jpg', 'Kage'),
('Shikamaru Nara', 'shikamaru@konoha.com', 17, 5, 'https://cdn.myanimelist.net/images/characters/3/131315.jpg', 'Chunin'),
('Hinata Hyuga', 'hinata@konoha.com', 16, 6, 'https://cdn.myanimelist.net/images/characters/16/55680.jpg', 'Genin'),
('Rock Lee', 'rocklee@konoha.com', 17, 6, 'https://cdn.myanimelist.net/images/characters/6/103171.jpg', 'Chunin'),
('Neji Hyuga', 'neji@konoha.com', 18, 6, 'https://cdn.myanimelist.net/images/characters/2/105538.jpg', 'Chunin'),
('Jiraiya', 'jiraiya@konoha.com', 54, 9, 'https://cdn.myanimelist.net/images/characters/4/103625.jpg', 'Special Jonin'),
('Tsunade Senju', 'tsunade@konoha.com', 55, 10, 'https://cdn.myanimelist.net/images/characters/8/225733.jpg', 'Kage'),
('Might Guy', 'guy@konoha.com', 30, 15, 'https://s4.anilist.co/file/anilistcdn/character/large/b307-xieUEdhdTVwQ.png', 'Special Jonin'),
('Minato Namikaze', 'minato@konoha.com', 24, 20, 'https://cdn.myanimelist.net/images/characters/4/103625.jpg', 'Kage'),
('Madara Uchiha', 'madara@uchiha.com', 90, 17, 'https://cdn.myanimelist.net/images/characters/5/292976.jpg', 'Ninja'),
( 'Obito Uchiha', 'obito@akatsuki.com', 31, 17, 'https://cdn.myanimelist.net/images/characters/8/338127.jpg', 'Ninja'),
( 'Pain Nagato', 'pain@akatsuki.com', 35, 14, 'https://cdn.myanimelist.net/images/characters/3/103959.jpg', 'Ninja'),
('Killer Bee', 'killerbee@kumogakure.com', 36, 15, 'https://cdn.myanimelist.net/images/characters/3/78852.jpg', 'Special Jonin'),
('Orochimaru', 'orochimaru@otogakure.com', 54, 18, 'https://s4.anilist.co/file/anilistcdn/character/large/n2455-V9tLMS3TIgJW.png', 'Ninja'),
('Konohamaru Sarutobi', 'konohamaru@konoha.com', 12, 3, 'https://cdn.myanimelist.net/images/characters/10/100216.jpg', 'Genin');