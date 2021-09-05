package NutriApp;

public class Nutriment extends Grocery {
    public double weight;
    public double kcal;
    public double proteins;
    public double carbs;
    public double fats;
    public double fiber;

    public Nutriment(String company, String name, double weight, double kcal, double proteins, double carbs, double fats, double fiber) {
        super(company, name);
        this.weight = weight;
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.fiber = fiber;
    }

    public void Update(String company, String name, Double weight, Double kcal, Double proteins, Double carbs, Double fats, Double fiber) {
        if (company != null) {
            this.company = company;
        }
        if (name != null) {
            this.name = name;
        }
        if (weight != null) {
            this.weight = weight;
        }
        if (kcal != null) {
            this.kcal = kcal;
        }
        if (proteins != null) {
            this.proteins = proteins;
        }
        if (carbs != null) {
            this.carbs = carbs;
        }
        if (fats != null) {
            this.fats = fats;
        }
        if (fiber != null) {
            this.fiber = fiber;
        }
    }


    public double getProteins() {
        return proteins;
    }

    public double getCarb() {
        return carbs;
    }

    public double getFats() {
        return fats;
    }

    public double getFiber() {
        return fiber;
    }

    public double getTotalProteins() {
        return proteins * (weight / 100);
    }

    public double getTotalCarb() {
        return carbs * (weight / 100);
    }

    public double getTotalFats() {
        return fats * (weight / 100);
    }

    public double getTotalFiber() {
        return fiber * (weight / 100);
    }

    @Override
    public double getKcal() {
        return kcal * (weight / 100);
    }


    @Override
    public String toString() {

        return "Company: " + company + "\n" +
                "Name: " + name + "\n" +
                "Weight: " + weight + "g" + "\n" +
                "Kcal: " + ((getKcal() / weight) * 100) + "\n" +
                "Proteins: " + ((getTotalProteins() / weight) * 100) + " % " + "\n" +
                "Carbohydrates: " + ((getTotalCarb() / weight) * 100) + " % " + "\n" +
                "Fats: " + ((getTotalFats() / weight) * 100) + " % " + "\n" +
                "Fiber: " + ((getTotalFiber() / weight) * 100) + " % ";
    }

    public String totalNutrientTabel() {

        return "Company: " + company + "\n" +
                "Name: " + name + "\n" +
                "Weight: " + weight + "g"+"\n" +
                "Kcal: " + getKcal() + "\n" +
                "Proteins: " + getTotalProteins()+"g" + "\n" +
                "Carbs: " + getTotalCarb()+"g" + "\n" +
                "Fats: " + getTotalFats()+"g" + "\n" +
                "Fiber: " + getTotalFiber()+"g";
    }


}
