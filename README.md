# Overview:
Java project to demonstrate and practice test-driven development (TDD) software engineering principle. As well as other software engineering tools like Java Ant, Java Junit and Git.

# Project Description:
Java program that implements a Searchable Flight Map. Program determines the route to each city that can be reached from the origin city with the associated total cost. At the end, the program outputs the flight route from the origin city to each reachable city and the associated total cost.

# Technologies used
- Java
- Algorthims (BFS)
- Junit for testing
- Java Ant
- TDD Development

# Useful Commands:
```ant clean``` deletes bin/dis/doc directories<br />
```ant init``` creates bin/dis/doc directoreis<br />
```ant compile``` compiles .java classes inside src into bin/main<br />
```ant dis``` transforms .java classes inside src to a jar file in dis<br />
```ant doc``` generates HTML doc of the .java classes
```ant test``` runs 20 JUnit tests


# How to run:
Using the jar file:
```java -jar dis/Project1.jar inputfile.txt outputfile.txt```<br />

Using the compile classes inside bin:
```java bin/main/SearchMap inputfile.txt outputfile.txt```<br />
