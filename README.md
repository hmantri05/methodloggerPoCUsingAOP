# methodloggerPoCUsingAOP
A simple PoC to log all the method parameters using AOP in Java
This is a Java Springboot project

## Steps to run
1. Clone the repository to your IDE
2. Import Maven Projects from the repository
3. Run the project as SpringBootApplication
4. Hit this URL from the browser to see the logger in action:

```
http://localhost:8080/logMessage?message1=test1&message2=test2
```

You will see that the logs are printed on your console.

In this project, the logs are printed onto the standard output console, but we can configure a logging framework for our project such as ```log4j``` and print the logs using logger as well.

## To implement this type of logging into your existing SpringBoot project, do the following:
1. Add the following dependencies in your ```pom.xml```

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
    <version>2.0.1.RELEASE</version>
</dependency>

<dependency>
    <groupId>com.jcabi</groupId>
    <artifactId>jcabi-aspects</artifactId>
    <version>0.22.6</version>
</dependency>

<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.8.7</version>
</dependency>
```

2. Copy ```MethodLogger.java``` into your Java project

3. Annotate the methods that you want to log with ```@Loggable``` annotation and you will notice the logs on your output console.

Happy coding! 
