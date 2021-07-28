# Seu Barriga / Curso de testes automatizados

## Projeto de testes automatizados usando a interface WEB Seu Barriga

### Ambiente

- [JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html "JDK")
    - (Versão utilizada: 11.0.11)
- [Maven](https://maven.apache.org/download.cgi "Maven")
    - (Versão utilizada: 3.8.1)

### Configuração

Clone o repositório:
```
git clone git@github.com:delonborges/seubarriga-web-test-automation.git
```
Acesse a pasta do projeto:
```
cd seubarriga-web-test-automation
```
Efetue a instalação das dependências (os testes serão iniciados também):
```
mvn install
```
Ou, efetue a instalação das dependências, sem a execução dos testes:
```
mvn install -DskipTests
```


### Execução local
Inicie a execução dos testes:
```
mvn test
```
Ou, execute o comando abaixo para executar a suíte de testes `TestsSuite`, especificamente:
```
mvn -Dtest=TestsSuite test 
```

#### Execução remota
Altere o arquivo `Properties`, dentro da pasta `common`, para `GRID`:
```
public static Executions execution = Executions.GRID;
```
Inicialize o hub:
```
java -jar selenium-server-standalone-3.141.59.jar -role hub
```
Inicialize o(s) nó(s):
```
java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register
```
