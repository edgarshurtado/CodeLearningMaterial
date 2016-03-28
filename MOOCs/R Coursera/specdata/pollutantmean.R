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