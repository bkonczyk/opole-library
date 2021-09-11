package pl.sda.library.config.dev;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.time.LocalDate.ofEpochDay;

@Component
@Profile("dev")
class AuthorMockData {

    private static final List<String> NAMES = List.of("Alan", "Rafal", "Tomek", "Zygmunt", "Rysiek", "Krystyna");
    private static final List<String> LAST_NAMES = List.of("Bania", "Brzeczek", "Gruszka", "Kutia", "Anitamta", "Stark", "Kaczka", "Krycha");
    private static final List<LocalDate> DATES = generateRandomDates(10);

    List<String> getNames() {
        return NAMES;
    }

    List<String> getLastNames() {
        return LAST_NAMES;
    }

    List<LocalDate> getDates() {
        return DATES;
    }

    private static List<LocalDate> generateRandomDates(int count) {
        final Random random = new Random();
        List<LocalDate> dates = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            long randomNumber = random.nextInt(15000);
            dates.add(ofEpochDay(randomNumber));
        }
        return dates;
    }
}
