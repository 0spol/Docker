# Descomprimir archivos tar.gz, .tar, .rpm y .deb

Esta subcarpeta contiene un conjunto de instrucciones para crear un entorno Linux que descomprima todos los archivos en la carpeta `files/`.

## Uso

### Puesta en marcha

1. **Posiciónate en la carpeta**: Abre tu terminal y navega a la carpeta donde se encuentra el archivo `docker-compose.yml`.

2. **Ejecuta el comando**:

   ```bash
   docker compose up -d
   ```

   **Explicación**: Este comando descargará las imágenes necesarias, montará la carpeta `files/` en el contenedor, descomprimirá los archivos y devolverá el resultado.

## Explicación

### docker-compose.yml

El siguiente contenido define cómo se ejecutará el contenedor de extracción:

```yaml
services:
  extractor:
    build: .
    volumes:
      - ./files:/files
```

### Dockerfile

El archivo `Dockerfile` se utiliza para definir la imagen que se construirá para extraer los archivos. Aquí está su contenido:

```dockerfile
# Usa una imagen base de Ubuntu
FROM ubuntu:latest

# Instala las herramientas necesarias para manejar .deb, .rpm y archivos .tar.gz
RUN apt-get update && \
    apt-get install -y \
    dpkg \
    rpm2cpio \
    cpio \
    tar \
    gzip && \
    apt-get clean

# Establece el directorio de trabajo
WORKDIR /files

# Ejecuta el script de extracción al iniciar el contenedor
CMD bash -c "for file in *; do \
    case \"\$file\" in \
        *.deb) mkdir \"\${file%.deb}\" && dpkg-deb -x \"\$file\" \"\${file%.deb}\" && rm \"\$file\" ;; \
        *.rpm) mkdir \"\${file%.rpm}\" && rpm2cpio \"\$file\" | cpio -idmv -D \"\${file%.rpm}\" && rm \"\$file\" ;; \
        *.tar.gz) mkdir -p \"\${file%.tar.gz}\" && echo \"Descomprimiendo: \$file\" && tar -xzf \"\$file\" -C \"\${file%.tar.gz}\" && rm \"\$file\" ;; \
        *.tar) mkdir -p \"\${file%.tar}\" && echo \"Descomprimiendo: \$file\" && tar -xf \"\$file\" -C \"\${file%.tar}\" && rm \"\$file\" ;; \
    esac; done"
```