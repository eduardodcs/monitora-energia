INSERT INTO TIPO (descricao, status, data_criacao) VALUES ('Iluminação', 'ATIVO', '2021-07-05 18:00:00');
INSERT INTO TIPO (descricao, status, data_criacao) VALUES ('Injetora', 'ATIVO', '2021-07-05 21:00:00');

INSERT INTO SETOR (descricao, status, data_criacao) VALUES ('Expedição', 'ATIVO', '2021-06-05 18:00:00');
INSERT INTO SETOR (descricao, status, data_criacao) VALUES ('Produção Linha 01', 'ATIVO', '2021-06-05 18:00:00');

INSERT INTO EQUIPAMENTO (descricao, tipo_id, setor_id, status, data_criacao) VALUES ('Iluminação da produção', 1, 1, 'ATIVO', '2021-06-05 18:00:00');
INSERT INTO EQUIPAMENTO (descricao, tipo_id, setor_id, status, data_criacao) VALUES ('Injetora Marca X Modelo Y', 2, 2, 'ATIVO', '2021-06-05 18:00:00');

INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (1, 0.253, '2021-07-09 16:00:00');
INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (1, 0.368, '2021-07-09 16:15:00');
INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (1, 0.169, '2021-07-09 16:30:00');
INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (1, 0.658, '2021-07-09 16:45:00');
INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (2, 0.388, '2021-07-09 16:00:00');
INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (2, 0.652, '2021-07-09 16:15:00');
INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (2, 0.189, '2021-07-09 16:30:00');
INSERT INTO CONSUMO (equipamento_id, consumo, data_criacao) VALUES (2, 0.455, '2021-07-09 16:45:00');;
