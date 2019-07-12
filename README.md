# SPRING-BOOT-REST
## REST API with Spring Boot 
### Includes embeed H2 Database, embeed Tomcat server, documentation with Swagger 2 and support for Docker and K8s

### Includes a small CRUD for a Employee Entity.

To run locally:
* mvn spring-boot:run

To package with dependencies:
* mvn clean package spring-boot:repackage

To run repackaged jar:
* java -jar target/employee-api-1.0.0.jar 

See Swagger documentation at:
* http://localhost:8080/

*See schema and data files for DB definition*

Feel free to reach me at carlos.salazar@codesolt.com or find out more about me at https://carlos-salazar.com/ or visit my programming blog https://codesolt.com/

## Added support for Docker & K8s

For all the following section make sure you have a Spring Boot fat jar built:
`mvn clean package spring-boot:repackage`

### Docker:
1. Build the image: `docker image build -t codesolt/spring:0.1.0 .`
2. Ensure the image by running it as: 
`docker container run --name springapp -p 8080:8080 -d codesolt/spring:0.1.0`
3. Kill the image: `docker rm -f <container-id>`

* Use slim JRE for a smaller image:
`docker image build -t codesolt/spring:0.1.1 -f Dockerfile.slim .`
* Use alpine for smallest image:
`docker image build -t codesolt/spring:0.1.1 -f Dockerfile.alpine .`

### Docker with jib
1. Build your image our of Maven plugin with: `mvn clean compile jib:dockerBuild`

* Current build pointing to `0.1.3` (consider when running)

### K8s with config file
1. Point your `kubectl config` to a proper running K8s cluster
2. Deploy the following file to the cluster with:
`kubectl create -f app.yaml`
3. See your deployment, service and pods with:
`kubectl get all` 
4. Delete your deployment with:
`kubectl delete -f app.yaml`

### K8s using Helm
1. Install Helm in your machine:
`brew install helm`
2. Create a Tiller in your cluster
`kubectl -n kube-system create sa tiller`
`kubectl create clusterrolebinding tiller --clusterrole cluster-admin --serviceaccount=kube-system:tiller`
`helm init --service-account tiller`
3.Deploy with helm template using:
`helm install --name springapp springapp`
4. Delete deployment with:
`helm delete --purge springapp`

### Skaffold support
1. Install Skaffold with brew on your machine:
`brew install skaffold`
2. Skaffold will automatically use the `latest` version of you image, so build it with:
`docker image build -t codesolt/spring .`
3. Run in the project directory to deploy your deployment & service:
`skaffold dev`

### Debug image with IDEA
1. Open Run menu/debug/config
3. Create a new `remote` configuration
3. Hit the debug button (Image has to bee running on local host, make an SSH tunnel if not)

* Consider this will work only with K8s deployments, not single docker images

## Support for AWS EKS

### EKS support
1. Change K8s context to AWS
`kubectl config use-context <aws-context>`  
2. Deploy to EKS cluster with HElM
`helm install --name springapp springapp`
3. Delete deploy, service and pods with (if needed):
`helm delete --purge springapp
