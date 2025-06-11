package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        writeObjectsData();
    }

    public static void writeObjectsData() {
        try {
            Properties props = new Properties();
            props.load(new FileReader("src/main/resources/application.properties"));

            String strategyName = props.getProperty("output.strategy");
            Strategy strategy = switch (strategyName) {
                case "console" -> new ConsoleOutputStrategy();
                case "kafka" -> new KafkaStrategy("test_topic");
                case "redis" -> new RedisStrategy("localhost", 6379, "redis");
                default -> throw new IllegalArgumentException("Invalid: " + strategyName);
            };
            strategy.output(readFromCSV("src/main/java/Annual_All_Utah_Air_Quality_2013_20250430.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<DataModel> readFromCSV(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            CsvToBean<DataModel> csvToBean = new CsvToBeanBuilder<DataModel>(reader)
                    .withType(DataModel.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
