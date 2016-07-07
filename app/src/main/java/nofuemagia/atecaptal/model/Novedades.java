package nofuemagia.atecaptal.model;

/**
 * Created by jlionti on 01/04/2016. No Fue Magia
 */
public class Novedades {

    public Noticia noticia;
    public Manifestacion movilizacion;

    public Novedades(Noticia noticia, Manifestacion manifestacion) {
        this.noticia = noticia;
        this.movilizacion = manifestacion;
    }

    public static class Noticia {
        public String Titulo;
        public String Imagen;
        public String Contenido;

        public Noticia(String titulo, String imagen, String contenido) {
            Titulo = titulo;
            Imagen = imagen;
            Contenido = contenido;
        }

        public String getTitulo() {
            return Titulo;
        }

        public void setTitulo(String titulo) {
            Titulo = titulo;
        }

        public String getImagen() {
            return Imagen;
        }

        public void setImagen(String imagen) {
            Imagen = imagen;
        }

        public String getContenido() {
            return Contenido;
        }

        public void setContenido(String contenido) {
            Contenido = contenido;
        }
    }

    public static class Manifestacion {
        public String Titulo;
        public String Latitud;
        public String Longitud;
        public String Dia;
        public String Horario;

        public String getTitulo() {
            return Titulo;
        }

        public void setTitulo(String titulo) {
            Titulo = titulo;
        }

        public double getLatitud() {
            return Double.parseDouble(Latitud.trim());
        }

        public void setLatitud(String latitud) {
            Latitud = latitud;
        }

        public double getLongitud() {
            return Double.parseDouble(Longitud.trim());
        }

        public void setLongitud(String longitud) {
            Longitud = longitud;
        }

        public String getDia() {
            return Dia;
        }

        public void setDia(String dia) {
            Dia = dia;
        }

        public String getHorario() {
            return Horario;
        }

        public void setHorario(String horario) {
            Horario = horario;
        }
    }

}
