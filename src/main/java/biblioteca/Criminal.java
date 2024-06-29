/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author grabe
 */
public class Criminal {
    private int idCriminal;
    private String nombreCriminal;
    private String sexo;
    private String ocupacion;
    private String colorPelo;
    private String vehiculo;
    private String hobby;
    private String caracteristica;

    public Criminal(int idCriminal, String nombreCriminal, String sexo, String ocupacion, String colorPelo, String vehiculo, String hobby, String caracteristica) {
        this.idCriminal = idCriminal;
        this.nombreCriminal = nombreCriminal;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.colorPelo = colorPelo;
        this.vehiculo = vehiculo;
        this.hobby = hobby;
        this.caracteristica = caracteristica;
    }

    /**
     * @return the idCriminal
     */
    public int getIdCriminal() {
        return idCriminal;
    }

    /**
     * @param idCriminal the idCriminal to set
     */
    public void setIdCriminal(int idCriminal) {
        this.idCriminal = idCriminal;
    }

    /**
     * @return the nombreCriminal
     */
    public String getNombreCriminal() {
        return nombreCriminal;
    }

    /**
     * @param nombreCriminal the nombreCriminal to set
     */
    public void setNombreCriminal(String nombreCriminal) {
        this.nombreCriminal = nombreCriminal;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param ocupacion the ocupacion to set
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * @return the colorPelo
     */
    public String getColorPelo() {
        return colorPelo;
    }

    /**
     * @param colorPelo the colorPelo to set
     */
    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    /**
     * @return the vehiculo
     */
    public String getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param hobby the hobby to set
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * @return the caracteristica
     */
    public String getCaracteristica() {
        return caracteristica;
    }

    /**
     * @param caracteristica the caracteristica to set
     */
    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    
}
