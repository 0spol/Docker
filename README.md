## Presentación

Este `README.md` sirve para conocer, en términos generales, lo que se necesita para usar las máquinas, la organización del repositorio y una pequeña introducción a Docker para que sepas lo mínimo necesario para utilizarlo.

## Organización del repositorio

Este repositorio tendrá una subcarpeta por cada máquina virtual en Docker que monte, y junto a los archivos de esa subcarpeta habrá un archivo `README.md` explicando cómo usar esa máquina y una breve explicación de su funcionamiento.

## Conceptos mínimos de Docker

- **Imagen**  
  Un archivo de solo lectura que contiene instrucciones, se podría asemejar a un molde.

- **Contenedor**  
  Una instancia en ejecución de una imagen, se podría asemejar a usar ese molde (imagen) y crear una figura.

- **Volumen**  
  Es un espacio de almacenamiento persistente que puede ser utilizado por los contenedores para guardar datos.

## Requisitos

### Instalación de Docker 

- [Docker Desktop](https://www.docker.com/get-started)

### Clonar el Repositorio

```bash
git clone https://github.com/0spol/Docker.git
```

### Clonar el Repositorio como Submódulo

Para mantener el código del repositorio **Docker** actualizado en tu proyecto, puedes agregarlo como un submódulo.

1. **Agrega el submódulo**
   ```bash
   git submodule add https://github.com/0spol/Docker.git docker
   ```
   Esto creará una carpeta llamada `docker` que estará vinculada al repositorio externo.

2. **Inicializa el submódulo**  
   Asegúrate de que el submódulo esté correctamente inicializado.
   ```bash
   git submodule update --init --recursive
   ```

3. **Realiza un commit de la configuración del submódulo**  
   Registra los cambios en tu repositorio principal.
   ```bash
   git add .gitmodules docker
   git commit -m "Añadido submódulo docker"
   git push origin main
   ```

##### Actualización del Submódulo

Si el repositorio **Docker** recibe actualizaciones, sigue estos pasos para mantener tu submódulo al día:

1. **Accede al directorio del submódulo**.
2. **Obtén los últimos cambios**
   ```bash
   git pull origin main
   ```

##### Clonación del Repositorio con el Submódulo

Si deseas clonar tu repositorio junto con el submódulo, utiliza el siguiente comando:
```bash
git clone --recurse-submodules https://github.com/tu-usuario/tu-repositorio.git
```

Si ya has clonado el repositorio sin los submódulos, puedes inicializarlos con:
```bash
git submodule update --init --recursive
```