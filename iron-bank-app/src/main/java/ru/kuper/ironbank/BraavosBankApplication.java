package ru.kuper.ironbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.kuper.ironbank.model.ProphetProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProphetProperties.class)
public class BraavosBankApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BraavosBankApplication.class, args);
    }

//    @PostConstruct
//    private void initDb() {
//        System.out.println("****** Inserting more sample data in the table: Bank ******");
//        String[] sqlStatements = {
//                "drop table bank if exists",
//                "create table bank\n" +
//                        "(\n" +
//                        "    id bigint not null primary key,\n" +
//                        "    name varchar(255) not null,\n" +
//                        "    balance varchar(255) not null,\n" +
//                        ");",
//                "insert into (bank) values (1, 'Braavos Bank', 1000000)",
//                "insert into (bank) values (2, 'Targarian', 0)"};
//        Arrays.stream(sqlStatements).forEach(sql -> {
//            System.out.println(sql);
//            jdbcTemplate.execute(sql);
//        });
//        System.out.println("Fetching from bank...");
//        jdbcTemplate.query("select id, name, balance from bank", new RowMapper<Object>() {
//            @Override
//            public Object mapRow(ResultSet rs, int i) throws SQLException {
//                System.out.println(String.format("id: %s, name: %s, amount: %s",
//                        rs.getString("id"),
//                        rs.getString("name"),
//                        rs.getString("amount")
//                ));
//                return null;
//            }
//        });
//    }

}

