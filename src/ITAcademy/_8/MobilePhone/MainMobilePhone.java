package ITAcademy._8.MobilePhone;

public class MainMobilePhone {
    public static void main(String[] args) {

        MobilePhone ksiajomi = new MobilePhone("Ksiajomi", "Najlepszy69", 1000, 500);

        ksiajomi.installApplication("Tinder",100);
        ksiajomi.installApplication("YouTube", 250);
        ksiajomi.installApplication("PokemonGO", 2500);
        ksiajomi.installApplication("Facebook", 150);
        ksiajomi.installApplication("Messenger", 500);

        ksiajomi.useApplication("YouTube", 5);
        ksiajomi.useApplication("AngryBirds", 10);
        ksiajomi.useApplication("Tinder", 6);
        ksiajomi.useApplication("Facebook", 2);

        ksiajomi.charge();
        ksiajomi.useApplication("Tinder", 4);
    }
}
