package PARCIAL1;

// Clase principal Libro
class Libro {
    private String titulo;
    private String autor;
    private double precio;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = 0.0; // Precio inicializado a 0 por defecto
    }

    // Métodos get y set para título, autor y precio
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Precio: $" + precio);
    }
}

// Clase LibroDeTextoIUAC que hereda de Libro
class LibroDeTextoIUAC extends Libro {
    private String curso;

    public LibroDeTextoIUAC(String titulo, String autor, String curso) {
        super(titulo, autor);
        this.curso = curso;
    }

    // Redefinición del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Curso: " + curso);
    }
}

// Clase Novela que hereda de Libro
class Novela extends Libro {
    private String tipo;

    public Novela(String titulo, String autor, String tipo) {
        super(titulo, autor);
        this.tipo = tipo;
    }

    // Redefinición del método mostrarInformacion
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo de novela: " + tipo);
    }
}

public class Libros {
    public static void main(String[] args) {
        // Crear un objeto de LibroDeTextoIUAC
        LibroDeTextoIUAC libroDeTexto = new LibroDeTextoIUAC("Programación II", "Oscar Dario Bautista Loza", "Cuarto Semestre");
        libroDeTexto.setPrecio(59.99);

        // Crear un objeto de Novela
        Novela novela = new Novela("Cien años de soledad", "Gabriel García Márquez", "Realista");
        novela.setPrecio(19.99);

        // Mostrar información de los libros
        System.out.println("Información del Libro de Texto de la IUAC:");
        libroDeTexto.mostrarInformacion();

        System.out.println("\nInformación de la Novela:");
        novela.mostrarInformacion();
    }
}
