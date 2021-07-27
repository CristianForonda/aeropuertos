package co.edu.unimagdalena.apmoviles.universidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class AeropuertoController {
    private BaseDatos bd;
    private Context c;
    public AeropuertoController(Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }
    public void agregarAeropuerto(Aeropuerto e){
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DefBD.col_id, e.getId());//Nuevo
            values.put(DefBD.col_nombre, e.getNombre());
            values.put(DefBD.col_pais, e.getPais());
            values.put(DefBD.col_ciudad, e.getCiudad());
            values.put(DefBD.col_direccion, e.getDireccion());//nuevo
            values.put(DefBD.col_latitud, e.getLatitud());//nuevo
            values.put(DefBD.col_longitud, e.getLongitud());//nuevo
            long id = sql.insert(DefBD.tabla_aeropuerto, null, values);
            //sql.execSQL("insert into " + DefBD.tabla_est + " values (" + e.getCodigo() + "," + e.getNombre() + "," + e.getPrograma() +");");
            Toast.makeText(c, "Aeropuerto registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando Aeropuerto " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarAeropuerto(Aeropuerto e){
        String args[] = new String[] {"" + e.getId()};
        String[] columnas = {DefBD.col_id,DefBD.col_nombre};
        String col[] = new String[] {DefBD.col_id,DefBD.col_nombre};
        SQLiteDatabase sql = bd.getReadableDatabase();
      Cursor c = sql.query(DefBD.tabla_aeropuerto,null,"id=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

    public Cursor allAeropuertos(){// para el listado pero no utilizado
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
 Cursor c = sql.query(DefBD.tabla_aeropuerto,null,null,null,null,null,null);
            return c;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta aeropuerto " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public Cursor allAeropuertos2(){//para el listado
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.rawQuery("select id as _id , nombre, pais, ciudad, direccion, latitud, longitud from aeropuerto", null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta aeropuerto " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void eliminarAeropuerto(int id){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {""+id};
           sql.delete(DefBD.tabla_aeropuerto,"id=?",args);
            Toast.makeText(c, "aeropuerto eliminado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error eliminar aeropuerto " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarAeropuerto(Aeropuerto e){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {""+e.getId()};
            ContentValues valores = new ContentValues();
            //como el id no se modifica aqui no va lo de id
            valores.put(DefBD.col_nombre, e.getNombre());
            valores.put(DefBD.col_pais, e.getPais());
            valores.put(DefBD.col_ciudad, e.getCiudad());
            valores.put(DefBD.col_direccion, e.getDireccion());//nuevo
            valores.put(DefBD.col_latitud, e.getLatitud());//nuevo
            valores.put(DefBD.col_longitud, e.getLongitud());//nuevo
            sql.update(DefBD.tabla_aeropuerto,valores,"id=?",args);
            Toast.makeText(c, "aeropuerto actualizado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error actualizar aeropuerto " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public Cursor filtrarAeropuerto(CharSequence filtro){
        SQLiteDatabase sql = bd.getWritableDatabase();
        String query = "SELECT id as _id, nombre, pais, ciudad, direccion, latitud, longitud FROM aeropuerto "
                + "where pais like '%" + filtro + "%' or ciudad like '%" + "ORDER BY nombre ASC";

        return  sql.rawQuery(query, null);

    }
   }


