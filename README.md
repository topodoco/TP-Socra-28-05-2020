# EPITA-SOCRA-JAVA

Projet de base en Java pour le TP de Software Craftmanship

Afin d'être opérationnel vous devez  :
- Trouver un binôme
- Avoir un PC avec a minima Java et maven. Un IDE comme Eclipse, IntelliJ ou Visual Studio Code est préférable.
- Le projet de base :
  - Il compile : `mvn compile`
  - Le test passe : `mvn test`
  - Il s'exécute : `mvn -q exec:java -Dexec.mainClass=com.epita.socra.app.App`
  - Vous pouvez aussi exécuter : `mvn package && java -cp target/socra-app-1.0-SNAPSHOT.jar com.epita.socra.app.App`
  
  
## Visual Studio Code 

Durant le TP, si vous utilisez VS Code, vous pouvez lancer les tests et obtenir votre couverture en direct via la commande : 

`mvn jacoco:prepare-agent test jacoco:report`

Il vous faudra le plugin `ryanluker.vscode-coverage-gutters`
