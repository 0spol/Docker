`🚧 Este README está en proceso. Algunas secciones pueden estar incompletas o sujetas a cambios. 🚧`

# Oracle Database

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno de base de datos para Oracle Database.

## Uso

### Puesta en marcha

1. **Descargar la imagen de Oracle Database**:
   La imagen de Oracle Database no está disponible públicamente. Debes descargarla desde el sitio web de Oracle. 

   - **Registro en el sitio de Oracle**: 
     Visita [Oracle Technology Network](https://www.oracle.com/database/technologies/) y regístrate para obtener una cuenta gratuita si aún no tienes una.

   - **Descargar la imagen**:
     1. Navega a la sección de "Oracle Database".
     2. Encuentra la versión deseada (por ejemplo, Oracle Database 19c) y descarga el archivo `docker-images.zip`. Este archivo contiene los Dockerfiles necesarios para construir la imagen de Oracle Database.
     3. Extrae el contenido del archivo ZIP en tu máquina.

2. **Importar la imagen a Docker**:
   Después de extraer el archivo ZIP, deberías encontrar una carpeta llamada `dockerfiles` que contendrá los Dockerfiles necesarios. Usa los siguientes comandos para construir la imagen de Docker:

   ```bash
   cd /path/to/extracted/dockerfiles
   docker build -t oracle/database:19.3.0-se2 .
   ```

   Asegúrate de reemplazar `/path/to/extracted/dockerfiles` con la ruta real donde se encuentran los archivos extraídos.

3. **Posiciónate en la carpeta**: Abre tu terminal y ve a la carpeta donde se encuentra el archivo `docker-compose.yml`.

4. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando arrancará el contenedor y configurará el entorno para su uso.

### Acceso a Oracle Database

- **URL de acceso**: Oracle Database se ejecuta en `localhost:1521`.
- **Credenciales**:
  - **Usuario SYS**: `SYS`
  - **Contraseña**: `mysecurepassword`
  - **Base de datos**: `mydatabase`
  - **Usuario adicional**: `myuser`
  - **Contraseña del usuario adicional**: `userpassword`
  
Puedes utilizar cualquier cliente de Oracle, como SQL Developer o DBeaver, para conectarte usando estas credenciales.

Si usas IntelliJ o Visual Studio, recomiendo descargar un plugin para facilitar la gestión de bases de datos. Para IntelliJ, se puede utilizar **Database Navigator**, y para Visual Studio, **JDBC Client**.

## Explicación

### docker-compose.yml

El archivo `docker-compose.yml` define cómo se debe ejecutar el contenedor y su configuración específica.

```yaml
services:
  oracle:
    image: oracle/database:19.3.0-se2
    container_name: oracle-db  
    ports:
      - "1521:1521"  
      - "5500:5500"  
    environment:
      ORACLE_PWD: mysecurepassword  
      ORACLE_DATABASE: mydatabase  
      ORACLE_USER: myuser  
      ORACLE_USER_PASSWORD: userpassword  
    volumes:
      - oracle_data:/opt/oracle/oradata  

volumes:
  oracle_data:  
```

### Detalles de la configuración

- **Oracle Database**:
  - `image: oracle/database:19.3.0-se2`: Utiliza la imagen que construiste a partir del Dockerfile.
  - `container_name: oracle-db`: Asigna un nombre al contenedor de Oracle.
  - `ports`: Mapea el puerto `1521` del contenedor al puerto `1521` de la máquina local para conexiones de base de datos, y el puerto `5500` para el Oracle Enterprise Manager.
  - `environment`: Define las variables de entorno necesarias para la configuración de la base de datos:
    - `ORACLE_PWD`: Contraseña para el usuario SYS.
    - `ORACLE_DATABASE`: Nombre de la base de datos inicial.
    - `ORACLE_USER`: Nombre de un usuario adicional.
    - `ORACLE_USER_PASSWORD`: Contraseña del usuario adicional.
  - `volumes`: Utiliza un volumen persistente para almacenar los datos de Oracle, asegurando que no se pierdan cuando el contenedor se detiene o se elimina.