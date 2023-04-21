package vn.codegym;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vn.codegym.util.MathUtil;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class DevopsIntegrationApplicationTests {
    MathUtil util = new MathUtil();

    @Test
    public void test1() {
        assertEquals(util.sum(1, 1), 2);
    }

    @Test
    public void test2() {
        assertEquals(util.sum(2, 1), 4);
    }

    @Test
    public void test3() {
        assertEquals(util.sum(1, 2), 3);
    }

}
