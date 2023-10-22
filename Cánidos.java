package Parcial2;

public class Cánidos extends Animal {
    public Cánidos() {
        sonidos = "aullido";
        alimentos = "carnívoro";
    }

    public String getNombreCientífico() {
        return "Canis lupus";
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
