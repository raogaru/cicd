# ######################################################################
# Dockerfile: tomcat 
# ######################################################################
FROM centos

MAINTAINER rao@raogaru.com

RUN mkdir /opt/tomcat/

WORKDIR /opt/tomcat
RUN curl -O https://downloads.apache.org/tomcat/tomcat-10/v10.0.6/bin/apache-tomcat-10.0.6.tar.gz
RUN tar xvfz apache-tomcat-*.tar.gz
RUN mv apache-tomcat-*/* /opt/tomcat/.
RUN yum -y install java
RUN java -version

WORKDIR /opt/tomcat/webapps
RUN rm -rf docs examples manager host-manager
RUN curl -O -L https://github.com/AKSarav/SampleWebApp/raw/master/dist/SampleWebApp.war

COPY tomcat-users.xml /opt/tomcat/conf/
COPY index.jsp /opt/tomcat/webapps/ROOT/

EXPOSE 8080

CMD ["/opt/tomcat/bin/catalina.sh", "run"]
