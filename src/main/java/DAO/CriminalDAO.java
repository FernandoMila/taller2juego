/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Clase que representa la entidad 'criminal' en la base de datos
@Entity
@Table(name = "criminal")
public class CriminalDAO {
    
    // Identificador único del criminal en la base de datos
    @Id
    @Column(name="idCriminal")
    private int idCriminal;
    
    // Nombre del criminal
    @Column(name="nombreCriminal")
    private String nombreCriminal;
    
    // Hobbie o pasatiempo del criminal
    @Column(name="hobbie")
    private String hobbie;
    
    // Sexo del criminal (puede ser masculino, femenino, etc.)
    @Column(name="sexo")
    private String sexo;
    
    // Color de pelo del criminal
    @Column(name="colorPelo")
    private String colorPelo;
    
    // Ocupación actual del criminal
    @Column(name="ocupacion")
    private String ocupacion;
    
    // Tipo de vehículo que posee el criminal
    @Column(name="vehiculo")
    private String vehiculo;
    
    // Características distintivas o particularidades del criminal
    @Column(name="caracteristicas")
    private String caracteristica;

    // Constructor para inicializar los atributos del criminal
    public CriminalDAO(int idCriminal, String nombreCriminal, String sexo, String ocupacion, String colorPelo, String vehiculo, String hobbie, String caracteristica) {
        this.idCriminal = idCriminal;
        this.nombreCriminal = nombreCriminal;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.colorPelo = colorPelo;
        this.vehiculo = vehiculo;
        this.hobbie = hobbie;
        this.caracteristica = caracteristica;
    }

    // Métodos getter y setter para acceder y modificar los atributos privados
    
    public int getIdCriminal() {
        return idCriminal;
    }

    public void setIdCriminal(int idCriminal) {
        this.idCriminal = idCriminal;
    }

    public String getNombreCriminal() {
        return nombreCriminal;
    }

    public void setNombreCriminal(String nombreCriminal) {
        this.nombreCriminal = nombreCriminal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getHobbie() {
        return hobbie;
    }
        
    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    // Método toString para obtener una representación en cadena del objeto
    @Override
    public String toString() {
        return "CriminalDAO{" +
                "nombreCriminal='" + nombreCriminal + '\'' +
                ", sexo='" + sexo + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", colorPelo='" + colorPelo + '\'' +
                ", vehiculo='" + vehiculo + '\'' +
                ", hobbie='" + hobbie + '\'' +
                ", caracteristica='" + caracteristica + '\'' +
                '}';
    }
}
