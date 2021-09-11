package pl.sda.library.config.dev;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Profile("dev")
class RandomValueGenerator<T> {

    private final Random random = new Random();

    T getRandomValue(List<T> values) {
        return values.get(random.nextInt(values.size()));
    }
}
