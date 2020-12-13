package me.anandsharma;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableCaching
@RequiredArgsConstructor
public class SpringBootMain implements ApplicationRunner {

    private final ExpensiveOps ops;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug(ops.getClass().getCanonicalName());
        log.debug("Calling isPrime(10000169) the first time...");
        log.debug("Got: " + ops.isPrime(10_000_169));
        log.debug("Calling isPrime(10000169) the second time...");
        log.debug("Got: " + ops.isPrime(10_000_169));
        log.debug("Calling isPrime(10000169) the third time indirectly via a local method inside ExpensiveOps...");
        ops.methodInTheSameClass();
    }
}
