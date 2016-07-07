package nofuemagia.atecaptal;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nofuemagia.atecaptal.model.Canciones;

/**
 * Created by jlionti on 22/04/2016. No Fue Magia
 */


//public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
//
//    private static final String STOP_MUSIC = "STOP_MUSIC";
//    private final IBinder musicBind = new MusicBinder();
//
//    private MediaPlayer player;
//    private ArrayList<Canciones> songs;
//    private int songId;
//    private int mNotificationId = 0x111222;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        songId = 0;
//        player = new MediaPlayer();
//
//        initMusicPlayer();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        String action = intent.getAction();
//        if ( action != null )
//        {
//            if ( action.equals(STOP_MUSIC)){
//                detener();
//                cancelarNotificacion();
//            }
//        }
//
//        return START_STICKY;
//    }
//
//    public void initMusicPlayer() {
//        player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
//        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//
//        player.setOnPreparedListener(this);
//        player.setOnCompletionListener(this);
//        player.setOnErrorListener(this);
//    }
//
//    public void setList(ArrayList<Canciones> theSongs) {
//        songs = theSongs;
//    }
//
//    public class MusicBinder extends Binder {
//        public MusicService getService() {
//            return MusicService.this;
//        }
//    }
//
//    @Override
//    public IBinder onBind(Intent arg0) {
//        return musicBind;
//    }
//
//    @Override
//    public boolean onUnbind(Intent intent) {
//        player.stop();
//        player.release();
//        return false;
//    }
//
//    public void setCancion(int idCancion) {
//        songId = idCancion;
//    }
//
//    public boolean reproducir() {
//        //play a song
//
//        player.reset();
//
//        String url = null;
//        for (Canciones cancion : songs) {
//            if (cancion.getIdCancion() == songId)
//                url = cancion.getCancion();
//        }
//
//        if (url == null) {
//            Toast.makeText(getApplicationContext(), "No se encontro el audio correspondiente", Toast.LENGTH_LONG).show();
//            return false;
//        }
//
//        try {
//            player.setDataSource(getApplicationContext(), Uri.parse(url));
//            player.prepareAsync();
//            Toast.makeText(getApplicationContext(), "Cargando", Toast.LENGTH_LONG).show();
//            return true;
//        } catch (Exception e) {
//            Log.e("MUSIC SERVICE", "Error setting data source", e);
//            return false;
//        }
//    }
//
//    public void detener() {
//        player.reset();
//    }
//
//
//    @Override
//    public void onCompletion(MediaPlayer mp) {
//        cancelarNotificacion();
//    }
//
//    private void cancelarNotificacion() {
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.cancel(mNotificationId);
//    }
//
//    @Override
//    public boolean onError(MediaPlayer mp, int what, int extra) {
//        return false;
//    }
//
//    @Override
//    public void onPrepared(MediaPlayer mp) {
//        mp.start();
//        if (!PantallaPrincipal.isRunning) {
//            System.out.println("Notificacion");
//            MostrarNotificacion();
//        } else
//            System.out.println("Presente");
//    }
//
//    public void MostrarNotificacion() {
//
//
//        Canciones cancion = null;
//        for (Canciones song : songs) {
//            if (song.getIdCancion() == songId)
//                cancion = song;
//        }
//
//        if (cancion != null) {
//
//            Intent yesReceive = new Intent(this, MusicService.class);
//            yesReceive.setAction(STOP_MUSIC);
//            PendingIntent stopIntent = PendingIntent.getService(this, 123, yesReceive, PendingIntent.FLAG_UPDATE_CURRENT);
//
//            PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, PantallaPrincipal.class), PendingIntent.FLAG_UPDATE_CURRENT);
//
//            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
//            Notification notification = mBuilder.setSmallIcon(R.mipmap.ic_logo).setWhen(0)
//                    .setAutoCancel(true)
//                    .setContentTitle(cancion.getTitulo())
//                    .setPriority(NotificationCompat.PRIORITY_HIGH)
//                    .setContentIntent(resultPendingIntent)
//                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                    .setContentText(cancion.getContenido())
//                    .addAction(android.R.drawable.ic_media_pause, "Detener", stopIntent).build();
//            //.addAction(android.R.drawable.ic_menu_share, "Share", shareIntent)
//
//            notification.flags = Notification.FLAG_NO_CLEAR;
//
//            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            notificationManager.notify(mNotificationId, notification);
//
//
//        }
//
//
//    }
//
//
//
//}

/*
public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnBufferingUpdateListener {

    private final IBinder musicBind = new MusicBinder();
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();
        initMusicPlayer();
    }

    public void initMusicPlayer() {

        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setOnPreparedListener(this);
        player.setOnErrorListener(this);
    }

    public void setUrl(String url) {
        try {
            player.setDataSource(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSong() {
        //player.reset();
        player.prepareAsync();
    }

    public void stop() {
        if (player.isPlaying())
            player.stop();
    }

    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        player.stop();
        player.reset();
        return false;
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        System.out.println("Porcentaje " + percent);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
*/