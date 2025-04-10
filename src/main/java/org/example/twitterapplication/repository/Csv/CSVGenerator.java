package org.example.twitterapplication.repository.Csv;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.Data;
import org.example.twitterapplication.domain.model.Poll;
import org.example.twitterapplication.domain.model.PollOption;
import org.example.twitterapplication.domain.model.Reaction;
import org.example.twitterapplication.domain.model.Tweet;
import org.example.twitterapplication.domain.model.User;
import org.example.twitterapplication.domain.model.UserFollowers;
import org.example.twitterapplication.domain.model.UserFollowings;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.example.twitterapplication.repository.Csv.TwitterFixture.next;

@Component
@Data
public class CSVGenerator {
    private static final Map<Class<?>, String> mapOfHeaders = new HashMap<>();

    static {
        mapOfHeaders.put(User.class, "name, email, timezone");
        mapOfHeaders.put(PollOption.class, "text, voteCount, poll_id");
        mapOfHeaders.put(Poll.class, "question, duration");
        mapOfHeaders.put(UserFollowers.class, "user_id, follower_id");
        mapOfHeaders.put(UserFollowings.class, "user_id, following_id");
        mapOfHeaders.put(Tweet.class, "text, timestamp, author_id, poll_id");
        mapOfHeaders.put(Reaction.class, "user_id, tweet_id, timestamp, reactionType");
    }

    public static <T> void generateAndWriteObject(Class<T> tClass, String filePath, Integer numOfObjects) {
        ColumnPositionMappingStrategy<T> mappingStrategy = new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(tClass);

        String[] columns = Arrays.stream(mapOfHeaders.getOrDefault(tClass, "id").split(","))
                .map(String::trim)
                .toArray(String[]::new);

        mappingStrategy.setColumnMapping(columns);

        try (Writer writer = new FileWriter(filePath)) {
            writer.write(String.join(",", columns) + "\n");

            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withApplyQuotesToAll(false)
                    .build();

            for (int i = 0; i < numOfObjects; i++) {
                T entity = next(tClass);
                beanToCsv.write(entity);
            }

            System.out.println("CSV written to " + filePath);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            System.out.println("CSV error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
