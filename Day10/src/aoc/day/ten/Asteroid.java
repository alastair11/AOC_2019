package aoc.day.ten;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.geom.Point2D;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Asteroid implements Comparable<Asteroid> {
    @EqualsAndHashCode.Include
    private final Point2D location;

    /**
     * An Ordered Map of bearings to set of asteroids in order of their closeness.
     * Closer Asteroids will be first in the TreeSet.
     * Bearing is in degrees, a bearing of 0 is straight up, bearings increase in a clockwise direction.
     */
    private final Map<Double, TreeSet<Asteroid>> bearingMap = new TreeMap<>();

    private final Comparator<Asteroid> distanceComparator = (o1, o2) -> (int) (distanceTo(o1) - distanceTo(o2));

    @Override
    public int compareTo(Asteroid o) {
        return bearingMap.size() - o.getBearingMap().size();
    }

    public void addBearingTo(Asteroid asteroid) {
        double bearing = (90.0d - Math.toDegrees(Math.atan2(getLocation().getY() - asteroid.getLocation().getY(), getLocation().getX() - asteroid.getLocation().getX()))) * - 1;
        if (bearing < 0.0d) {
            bearing += 360.0;
        }

        TreeSet<Asteroid> asteroids = bearingMap.get(bearing);

        if (asteroids == null) {
            asteroids = new TreeSet<>(distanceComparator);
            bearingMap.put(bearing, asteroids);
        }

        asteroids.add(asteroid);
    }

    private double distanceTo(Asteroid a2) {
        double x = getLocation().getX() - a2.getLocation().getX();
        double y = getLocation().getY() - a2.getLocation().getY();
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "aoc.day.ten.Asteroid{" +
                "Number In View=" + bearingMap.size() +
                ", location=" + location +
                '}';
    }
}
