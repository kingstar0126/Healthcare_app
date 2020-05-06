#####Project documentation
Steps to be followed!
-
Create Springboot application
-
1. Create a simple springboot project from spring.io
    https://start.spring.io/
2. Add dependencies a) spring-boot-starter-web b) spring-boot-starter-data-mongodb
3. Download/Generate project
4. Extract in your local
5. import the project in IntelliJ as a maven project 

Application setup
-
1. Create required java classes and implement your logic
2. add spring.data.mongodb.uri=mongodb://mongo:27017/doctordb in application properties
    where mongo refers to localhost in this case it refers to docker container name
    27017 is the default mongodb port in this case it is exposed from docker container
    doctordb is the mongodb database
    You can use local mongodb in that case the URL is as below
    spring.data.mongodb.uri=mongodb://localhost:27017/doctordb
    Unless mongodb profile/user is not created we can refer as above else we need to specify the username and password
    spring.data.mongodb.uri=mongodb://user:password@localhost:27017/doctordb    
3. Run the application and test if you're able add/get/update/delete operations

MongoDB setup
-
1. Download the latest mongoDB binaries as zip
2. Extract the zip and place under the desired location
3. Create a folder called data under C directory in Windows machine, linux please follow steps from official site.
4. Run mongod.exe from the <installed dir>/bin/ available under folder.
5. Run mongo.exe to connect to the database

Useful MongoDB commands
-
1. show dbs or show databases
2. use doctordb - doctordb database
3. show collections - list all collections available
4. db.doctors.find() - Find all the entries in collections
5. db.doctors.findOne() - Find first entry of the collection

Docker movement
-
1. Create a dockerfile with the following
    FROM java:8                  - Get java:8 image from docker hub
    VOLUME /tmp                  - Create a volume
    ADD target/SpringbootProject-1.0-SNAPSHOT.jar app.jar 
                                 - Add project from the target and rename as app.jar
    EXPOSE 8080                  - Expose port 8080
    RUN bash -c 'touch /app.jar' - This trick allows you to run Linux commands in powershell, just as you'd run a 
                                   normal windows executable. As with a command prompt window, the output of the command will appear directly
                                   in the powershell. These methods can be used to add Linux commands to a batch file or powershell scripts too.
                                   Run the command in the background and pass the command to it
    ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/test","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
                                 - How to run your java application once the docker container image is started.
                                   urandom is used to activate a much faster implementation for the SecureRandom provider
                                   In some applications this can cut down the applications startup time in half.
                                   In short it looks like this ENTRYPOINT ["java","-jar","/app.jar"]
                                   Check if you're able to connect to mongoDB
2. Docker build
    docker build -t healthcare-backend:latest .
    Here -t is a tag which will be given the image, healthcare-backend being the name, latest being the tag/version
    Dot (.) refers to the current version.               
3. Pull the mongoDB image from the docker hub and run it.
    docker run --name mongo mongo
    Remember the name should be mongo as we mentioned in the application.properties file.
    Here --name gives a name to image and container. If not given then docker will generate its own name.
4. Run the healthcare-backend image
    docker run -d -p 8080:8080 --link=mongo -t healthcare
    Here -d is detached mode, -p is for exposing port, --link to establish a link between spring and mongodb containers
    Check logs using - docker container logs <container-name>
    Connect to container using - docker container exec -it <container-name> bash 
5. You can create volume if you think you need to expose outside docker containers.
6. Test using Postman to check if the services are working as expected.
7. It is best to use docker-compose when we have multiple docker containers to run.

Other useful docker commands
-
01. docker ps
02. docker ps -all
03. docker images
04. docker image rm <image-name>
05. docker container ls -all
06. docker container ls
07. docker container rm <container-name>
08. docker container start <container-name>
09. docker container stop <container-name>
10. docker network ls
11. docker network create <network-name>
12. docker volume create <volume-name>
13. docker volume ls
14. docker run -v c:/data:/opt/logs -network=<network-name> <image-name:tag>