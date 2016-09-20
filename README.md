## My Experiments on Spring Boot
## This uses mysql, will use ng2 etc

# gradle

brew install gradle
gradle -v
#nano build.gradle
gradle wrapper
gradle tasks
./gradlew build && java -jar build/libs/myproject-0.0.1-SNAPSHOT.jar


## git ignores
should ignore
build/*

## should be added to repo
gradlew


gradle idea

start app in terminal with

gradle bootRun
which can then see how it reloads the changes




## to run a specific profile options
1 SPRING_PROFILES_ACTIVE=staging ./gradlew bootRun
2. ./gradlew staging bootRun
3. ./gradlew build && java -jar build/libs/myproject-0.0.1-SNAPSHOT.war --spring.profiles.active=staging


build war
gradle -Denv=prod war


# Mysql
Look at database/setup.sql
mysql -u boot_user -p bootsample



JDBC Security
http://www.programming-free.com/2015/09/spring-security-jdbc-authentication.html


Multiple DS
https://scattercode.co.uk/2013/11/18/spring-data-multiple-databases/


JODA Time into JPA
http://blog.netgloo.com/2015/04/06/spring-boot-using-joda-time-on-jpa-entity-with-hibernate/

Spring Managed Hibernate Persistence Provider for Entity Listeners
https://dzone.com/articles/spring-managed-hibernate


# TODO
before startup if dev mode
    drop all tables from all datasources

after startup
    populate data

Create a User class extending org.springframework.security.core.userdetails.UserDetails
Create a UserDetailsService implementing org.springframework.security.core.userdetails.UserDetailsService
Create util SecurityService to getCurrent User, isLogin check, reautneticate
