package aoc.day.ten;

import lombok.SneakyThrows;

import java.awt.geom.Point2D;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Part1 {

    public Asteroid calculateBestAsteroid(String filename) {
        List<Asteroid> asteroids = asteroidMapper(filename);

        for (Asteroid fromAsteroid : asteroids) {
            for (Asteroid toAsteroid : asteroids) {
                if (fromAsteroid == toAsteroid) {
                    continue;
                }
                fromAsteroid.addBearingTo(toAsteroid);
            }
        }

        System.out.println(asteroids.stream().sorted(Comparator.reverseOrder()).findFirst().get());
        return asteroids.stream().sorted(Comparator.reverseOrder()).findFirst().get();
    }

    @SneakyThrows
    private List<Asteroid> asteroidMapper(String filename) {
        List<Asteroid> asteroids = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(filename));
        Iterator<String> iterator = lines.listIterator();

        for (int y = 0; iterator.hasNext(); y++) {
            String line = iterator.next();
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    asteroids.add(new Asteroid(new Point2D.Double(x, y)));
                }
            }
        }

        return asteroids;
    }
}
