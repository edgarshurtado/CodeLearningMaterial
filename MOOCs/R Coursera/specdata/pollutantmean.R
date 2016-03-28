# Functions for Assigment 1

pollutantmean <- function(directory = getwd(), pollutant, id = 1:322){
    files <- list.files(directory, full.names = TRUE)[id]
    result <- NA
    for(i in 1:length(id)){
        data <- read.csv(files[i])
        result <- c(result, data[, pollutant])
    }
    mean(result, na.rm = TRUE)
}

nComplete <- function(file) {
    data <- read.csv(file)
    compCases <- complete.cases(data)
    length(compCases[compCases == TRUE])
}

complete <- function(directory = ".", id = 1:332){
    files <- list.files(directory, full.names = TRUE)[id]
    resultDataFrame <- data.frame("complete.cases" = numeric(0))
    for(file in files){
        tempDataFrame <- data.frame("complete.cases" = nComplete(file), row.names = file)
        resultDataFrame <- rbind(resultDataFrame, tempDataFrame)
    }
    resultDataFrame
}

corr <- function(directory = ".", threshold = 0){
    files <- list.files()[1:332]
    result <- numeric(0)
    for(file in files){
        if(nComplete(file) >= threshold){
            data <- read.csv(file)
            data <- data[complete.cases(data),]
            result[length(result) + 1] <- cor(data$sulfate, data$nitrate)
        }
    }
    result
}