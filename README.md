# Donjon project

For run project :
- run : ```mvn clean install```
- run : 
    - if window : ```java -XstartOnFirstThread -cp "target/labyrinth-monsters-1.0.jar;libs/*" Main```
    - if linux : ```java -cp "target/labyrinth-monsters-1.0.jar:libs/*" Main```
    - Attention : Peut être besoin d'installer ça ```sudo yum install openal-soft```
    - Attention : Besoin d'installer la librairie jsfml ```mvn install:install-file -Dfile=libs/jsfml.jar -DgroupId=org.jsfml -DartifactId=jsfml -Dversion=1.0 -Dpackaging=jar```
    
For develop in IDE, add external dependency ```libs/jsfml.jar``` in your IDE.
