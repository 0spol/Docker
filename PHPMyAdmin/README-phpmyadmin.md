# phpMyAdmin con MySQL

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos que incluye un contenedor para MySQL y otro para phpMyAdmin.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando descargará las imágenes necesarias, arrancará los contenedores de MySQL y phpMyAdmin, y configurará el entorno para su uso.

### Acceso a phpMyAdmin

- **URL de acceso**: Abre tu navegador y ve a `http://localhost:8080`.
- **Credenciales**:
  - **Usuario**: `root`
  - **Contraseña**: `rootpassword`

## Explicación

### docker-compose.yml

El archivo `docker-compose.yml` define cómo se deben ejecutar los contenedores y sus configuraciones específicas.

```yaml
services:
  mysql:
    image: mysql:latest
    container_name: mysql
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword 
      MYSQL_DATABASE: my_database       
      MYSQL_USER: user                  
      MYSQL_PASSWORD: userpassword
    volumes:
      - mysql_data:/var/lib/mysql
    networks:
      - app_network

  phpmyadmin:
    image: phpmyadmin:latest
    container_name: phpmyadmin
    environment:
      PMA_HOST: mysql
      MYSQL_ROOT_PASSWORD: rootpassword
    ports:
      - "8080:80"  
    depends_on:
      - mysql
    networks:
      - app_network

volumes:
  mysql_data:

networks:
  app_network:
    driver: bridge
```

### Detalles de la configuración

- **MySQL**:
  - `image: mysql:latest`: Utiliza la última imagen de MySQL.
  - `container_name: mysql`: Asigna un nombre al contenedor de MySQL.
  - `environment`: Define las variables de entorno necesarias para la configuración de la base de datos:
    - `MYSQL_ROOT_PASSWORD`: Contraseña del usuario root.
    - `MYSQL_DATABASE`: Nombre de la base de datos inicial.
    - `MYSQL_USER`: Nombre de un usuario adicional.
    - `MYSQL_PASSWORD`: Contraseña del usuario adicional.
  - `volumes`: Utiliza un volumen persistente para almacenar los datos de MySQL.
  - `networks`: Conecta el contenedor a la red de la aplicación.

- **phpMyAdmin**:
  - `image: phpmyadmin:latest`: Utiliza la última imagen de phpMyAdmin.
  - `container_name: phpmyadmin`: Asigna un nombre al contenedor de phpMyAdmin.
  - `environment`: Define las variables de entorno necesarias para la configuración de phpMyAdmin:
    - `PMA_HOST`: Especifica el nombre del contenedor de MySQL al que phpMyAdmin debe conectarse.
    - `MYSQL_ROOT_PASSWORD`: Contraseña del usuario root para autenticar phpMyAdmin.
  - `ports`: Mapea el puerto 80 del contenedor al puerto 8080 de la máquina local.
  - `depends_on`: Asegura que el contenedor de MySQL esté disponible antes de iniciar phpMyAdmin.
  - `networks`: Conecta el contenedor a la red de la aplicación.