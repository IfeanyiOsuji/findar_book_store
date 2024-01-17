# findar_book_store

This project aims to integrate payment APIs of popular organizations like paystack, interswitch, flutterwave, etc.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)

## Installation
This is a server side project so in order to set up the project, you need to JDK installed. You also need to have maven installed and a host of dependencies such as spring data jpa, spring data web, h2 database, spring starter validation

## Usage

To run this project, make sure you have JDK 17 or higher installed

1. Clone the repository:
   git clone https://github.com/IfeanyiOsuji/findar_book_store.git

2. Navigate to the project directory
   cd findar_book_store

Compile the Java files
javac BookStoreApplication.java
or
Click on the run button at the top right if you are using vs code or intellij idea

4. Run the program
   java BookStoreApplication.java

If the code runs successfully, you can use postman to call the endpoints


## Examples
To add new Book to the store:
http://localhost:8080/rest/book/addBook

To update a book details:
http://localhost:8080/rest/book/updateBook/id/{id}

To list all available books:
http://localhost:8080/rest/book/listBooks/{pageNumber}/{pageSize}

To delete a book from the store:
http://localhost:8080/rest/book/deleteBook/id/{id}


