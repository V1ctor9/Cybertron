package Parcial2;

public class Felinos extends Animal {
    public Felinos() {
        sonidos = "rugido";
        alimentos = "carnívoro";
    }

    public String getNombreCientífico() {
        return "Felis silvestris";
    }

    public String getHábitat() {
        return "desconocido";
    }

    public String getSonido() {
        return sonidos;
    }

    public String getAlimentos() {
        return alimentos;
    }
}
