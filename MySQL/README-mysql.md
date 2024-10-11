# MySQL

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos MySQL.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando descargará la imagen de MySQL, arrancará el contenedor y configurará el entorno para su uso.

### Acceso a MySQL

- **URL de acceso**: MySQL se ejecuta en `http://localhost:3306`.
- **Credenciales**:
  - **Usuario**: `root`
  - **Contraseña**: `rootpassword`
  - **Base de datos**: `my_database`
  - **Usuario restringido**: `user`
  - **Contraseña del usuario restringido**: `userpassword`
  
Puedes utilizar cualquier cliente MySQL, como MySQL Workbench o la línea de comandos, para conectarte usando estas credenciales. 

Si usas IntelliJ o Visual Studio, recomiendo descargar un plugin para facilitar la gestión de bases de datos. Para IntelliJ, se puede utilizar **Database Navigator**, y para Visual Studio, **JDBC Client**.

## Explicación

### docker-compose.yml

El archivo `docker-compose.yml` define cómo se debe ejecutar el contenedor y su configuración específica.

```yaml
services:
  mysql:
    image: mysql:latest
    container_name: mysql
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword 
      MYSQL_DATABASE: my_database       
      MYSQL_USER: user                  
      MYSQL_PASSWORD: userpassword
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

### Detalles de la configuración

- **MySQL**:
  - `image: mysql:latest`: Utiliza la última imagen de MySQL.
  - `container_name: mysql`: Asigna un nombre al contenedor de MySQL.
  - `ports`: Mapea el puerto `3306` del contenedor al puerto `3306` de la máquina local, permitiendo conexiones desde el host.
  - `environment`: Define las variables de entorno necesarias para la configuración de la base de datos:
    - `MYSQL_ROOT_PASSWORD`: Contraseña del usuario root.
    - `MYSQL_DATABASE`: Nombre de la base de datos inicial.
    - `MYSQL_USER`: Nombre de un usuario adicional.
    - `MYSQL_PASSWORD`: Contraseña del usuario adicional.
  - `volumes`: Utiliza un volumen persistente para almacenar los datos de MySQL, asegurando que no se pierdan cuando el contenedor se detiene o se elimina.