-- Create the vector extension
CREATE EXTENSION IF NOT EXISTS vector;

-- Create sequences for HiLo ID generation
CREATE SEQUENCE catalog_brand_hilo START WITH 10 INCREMENT BY 10;
CREATE SEQUENCE catalog_hilo START WITH 10 INCREMENT BY 10;
CREATE SEQUENCE catalog_type_hilo START WITH 10 INCREMENT BY 10;

-- Create the CatalogBrand table
CREATE TABLE "CatalogBrand" (
                                "Id" SERIAL PRIMARY KEY,
                                "Brand" VARCHAR(100) NOT NULL
);

-- Create the CatalogType table
CREATE TABLE "CatalogType" (
                               "Id" SERIAL PRIMARY KEY,
                               "Type" VARCHAR(100) NOT NULL
);

-- Create the Catalog table with a vector column
CREATE TABLE "Catalog" (
                           "Id" SERIAL PRIMARY KEY,
                           "Name" VARCHAR(50) NOT NULL,
                           "Description" TEXT,
                           "Price" NUMERIC NOT NULL,
                           "PictureFileName" TEXT,
                           "CatalogTypeId" INTEGER NOT NULL,
                           "CatalogBrandId" INTEGER NOT NULL,
                           "AvailableStock" INTEGER NOT NULL,
                           "RestockThreshold" INTEGER NOT NULL,
                           "MaxStockThreshold" INTEGER NOT NULL,
                           "Embedding" VECTOR(384), //"Embedding BYTEA,
                           "OnReorder" BOOLEAN NOT NULL,
                           FOREIGN KEY ("CatalogBrandId") REFERENCES "CatalogBrand"("Id") ON DELETE CASCADE,
                           FOREIGN KEY ("CatalogTypeId") REFERENCES "CatalogType"("Id") ON DELETE CASCADE
);

-- Create Indexes on Catalog table
CREATE INDEX "IX_Catalog_CatalogBrandId" ON "Catalog" ("CatalogBrandId");
CREATE INDEX "IX_Catalog_CatalogTypeId" ON "Catalog" ("CatalogTypeId");
CREATE INDEX "IX_Catalog_Name" ON "Catalog" ("Name");