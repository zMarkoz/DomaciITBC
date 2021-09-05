package NutriApp;

public abstract class Grocery implements Energy {
    String company;
    String name;


    public Grocery(String company, String name) {
        this.company = company;
        this.name = name;

    }
    public String getId(){
        return getId();
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object one) {
        if (this == one) {
            return true;
        }
        if (one == null || this.getClass() != one.getClass()) {
            return false;
        }
        Grocery m = (Grocery) one;
        if (this.name.equals(m.name) && this.company.equals(m.company)) {
            return true;
        }
        return false;

    }

}

