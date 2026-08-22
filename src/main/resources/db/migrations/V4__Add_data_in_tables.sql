-- Naruto database seed
-- Cleans existing data, inserts 20 missions and 20 Naruto characters,
-- then applies the verified AniList image fixes.

INSERT INTO TB_MISSOES (ID, NOME, DIFICULDADE, DESCRICAO) VALUES
(1, 'Treinamento do Time 7', 'Fácil', 'Complete o treinamento básico com Kakashi.'),
(2, 'Missão no País das Ondas', 'Fácil', 'Proteja Tazuna durante sua viagem.'),
(3, 'Resgate de Konohamaru', 'Fácil', 'Proteja Konohamaru de uma ameaça.'),
(4, 'Exame Chunin - Primeira Fase', 'Fácil', 'Passe no teste escrito do Exame Chunin.'),
(5, 'Floresta da Morte', 'Médio', 'Sobreviva à Floresta da Morte e consiga o pergaminho.'),
(6, 'Batalha contra Neji', 'Médio', 'Enfrente um poderoso membro do clã Hyuga.'),
(7, 'Defesa de Konoha', 'Médio', 'Proteja a Vila da Folha durante a invasão.'),
(8, 'Resgate de Sasuke', 'Médio', 'Participe da missão para trazer Sasuke de volta.'),
(9, 'Treinamento com Jiraiya', 'Médio', 'Treine suas habilidades ninja com Jiraiya.'),
(10, 'Busca por Tsunade', 'Médio', 'Encontre Tsunade e convença-a a retornar para Konoha.'),
(11, 'Resgate do Kazekage', 'Difícil', 'Resgate Gaara das mãos da Akatsuki.'),
(12, 'Batalha contra Kakuzu', 'Difícil', 'Derrote Kakuzu e proteja seus companheiros.'),
(13, 'Confronto com Itachi', 'Difícil', 'Enfrente um dos membros mais poderosos da Akatsuki.'),
(14, 'Invasão de Pain', 'Difícil', 'Defenda Konoha contra os Seis Caminhos de Pain.'),
(15, 'Controle da Kurama', 'Difícil', 'Aprenda a controlar o poder da Raposa de Nove Caudas.'),
(16, 'Quarta Guerra Ninja', 'Muito Difícil', 'Lute ao lado da Aliança Shinobi durante a grande guerra.'),
(17, 'Batalha contra Madara', 'Muito Difícil', 'Enfrente Madara Uchiha durante a guerra.'),
(18, 'Poder dos Seis Caminhos', 'Muito Difícil', 'Domine poderes de nível lendário.'),
(19, 'Batalha no Vale do Fim', 'Muito Difícil', 'Enfrente seu maior rival em uma batalha decisiva.'),
(20, 'Salvar o Mundo Ninja', 'Muito Difícil', 'Derrote a ameaça final e proteja todo o mundo ninja.');

INSERT INTO TB_CADASTRO
(ID, NOME, EMAIL, IDADE, MISSOES_ID, IMG_URL, RANK) VALUES
(1, 'Naruto Uzumaki', 'naruto@konoha.com', 17, 20, 'https://cdn.myanimelist.net/images/characters/16/101039.jpg', 'Kage'),
(2, 'Sasuke Uchiha', 'sasuke@konoha.com', 17, 19, 'https://s4.anilist.co/file/anilistcdn/character/large/b13-SISLEw1oAD7a.png', 'Ninja'),
(3, 'Sakura Haruno', 'sakura@konoha.com', 17, 16, 'https://s4.anilist.co/file/anilistcdn/character/large/b145-IorfpI8arxeX.png', 'Chunin'),
(4, 'Kakashi Hatake', 'kakashi@konoha.com', 31, 15, 'https://cdn.myanimelist.net/images/characters/14/103647.jpg', 'Special Jonin'),
(5, 'Itachi Uchiha', 'itachi@akatsuki.com', 21, 13, 'https://cdn.myanimelist.net/images/characters/9/69483.jpg', 'ANBU'),
(6, 'Gaara', 'gaara@sunagakure.com', 17, 11, 'https://cdn.myanimelist.net/images/characters/12/34767.jpg', 'Kage'),
(7, 'Shikamaru Nara', 'shikamaru@konoha.com', 17, 5, 'https://cdn.myanimelist.net/images/characters/3/131315.jpg', 'Chunin'),
(8, 'Hinata Hyuga', 'hinata@konoha.com', 16, 6, 'https://cdn.myanimelist.net/images/characters/16/55680.jpg', 'Genin'),
(9, 'Rock Lee', 'rocklee@konoha.com', 17, 6, 'https://cdn.myanimelist.net/images/characters/6/103171.jpg', 'Chunin'),
(10, 'Neji Hyuga', 'neji@konoha.com', 18, 6, 'https://cdn.myanimelist.net/images/characters/2/105538.jpg', 'Chunin'),
(11, 'Jiraiya', 'jiraiya@konoha.com', 54, 9, 'https://cdn.myanimelist.net/images/characters/4/103625.jpg', 'Special Jonin'),
(12, 'Tsunade Senju', 'tsunade@konoha.com', 55, 10, 'https://cdn.myanimelist.net/images/characters/8/225733.jpg', 'Kage'),
(13, 'Might Guy', 'guy@konoha.com', 30, 15, 'https://s4.anilist.co/file/anilistcdn/character/large/b307-xieUEdhdTVwQ.png', 'Special Jonin'),
(14, 'Minato Namikaze', 'minato@konoha.com', 24, 20, 'https://cdn.myanimelist.net/images/characters/4/103625.jpg', 'Kage'),
(15, 'Madara Uchiha', 'madara@uchiha.com', 90, 17, 'https://cdn.myanimelist.net/images/characters/5/292976.jpg', 'Ninja'),
(16, 'Obito Uchiha', 'obito@akatsuki.com', 31, 17, 'https://cdn.myanimelist.net/images/characters/8/338127.jpg', 'Ninja'),
(17, 'Pain Nagato', 'pain@akatsuki.com', 35, 14, 'https://cdn.myanimelist.net/images/characters/3/103959.jpg', 'Ninja'),
(18, 'Killer Bee', 'killerbee@kumogakure.com', 36, 15, 'https://cdn.myanimelist.net/images/characters/3/78852.jpg', 'Special Jonin'),
(19, 'Orochimaru', 'orochimaru@otogakure.com', 54, 18, 'https://s4.anilist.co/file/anilistcdn/character/large/n2455-V9tLMS3TIgJW.png', 'Ninja'),
(20, 'Konohamaru Sarutobi', 'konohamaru@konoha.com', 12, 3, 'https://cdn.myanimelist.net/images/characters/10/100216.jpg', 'Genin');