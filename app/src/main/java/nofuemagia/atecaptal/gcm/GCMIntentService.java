package nofuemagia.atecaptal.gcm;

//import android.app.IntentService;
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.BitmapFactory;
//import android.media.RingtoneManager;
//import android.os.Bundle;
//import android.support.v4.app.NotificationCompat;
//import android.support.v4.content.ContextCompat;
//
//import com.google.android.gms.gcm.GoogleCloudMessaging;
//
//import nofuemagia.atecaptal.PantallaPrincipal;
//import nofuemagia.atecaptal.R;
//
///**
// * Created by jlionti on 29/04/2016. No Fue Magia
// */
//public class GCMIntentService extends IntentService {
//
//    private static final int mNotificationId = 0x0101010;
//
//    public GCMIntentService() {
//        super("AteCapital");
//    }
//
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
//
//        String messageType = gcm.getMessageType(intent);
//        Bundle extras = intent.getExtras();
//
//        if (!extras.isEmpty()) {
//            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
//                mostrarNotification(extras);
//            }
//        }
//
//        GCMBroadcastReceiver.completeWakefulIntent(intent);
//    }
//
//    private void mostrarNotification(Bundle extras) {
//        String title = extras.getString("Titulo");
//        String message = extras.getString("Mensaje");
//
//        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0,new Intent(this, PantallaPrincipal.class),PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
//        Notification notification = mBuilder.setSmallIcon(R.mipmap.ic_logo).setTicker(title).setWhen(0)
//                .setAutoCancel(true)
//                .setContentTitle(title)
//                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setContentIntent(resultPendingIntent)
//                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                .setContentText(message).build();
//
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(mNotificationId, notification);
//    }
//}
