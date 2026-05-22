--V3: Migration para adicionar a coluna ranking na tabela de cadastro
ALTER TABLE tb_cadastro
    ADD COLUMN rank VARCHAR(255);