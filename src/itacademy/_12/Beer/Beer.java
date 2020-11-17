package itacademy._12.Beer;

public class Beer {
    private final String name;
    private final String type;
    private final double alcoholAmount;
    private final double alcoholVolume;

    public Beer(String name, String type, double alcoholAmount, double alcoholVolume) {
        this.name = name;
        this.type = type;
        this.alcoholAmount = alcoholAmount;
        this.alcoholVolume = alcoholVolume;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        String name = ((Beer) obj).getName();
        String type = ((Beer) obj).getType();

        return (this.name.equals(name) && this.type.equals(type));
    }

    @Override
    public int hashCode() {
        return (this.name.hashCode() + this.type.hashCode());
    }

    @Override
    public String toString() {
        return "Beer " + name + " " + type + " alc: " + alcoholVolume + "% which consist " + alcoholAmount + "g of pure alcohol.";
    }
}
