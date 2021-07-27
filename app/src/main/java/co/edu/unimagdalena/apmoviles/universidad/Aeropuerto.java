package co.edu.unimagdalena.apmoviles.universidad;

public class Aeropuerto {

    private int id;
    private String pais;
    private String ciudad;
    private String nombre;
    private String direccion;
    private String latitud;
    private String longitud;

    public Aeropuerto(int id, String nombre, String pais, String ciudad, String direccion, String latitud, String longitud) {
        this.id = id;//nuevo
        this.pais = pais;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;//nuevo
        this.latitud = latitud;//nuevo
        this.longitud = longitud;//nuevo
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Aeropuertos{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }
}
