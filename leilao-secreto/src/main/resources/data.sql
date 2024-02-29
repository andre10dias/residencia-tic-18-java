INSERT INTO Leilao (descricao, valor_minimo, status) VALUES 
('Pintura', 100.00, 'Aberto'),
('Joias da coroa', 500.00, 'Fechado'),
('IPhone', 10000.00, 'Aberto');


INSERT INTO Concorrente (nome, cpf) VALUES 
('João Silva', '12345678900'),
('Maria Oliveira', '98765432100'),
('Carlos Santos', '11122233344');


INSERT INTO Lance (id_leilao, id_concorrente, valor) VALUES
(1, 1, 120.00),
(1, 2, 150.00),
(2, 2, 550.00),
(3, 3, 10500.00);