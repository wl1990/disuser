FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD disuser.jar appdocker.jar
#RUN bash -c 'touch /appdocker.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/appdocker.jar"]