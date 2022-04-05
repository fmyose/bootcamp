create table cliente(id serial primary key, nome varchar(100) not null, cpf varchar(15));

INSERT INTO cliente(nome) VALUES ('cliente1');
INSERT INTO cliente(nome) VALUES ('cliente2');


CREATE TABLE compra(id serial primary key, 
clinte_id int not null, constraint fk_cliente_id foreign key (clinte_id) references cliente
);

INSERT INTO compra(clinte_id) VALUES (1);


CREATE TABLE produto(id serial primary key, nome varchar(100), quantidade int);

INSERT INTO produto(nome,quantidade) VALUES ('celular', 10);
INSERT INTO produto(nome,quantidade) VALUES ('relogio', 5);


CREATE TABLE compraProduto (id serial primary key,
quantidade int,
compra_id int not null, constraint fk_compra_id foreign key (compra_id) references compra,
produto_id int not null, constraint fk_produto_id foreign key (produto_id) references produto
);

INSERT INTO compraProduto(quantidade,compra_id,produto_id) VALUES (2,1,1);
INSERT INTO compraProduto(quantidade,compra_id,produto_id) VALUES (1,1,2);

