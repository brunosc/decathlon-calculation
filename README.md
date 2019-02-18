## Decathlon Calculation
> It is a Java program that would calculate the results of a Decathlon competition.

### Input
> A CSV file containing the raw results of the competition

### Output
> The result is an XML file which contains all the athletes in ascending order of their places. Athletes should have all the result data from the CSV file plus calculated total score and the place in the competition. In case of equal scores, athletes must share the places, e.g. 3-4 and 3-4 instead of 3 and 4.

### How to use

Running on command line. Examples below:

> Build
```
$ cd decathlon-calculation
$ mvn clean install
```

> Running and passing a path to CSV on the parameters
```
$ cd target
$ java -jar decathlon-calculation-1.0-SNAPSHOT.jar /home/user/downloads/results.csv
```

