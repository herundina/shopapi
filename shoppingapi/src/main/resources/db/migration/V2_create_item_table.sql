
CREATE TABLE shoppings.item(
    id SERIAL PRIMARY KEY UNIQUE NOT NULL,    
    product_identifier VARCHAR(150) NOT NULL,
    price FLOAT NOT NULL,
    shop_id BIGSERIAL REFERENCES shoppings.shop(id)
);