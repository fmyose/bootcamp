CREATE TABLE "departamento" (
    "depto_nro" varchar(255),
    "nome_depto" varchar(255),
    "localizacao" varchar(255),
    PRIMARY KEY ("depto_nro")
);

CREATE TABLE "funcionario" (
    "cod_func" varchar(255),
    "nome" varchar(255),
    "sobrenome" varchar(255),
    "cargo" varchar(255),
    "data_alta" timestamp,
    "salario" decimal,
    "comissao" decimal,
    "depto_nro" varchar(255),
    PRIMARY KEY("cod_func"),
    CONSTRAINT "depto_nro" FOREIGN KEY ("depto_nro") REFERENCES "departamento" ("depto_nro")
);

INSERT INTO departamento VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidade', 'La Roca'),
('D-000-4', 'Vendas', 'Plata');

INSERT INTO funcionario VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018/05/12 00:00:00', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015/07/14 00:00:00', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Diretor', '2014/06/05 00:00:00', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015/06/03 00:00:00', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018/03/03 00:00:00', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014/06/05 00:00:00', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desenvolvedor', '2014/08/02 00:00:00', 60000, 0, 'D-000-1');


-- 1. Selecione o nome, cargo e localização dos departamentos onde os vendedores trabalham.
SELECT funcionario.nome, funcionario.sobrenome, departamento.nome_depto, funcionario.cargo, departamento.localizacao
FROM funcionario INNER JOIN departamento
    ON funcionario.depto_nro = departamento.depto_nro;

-- 2. Visualize departamentos com mais de cinco funcionários.
SELECT departamento.nome_depto, COUNT(*) AS total
FROM funcionario INNER JOIN departamento
    ON funcionario.depto_nro = departamento.depto_nro
GROUP BY departamento.nome_depto
HAVING COUNT(funcionario.cod_func) > 5;

-- 3. Exiba o nome, salário e nome do departamento dos funcionários que têm o mesmo cargo que 'Mito Barchuk'.
SELECT funcionario.nome, funcionario.salario, departamento.nome_depto
FROM funcionario INNER JOIN departamento
	ON funcionario.depto_nro = departamento.depto_nro
WHERE 
	cargo IN (SELECT cargo 
			  FROM funcionario 
			  WHERE nome = 'Mito' AND sobrenome = 'Barchuk')
    AND funcionario.depto_nro IN (SELECT depto_nro 
								  FROM funcionario 
								  WHERE nome = 'Mito' AND sobrenome = 'Barchuk');
-- ou, sabendo o cargo:
SELECT funcionario.nome, funcionario.salario, departamento.nome_depto
FROM funcionario INNER JOIN departamento
	ON funcionario.depto_nro = departamento.depto_nro
WHERE 
	cargo = 'Presidente';

-- 4. Mostre os dados dos funcionários que trabalham no departamento de contabilidade, ordenados por nome.
SELECT DISTINCT funcionario.nome, funcionario.sobrenome, funcionario.sobrenome, funcionario.salario
FROM funcionario
INNER JOIN departamento
ON funcionario.depto_nro in (SELECT depto_nro FROM departamento WHERE nome_depto = 'Contabilidade')
ORDER BY nome ASC;

-- 5. Mostre o nome do funcionário que tem o menor salário.
SELECT nome
FROM funcionario
ORDER BY salario ASC
LIMIT 1;

-- 6. Mostre os dados do funcionário que tem o maior salário no departamento 'Vendas'.
SELECT funcionario.nome, funcionario.sobrenome, funcionario.sobrenome, funcionario.salario
FROM funcionario INNER JOIN departamento
    ON funcionario.depto_nro IN (SELECT depto_nro FROM departamento WHERE nome_depto = 'Vendas')
ORDER BY funcionario.salario DESC
LIMIT 1;
