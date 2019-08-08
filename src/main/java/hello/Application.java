package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ----------- PART 1 ---------------
// Run the application locally.

// TODO-11: Start MySQL server

// TODO-12: Using MySQL client, do the following
// - mysql> create database db_example; -- Create the new database
// - mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
// - mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database

// TODO-13: Run this application

// TODO-14: Add a new user and then access all users
// curl -X POST localhost:8080/demo/add -d name=mary -d email=mary@gmail.com
// curl localhost:8080/demo/all

// TODO-15: Create fat jar
// mvnw clean package

// ----------- PART 2 ---------------
// Run the application in PCF. Note that database credentials
// are automatically created and used to create DataSource bean.

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

// TODO-27: Assuming the route of your app is <my-mysql-app-route>
//          access the application
// curl -X POST <my-mysql-app-route>/demo/add -d name=mary -d email=mary@gmail.com
// curl -X POST <my-mysql-app-route>/demo/add -d name=sang -d email=sang@gmail.com
// curl <my-mysql-app-route>/demo/all

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
