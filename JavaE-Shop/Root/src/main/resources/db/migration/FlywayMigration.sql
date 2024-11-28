CREATE TABLE catalog_item (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(50) NOT NULL,
                              description TEXT,
                              price NUMERIC,
                              catalog_brand_id INT REFERENCES catalog_brand(id),
                              catalog_type_id INT REFERENCES catalog_type(id),
                              available_stock INT,
                              restock_threshold INT,
                              max_stock_threshold INT,
                              embedding BYTEA,  -- Vector type stored as BYTEA
                              on_reorder BOOLEAN,
                              picture_file_name TEXT
);
