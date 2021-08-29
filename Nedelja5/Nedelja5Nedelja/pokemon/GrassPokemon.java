package pokemon;

public class GrassPokemon extends Pokemon{
    public GrassPokemon(String name, int health) {
        super(name, PokemonTypes.GRASS_TYPE, health);
    }

    @Override
    public String attack() {
        return  PokemonAttackTypes.GRASS_ATTACK_TYPE;
    }

    @Override
    public String defend() {
        return PokemonDefenceTypes.DODGE;
    }

    @Override
    public String winsAgainst() {
        return PokemonTypes.WATER_TYPE;
    }

    @Override
    public String losesAgainst() {
        return PokemonTypes.FIRE_TYPE;
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
