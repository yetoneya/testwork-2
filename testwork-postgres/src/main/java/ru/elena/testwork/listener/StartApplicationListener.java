package ru.elena.testwork.listener;

import com.opencsv.CSVIterator;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.elena.testwork.domain.User;
import ru.elena.testwork.service.UserServiceImpl;

@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    public static final String URL = "https://raw.githubusercontent.com/revkov/JAVA.CSV.TEST/master/test_case.csv";

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        final CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        userService.deleteAll();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(URL).openStream()));
                CSVReader csvr = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build();) {
            CSVIterator iterator = (CSVIterator) csvr.iterator();           
            while (iterator.hasNext()) {
                User user = User.createNewUser(iterator.next());
                if (user != null) {
                    userService.save(user);          
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
