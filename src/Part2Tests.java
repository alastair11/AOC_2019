import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

public class Part2Tests {

    Part2 part2 = new Part2();

    @Test
    void test1() {
        Asteroid lastAsteroid = part2.destroyAsteroids("./test5.txt", 9);

        Assertions.assertEquals(new Point2D.Double(15, 1), lastAsteroid.getLocation());
        System.out.println(lastAsteroid);
    }

    @Test
    void test2() {
        Asteroid lastAsteroid = part2.destroyAsteroids("./test5.txt", 18);

        Assertions.assertEquals(new Point2D.Double(4, 4), lastAsteroid.getLocation());
        System.out.println(lastAsteroid);
    }

    @Test
    void puzzle() {
        Asteroid lastAsteroid = part2.destroyAsteroids("./puzzle.txt", 200);

        System.out.println(lastAsteroid);
        System.out.println((lastAsteroid.getLocation().getX() * 100) + lastAsteroid.getLocation().getY());
    }
}
