# ProductManagement
Descripción
Este proyecto es un sistema de gestión de productos desarrollado en Java utilizando JavaFX para la interfaz gráfica y H2 Database para la base de datos. Permite gestionar productos, empresas, dueños y ventas, proporcionando una interfaz amigable para el usuario.

🚀 Características

✔️ CRUD de productos (Crear, Leer, Actualizar, Eliminar).

✔️ Gestión de ventas.

✔️ Soporte para múltiples empresas y dueños.

✔️ Interfaz gráfica con JavaFX.

✔️ Base de datos en memoria con H2.

🛠️ Tecnologías Utilizadas
Lenguaje: Java (JDK 17 o superior)
Interfaz gráfica: JavaFX
Base de datos: H2 Database

Para la utilizacion de este codigo se debe descargar los drives de H2 del siguiente link: https://www.h2database.com/html/main.html
Tener mucho cuidado en que carpeta se descomprime el archivo, debido a que se necesitara un JAR que viene dentro de la instalacion, para configurar el proyecto 

En el menu del projecto, dar click en la opcion Project Structure, esto abrira otro menu en el cual al lado izquierdo se encontrara la opcion Modules.
Luego de darle click a Module, buscamos al lado derecho la opcion Dependecies y la seleccionamos por ultimo le damos al + en la opcion JAR OR DIRECTORIES.
Esto abrira la la interfaz de archivos que maneja Intellij, en esta interfaz buscaremos la carpeta de H2, la seleccionaremos, luego a la carpeta bin y por ultimo al Jar.
Luego de seleccionar el Jar daremos en apply y ok, para terminar de incluir los dirvers de la base de datos

