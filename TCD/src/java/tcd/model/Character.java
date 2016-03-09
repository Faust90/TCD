package tcd.model;

public class Character {

    private int characterId;
    private int strenght;
    private int agility;
    private int thoughness;
    private int mind;
    private int mediumHp;
    private int characterLevel;
    private String characterName;
    private Role characterRole;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getThoughness() {
        return thoughness;
    }

    public void setThoughness(int thoughness) {
        this.thoughness = thoughness;
    }

    public int getMind() {
        return mind;
    }

    public void setMind(int mind) {
        this.mind = mind;
    }

    public int getMediumHp() {
        return mediumHp;
    }

    public void setMediumHp(int mediumHp) {
        this.mediumHp = mediumHp;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Role getCharacterRole() {
        return characterRole;
    }

    public void setCharacterRole(Role characterRole) {
        this.characterRole = characterRole;
    }        
}
