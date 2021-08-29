package pokemon;

public class FirePokemon extends Pokemon{
    public FirePokemon(String name, int health) {
        super(name, PokemonTypes.FIRE_TYPE, health);
    }

    @Override
    public String attack() {
        return PokemonAttackTypes.FIRE_ATTACK_TYPE;
    }

    @Override
    public String defend() {
        return PokemonDefenceTypes.BODY_BLOCK;
    }

    @Override
    public String winsAgainst() {
        return PokemonTypes.GRASS_TYPE;
    }

    @Override
    public String losesAgainst() {
        return PokemonTypes.WATER_TYPE;
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
