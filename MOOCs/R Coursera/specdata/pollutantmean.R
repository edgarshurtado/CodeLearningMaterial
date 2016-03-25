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