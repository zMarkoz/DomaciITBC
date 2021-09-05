package NutriApp;

import java.util.ArrayList;
import java.util.List;

public class Fridge {
    List<Nutriment> nutrimentList;

    public Fridge() {
        this.nutrimentList = new ArrayList<>();
    }

    public void add(Nutriment a) {
        if (!nutrimentList.contains(a)) {
            nutrimentList.add(a);

        } else {
            for (Nutriment b : nutrimentList) {
                if (b.equals(a)) {
                    b.weight += a.weight;
                    break;
                }
            }
        }
    }

    public void remove(Nutriment n) {
        for (Nutriment el : nutrimentList) {
            if (el == n) {
                nutrimentList.remove(el);
                break;
            }
        }
    }

    public void remove(Nutriment a, double weight) {
        for (Nutriment b : nutrimentList) {
            if (b.equals(a)) {
                b.weight -= weight;
                break;
            }
        }
    }

    public List<Nutriment> getNutrimentList() {
        return nutrimentList;
    }

    @Override
    public String toString() {
        String s = "";
        for (Nutriment el : nutrimentList) {
            s += el.toString();
        }
        return s;
    }
}