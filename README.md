# Saddlepoint-Spring-MVC

**Build with Maven**

`mvn clean package`


**Run the Spring app**

`java -jar target/Saddlepoint-0.0.1-SNAPSHOT.jar`


**POST request**

`curl -X POST -F 'file=@matrix.txt' localhost:8080/rest/matrix`


**RESPONSE**

`{"size":3,"data":[[1,2,3],[4,5,6],[7,8,9]],"saddlePoint":{"row":2,"col":0,"value":7}}`
