package com.github.derickfelix.bankapplication.utilities;

import com.github.derickfelix.bankapplication.database.BankAppTemplate;
import com.github.derickfelix.bankapplication.models.User;
import com.github.derickfelix.bankapplication.repositories.impl.UserRepositoryImpl.UserMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import org.h2.tools.Server;

public class DBUtility {

    private static BankAppTemplate template;

    private DBUtility()
    {
    }

    public static void prepare()
    {
        try {
            Server.createWebServer().start();
            template = new BankAppTemplate();
            checkDatabase();
        } catch (SQLException e) {
            MessageUtility.error(null, e);
        }
    }

    private static void checkDatabase()
    {
        initialiseTable("customers",
                "id identity", "name varchar", "address varchar", "account_number varchar", "account_type varchar", "password varchar"
        );
        
        initialiseTable("users",
                "id identity", "name varchar", "username varchar unique",
                "password varchar", "role varchar"
        );
        
        initialiseTable("deposits",
                "id identity", "created_at timestamp", "account_number varchar", "amount decimal"
        );
        
        initialiseTable("withdraws",
                "id identity", "created_at timestamp", "account_number varchar", "amount decimal"
        );
        
        // Optional
        seedTables();
        checkDefaultUser();
    }

    private static void initialiseTable(String tableName, String... fields)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("create table if not exists ");
        builder.append(tableName);
        builder.append('(');

        for (int i = 0; i < fields.length - 1; ++i) {
            builder.append(fields[i]);
            builder.append(", ");
        }

        builder.append(fields[fields.length - 1]);
        builder.append(')');

