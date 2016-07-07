package nofuemagia.atecaptal.fragments;

//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import nofuemagia.atecaptal.MusicService;
//import nofuemagia.atecaptal.PantallaPrincipal;
//import nofuemagia.atecaptal.R;
//import nofuemagia.atecaptal.adapters.CancioneroAdapter;
//import nofuemagia.atecaptal.model.Canciones;
//
///**
// * Created by jlionti on 01/04/2016. No Fue Magia
// */
//public class CancioneroFragment extends Fragment {
//
//    private MusicService musicSrv;
//    private Intent playIntent;
//    private boolean musicBound = false;
//
//    public CancioneroFragment() {
//
//    }
//
//    public static CancioneroFragment newInstance() {
//
//        CancioneroFragment fragment = new CancioneroFragment();
//
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (playIntent == null) {
//            playIntent = new Intent(getContext(), MusicService.class);
//            getContext().bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
//        }
//    }
//
//    private ServiceConnection musicConnection = new ServiceConnection() {
//
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            MusicService.MusicBinder binder = (MusicService.MusicBinder) service;
//            musicSrv = binder.getService();
//            musicBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            musicBound = false;
//        }
//    };
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.fragment_cancionero, container, false);
//
//        RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.recycler_cancionero);
//        recList.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(getContext());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        recList.setLayoutManager(llm);
//
//        PantallaPrincipal pp = (PantallaPrincipal) getContext();
//        ArrayList<Canciones> canciones = pp.getLista();
//
//        for ( int x = 0; x < canciones.size(); x++){
//            Canciones cancion = canciones.get(x);
//            if ( cancion.getIdCancion() == 1)
//                canciones.remove(x);
//        }
//
//        CancioneroAdapter adapter = new CancioneroAdapter(getContext(), canciones, this);
//        recList.setAdapter(adapter);
//
//        return rootView;
//    }
//
//    public boolean startCancion(int idCancion){
//        musicSrv.setCancion(idCancion);
//        return musicSrv.reproducir();
//    }
//
//    public void stopCancion(){
//        musicSrv.detener();
//    }
//}