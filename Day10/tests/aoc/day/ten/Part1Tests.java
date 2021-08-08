package aoc.day.ten;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

public class Part1Tests {

    Part1 part1 = new Part1();

    @Test
    void test1() {
        Asteroid asteroid = part1.calculateBestAsteroid("./test1.txt");

        Assertions.assertEquals(asteroid.getLocation(), new Point2D.Double(5, 8));
        Assertions.assertEquals(asteroid.getBearingMap().size(), 33);
        System.out.println(asteroid);
    }

    @Test
    void test2() {
        Asteroid asteroid = part1.calculateBestAsteroid("./test2.txt");

        System.out.println(asteroid);
        Assertions.assertEquals(asteroid.getLocation(), new Point2D.Double(11, 13));
        Assertions.assertEquals(asteroid.getBearingMap().size(), 210);
    }

    @Test
    void simpleTest() {
        Asteroid asteroid = part1.calculateBestAsteroid("./simpleTest.txt");

        System.out.println(asteroid);
        Assertions.assertEquals(new Point2D.Double(3, 4), asteroid.getLocation());
        Assertions.assertEquals(8, asteroid.getBearingMap().size());
    }

    @Test
    void test3() {
        Asteroid asteroid = part1.calculateBestAsteroid("./test3.txt");

        System.out.println(asteroid);
        Assertions.assertEquals(new Point2D.Double(6, 3), asteroid.getLocation());
        Assertions.assertEquals(41, asteroid.getBearingMap().size());
    }

    @Test
    void test4() {
        Asteroid asteroid = part1.calculateBestAsteroid("./test4.txt");

        System.out.println(asteroid);
        Assertions.assertEquals(new Point2D.Double(8, 16), asteroid.getLocation());
        Assertions.assertEquals(214, asteroid.getBearingMap().size());
    }

    @Test
    void puzzle() {
        Asteroid asteroid = part1.calculateBestAsteroid("./puzzle.txt");

        System.out.println(asteroid);
    }
}
