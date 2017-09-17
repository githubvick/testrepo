FROM java:8
VOLUME /tmp
ADD Reward/target/Reward.jar rewardfinal.jar
RUN bash -c 'touch /rewardfinal.jar'
EXPOSE 8082
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/microservices", "-Djava.security.egd=file:/dev/./urandom","-jar","/rewardfinal.jar"]
