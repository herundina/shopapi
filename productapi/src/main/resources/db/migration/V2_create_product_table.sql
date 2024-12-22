
CREATE TABLE products.product(
    id BIGSERIAL PRIMARY KEY UNIQUE NOT NULL,
    product_identifier VARCHAR NOT NULL,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    preco FLOAT NOT NULL,
    category_id BIGINT REFERENCES products.category(id)
);