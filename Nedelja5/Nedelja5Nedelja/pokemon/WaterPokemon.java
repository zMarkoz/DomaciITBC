package pokemon;

public class WaterPokemon extends Pokemon{

    public WaterPokemon(String name, int health) {
        super(name, PokemonTypes.WATER_TYPE, health);
    }

    @Override
    public String attack() {
        return PokemonAttackTypes.WATER_ATTACK_TYPE;
    }

    @Override
    public String defend() {
        return PokemonDefenceTypes.WATER;
    }

    @Override
    public String winsAgainst() {
        return PokemonTypes.FIRE_TYPE;
    }

    @Override
    public String losesAgainst() {
        return PokemonTypes.GRASS_TYPE;
    }

    @Override
    public String logAll() {
        String log = "Attacks whith: " + attack() +"\n"
                + "Defends whit: " + defend() + "\n"
                + "Wins against: " + winsAgainst() +  " type\n"
                + "Lose against: " + losesAgainst() + " type";
        System.out.println(log);
        return log;
    }
}
