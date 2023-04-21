package vn.codegym;

import org.junit.Test;
import vn.codegym.util.MathUtil;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {
    MathUtil util = new MathUtil();

    @Test
    public void test1() {
        assertEquals(util.sum(1, 1), 2);
    }

    @Test
    public void test2() {
        assertEquals(util.sum(2, 1), 3);
    }

    @Test
    public void test3() {
        assertEquals(util.sum(1, 2), 3);
    }
}
