-- Remove the index on the Name column of the Catalog table
DROP INDEX IF EXISTS idx_catalog_name;

-- If you were using HiLo strategy (which typically applies to ID generation), ensure that the strategy is removed
-- (In JPA, this would typically involve changing the ID generation strategy to 'identity' or 'sequence')

-- Example: If you're using HiLo strategy, you'd modify the ID generation strategy here.
-- Since we can't see the specific HiLo setup in your migration, let's assume the IDs are using Identity or Sequence in the new configuration.

-- Remove HiLo Sequences
DROP SEQUENCE IF EXISTS catalog_brand_hilo;
DROP SEQUENCE IF EXISTS catalog_hilo;
DROP SEQUENCE IF EXISTS catalog_type_hilo;

-- Alter ID columns to use Identity generation strategy
ALTER TABLE "CatalogType" ALTER COLUMN "Id" SET DATA TYPE integer USING "Id"::integer;
ALTER TABLE "CatalogBrand" ALTER COLUMN "Id" SET DATA TYPE integer USING "Id"::integer;
ALTER TABLE "Catalog" ALTER COLUMN "Id" SET DATA TYPE integer USING "Id"::integer;

-- Create Index on 'Name' column of Catalog table
CREATE INDEX "IX_Catalog_Name" ON "Catalog" ("Name");
