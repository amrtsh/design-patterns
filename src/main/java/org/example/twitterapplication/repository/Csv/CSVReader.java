package org.example.twitterapplication.repository.Csv;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.Data;
import org.example.twitterapplication.domain.model.Poll;
import org.example.twitterapplication.domain.model.PollOption;
import org.example.twitterapplication.domain.model.Reaction;
import org.example.twitterapplication.domain.model.Tweet;
import org.example.twitterapplication.domain.model.User;
import org.example.twitterapplication.domain.model.UserFollowers;
import org.example.twitterapplication.domain.model.UserFollowings;
import org.example.twitterapplication.repository.PollOptionRepository;
import org.example.twitterapplication.repository.PollRepository;
import org.example.twitterapplication.repository.ReactionRepository;
import org.example.twitterapplication.repository.TweetRepository;
import org.example.twitterapplication.repository.UserFollowersRepository;
import org.example.twitterapplication.repository.UserFollowingsRepository;
import org.example.twitterapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class CSVReader {
    private static final Map<Class<?>, String> mapOfHeaders = new HashMap<>();
    private static CSVReader instance;

    static {
        mapOfHeaders.put(User.class, "name, email, timezone");
        mapOfHeaders.put(PollOption.class, "text, voteCount, poll_id");
        mapOfHeaders.put(Poll.class, "question, duration");
        mapOfHeaders.put(UserFollowers.class, "user_id, follower_id");
        mapOfHeaders.put(UserFollowings.class, "user_id, following_id");
        mapOfHeaders.put(Tweet.class, "text, timestamp, author_id, poll_id");
        mapOfHeaders.put(Reaction.class, "user_id, tweet_id, timestamp, reactionType");
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private PollOptionRepository pollOptionRepository;
    @Autowired
    private ReactionRepository reactionRepository;
    @Autowired
    private UserFollowersRepository userFollowersRepository;
    @Autowired
    private UserFollowingsRepository userFollowingsRepository;

    public CSVReader(UserRepository userRepository,
                     TweetRepository tweetRepository,
                     PollRepository pollRepository,
                     PollOptionRepository pollOptionRepository,
                     ReactionRepository reactionRepository,
                     UserFollowersRepository userFollowersRepository,
                     UserFollowingsRepository userFollowingsRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
        this.pollRepository = pollRepository;
        this.pollOptionRepository = pollOptionRepository;
        this.reactionRepository = reactionRepository;
        this.userFollowingsRepository = userFollowingsRepository;
        this.userFollowersRepository = userFollowersRepository;

        instance = this;
    }

    public static <T> void readObjectFromCsv(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            String headerLine = new BufferedReader(new FileReader(filePath)).readLine();
            if (headerLine == null || headerLine.isEmpty()) throw new NullPointerException("Empty header");

            for (Map.Entry<Class<?>, String> entry : mapOfHeaders.entrySet()) {
                String expectedHeader = entry.getValue().replaceAll("\\s+", "");
                String actualHeader = headerLine.replaceAll("\\s+", "");

                if (expectedHeader.equalsIgnoreCase(actualHeader)) {
                    Class<T> tClass = (Class<T>) entry.getKey();

                    HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
                    strategy.setType(tClass);

                    List<T> objects = new CsvToBeanBuilder<T>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build()
                            .parse();

                    addIntoDB(objects, tClass);
                    return;
                }
            }

            System.out.println("Header did not match any known format: " + headerLine);
        } catch (Exception e) {
            System.out.println("Error while reading: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static <T> void addIntoDB(List<T> objects, Class<T> tClass) {
        if (tClass == User.class) {
            instance.userRepository.saveAll((List<User>) objects);
            System.out.println("Users saved to the database.");
        } else if (tClass == Tweet.class) {
            instance.tweetRepository.saveAll((List<Tweet>) objects);
            System.out.println("Tweets saved to the database.");
        } else if (tClass == Poll.class) {
            instance.pollRepository.saveAll((List<Poll>) objects);
            System.out.println("Polls saved to the database.");
        } else if (tClass == PollOption.class) {
            instance.pollOptionRepository.saveAll((List<PollOption>) objects);
            System.out.println("Poll Options saved to the database.");
        } else if (tClass == UserFollowers.class) {
            instance.userFollowersRepository.saveAll((List<UserFollowers>) objects);
            System.out.println("User Followers saved to the database.");
        } else if (tClass == UserFollowings.class) {
            instance.userFollowingsRepository.saveAll((List<UserFollowings>) objects);
            System.out.println("User Followings saved to the database.");
        } else if (tClass == Reaction.class) {
            instance.reactionRepository.saveAll((List<Reaction>) objects);
            System.out.println("Reactions saved to the database.");
        }
    }
}
