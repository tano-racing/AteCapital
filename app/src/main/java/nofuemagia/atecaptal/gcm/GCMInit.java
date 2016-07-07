package nofuemagia.atecaptal.gcm;

//import android.accounts.Account;
//import android.accounts.AccountManager;
//import android.app.Activity;
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.content.pm.PackageInfo;
//import android.content.pm.PackageManager;
//import android.os.AsyncTask;
//import android.util.Log;
//import android.util.Patterns;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GooglePlayServicesUtil;
//import com.google.android.gms.gcm.GoogleCloudMessaging;
//import com.loopj.android.http.JsonHttpResponseHandler;
//import com.loopj.android.http.RequestParams;
//import com.loopj.android.http.SyncHttpClient;
//import com.loopj.android.http.TextHttpResponseHandler;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//import java.util.regex.Pattern;
//
//import cz.msebera.android.httpclient.Header;
//
///**
// * Created by jlionti on 29/04/2016. No Fue Magia
// */
//public class GCMInit {
//
//    private static final String URL = "http://www.atecapital.somee.com/Usuarios/RegistrarUsuario";
//    private static final String SENDER_ID = "785348270528";
//
//    private static final String PROPERTY_REG_ID = "registration_id";
//    private static final String PROPERTY_APP_VERSION = "appVersion";
//    private static final String PROPERTY_EXPIRATION_TIME = "onServerExpirationTimeMs";
//    private static final String PROPERTY_USER = "user";
//    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
//
//
//    private GoogleCloudMessaging gcm;
//    private String regid;
//    private boolean reg = false;
//
//    private final Activity mActivity;
//
//    public GCMInit(Activity main) {
//        mActivity = main;
//    }
//
//    public void Configure() {
//        if (checkPlayServices()) {
//            gcm = GoogleCloudMessaging.getInstance(mActivity);
//
//            regid = getRegistrationId(mActivity.getApplicationContext());
//            if (regid.equals("")) {
//
//                Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
//                Account[] accounts = AccountManager.get(mActivity.getApplicationContext()).getAccounts();
//
//                String possibleEmail = null;
//                for (Account account : accounts) {
//                    if (account.type.equals("com.google") && emailPattern.matcher(account.name).matches() && possibleEmail == null) {
//                        possibleEmail = account.name;
//                    }
//                }
//
//                TareaRegistroGCM tarea = new TareaRegistroGCM();
//                tarea.execute(possibleEmail);
//            }
//        } else {
//            Log.i("NFM", "No se ha encontrado Google Play Services.");
//        }
//    }
//
//    private boolean checkPlayServices() {
//        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mActivity);
//        if (resultCode != ConnectionResult.SUCCESS) {
//            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
//                GooglePlayServicesUtil.getErrorDialog(resultCode, mActivity, PLAY_SERVICES_RESOLUTION_REQUEST).show();
//            } else {
//                Log.i("GCMInit", "Dispositivo no soportado.");
//                mActivity.finish();
//            }
//            return false;
//        }
//        return true;
//    }
//
//    private String getRegistrationId(Context context) {
//        SharedPreferences prefs = context.getSharedPreferences(mActivity.getClass().getSimpleName(), Context.MODE_PRIVATE);
//        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
//
//        if (registrationId.length() == 0) {
//            Log.d("GCMInit", "Registro GCM no encontrado.");
//            return "";
//        }
//
//        String registeredUser = prefs.getString(PROPERTY_USER, "user");
//        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
//        long expirationTime = prefs.getLong(PROPERTY_EXPIRATION_TIME, -1);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
//        String expirationDate = sdf.format(new Date(expirationTime));
//
//        Log.d("GCMInit", "Registro GCM encontrado (usuario=" + registeredUser + ", version=" + registeredVersion + ", expira=" + expirationDate + ")");
//
//        int currentVersion = getAppVersion(context);
//
//        if (registeredVersion != currentVersion) {
//            Log.d("GCMInit", "Nueva versión de la aplicación.");
//            return "";
//        } else if (System.currentTimeMillis() > expirationTime) {
//            Log.d("GCMInit", "Registro GCM expirado.");
//            return "";
//        }
//
//        return registrationId;
//    }
//
//    private int getAppVersion(Context context) {
//        try {
//            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
//
//            return packageInfo.versionCode;
//        } catch (PackageManager.NameNotFoundException e) {
//            throw new RuntimeException("Error al obtener versión: " + e);
//        }
//    }
//
//    private class TareaRegistroGCM extends AsyncTask<String, Integer, String> {
//        @Override
//        protected String doInBackground(String... params) {
//            String msg = "";
//
//            try {
//                if (gcm == null)
//                    gcm = GoogleCloudMessaging.getInstance(mActivity.getApplicationContext());
//
//                regid = gcm.register(SENDER_ID);
//
//                Log.d("GCMInit", "Registrado en GCM: registration_id=" + regid);
//
//                boolean registrado = registroServidor(params[0], regid);
//                if (registrado)
//                    setRegistrationId(params[0], regid);
//
//            } catch (IOException ex) {
//                Log.d("GCMInit", "Error registro en GCM:" + ex.getMessage());
//            }
//
//            return msg;
//        }
//
//        private void setRegistrationId(String user, String regId) {
//            SharedPreferences prefs = mActivity.getSharedPreferences(mActivity.getClass().getSimpleName(), Context.MODE_PRIVATE);
//            int appVersion = getAppVersion(mActivity.getApplicationContext());
//
//            SharedPreferences.Editor editor = prefs.edit();
//            editor.putString(PROPERTY_USER, user);
//            editor.putString(PROPERTY_REG_ID, regId);
//            editor.putInt(PROPERTY_APP_VERSION, appVersion);
//            editor.putLong(PROPERTY_EXPIRATION_TIME, System.currentTimeMillis() + (1000 * 3600 * 24 * 7));
//
//            editor.apply();
//        }
//
//
//        private boolean registroServidor(String mail, String regId) {
//            reg = false;
//
//            if (mail == null)
//                mail = "emulador@gmail.com";
//
//            RequestParams params = new RequestParams();
//            params.put("email", mail);
//            params.put("regId", regId);
//
//            SyncHttpClient client = new SyncHttpClient();
//            client.post(URL, params, new JsonHttpResponseHandler() {
//                @Override
//                public void onFailure(int statusCode, Header[] headers, String responseStringg, Throwable error){
//                    Log.d("GCMInit", "Fallo");
//                    reg = false;
//                }
//
//                @Override
//                public void onSuccess(int statusCode, Header[] headers, String responseString) {
//                    Log.d("GCMInit", "REGISTRADO");
//                    reg = true;
//                }
//            });
//
//            return reg;
//        }
//    }
//}
