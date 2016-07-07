package nofuemagia.atecaptal.adapters;

//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.joanzapata.iconify.widget.IconTextView;
//
//import java.util.ArrayList;
//
//import nofuemagia.atecaptal.MusicService;
//import nofuemagia.atecaptal.PantallaPrincipal;
//import nofuemagia.atecaptal.R;
//import nofuemagia.atecaptal.fragments.CancioneroFragment;
//import nofuemagia.atecaptal.model.Canciones;
//
///**
// * Created by jlionti on 01/04/2016. No Fue Magia
// */
//public class CancioneroAdapter extends RecyclerView.Adapter<CancioneroAdapter.CancioneroViewHolder> {
//
//    private final ArrayList<Canciones> mDataset;
//    private final Context mContext;
//    private final CancioneroFragment mFrag;
//
//    public CancioneroAdapter(Context context, ArrayList<Canciones> actividades, Fragment frag) {
//        mContext = context;
//        mDataset = actividades;
//        mFrag = (CancioneroFragment) frag;
//    }
//
//    @Override
//    public void onBindViewHolder(CancioneroViewHolder holder, int position) {
//        Canciones usar = mDataset.get(position);
//
//        holder.tvTitulo.setText(usar.getTitulo());
//        holder.tvTitulo.setTag(usar.getIdCancion());
//        holder.tvContenido.setText(usar.getContenido());
//    }
//
//    @Override
//    public CancioneroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cancionero, parent, false);
//        return new CancioneroViewHolder(v);
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return mDataset.size();
//    }
//
//    public class CancioneroViewHolder extends RecyclerView.ViewHolder {
//
//        private final TextView tvTitulo;
//        private final TextView tvContenido;
//        private final IconTextView tvEscuchar;
//
//        public CancioneroViewHolder(View itemView) {
//            super(itemView);
//
//
//            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo_cancionero);
//            tvContenido = (TextView) itemView.findViewById(R.id.tv_contenido_cancionero);
//            tvEscuchar = (IconTextView) itemView.findViewById(R.id.tv_esuchar_cancionero);
//            tvEscuchar.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    int idCancion = (int) tvTitulo.getTag();
//
//                    String texto = tvEscuchar.getText().toString();
//                    if (texto.contains("Detener")) {
//                        tvEscuchar.setText(R.string.escuchar_cancion);
//                        mFrag.stopCancion();
//                    } else {
//                        if (!mFrag.startCancion(idCancion))
//                            tvEscuchar.setText(R.string.escuchar_cancion);
//                        else
//                            tvEscuchar.setText(R.string.detener);
//                    }
//                }
//            });
//        }
//    }
//}
