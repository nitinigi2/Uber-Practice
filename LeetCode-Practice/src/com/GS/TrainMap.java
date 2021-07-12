package src.com.GS;

import java.util.*;

class TrainMap {
    private HashMap<String, Station> stations;

    public TrainMap() {
        this.stations = new HashMap<>();
    }

    public TrainMap addStation(String name) {
        Station s = new Station(name);
        this.stations.putIfAbsent(name, s);
        return this;
    }

    public Station getStation(String name) {
        return this.stations.get(name);
    }

    public TrainMap connectStations(Station fromStation, Station toStation) {
        if (fromStation == null) {
            throw new IllegalArgumentException("From station is null");
        }
        if (toStation == null) {
            throw new IllegalArgumentException("From station is null");
        }
        fromStation.addNeighbour(toStation);
        toStation.addNeighbour(fromStation);
        return this;
    }

    // TODO
    public List<Station> shortestPath(String from, String to) {
        List<Station> stationList = new ArrayList<>();
        Set<Station> visited = new HashSet<>();
        Station src = stations.get(from);
        Station dest = stations.get(to);
        Map<Station, Station> paths = new HashMap<>();
        boolean isPathAvail = bfs(src, dest, visited, paths);
        if (!isPathAvail) return new ArrayList<>();

        stationList.add(stations.get(dest));
        while (paths.containsKey(dest)) {
            dest = paths.get(dest);
            stationList.add(dest);
        }

        return stationList;
    }

    private boolean bfs(Station src, Station dest, Set<Station> visited, Map<Station, Station> paths) {
        visited.add(src);

        Queue<Station> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            Station visitedStation = queue.poll();
            for (int i = 0; i < visitedStation.getNeighbours().size(); i++) {
                Station adj = visitedStation.getNeighbours().get(i);
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    paths.put(adj, visitedStation);
                    if (adj == dest) {
                        return true;
                    }
                    queue.add(adj);
                }
            }
        }
        return false;
    }

    public static String convertPathToStringRepresentation(List<Station> path) {
        if (path.isEmpty()) {
            return "";
        }
        return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
    }

}

class Station {
    private String name;
    private List<Station> neighbours;

    public Station(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Station station) {
        this.neighbours.add(station);
    }

    public List<Station> getNeighbours() {
        return this.neighbours;
    }

    public String getName() {
        return this.name;
    }
}

