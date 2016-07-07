package nofuemagia.atecaptal.adapters;

//import android.app.Activity;
//import android.content.Context;
//import android.support.design.widget.Snackbar;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentManager;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.GoogleMapOptions;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import nofuemagia.atecaptal.PantallaPrincipal;
//import nofuemagia.atecaptal.R;
//import nofuemagia.atecaptal.fragments.NovedadesFragment;
//import nofuemagia.atecaptal.model.Novedades;
//
///**
// * Created by jlionti on 01/04/2016. No Fue Magia
// */
//public class NovedadesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private final ArrayList<Novedades> mDataset;
//    private final Context mContext;
//
//    public NovedadesAdapter(Context context, ArrayList<Novedades> actividades) {
//        mDataset = actividades;
//        mContext = context;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        final Novedades usar = mDataset.get(position);
//
//        //Noticias
//        if ( usar.noticia != null ){
//            NoticiasViewHolder hold = (NoticiasViewHolder) holder;
//            hold.tvTitulo.setText(usar.noticia.getTitulo());
//            hold.tvContenido.setText(usar.noticia.getContenido());
//
//            Picasso.Builder builder = new Picasso.Builder(mContext);
//            builder.build().load(usar.noticia.getImagen()).into(hold.ivNoticia);
//        }
//        else // Manifestacion
//        {
//            ManifestacionViewHolder hold = (ManifestacionViewHolder) holder;
//
//            GoogleMapOptions options = new GoogleMapOptions();
//            options.liteMode(true);
//            SupportMapFragment mapFrag = SupportMapFragment.newInstance(options);
//            mapFrag.getMapAsync(new OnMapReadyCallback() {
//                @Override
//                public void onMapReady(GoogleMap googleMap) {
//                    //LatLng local10 = new LatLng(-34.62419, -58.50896);
//                    LatLng local10 = new LatLng(usar.movilizacion.getLatitud(), usar.movilizacion.getLongitud());
//
//                    googleMap.addMarker(new MarkerOptions().position(local10).title(usar.movilizacion.getTitulo()));
//
//                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(local10, 15.0f));
//                }
//            });
//
//            FragmentManager fm = ((AppCompatActivity) mContext).getSupportFragmentManager();
//            fm.beginTransaction().add(hold.frMapa.getId(), mapFrag).commit();
//
//            hold.tvTitulo.setText(usar.movilizacion.getTitulo());
//            hold.tvDia.setText("Dia: " + usar.movilizacion.getDia());
//            hold.tvHorario.setText("Horario: " + usar.movilizacion.getHorario());
//        }
//
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case 0: {
//                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticia, parent, false);
//                return new NoticiasViewHolder(v);
//            }
//            case 1: {
//                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manifestacion, parent, false);
//                return new ManifestacionViewHolder(v);
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        Novedades usar = mDataset.get(position);
//        return usar.noticia != null ? 0 : 1;
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDataset.size();
//    }
//
//
//    public class NoticiasViewHolder extends RecyclerView.ViewHolder {
//
//        private final TextView tvTitulo;
//        private final ImageView ivNoticia;
//        private final TextView tvContenido;
//
//        public NoticiasViewHolder(View itemView) {
//            super(itemView);
//
//            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo_noticia);
//            ivNoticia = (ImageView) itemView.findViewById(R.id.iv_imagen_noticia);
//            tvContenido = (TextView) itemView.findViewById(R.id.tv_contenido_noticia);
//
//        }
//    }
//
//    public class ManifestacionViewHolder extends RecyclerView.ViewHolder {
//
//        private final TextView tvTitulo;
//        private final TextView tvDia;
//        private final TextView tvHorario;
//        private final FrameLayout frMapa;
//
//        public ManifestacionViewHolder(View itemView) {
//            super(itemView);
//
//            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo_noticia);
//            frMapa = (FrameLayout) itemView.findViewById(R.id.mapcontainer);
//            tvDia = (TextView) itemView.findViewById(R.id.tv_dia_movilizacion);
//            tvHorario = (TextView) itemView.findViewById(R.id.tv_horario_movilizacion);
//
//        }
//    }
//}
