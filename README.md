# SPRING-BOOT-REST
## REST API with Spring Boot 
### Includes embeed H2 Database, embeed Tomcat server, documentation with Swagger 2 and Authorization with OAUTH2 server

### Includes a small CRUD for a Employee Entity.

To run locally:
* mvn spring-boot:run

To package with dependencies:
* mvn clean package spring-boot:repackage

To run repackaged jar:
* java -jar target/employee-api-1.0.0.jar 

See Swagger documentation at:
* http://localhost:8080/

*Requires OAUTH2 authentication for consuming*

*See schema and data files for DB definition*

Feel free to reach me at carlos.salazar@codesolt.com or find out more about me at https://carlos-salazar.com/ or visit my programming blog https://codesolt.com/

## Added support for Docker & K8s

### Docker:
1. Package your application: `mvn clean package`
2. Build the image: `docker image build -t codesolt/spring:0.1.0 .`
3. Ensure the image by running it as: 
`docker container run --name springapp -p 8080:8080 -d codesolt/spring:0.1.0`
4. Kill the image: `docker rm -f <container-id>`
 
### Docker with jib
1. Build your image our of Maven plugin with: `mvn clean jib:dockerBuild`

### Docker with Java 9 modules
1. create a folder to store your personalized JDK:
`mkdir slimjre`
2. Build a slim JDK with your only needed modules with: 
`jlink --output slimjre --add-modules $(jdeps --print-module-deps target/employee-api-1.0.0.jar),java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument`
3. Build an image using that slim JRE with: `docker image build -t codesolt/spring:0.1.1 -f Dockerfile.jre .`
 
### K8s with config file
1. Point your `kubectl config` to a proper running K8s cluster
2. Deploy the following file to the cluster with:
`kubectl create -f app.yaml`
3. See your deployment, service and pods with:
`kubectl get all` 

### K8s using Helm
1.Deploy with helm template using:
`helm install --name springapp springapp` 