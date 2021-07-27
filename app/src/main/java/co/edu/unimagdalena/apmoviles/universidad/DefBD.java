package co.edu.unimagdalena.apmoviles.universidad;


    public class DefBD {
        public static final String nameDb = "Aeropuertos";
        public static final String tabla_aeropuerto = "aeropuerto";
        public static final String col_id = "id";//en el texto dira codigo
        public static final String col_pais = "pais";
        public static final String col_nombre = "nombre";
        public static final String col_ciudad = "ciudad";
        public static final String col_direccion = "direccion";//nuevo
        public static final String col_latitud = "latitud";//nuevo
        public static final String col_longitud = "longitud";//nuevo

        public static final String create_tabla_est = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_aeropuerto + " ( " +
                //DefBD.col_id + " integer primary key autoincrement," +
                DefBD.col_id + " integer," +
                DefBD.col_nombre + " text," +
                DefBD.col_pais + " text," +
                DefBD.col_ciudad + " text," +
                DefBD.col_direccion + " text," +//nuevo
                DefBD.col_latitud + " real," +//nuevo
                DefBD.col_longitud + " real" +//nuevo
                ");";


}
