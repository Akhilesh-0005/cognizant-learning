-- ============================================================
--  Advanced SQL Exercise 1: Ranking and Window Functions
--  Goal: ROW_NUMBER(), RANK(), DENSE_RANK(), OVER(), PARTITION BY
--  Scenario: Top 3 most expensive products in each category
-- ============================================================

-- ── Step 1: Create and Populate Products Table ──
CREATE TABLE Products (
    ProductID   INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Category    VARCHAR(50),
    Price       DECIMAL(10, 2)
);

INSERT INTO Products (ProductID, ProductName, Category, Price) VALUES
(1,  'Gaming Laptop',     'Electronics',  85000.00),
(2,  'Smartphone Pro',    'Electronics',  72000.00),
(3,  'Bluetooth Speaker', 'Electronics',  72000.00),
(4,  'Smart TV 55"',      'Electronics',  55000.00),
(5,  'Headphones X',      'Electronics',  45000.00),
(6,  'Sofa Set',          'Furniture',    35000.00),
(7,  'Office Chair',      'Furniture',    18000.00),
(8,  'Wooden Table',      'Furniture',    18000.00),
(9,  'Bookshelf',         'Furniture',    12000.00),
(10, 'Bed Frame King',    'Furniture',    28000.00),
(11, 'Running Shoes',     'Clothing',      4500.00),
(12, 'Leather Jacket',    'Clothing',      8500.00),
(13, 'Denim Jeans',       'Clothing',      2500.00),
(14, 'Sports T-Shirt',    'Clothing',      2500.00),
(15, 'Formal Suit',       'Clothing',      9000.00);


-- ============================================================
--  Step 2: ROW_NUMBER() — Unique rank, no ties (skips numbers)
-- ============================================================
SELECT
    ProductID,
    ProductName,
    Category,
    Price,
    ROW_NUMBER() OVER (
        PARTITION BY Category
        ORDER BY Price DESC
    ) AS RowNum
FROM Products;

-- ⬆ ROW_NUMBER always gives unique rank even for same Price
-- e.g. two products at 72000 get ranks 2 and 3 separately


-- ============================================================
--  Step 3: RANK() — Ties get same rank, next rank is skipped
-- ============================================================
SELECT
    ProductID,
    ProductName,
    Category,
    Price,
    RANK() OVER (
        PARTITION BY Category
        ORDER BY Price DESC
    ) AS RankNum
FROM Products;

-- ⬆ RANK: if two products tied at rank 2, next product gets rank 4 (skips 3)


-- ============================================================
--  Step 4: DENSE_RANK() — Ties get same rank, NO rank skipped
-- ============================================================
SELECT
    ProductID,
    ProductName,
    Category,
    Price,
    DENSE_RANK() OVER (
        PARTITION BY Category
        ORDER BY Price DESC
    ) AS DenseRankNum
FROM Products;

-- ⬆ DENSE_RANK: if two products tied at rank 2, next product gets rank 3


-- ============================================================
--  Step 5: All 3 functions side by side (comparison)
-- ============================================================
SELECT
    ProductID,
    ProductName,
    Category,
    Price,
    ROW_NUMBER()  OVER (PARTITION BY Category ORDER BY Price DESC) AS RowNum,
    RANK()        OVER (PARTITION BY Category ORDER BY Price DESC) AS RankNum,
    DENSE_RANK()  OVER (PARTITION BY Category ORDER BY Price DESC) AS DenseRankNum
FROM Products
ORDER BY Category, Price DESC;


-- ============================================================
--  Step 6: Final — Top 3 products per category using DENSE_RANK
-- ============================================================
SELECT *
FROM (
    SELECT
        ProductID,
        ProductName,
        Category,
        Price,
        DENSE_RANK() OVER (
            PARTITION BY Category
            ORDER BY Price DESC
        ) AS DenseRankNum
    FROM Products
) ranked
WHERE DenseRankNum <= 3
ORDER BY Category, DenseRankNum;

-- ============================================================
--  Expected Output (Top 3 per Category):
--
--  Electronics:
--    Rank 1 → Gaming Laptop      ₹85,000
--    Rank 2 → Smartphone Pro     ₹72,000  ← tie
--    Rank 2 → Bluetooth Speaker  ₹72,000  ← tie (same rank)
--    Rank 3 → Smart TV 55"       ₹55,000
--
--  Furniture:
--    Rank 1 → Sofa Set           ₹35,000
--    Rank 2 → Bed Frame King     ₹28,000
--    Rank 3 → Office Chair       ₹18,000  ← tie
--    Rank 3 → Wooden Table       ₹18,000  ← tie (same rank)
--
--  Clothing:
--    Rank 1 → Formal Suit        ₹9,000
--    Rank 2 → Leather Jacket     ₹8,500
--    Rank 3 → Running Shoes      ₹4,500
-- ============================================================
