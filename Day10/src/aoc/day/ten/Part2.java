package aoc.day.ten;

import java.util.Map;
import java.util.TreeSet;

public class Part2 {

    Part1 part1 = new Part1();

    /**
     * Destroys asteroids in a clockwise pattern starting from straight up (0 degrees)
     * Only one asteroid is destroyed with each pass of the laser.
     *
     * @param filename input asteroid map file name
     * @param numToDestroy number of asteroids to destroy being stopping
     * @return the last asteroid destroyed
     */
    public Asteroid destroyAsteroids(String filename, int numToDestroy) {
        Asteroid station = part1.calculateBestAsteroid(filename);

        while (true) {
            for (Map.Entry<Double, TreeSet<Asteroid>> bearing : station.getBearingMap().entrySet()) {
                Asteroid lasedAsteroid = bearing.getValue().pollFirst();

                numToDestroy--;
                if (numToDestroy == 0) {
                    return lasedAsteroid;
                }
            }
        }
    }
}
