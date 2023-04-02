import java.util.*;

public class ResortService {
    private Set<Resort> resorts = new HashSet<Resort>();
    private static ResortService instance;

    private ResortService() {}

    public static ResortService getInstance() {
        if (instance == null) {
            instance = new ResortService();
        }
        return instance;
    }

    public void addResort(Resort resort) {
        resorts.add(resort);
    }

    public void removeResort(Resort resort) {
        resorts.remove(resort);
    }

    public Set<Resort> getResorts() {
        return resorts;
    }

    public Resort getResortById(int id) {
        for (Resort resort : resorts) {
            if (resort.getId() == id) {
                return resort;
            }
        }
        return null;
    }

    public List<Resort> getResortByName(String name) {
        List<Resort> rs = new ArrayList<Resort>();
        for (Resort resort : resorts) {
            if (resort.getName().equals(name)) {
                rs.add(resort);
            }
        }
        if(rs.size() >= 1) {
            return rs;
        } else {
            return Collections.emptyList();
        }
    }

    public List<Resort> getResortByLocation(String location) {
        List<Resort> rs = new ArrayList<Resort>();
        for (Resort resort : resorts) {
            if (resort.getLocation().equals(location)) {
                rs.add(resort);
            }
        }
        if(rs.size() >= 1) {
            return rs;
        } else {
            return Collections.emptyList();
        }
    }
}
