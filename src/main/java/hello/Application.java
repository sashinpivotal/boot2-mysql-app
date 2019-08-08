package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

// ----------- PART 1 ---------------
// Run the application locally.

// TODO-11: Install and start MySQL server

// TODO-12: Using MySQL client, do the following
// mysql> create database db_example; -- Create the new database
// mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
// mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database

// TODO-13: Run this application

// TODO-14: Add a couple of new users and then access all users
// curl -X POST localhost:8080/demo/add -d name=mary -d email=mary@gmail.com
// curl -X POST localhost:8080/demo/add -d name=sang -d email=sang@gmail.com
// curl localhost:8080/demo/all

// TODO-15: Create fat jar
// ./mvnw clean package

// ----------- PART 2 ---------------
// Run the application in PCF. Three key benefits to note
// 1. You self-serve a backing service, MySQL database in this
//    example (via "create-service")
// 2. You don't have to configure database credentials.
//    The database credentials are automatically set
//    (via "bind-service")
// 3. The same application runs locally and on PCF without
//    any code change.  In other words, a "DataSource" bean
//    gets created with proper settings depending on where
//    it is being deployed (via Java Buildpack of PCF
//    (See https://github.com/cloudfoundry/java-buildpack-auto-reconfiguration)

// TODO-21: Log in to the PWS
// cf login -a https://api.run.pivotal.io
//
// TODO-22: Deploy the application
// cf push my-mysql-app -p ./target/boot-mysql-app-0.1.0.jar --random-route --no-start

// TODO-23a: Create a service instance from 'cleardb'
// cf create-service cleardb spark my-mysql-db
// TODO-23b: Wait until the service is created
// cf services (and verify "create succeeded")

// TODO-24: Bind your application to the service instance
// cf bind-service my-mysql-app my-mysql-db

// TODO-25: Restart the application
// cf restart my-mysql-app

// TODO-26: Find out the route of your application
// cf apps (route of the my-mysql-app will be displayed)

// TODO-27: Assuming the route of your app is <my-mysql-app-route>,
//          add a couple of users and then access all users
// curl -X POST <my-mysql-app-route>/demo/add -d name=mary -d email=mary@gmail.com
// curl -X POST <my-mysql-app-route>/demo/add -d name=sang -d email=sang@gmail.com
// curl <my-mysql-app-route>/demo/all

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(DataSource dataSource) {
        return args -> System.out.println("---> Datasource: " + dataSource);
    }
}
