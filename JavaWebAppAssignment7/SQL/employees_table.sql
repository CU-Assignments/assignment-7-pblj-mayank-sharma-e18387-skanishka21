CREATE TABLE employees (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  department VARCHAR(100),
  email VARCHAR(100)
);

INSERT INTO employees (id, name, department, email) VALUES
(1, 'Alice', 'HR', 'alice@example.com'),
(2, 'Bob', 'IT', 'bob@example.com'),
(3, 'Charlie', 'Finance', 'charlie@example.com');
