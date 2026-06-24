CREATE PROCEDURE sp_GetEmployeeCount
    @DepartmentID INT
AS
BEGIN
    SELECT
        d.DepartmentName,
        COUNT(e.EmployeeID) AS TotalEmployees
    FROM Employees e
    JOIN Departments d ON e.DepartmentID = d.DepartmentID
    WHERE e.DepartmentID = @DepartmentID
    GROUP BY d.DepartmentName;
END;

EXEC sp_GetEmployeeCount @DepartmentID = 1;

EXEC sp_GetEmployeeCount @DepartmentID = 3;

CREATE PROCEDURE sp_GetAllDepartmentCounts
AS
BEGIN
    SELECT
        d.DepartmentName,
        COUNT(e.EmployeeID) AS TotalEmployees
    FROM Departments d
    LEFT JOIN Employees e ON d.DepartmentID = e.DepartmentID
    GROUP BY d.DepartmentName
    ORDER BY TotalEmployees DESC;
END;

EXEC sp_GetAllDepartmentCounts;

