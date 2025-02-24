
DROP TABLE VENTAS;
DROP TABLE PRODUCTO;
DROP TABLE EMPRESA;
DROP TABLE DUENO;


-- Crear tabla Dueño
CREATE TABLE IF NOT EXISTS Dueno (
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
                                       id_dueno INT NOT NULL,
                                       FOREIGN KEY (id_dueno) REFERENCES Dueno(id) ON DELETE CASCADE
);

-- Crear tabla Producto
CREATE TABLE IF NOT EXISTS Producto (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(100) NOT NULL,
                                        precio DECIMAL(10,2) NOT NULL,
                                        cantidad INT NOT NULL,
                                        estado VARCHAR(50) NOT NULL,
                                        id_empresa INT NOT NULL,
                                        FOREIGN KEY (id_empresa) REFERENCES Empresa(id) ON DELETE CASCADE

);

-- Crear tabla de Ventas

CREATE TABLE IF NOT EXISTS Ventas (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      id_producto INT NOT NULL,
                                      cantidad INT NOT NULL,
                                      id_empresa INT NOT NULL,
                                      valor DECIMAL(10,2) NOT NULL,
                                      FOREIGN KEY (id_producto) REFERENCES Producto(id) ON DELETE CASCADE,
                                      FOREIGN KEY (id_empresa) REFERENCES Empresa(id) ON DELETE CASCADE



);

-- Insertar datos de prueba
INSERT INTO Dueno (nombre, apellido, username,password,cedula) VALUES
                                                 ('Juan', 'Pérez','JuanP','456','12345678'),
                                                 ('María', 'López','MariaL','1234','87654321');


INSERT INTO Empresa (nombre, sector, id_dueno) VALUES
                                                   ('Tech Solutions', 'Tecnologia', 1),
                                                   ('Market Experts', 'Consultoria', 2);


INSERT INTO Producto (nombre, precio, cantidad, estado,id_empresa) VALUES
                                                                                 ('Laptop', 1500.00, 10, 'Activo',1),
                                                                                 ('Mouse', 25.00, 50, 'Activo',2);