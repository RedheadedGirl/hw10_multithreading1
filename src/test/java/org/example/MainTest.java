package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void givenFileWithNumbers_whenMultithreadRun_thenCountFactorial() throws IOException, InterruptedException {
        Main main = new Main();
        Main.main(null);
        assertEquals(8, main.getResults().size());
        assertEquals(BigInteger.TWO, main.getResults().get(2));
        assertEquals(BigInteger.valueOf(6), main.getResults().get(3));
        assertEquals(BigInteger.valueOf(24), main.getResults().get(4));
        assertEquals(BigInteger.valueOf(120), main.getResults().get(5));
        assertEquals(BigInteger.valueOf(720), main.getResults().get(6));
        assertEquals(new BigInteger("355687428096000"), main.getResults().get(17));
        assertEquals(new BigInteger("295232799039604140847618609643520000000"), main.getResults().get(34));
        assertEquals(new BigInteger("608281864034267560872252163321295376887552831379210240000000000"),
                main.getResults().get(49));
    }
}