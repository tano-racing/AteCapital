package nofuemagia.atecaptal.fragments;

//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.joanzapata.iconify.widget.IconButton;
//
//import nofuemagia.atecaptal.MusicService;
//import nofuemagia.atecaptal.R;
//
///**
// * Created by jlionti on 01/04/2016. No Fue Magia
// */
//public class RadioFragment extends Fragment {
//
//    private IconButton play;
//    private IconButton stop;
//
//    private MusicService musicSrv;
//    private Intent playIntent;
//    private boolean musicBound = false;
//
//    public RadioFragment() {
//    }
//
//    public static RadioFragment newInstance() {
//
//        RadioFragment fragment = new RadioFragment();
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
//        View rootView = inflater.inflate(R.layout.fragment_radio, container, false);
//
//        play = (IconButton) rootView.findViewById(R.id.play);
//        stop = (IconButton) rootView.findViewById(R.id.pause);
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (musicBound){
//                    musicSrv.setCancion(1);
//                    musicSrv.reproducir();
//
//                    play.setEnabled(false);
//                    stop.setEnabled(true);
//                }
//            }
//        });
//
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if ( musicBound){
//                    musicSrv.detener();
//
//                    play.setEnabled(true);
//                    stop.setEnabled(false);
//                }
//            }
//        });
//
//
//        return rootView;
//    }
//}