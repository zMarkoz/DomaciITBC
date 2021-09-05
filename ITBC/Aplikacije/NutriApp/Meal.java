package NutriApp;

import java.util.List;
import java.util.UUID;

public class Meal implements Energy {
    public List<Nutriment> nutriments;
    public String name;
    UUID id;

    public Meal(List<Nutriment> nutriments, String name) {
        id = UUID.randomUUID();
        this.nutriments = nutriments;
        this.name = name;
    }

    public List<Nutriment> getNutriments() {
        return nutriments;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void add(Nutriment n) {
        if (!nutriments.contains(n)) {
            nutriments.add(n);
        } else {
            for (Nutriment b : nutriments) {
                if (b == n) {
                    b.weight += n.weight;
                    break;
                }
            }
        }
    }

    public void remove(Nutriment n) {
        for (Nutriment m : nutriments) {
            if (m == n) {
                nutriments.remove(m);
                break;
            }
        }
    }

    public void remove(Nutriment n, double weight) {
        for (Nutriment m : nutriments) {
            if (m == n) {
                m.weight -= weight;
                break;
            }
        }
    }


    public double getProteins() {
        double sum = 0;
        for (Nutriment m : nutriments) {
            sum += m.getTotalProteins();
        }
        return sum;
    }

    public double getCarbs() {
        double sum = 0;
        for (Nutriment m : nutriments) {
            sum += m.getTotalCarb();
        }
        return sum;
    }

    public double getFats() {
        double sum = 0;
        for (Nutriment m : nutriments) {
            sum += m.getTotalFats();
        }
        return sum;
    }

    public double getFiber() {
        double sum = 0;
        for (Nutriment m : nutriments) {
            sum += m.getTotalFiber();
        }
        return sum;
    }

    @Override
    public double getKcal() {
        double sum = 0;
        for (Nutriment m : nutriments) {
            sum += m.getKcal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Meal m = (Meal) obj;
        if (id.equals(m.id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "nutriments=" + nutriments +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
