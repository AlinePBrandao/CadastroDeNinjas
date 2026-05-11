--V2: Migration para adicionar a coluna descrição na tabela de missoes
ALTER TABLE tb_missoes
ADD COLUMN descricao VARCHAR(255);