        template.update(builder.toString(), null);
    }
    
    private static void checkDefaultUser()
    {
        String sql = "select * from users where username = 'root'";
        Optional<User> optional = template.queryForObject(sql, null, new UserMapper());
        
        if (!optional.isPresent()) {            
            template.update("insert into users (name, username, password, role) values ('Admin User', 'root', HASH('SHA256', 'admin'), 'Administrator')", null);
        }
    }
    
    private static void seedTables()
    {
        if (!hasData("users")) {
            seedUsers();
        }
        if (!hasData("customers")) {
            seedCustomers();
        }
    }
    
    private static boolean hasData(String table)
    {
        String sql = "select count(*) as count from " + table;
        
        Integer count = template.queryForObject(sql, null, (ResultSet rs) -> rs.getInt("count")).orElse(0);
        
        return count > 0;
    }
    
    private static void seedUsers()
    {
        StringBuilder sql = new StringBuilder("insert into users (name, username, password, role) values\n");

        int amount = 100;

        for (int i = 0; i < amount; i++) {
            sql.append('(');
            //Generating and appending fullname and username
            sql.append(generateNameAndUsername());
            // password
            sql.append("', HASH('SHA256', '123456'), 'Standard')");

            if ((i + 1) < amount) {
                sql.append(",\n");
            }
        }

        template.update(sql.toString(), null);
    }

    private  static StringBuilder generateNameAndUsername(){
        Random random = new Random();
        String[] maleNames = maleNames();
        String[] femaleNames = femaleNames();
        StringBuilder name = new StringBuilder();
        boolean male = random.nextBoolean();
        String firstName = male ? maleNames[random.nextInt(maleNames.length)] : femaleNames[random.nextInt(femaleNames.length)];

        // Full name
        name.append("'");
        name.append(firstName);
        name.append(' ');
        name.append(maleNames[random.nextInt(maleNames.length)]);
        name.append("', '");
        // username
        name.append(firstName.toLowerCase());
        name.append(random.nextInt(1000));

        return name;
    }

    private static void seedCustomers()
    {
        StringBuilder sql = new StringBuilder("insert into customers (name, address, account_number, account_type, password) values\n");
        Random random = new Random();
        String[] maleNames = maleNames();
        String[] femaleNames = femaleNames();
        String[] states = states();
        int amount = 1000;

        for (int i = 0; i < amount; i++) {
            sql.append('(');
            boolean male = random.nextBoolean();
            
            // Full name
            sql.append("'");
            sql.append(male ? maleNames[random.nextInt(maleNames.length)] : femaleNames[random.nextInt(femaleNames.length)]);    
            sql.append(' ');
            sql.append(maleNames[random.nextInt(maleNames.length)]);    
            
            sql.append("', '");
            // address
            sql.append(random.nextInt(8066) + 1000);
            sql.append(" Example St, ");
            sql.append(states[random.nextInt(states.length)]);
            sql.append(' ');
            sql.append(random.nextInt(38208) + 1000);
            
            sql.append("', '");
            // account number
            sql.append(random.nextInt(175665) + 100000);
            sql.append("-");
            sql.append(random.nextInt(1000) + 100);
            sql.append("', '");
            // account type
            sql.append(random.nextBoolean() ? "Current" : "Savings");
            // password
            sql.append("', HASH('SHA256', '123456'))");
            
            if ((i + 1) < amount) {
                sql.append(",\n");
            }
        }
        
        template.update(sql.toString(), null);
    }
    
    private static String[] maleNames()
    {
        return new String[] {
            "Jeff", "Abel", "Daron", "Lenard", "Reinaldo", "Earnest",
            "Gilberto", "Thaddeus", "Rafael", "Leland", "Cristopher",
            "Nickolas", "Darrick", "Jon", "Houston", "Rashad",
            "Jason", "Archie", "Carmen", "Thurman", "Forest", "Dannie",
            "Dick", "David", "Nick", "Stefan", "Stephen", "Mauricio",
            "Sidney", "Pat", "Garry", "Dee", "Rosario", "Ellis",
            "Bob", "Julio", "Chung", "Raymond", "Timmy", "Xavier",
            "Clay", "Clark", "Kris", "Raleigh", "Neville", "Brendon",
            "Wilford", "Zachariah", "Ollie", "Silas", "Terry", "Bennett",
            "Asa", "Olen", "Everett", "Benjamin", "Bobbie", "Renaldo",
            "Murray", "Josue", "Jamison", "Boyce", "Carson", "Edgardo",
            "Kenton", "Ernesto", "Brain", "Jack", "Truman", "Les", "Antonia",
            "Thurman", "Robby", "Kris", "Raymon", "Adam", "Damon", "Bernardo",
            "Christoper", "Hank", "Man", "Ivory", "Markus", "Weston",
            "Kendall", "Edmond", "Royal", "Mervin", "Art", "Moshe",
            "Dorian", "Eugenio", "Noe", "Ronald", "Emerson", "Ambrose",
            "Avery", "Miquel", "Ruben", "Wyatt"
        };
    }
    
    private static String[] femaleNames()
    {
        return new String[] {
            "Eladia", "Phylicia", "Karey", "Lissa", "Shela", "Maryetta",
            "Kimberely", "Estrella", "Bev", "Vallie", "Tonda", "Carline",
            "Agripina", "Tiffani", "Yan", "Dori", "Amberly", "Noreen",
            "Susan", "Josphine", "Garnet", "Cori", "Trina", "Lyla", "Felicia",
            "Nikole", "Katelynn", "Laveta", "Latasha", "Inell", "Teressa",
            "Temple", "Oma", "Marlen", "Larhonda", "Fae", "Carole", "Tess", 
            "Zofia", "Noelia", "Lyndsay", "Odessa", "Yolanda", "Antonina", 
            "Delorse", "Marry", "Misty", "Winnifred", "Alethia", "Marth"
        };
    }
    
    private static String[] states()
    {
        return new String[] {
           "NY", "CA", "MS", "MD", "GA", "PA", "NJ", "WI", "IL", "MA",
           "CT", "SC", "NC", "VA", "TN", "FL"
        };
    }
}
