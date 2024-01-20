# Autor: Alejandro Polo Carvajal
#### https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/
## reto_tecnico_juju
PRUEBA ANALISTA DE CALIDAD
#### Pagina automatizada: https://automationcompany-qa.jujutests.com/
#### Funciones automatizadas: Login - Catalogo
#### Patron de diseño: Screenplay
#### Framework: gherkin, cucumber, Junit, SerenityBDD, selenium
#### Framework adicionales: librerias lombok, Faker, SonarLink, cucumber for java
#### Lenguaje programacion: Java
#### version gradle: gradle-8.4
#### OPEN_JDK Version 17.0.9
#### Driver: Edge version  120.0.2210.121
#### ID: Intellij IDEA community Edition 2023.1
##### ------------------------------------------------------------------------------------------------------

### Todos los casos pruebas cumplen con cada criterio solicitado
### Todas las clases estan con auto-ident lines y reformat code
### El codigo no tiene ningun Bug o codeSmell 
##### ------------------------------------------------------------------------------------------------------
## Dentro de esta ruta encontrara dos runners llamados:
#### src/test/java/co/com/juju/project/runners
#### LoginRunner.java
#### CatalogRunner.java
## Todos los test funcionan correctamente VER IMG-0
# PASOS PARA LE EJECUCIÓN

## Opcion 1
#### El stakeholder podra ejecutar desde la linea #15 si gusta (Ver IMG-1)
#### Automaticamente se ejecutara todos los test que estan dentro del feature ( aplica para ambos ) ya que el tag que esta por defecto es general solo para login
### IMG-1
![img1.png](..%2F..%2FUsers%2Faleja%2FOneDrive%2FEscritorio%2Fimg1.png)

#### En caso de ejecutar individual, solo cambiar en la linea #13  el tags "" cada escenario tiene uno (Ver IMG-2)
### IMG-2
![img2.png](..%2F..%2FUsers%2Faleja%2FOneDrive%2FEscritorio%2Fimg2.png)
##### ------------------------------------------------------------------------------------------------------

## Opcion 2
### PASO A PASO PARA LA EJECUCIÓN POR CONSOLA

## Comando para limpiar el proyecto y luego ejecuta TODOS los escenarios uno por uno (total 4)
#### ./gradlew clean test
## Comando para ejecutar por feature 
#### ./gradlew test --tests "co.com.juju.project.runners.LoginRunner"
## comando para generar reporte despues que haya terminado un test (Por consola arrojara la ruta .html )
#### ./gradlew reports   
## Comando para limpiar los reportes
#### ./gradlew clearReports


# IMG-0
![img0.png](..%2F..%2FUsers%2Faleja%2FOneDrive%2FEscritorio%2Fimg0.png)