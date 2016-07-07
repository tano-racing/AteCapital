package nofuemagia.atecaptal.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jlionti on 01/04/2016. No Fue Magia
 */
public class Canciones implements Parcelable {

    private int IdCancion;
    private String Titulo;
    private String Contenido;
    private String Cancion;

    public Canciones(Parcel in) {
        Titulo = in.readString();
        Contenido = in.readString();
        Cancion = in.readString();
    }

    public Canciones(int idCancion, String Titulo, String Contenido, String url) {
        IdCancion = idCancion;
        setTitulo(Titulo);
        setContenido(Contenido);
        setCancion(url);
    }

    public Canciones(int idCancion, String titulo, String contenido) {
        this(idCancion, titulo, contenido, null);

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(IdCancion);
        dest.writeString(Titulo);
        dest.writeString(Contenido);
        dest.writeString(Cancion);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Canciones> CREATOR = new Creator<Canciones>() {
        @Override
        public Canciones createFromParcel(Parcel in) {
            return new Canciones(in);
        }

        @Override
        public Canciones[] newArray(int size) {
            return new Canciones[size];
        }
    };

    public String getTitulo() {
        return Titulo;
    }

    public String getContenido() {
        return Contenido;
    }

    public String getCancion() {
        return Cancion;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public void setCancion(String cancion) {
        Cancion = cancion;
    }

    public int getIdCancion() {
        return IdCancion;
    }

    public void setIdCancion(int idCancion) {
        IdCancion = idCancion;
    }
}
