package me.anandsharma;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@LoggedClass
public class ExpensiveOps {

    private static final BigDecimal TWO = new BigDecimal("2");

    @Cacheable("primes")
    public Boolean isPrime(int n) {
        log.debug("isPrime({}) is working. Bugger off...", n);
        //new RuntimeException().printStackTrace();

        BigDecimal number = new BigDecimal(n);
        if (number.compareTo(TWO) <= 0) {
            return true;
        }
        if (number.remainder(TWO).equals(BigDecimal.ZERO)) {
            return false;
        }
        for (BigDecimal divisor = new BigDecimal("3");
             divisor.compareTo(number.divide(TWO)) < 0;
             divisor = divisor.add(TWO)) {
            if (number.remainder(divisor).equals(BigDecimal.ZERO)) {
                return false;
            }
        }

        return true;
    }

    public void methodInTheSameClass() {
        log.debug("Got: " + isPrime(10_000_169));
    }

}

