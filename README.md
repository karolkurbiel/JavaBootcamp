# Projects from Java Bootcamp
This repository contains a collection of smaller projects - coding excercises made during the bootcamp listed below. Each project has a task content and a link to my solution from this repository.

## Tech
 - Java 11
 - Maven
 - JUnit

## Table of contents
- [1. Classes and Objects](#classes-and-objects)
    - [1.1 Car with engine](#car)
    - [1.2 Mobile phone](#mobile-phone)
    - [1.3 Cat](#cat)
- [2. OOP principles](#oop-principles)
    - [2.1 Person and student](#person-and-student)
    - [2.2 Inheritance](#inheritance)
    - [2.3 Polymorphism](#polymorphism)
- [3. Interface](#interface)
    - [3.1 Car with interface](#car-with-interface)
- [4. Algorithms](#algorithms)
    - [4.1 Letter counter](#letter-counter)
    - [4.2 Factorial](#letter-counter)
    - [4.3 Fibonacci sequence](#fibonacci-sequence)
    - [4.4 The longest and the shortest words](#the-longest-and-the-shortest-words)
    - [4.5 Bubble sort](#bubble-sort)
- [5. Object methods](#object-methods)
    - [5.1 Beer](#beer)
    - [5.2 Laptop cloning](#laptop-cloning)
- [6. Collection framework](#collection-framework)
    - [6.1 Parts catalogue](#parts-catalogue)
    - [6.2 ArrayList vs LinkedList](#arraylist-vs-linkedlist)
    - [6.3 Unique letters](#unique-letters)
- [7. Comparing objects](#comparing-objects)
    - [7.1 Items in online store](#items-in-online-store)
- [8. Simple bank application](#simple-bank-application)
    - [8.1 Bank accounts](#bank-accounts)
    - [8.2 Transaction log](#transaction-log)
    - [8.3 Handle exceptions](#handle_exceptions)
- [9. Generics](#generics)
    - [9.1 Boxes and shelves](#boxes-and-shelves)
- [10. Enums](#enums)
    - [10.1 Week days](#week-days)
- [11. Java 8 features](#java-8-features)
    - [11.1 Streams and lambdas](#streams-and-lambdas)
    - [11.2 User name with optional](#user-name-with-optional)
    - [11.3 Lambdas](#lambdas)
- [12. Annotations](#annotations)
    - [12.1 Execute annotated method](#execute-annotated-method)
- [13. Immutable objects](#immutable-objects)
    - [13.1 Immutable car](#immutable-car)
- [14. JUnit](#junit)
    - [14.1 Test bank application](#test-bank-application)
- [15. Additional stuff](#additional-stuff)
    - [15.1 Work with files](#work-with-files)

## Projects with task content
### 1. Classes and Objects
#### 1.1 [Car with engine](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_8/carwithengine)

Create class Engine.
 Engine has properties:
- name,
- horsepower,
- capacity,
- isStarted status.

Engine can be started or stopped.
Engine need 50 horsepower for each 100 km/h speed.
Engine uses fuel 10 times more than his capacity for each 100 km. For example, if engine capacity is 2000 cm3 (2L) - it need 20L for 100km.

Create class Car.
Car has properties:
- name,
- Engine (look behind for Engine class),
- fuel tank capacity,
- remaining fuel amount.
- Car can be tank(), which tanks up for full capacity. 

Car can be drive(with speed, for N kilometers). Speed limited by Engine possibilities.
Car can startEngine().
Car can stopEngine();
For drive a car we should start engine first.
We can't start engine if it already started.
We can't stop engine if it already stop.
#### 1.2 [Mobile phone](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_8/mobilephone)
Create class MobilePhone.
Mobile phone has properties:
- brand,
- model,
- battery capacity,
- battery amount,
- memory,
- free memory.

Mobile phone can be charged, which will make battery charged for full.
Mobile phone can install(application name, which take out some amount of memory).
Mobile phone can use some application(for n hours), each hour decrease remain battery amount for 100 mah.
Discharged phone can't do anything except charge.
If there are no free memory - new applications can't be installed.
#### 1.3 [Cat](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_8/cat)
Create class Cat.
Cat has properites: name and isHungry. Cat can eat(some food), play(with toy) and sleep(some time).
Cat also should be able to notify us is it hungry, or not.
Cat never hungry after eating. And always hungry after sleeping.
Cat never eats if it is not hungry.
### 2. OOP principles
#### 2.1 [Person and student](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_10/personandstudent)
Create classes Person and Student.
One should extend another.
Person should have private properties FirstName, LastName, BirthDate (type java.time.LocalDate)
Create constructor with all mentioned parameters.
Student should have additional private properties Faculty and GraduateYear
Create constructor for Student, which has all the same parameters as Person, but also Faculty and GraduateYear. Inside of Student constructor use super constructor for Person.
For Person and for Student create getter methods. Getter method - is a method which just returns value of private property.
For Person and for Student create setter methods. Setter method - is a method which sets value for private property.
#### 2.2 [Inheritance](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_10/inheritanceandpolymorphism)
Create class hierarchy: Airplane, Transport, Car, Bus, Train, Bicycle, Tram, Public Transport, Scooter, Motorbike
Think carefully which class should be parent to another.
#### 2.3 [Polymorphism](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_10/inheritanceandpolymorphism)
1. Finish Inheritance task first.
2. In parent class create a METHOD which related to each child class.
3. In children classes override the METHOD, change the behavior in depends of class type.

Create class for testing polymorphism.
1. Create main method for testing.
2. Create a method, which expects as a parameter object of the parent type for created hierarchy. Inside of this method call the METHOD from the object.

Play around passing different class types to method and see what happens.

### 3. Interface
#### 3.1 [Car with interface](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_11/carwinterface)
Create Car class. It has manufacturer and model properties. Create constructor, setters and getters.
Create interface Tankable with method tank()
Create interface Chargable with method charge()
Create class FuelCar, which extends Car and implements Tankable
Create class ElectricCar, which extends Car and implements Chargable
Create class HybridCar, which extends Car and implements Tankable and Chargable.
Create CarTester class. Create several instances of different cars.
Create array of cars. Put all the before created cars into that array.
Iterate over array.
Inside of loop check with instanceof operator:
- if car is Chargable - charge it;
- if car is Tankable - tank it.

### 4. Algorithms
#### 4.1 [Letter counter](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_14/lettercounter)
For given text print out count for each letter inside. For example:
"This is a test text"
Should give a response: T - 1, h - 1, i - 2, s - 3... and so on.
#### 4.2 [Factorial](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_12/Factorial)
Print factorial for numbers from 0 to 10.
Expected output:
1 1 2 6 24 120 720 5040 40320 362880 3628800
For solution you should use recursive method call.
#### 4.3 [Fibonacci sequence](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_9/fibonacci)
Print first 10 numbers from Fibonacci Sequence.
Expected output:
0 1 1 2 3 5 8 13 21 34
As a solution you should use method with recursive call.
#### 4.4 [The longest and the shortest words](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_8/thelongestandtheshorteswords)
For given text find the longest and the shortest words:
Example: "For given text find the longest and the shortest words",
result: "shortest" and "For"
Think, how to keep all the shortest and longest words in result?
so, for shortest we will get: For, the, the
#### 4.5 Bubble sort
Write application for sorting array with Bubble sort algorithm.
[![Bubble sort](https://img.youtube.com/vi/nmhjrI-aW5o/0.jpg)](https://www.youtube.com/watch?v=nmhjrI-aW5o)
```java
public class Main {

    public static void main(String[] args) {
        int[] array = {5, 9, 1, 0, -2, 3};

        System.out.println(Arrays.toString(turboSortIntegers(array)));
    }

    public static int[] turboSortIntegers(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;
            for(int i = 0; i < (sortedArray.length-1);i++) {
                if(sortedArray[i] > sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
```
### 5. Object methods
#### 5.1 [Beer](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_12/Beer)
Create class Beer.
Add properties: name, type, alcohol amount and volume.
Override equals and hashCode methods for class Beer.
For learning purpose, please, don't use auto-generated templates, but create them manually keeping to rules from lesson.

Create another class with main method.
Create several instances of beers and compare each with another.
Check hash codes for them.
#### 5.2 [Laptop cloning](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_11/laptopcloning)
Create class Processor with properties: name, frequency, number of cores.
Create class HardDrive with properties: name, type, capacity.
Create class Laptop with properties: name, Processor, HardDrive, display size, weight, RAM amount.

Create another class with main method.
Create Laptop instance with HardDrive and Processor inside.

Perform deep cloning for Laptop.
Deep cloning - means, clone not only laptop itself, but also everything what was inside.

ADDITIONAL TASK:
perform the same deep cloning but with copy constructor
### 6. Collection framework
#### 6.1 [Parts catalogue](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_14/partscatalogue)
For popular automotive service we need to implement catalogue with parts.
Each part has the next properties: part-number, brand, name.
We should choose the best option for storing parts in catalogue to have possibility of quick getting them by part-number.
#### 6.2 [ArrayList vs LinkedList](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_13/list)
Save the system time as a start point. System.currentTimeMillis()
Create ArrayList of Integers.
Prepare loop for 100_000 iterations.
Inside of loop add to list new element, but at 0 position. add(0, number). As a number you can use an i from loop, for example. Or anything else.
After loop save end point system time.
Printout to console time spent to loop execution.

Repeat previous steps, but this time create LinkedList of Integers.
Compare execution time for both cases.

Save another one start point time.
Create loop from 0 to 100_000, and inside of loop get from previously created ArrayList elements by index i, so get(i)
Save end point time.
Printout to console execution time.

Repeat getting steps but for previously created LinkedList.
Compare execution time.
#### 6.3 [Unique letters](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_14/uniqueletters)
For given text print out all unique letters. For example This is a test text Should give a response: T, h, i, s, a, t, e, x
### 7. Comparing objects
#### 7.1 [Items in online store](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_15/itemsstorecatalogue)
Consider the scenario:
You are working as a developer in popular online store.
Today your manager said you that last market research shows that your store gets much more clients if you implement possibility to sort catalogue items in different ways.
You asked to do:
- Create Item class with name and price.
- Create Catalogue with items inside.
- Give customers the next possibilities of viewing catalogue items:
    - sorted by item name;
    - sorted by item name in reverse order;
    * sorted by price from the cheapest to the most expensive item;
    * sorted by price from the most expensive to the cheapest item.

### 8. Simple bank application
#### 8.1 [Bank accounts](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_15/bankaccounts)
We are going to implement simple banking application.
We need to have the next:
- Account with possibility:
    * top up
    * withdraw
    * setting percents
    * apply percents on balance
    * getting current balance
    * getting account number
- Debit account:
    * does not allow <0 balance
    * apply percents on balance -> should increase balance on percents difference
- Credit account:
    * has credit limit
    * apply percents on balance -> in case of negative balance should decrease it on percents difference
- Bank with next properties:
    * name
    * accounts
    * Bank can topUp own accounts
    * Bank can withDraw own accounts
- National Bank which:
    * contains all registered banks
    * can return Bank by name

#### 8.2 [Transaction log](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_15/bankaccounts)
Each account should handle all the transaction history.
TopUp, WithDraw and ApplyPercents operations should have a log message in history.
Transaction history should be updated with new record about information of performing transaction.
It should contain Date and Time of operation, type of operation and some basic information about balance before and after transaction.
We should be able to get Collection of history records by setting up date range.

#### 8.3 [Handle exceptions](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_15/bankaccounts)
When we are trying to to get non-existing bank from NationalBank catalogue we need to throw BankNotFoundException.
When we are trying to to get non-existing account from Bank accounts we need to throw AccountNotFoundException.
When we want to withdraw money, but have non sufficient funds for Deposit account NonSufficientFundsException should be thrown, with information about current balance.
When we want to withdraw money, but reached credit limit for Credit account ReachedCreditLimitException should be thrown, with information about current balance and credit limit.

The same related for transfer money operation.

Handle exceptions on top level BankingAplication with try-catch section to be sure that our application will not crash.
### 9. Generics
#### 9.1 [Boxes and shelves](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_16/boxesandshelves)
Create class Box<T> which has possibility to contain several items of the same type. (Means, Collection of T inside. Any collection you want.)
Make method add item which accepts T item
Make method get items, which returns Collection of T with items.

Create abstract class Item.
Create Item sub-classes: Book, Toy, Food.
Create class Fantasy which is subclass for Book.

Create class Shelf, which can contain boxes with something.

Write simple test-class with main method which verifies that created classes works properly.
Create boxes with Toys, Foods, Books and separate Box which accepts only Fantasy books.
Create Shelf, which can contain boxes with Toys only.
Create Shelf which can contains boxes with Books. Ensure, that it still accepts Boxes with Fantasy books as well.
Create Shelf, which can contains boxes of any Item.
### 10. Enums
#### 10.1 [Week days](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_17/weekdays)
Create enum DayOfWeek
It should be enum of MON, TUE, WED, THU, FRI, SAT, SUN, it should have properties:
- String englishName,
- String polishName,
- boolean workingDay

Create getters for all properties.
Create methods fromEnglishName, fromPolishName which will return enum instance by parameter.
Create boolean method isWeekend.
Create methods getWeekends and getWorkingDays
### 11. Java 8 features
#### 11.1 [Streams and lambdas](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_20/streamsandlambdas)
Streams:
1. Create class Person:
    - String firstName
    - String lastName
    - LocalDate birthDay
    - some_enum sex
    - int salary
    - Address address
2. Class Address
    - String city
3. Create list of different persons.
4. Using streams and lambda functions (or method references) create new lists with:
    - all men under 65 years
    - all women with salary less than 5000
    - all persons younger than 18 years from Krakow
    - all persons who are not from Krakow
    
during streaming try to sort lists by firstName, or lastName, or birthDay
try to sort in reverse order
hint: use stream, filter, predicate, sort, collect, collector
5. Using streams and lambda functions find:
    - average salary
    - number of women in Krakow
    - number of men after 65 years
    - oldest person
    - youngest person from Krakow
    - total salary

hint: use map, count, max, min, reduce
6. Using streams on new collections from P4 check:
    - does any person has first letter 'A' in firstName
    - does all persons contains letter 'a' in lastName

hint: use anyMatch, allMatch
#### 11.2 [User name with optional](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_20/usernamewithoptionals)
Create method which will generate userName for Person.
UserName will consist from:
1st later from First Name,
LastName
and year of birth day.
For example, Person {"Jan" "Kowalski" 1999-01-01} should get userName jkowalski1999
If Person has no birthday provided, use current year instead. <== do it with Optionals
For example, Person {"Ola" "Nowak" null} should get userName onowak2020

#### 11.3 [Lambdas](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_19/lambdas)
Create some LambdaTester class with main method.
Create static method modifyString which returns String, and gets as a parameter String and Function<String, String>
(Function<String, String> means that this function has inside method which accepts String type, and returns String type).
Method modifyString should just return result of function apply.

From main method call modifyString method with different text as input, and different functions as a modifier.
Make one call with function:
... which converts input String to upper case.
... which converts input String to lower case.
... which returns first letter from input string.
... which returns last letter form input string.

Add another method, which accepts String and Function<String, Integer> (accepts String returns Integer.)
And make lambdas
... which returns length of the input text.
... count of words in String (split by space to array of string, and get array length)
### 12. Annotations
#### 12.1 [Execute annotated methods](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_21/annotatedmethod)
1. Create @Execute annotation.
Add to it property "times" with will be means how much times you want it to be executed.
Default value to "times" property should be 1.

2. Create some class (actually, use you fantasy, and it literally can be ANY class).
And add few methods to it.
Annotate some methods with @Execute annotation.
Play around with "times" property.

3. Create tester class, where we want to execute methods from created at p.3. class.
Using reflection API find all annotated methods in class, and execute them.
We want to execute them so much times, how many that been provided in annotation.

Hints:
- do not forget about @Target and @Retention
- use reflection examples from the lesson
- to execute static method we need to pass null to invoke(...).
- to execute non-static method we need to pass a tarket object to invoke(...).

### 13. Immutable objects
#### 13.1 [Immutable car](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_23/immutableobject)
Let's say we have mutable classes Engine and Wheel:
Engine
String type;
int horsePower;
int volume;
Wheel
int radius;
int width;
Create immutable class Car
Car
String manufacturer;
String model;
Engine engine;
List<Wheel> wheels;
Ensure that class Car really immutable, even with mutable classes Engine and Wheel.
### 14. JUnit
#### 14.1 [Test bank application](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/test/java/_15/bankaccounts)
Add unit tests to Bank Application.
Perform tests for everything you want.
Just remember, that test should be clean, fast, and can be used as documentation for Bank application.
### 15. Additional stuff
#### 15.1 [Work with files](https://github.com/karolkurbiel/JavaBootcamp/tree/master/src/master/java/itacademy/_18/workwithfiles)
Write java application wich:
1. writes text file to your local hard drive with content:
Hello File World!
2. Read the file back to application, and print's read content to console.

