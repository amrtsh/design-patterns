package org.example.twitterapplication;

import org.example.twitterapplication.domain.model.Poll;
import org.example.twitterapplication.domain.model.PollOption;
import org.example.twitterapplication.domain.model.Reaction;
import org.example.twitterapplication.domain.model.Tweet;
import org.example.twitterapplication.domain.model.User;
import org.example.twitterapplication.repository.Csv.CSVGenerator;
import org.example.twitterapplication.repository.Csv.CSVReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TwitterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TwitterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Start creating csv files");
        CSVGenerator.generateAndWriteObject(User.class, "src/main/resources/user.csv", 50);
        CSVGenerator.generateAndWriteObject(PollOption.class, "src/main/resources/pollOption.csv", 50);
        CSVGenerator.generateAndWriteObject(Poll.class, "src/main/resources/poll.csv", 50);
        CSVGenerator.generateAndWriteObject(Tweet.class, "src/main/resources/tweet.csv", 50);
        CSVGenerator.generateAndWriteObject(Reaction.class, "src/main/resources/reaction.csv", 50);

        System.out.println("Files created. Do you want write objects into db?");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            CSVReader.readObjectFromCsv("src/main/resources/user.csv");
            CSVReader.readObjectFromCsv("src/main/resources/pollOption.csv");
            CSVReader.readObjectFromCsv("src/main/resources/poll.csv");
            CSVReader.readObjectFromCsv("src/main/resources/tweet.csv");
            CSVReader.readObjectFromCsv("src/main/resources/reaction.csv");
            CSVReader.readObjectFromCsv("src/main/resources/userFollow.csv");
            System.out.println("Values are written to the database");
        } else {
            System.out.println("Operation cancelled.");
        }
    }
}
