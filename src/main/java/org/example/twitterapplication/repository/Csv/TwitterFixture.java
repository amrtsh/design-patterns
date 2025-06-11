package org.example.twitterapplication.repository.Csv;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

public class TwitterFixture {
    static EasyRandomParameters parameters = new EasyRandomParameters()
            .randomize(Integer.class, () -> new Random().nextInt(1000) + 1)
            .excludeField(FieldPredicates.named("id"))
            .randomize(FieldPredicates.named("email"), () -> generateRandomEmail())
            .randomize(LocalDateTime.class, () -> LocalDateTime.now().plusDays(new Random().nextInt(30)))
            .randomize(ZoneId.class, () -> randomZoneId());

    static EasyRandom generator = new EasyRandom(parameters);

    public static <T> T next(Class<T> tClass) {
        return generator.nextObject(tClass);
    }

    private static ZoneId randomZoneId() {
        List<String> zoneIds = ZoneId.getAvailableZoneIds().stream().toList();
        String randomZone = zoneIds.get(new Random().nextInt(zoneIds.size()));
        return ZoneId.of(randomZone);
    }

    private static String generateRandomEmail() {
        SecureRandom random = new SecureRandom();
        StringBuilder randomString = new StringBuilder(10);

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < 10; i++) {
            randomString.append(chars.charAt(random.nextInt(chars.length())));
        }

        return randomString + "@gmail.com";
    }
}
