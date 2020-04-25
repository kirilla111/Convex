import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Задача — посчитать количество ребер выпуклой оболочки, целиком расположенных внутри квадрата (0;0) (0;3) (3;3) (3;0)
public class ConvexTester {
    @Test
    public void test_1() {
        Convex c = new Convex();
        c.add(new R2Point(0.0, 0.0)); // точка внутри квадрата 3x3
        assertEquals(0, c.count());
    }

    @Test
    public void test_2() {
        Convex c = new Convex();
        c.add(new R2Point(0.0, 0.0)); // прямая внутри квадрата 3x3
        c.add(new R2Point(3.0, 0.0));
        assertEquals(0, c.count());
    }

    @Test
    public void test_3() {
        Convex c = new Convex();
        c.add(new R2Point(0.0, 0.0)); // треугольник внутри квадрата 3x3
        c.add(new R2Point(0.0, 3.0));
        c.add(new R2Point(3.0, 0.0));
        assertEquals(3, c.count());
    }

    @Test
    public void test_4() {
        Convex c = new Convex();
        c.add(new R2Point(0.0, 0.0)); // квадрат внутри квадрата 3x3
        c.add(new R2Point(0.0, 3.0));
        c.add(new R2Point(3.0, 0.0));
        c.add(new R2Point(3.0, 3.0));
        assertEquals(4, c.count());
    }

    @Test
    public void test_5() {
        Convex c = new Convex();
        c.add(new R2Point(0.0, 0.0)); // параллелограмм, два ребра внутри, два снаружи квадрата 3x3
        c.add(new R2Point(0.0, 3.0));
        c.add(new R2Point(3.0, 0.0));
        c.add(new R2Point(3.0, 3.0));
        c.add(new R2Point(5.0, 5.0));
        assertEquals(2, c.count());
    }

    @Test
    public void test_6() {
        Convex c = new Convex();
        c.add(new R2Point(-1.0, -1.0)); //квадрат снаружи,0 ребер внутри
        c.add(new R2Point(-1.0, 4.0));
        c.add(new R2Point(4.0, -1.0));
        c.add(new R2Point(4.0, 4.0));
        assertEquals(0, c.count());
    }

    @Test
    public void test_7() {
        Convex c = new Convex();
        try {
            c.add(new R2Point(11111.0, 111111.0)); //Проверка на большие значения, вне квадрата 3x3
            c.add(new R2Point(-11111.0, 11111.0));
            c.add(new R2Point(2222.0, 2222.0));
            c.add(new R2Point(4.0, 4.0));
            assertEquals(0, c.count());
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void test_8() {
        Convex c = new Convex();
        try {
            c.add(new R2Point(0.5, 0.5)); //Проверка на маленькие значения, пятиугольник внутри квадрата 3x3
            c.add(new R2Point(0.3, 0.7));
            c.add(new R2Point(0.4, 0.9));
            c.add(new R2Point(0.8, 0.9));
            c.add(new R2Point(1.0, 0.5));
            assertEquals(5, c.count());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test_9() {
        Convex c = new Convex();
        c.add(new R2Point(-1.5, 1.5)); //Четырех угольник, пересекающий квадрат 3x3
        c.add(new R2Point(-1.5, 2.0));
        c.add(new R2Point(4.0, 2.0));
        c.add(new R2Point(4.0, 1.5));
        assertEquals(0, c.count());
    }

    @Test
    public void test_10() {
        Convex c = new Convex();
        try {
            c.add(new R2Point(-15, 15)); //Проверка на целочисленный ввод,четырех угольник, пересекающий квадрат 3x3
            c.add(new R2Point(-15, 20));
            c.add(new R2Point(40, 20));
            c.add(new R2Point(40, 15));
            assertEquals(0, c.count());
        } catch (Exception e) {
            fail();
        }
    }
}