package pl.sda.library.config.dev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.time.LocalDate.ofEpochDay;

class AuthorMockData {

    static final List<String> NAMES = List.of("Alan", "Rafal", "Tomek", "Zygmunt", "Rysiek", "Krystyna");
    static final List<String> LAST_NAMES = List.of("Bania", "Brzeczek", "Gruszka", "Kutia", "Anitamta", "Stark", "Kaczka", "Krycha");
    static final List<LocalDate> DATES = generateRandomDates(10);

    static List<LocalDate> generateRandomDates(int count) {
        final Random random = new Random();
        List<LocalDate> dates = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            long randomNumber = random.nextInt(15000);
            dates.add(ofEpochDay(randomNumber));
        }
        return dates;
    }
}
