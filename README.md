# pruebaJava - Sprint Boot Gustavo Polania

## Instalación
La base de datos es MYSQL y el nombre de la base de datos debe ser "pruebajava".

Presionar Control+F10 para levantar el proyecto.

EL proyecto corre en
http://localhost:8081/app/api/

#Los siguientes son las rutas de los servicios

### Listar todas las inscripciónes
 GET => http://localhost:8081/app/api/inscriptions/
### ------------------------------------------------------------------------------------------------------------------
### Listar todas las casas
GET => http://localhost:8081/app/api/inscriptions/houses/
### ------------------------------------------------------------------------------------------------------------------


### Crear inscripción
POST => http://localhost:8081/app/api/inscriptions/
#### contenido
{
"name": "Gustavo",
"lastname": "Ardila",
"identification": 776584,
"age": 20,
"house":3
}
### ------------------------------------------------------------------------------------------------------------------
### Actualizar inscripción
PUT => http://localhost:8081/app/api/inscriptions/9
#### Contenido
{
"name": "Camilo",
"lastname": "Ardila",
"identification": "3216972",
"age": "12",
"house": 2
}
### ------------------------------------------------------------------------------------------------------------------
### Eliminar inscripción
DELETE => http://localhost:8081/app/api/inscriptions/1
### ------------------------------------------------------------------------------------------------------------------
### Paginar inscripción
GET => http://localhost:8081/app/api/inscriptions/pageable?page=1&size=5

