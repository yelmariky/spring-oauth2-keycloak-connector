FROM openjdk:8-jdk-alpine


WORKDIR /app
ADD *.jar keycloak-backend-oauth2.jar
RUN mkdir /app/logs

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","keycloak-backend-oauth2.jar"]

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","keycloak-backend-oauth2.jar"]

## docker build . -t keycloak-backend-oauth2:v1
## docker tag keycloak-backend-oauth2:v1 dokeryelmariki/keycloak-backend-oauth2:latest
## docker push dokeryelmariki/keycloak-backend-oauth2:latest