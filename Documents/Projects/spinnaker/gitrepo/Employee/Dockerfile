FROM java:8
VOLUME /tmp
ADD Employee/target/Employee.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 30062
RUN apt-get update && apt-get install -yq dnsutils  && apt-get clean && rm -rf /var/lib/apt/lists
RUN apt-get update && apt-get install -yq netcat  && apt-get clean && rm -rf /var/lib/apt/lists
RUN apt-get update && apt-get install -yq telnetd  && apt-get clean && rm -rf /var/lib/apt/lists
#RUN apt-get install telnetd
#RUN apt-get install -yq netcat
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongodb/microservices", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
