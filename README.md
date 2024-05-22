## Banking System Management
This application handles some of the basics operations of a bank, such as customer's deposit and withdraw, money transferences, and fixed income calculations (Interest Rate or Bonds calculations). Still in development, feel free to contribute!

![Image Demo](https://github.com/derickfelix/BankApplication/blob/master/src/main/resources/images/demo.jpeg)

### Getting Started
#### Step 1: Clone this Repository
`git clone https://github.com/derickfelix/BankApplication` 
#### Step 2: Build & Run
```shell
./mvn clean package
java -jar target/BankApplication-<current version>-jar-with-dependencies.jar
```

### Development
You'll need to use Netbeans for development, this IDE was chosen because it is widely used by most programmers due to its excellent tools for design forms of the Swing GUI.

No database is required to be installed, since this project is using the H2 Database, and all the data will be generated on the home folder of the project ~/.zweibank/db (Unix) or C:\\zweibank\\db (Windows). You can open the console of the database when the application is running by looking into http://localhost:8082.
Enjoy!

### Default Credentials
user: root

password: admin
