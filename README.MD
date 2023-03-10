# Actividad 21

Toda la actividad se encuentra en el repositorio [calculador](https://github.com/danyelliot/calculador)

Se realizo la actividad en una VM con Ubuntu 18.04.6 

## Ampliación de la pipeline Hello World 


<img src="https://i.imgur.com/tC6kvcG.png" height="500">


<img src="https://i.imgur.com/St3jiOW.png" height="500">


<img src="https://i.imgur.com/sIAetdj.png" height="500">


Se modificó la linea 29 
```
 post { always { echo 'Hola muchas gracias' } }
````

<img src="https://i.imgur.com/zOZOsgJ.png" height="500">


## Creación de una etapa checkout

### Pipeline

<img src="./img/c1.png" height="500">

### Ejecución

<img src="./img/c2.png" height="500">


## Creación de un proyecto Java Spring Boot

### Configuración

<img src="./img/c3.png" height="500">


## Ejecución del proyecto

<img src="./img/c4a.png" height="500">

<img src="./img/c4.png" height="500">

## Creación de una etapa Compile

### Agregando una etapa Compile al pipeline
<img src="./img/c5.png" height="500">

### Ejecución 

<img src="./img/c6.png" height="500">

<img src="./img/c6b.png" height="500">

## Crear la lógica de negocios

<img src="./img/c7.png" height="500">

<img src="./img/c8.png" height="500">

## Ejecución de la construcción en jenkins

Agregando la siguiente etapa al pipeline :

```
stage("Compile") {
    steps {
        sh "./gradlew compileJava"
    }
}
```

<img src="./img/c9.png" height="500">


## Escribiendo una prueba unitaria

<img src="./img/c10.png" height="500">

Ejecución mediante 
```
./gradlew test
```

<img src="./img/c11.png" height="500">

## Creación de una etapa de prueba unitaria

<img src="./img/c12.png" height="500">

<img src="./img/c13.png" height="500">

<img src="./img/c14.png" height="500">

## Jenkinsfile

<img src="./img/jenkinsfile.png" height="500">

## Ejecutar el pipeline desde el Jenkinsfile

### Configuración

<img src="./img/csemi.png" height="500">

### Ejecución

<img src="./img/cfinal.png" height="500">


# Actividad 22

## Agregar JaCoCo a Gradle

<img src="./img/d1.png" height="500">

### Ejecución

```
$ ./gradlew test jacocoTestCoverageVerification
```

<img src="./img/d2.png" >

```
$ ./gradlew test jacocoTestReport
```

<img src="./img/d3.png" >

## Agregando una etapa de cobertura de código

<img src="./img/d4.png" >

<img src="./img/d5.png" >

## Publicación del informe de cobertura de código

<img src="./img/d6.png" >


## Análisis de código estático

1. Agregamos la configuración de Checkstyle
2. Agregamos la etapa Checkstyle
3. Opcionalmente, publicamos el informe Checkstyle en Jenkins

## Agregamos la configuración de Checkstyle

```
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
    "-//Puppy Crawl//DTD Check Configuration 1.2//EN"
    "http://www.puppycrawl.com/dtds/configuration_1_2.dtd">
<module name="Checker">
   <module name="TreeWalker">
     <module name="ConstantName"/>
    </module>
</module>
```

## Información

```
plugins {
...
id 'checkstyle'
}
```

```
$ ./gradlew checkstyleMain
```

<img src="./img/d7.png" >

Agregando 

```
@SpringBootApplication
public class CalculatorApplication {
private static final String constant = "constant";
public static void main(String[] args) {
SpringApplication.run(CalculatorApplication.class,
args);
}
}
```


<img src="./img/d8.png" >

## Agregando una etapa de análisis de código estático

```
stage("Static code analysis") {

steps {
sh "./gradlew checkstyleMain"
}
}
```

