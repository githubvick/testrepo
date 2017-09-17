FROM java:8
VOLUME /tmp
ADD Mission/target/Mission.jar missionfinal.jar
RUN bash -c 'touch /missionfinal.jar'
EXPOSE 8081
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/microservices", "-Djava.security.egd=file:/dev/./urandom","-jar","/missionfinal.jar"]
