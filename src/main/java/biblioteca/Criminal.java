package biblioteca;

public class Criminal {
    private int id;
    private String nombreCriminal;
    private String genero;
    private String profesion;
    private String colorCabello;
    private String medioTransporte;
    private String hobby;
    private String caracteristica;

    // Constructor
    public Criminal(int id, String nombreCriminal, String genero, String profesion,
                   String colorCabello, String medioTransporte, String hobby, String caracteristica) {
        this.id = id;
        this.nombreCriminal = nombreCriminal;
        this.genero = genero;
        this.profesion = profesion;
        this.colorCabello = colorCabello;
        this.medioTransporte = medioTransporte;
        this.hobby = hobby;
        this.caracteristica = caracteristica;
    }

    // Getters y Setters
    public String getNombreCriminal() {
        return nombreCriminal;
    }

    // Otros getters y setters según sea necesario
}
