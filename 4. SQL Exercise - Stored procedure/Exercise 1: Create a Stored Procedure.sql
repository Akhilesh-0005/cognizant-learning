-- ============================================================
--  Employee Management System
--  Exercise 1: Create a Stored Procedure
--  Goal: Retrieve employee details by DepartmentID
-- ============================================================

-- ── Step 1: Create Tables ──
CREATE TABLE Departments (
    DepartmentID   INT PRIMARY KEY,
    DepartmentName VARCHAR(100)
);

CREATE TABLE Employees (
    EmployeeID   INT PRIMARY KEY,
    FirstName    VARCHAR(50),
    LastName     VARCHAR(50),
    DepartmentID INT FOREIGN KEY REFERENCES Departments(DepartmentID),
    Salary       DECIMAL(10, 2),
    JoinDate     DATE
);

-- ── Step 2: Insert Sample Data ──
INSERT INTO Departments (DepartmentID, DepartmentName) VALUES
(1, 'HR'),
(2, 'Finance'),
(3, 'IT'),
(4, 'Marketing');

INSERT INTO Employees (EmployeeID, FirstName, LastName, DepartmentID, Salary, JoinDate) VALUES
(1, 'John',    'Doe',      1, 5000.00, '2020-01-15'),
(2, 'Jane',    'Smith',    2, 6000.00, '2019-03-22'),
(3, 'Michael', 'Johnson',  3, 7000.00, '2018-07-30'),
(4, 'Emily',   'Davis',    4, 5500.00, '2021-11-05');

-- ── Step 3: Stored Procedure — Get Employees by DepartmentID ──
CREATE PROCEDURE sp_GetEmployeesByDepartment
    @DepartmentID INT
AS
BEGIN
    SELECT
        e.EmployeeID,
        e.FirstName,
        e.LastName,
        d.DepartmentName,
        e.JoinDate
    FROM Employees e
    JOIN Departments d ON e.DepartmentID = d.DepartmentID
    WHERE e.DepartmentID = @DepartmentID;
END;

-- ── Step 4: Stored Procedure — Insert New Employee ──
CREATE PROCEDURE sp_InsertEmployee
    @FirstName    VARCHAR(50),
    @LastName     VARCHAR(50),
    @DepartmentID INT,
    @Salary       DECIMAL(10, 2),
    @JoinDate     DATE
AS
BEGIN
    INSERT INTO Employees (FirstName, LastName, DepartmentID, Salary, JoinDate)
    VALUES (@FirstName, @LastName, @DepartmentID, @Salary, @JoinDate);
END;

-- ── Step 5: Execute the Stored Procedures ──

EXEC sp_GetEmployeesByDepartment @DepartmentID = 3;

-- Insert a new employee
EXEC sp_InsertEmployee
    @FirstName    = 'Akhilesh',
    @LastName     = 'Kumar',
    @DepartmentID = 3,
    @Salary       = 7500.00,
    @JoinDate     = '2024-06-01';

-- Verify insertion
EXEC sp_GetEmployeesByDepartment @DepartmentID = 3;


