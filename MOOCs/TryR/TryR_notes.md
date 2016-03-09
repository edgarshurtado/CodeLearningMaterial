# R Syntax
T and F are shorthand for TRUE and FALSE. 
``` 
T == TRUE
[1] TRUE
```
it's TRUE and FALSE. true and false doesn't work.

## Asignation
```
x <- 42
```
**R is dinamic**


```
rep("Yo ho!", times = 3)
[1] "Yo ho!" "Yo ho!" "Yo ho!"
```

## Getting Help
```
help(functionname) #-> documentation about the function
example(functionname) #-> usage examples for the function
```

## Files
Get a list of files
```
list.files()
```

Run a script
```
source("bottle1.R")
```


## Vectors
Create a vector
```
c(4, 7, 9) #-> the vector values have to be of the same type
```

If we put diferent types of values the c() function will convert all to a single
type to hold them.

## Sequence Vectors
```
5:9
[1] 5 6 7 8 9

seq(5,9)
[2] 5 6 7 8 9

seq(5, 9, 0.5)
[3] 5.0 5.5 6.0 6.5 7.0 7.5 8.0 8.5 9.0

9:5
[4] 9 8 7 6 5
```

R starts its index at 1
```
sentence <- c('walk', 'the', 'plank')
sentence[1]
[1] "walk"
```

You can add elements to arrays by accesing to the index and the array will
expand.

In R you can use an array to retrieve several values
```
sentence[c(1, 3)]
[1] "walk" "dog"

sentence[5:7] <- c('the', 'poop', 'deck')
```

## Vector Names

Can assign names to elements in an array

```
ranks <- 1:3 
names(ranks) <- c("first", "second", "third")
ranks["first"]
[1] 1
```


## Plotting One Vector
```
barplot(vesselsSunk)
```

> if you give names to the values they'll be represented

## Vector Math

You can simply do vector operation without the map method as python

```
a <- c(1, 2, 3)
a + 1
[1] 2 3 4
```

Operation between arrays
```

a <- c(1, 2, 3)
b <- c(4,5,6)
a + b
[1] 5 7 9
```

Comparations between arrays
```
a == c(1,99,3)
[1]  TRUE FALSE  TRUE
```

## Scatter plots

the function **plot()** takes 2 parameters (2 vectors). The first is for the x
axis and the second is for y axis

## NA elements

When we have some samples missing we have the special type **NA** 


# Matrices

Create a matrix:

```
matrix(0, 3, 4) #-> first argument the inital value, second the rows and third
                #-> the cols
     [,1] [,2] [,3] [,4]
[1,]    0    0    0    0
[2,]    0    0    0    0
[3,]    0    0    0    0
```

Can pass an array as first argument:
```
a <- 1:12
matrix(a, 3, 4)
     [,1] [,2] [,3] [,4]
[1,]    1    4    7   10
[2,]    2    5    8   11
[3,]    3    6    9   12
```

From a vector create a Matrix.

```
plank <- 1:8
dim(plank) <- c(2, 4) #-> First argument are the rows and second the cols
print(plank)
     [,1] [,2] [,3] [,4]
[1,]    1    3    5    7
[2,]    2    4    6    8
```

## Matrix Access
```
print(plank)
     [,1] [,2] [,3] [,4]
[1,]    1    3    5    7
[2,]    2    4    6    8

plank[2, 3]
[1] 6
```

Retrieve an entire row and col
```
plank[2,]
[1] 2 4 6 8

plank[2,]
[1] 2 4 6 8
```

Select rows or cols to retrieve
```
plank[, 2:4] #-> retrieve cols from 2 to 4
     [,1] [,2] [,3]
[1,]    3    5    7
[2,]    4    6    8
```

## Matrix Plotting
```
contour(matrix) #-> 2D representation
persp(matrix) #-> 3D representation
image(matrix) #-> Heat Map
```

# Sumary Statistics
Draw a barplot with a horizontal line (**h**) representing the mean. For vertical
line use **v**.
```
barplot(limbs)
abline(h = mean(limbs))
```
some functions
* mean -> mean of a vector
* sd -> standard deviation of a vector

# Factors
Create a factor
```
chests <- c('gold', 'silver', 'gems', 'gold', 'gems')
types <- factor(chests)
print(chests)
[1] "gold"   "silver" "gems"   "gold"   "gems"  
print(types)
[2] gold   silver gems   gold   gems  
Levels: gems gold silver
```

Values of types
```
as.integer(types)
[1] 2 3 1 2 1

evels(types)
[2] "gems"   "gold"   "silver"
```

Plot by types
```
plot(weights, prices, pch=as.integer(types))
legend("topright", levels(types), pch=1:length(levels(types)))
```

# Data Frames
Are data structures similar as a database or Excel spreadsheet

