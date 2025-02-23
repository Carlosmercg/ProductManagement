
DROP TABLE PRODUCTO;
DROP TABLE EMPRESA;
DROP TABLE DUEÑO;


-- Crear tabla Dueño
CREATE TABLE IF NOT EXISTS Dueño (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     nombre VARCHAR(100) NOT NULL,
                                     apellido VARCHAR(100) NOT NULL,
                                     username VARCHAR(100) NOT NULL,
                                     password VARCHAR(100) NOT NULL,
                                     cedula VARCHAR(20) UNIQUE NOT NULL,
                                     CONSTRAINT unique_cedula UNIQUE (cedula)
);


-- Crear tabla Empresa
CREATE TABLE IF NOT EXISTS Empresa (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(100) NOT NULL,
                                       sector VARCHAR(100) NOT NULL,
                                       id_dueño INT NOT NULL,
                                       FOREIGN KEY (id_dueño) REFERENCES Dueño(id) ON DELETE CASCADE
);

-- Crear tabla Producto
CREATE TABLE IF NOT EXISTS Producto (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(100) NOT NULL,
                                        precio DECIMAL(10,2) NOT NULL,
                                        cantidad INT NOT NULL,
                                        estado VARCHAR(50) NOT NULL,
                                        id_dueño INT NOT NULL,
                                        id_empresa INT NOT NULL,
                                        FOREIGN KEY (id_empresa) REFERENCES Empresa(id) ON DELETE CASCADE,
                                        FOREIGN KEY (id_dueño) REFERENCES Dueño(id) ON DELETE CASCADE
);

-- Insertar datos de prueba
INSERT INTO Dueño (nombre, apellido, username,password,cedula) VALUES
                                                 ('Juan', 'Pérez','JuanP','456','12345678'),
                                                 ('María', 'López','MariaL','1234','87654321');


INSERT INTO Empresa (nombre, sector, id_dueño) VALUES
                                                   ('Tech Solutions', 'Tecnología', 1),
                                                   ('Market Experts', 'Consultoría', 2);


INSERT INTO Producto (nombre, precio, cantidad, estado, id_dueño,id_empresa) VALUES
                                                                                 ('Laptop', 1500.00, 10, 'Disponible', 1,1),
                                                                                 ('Mouse', 25.00, 50, 'Disponible', 2,2);