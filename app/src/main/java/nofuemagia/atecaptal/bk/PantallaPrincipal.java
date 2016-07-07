package nofuemagia.atecaptal.bk;

//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.support.design.widget.TabLayout;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import com.joanzapata.iconify.Iconify;
//import com.joanzapata.iconify.fonts.FontAwesomeModule;
//
//import java.util.ArrayList;
//
//import nofuemagia.atecaptal.MusicService;
//import nofuemagia.atecaptal.R;
//import nofuemagia.atecaptal.adapters.PrincipalAdapter;
//import nofuemagia.atecaptal.model.Canciones;
//
//
//////Server API Key
////AIzaSyD0B2lHuosLGSnGisDQp1VoVjQa0M2PSNg
//////Sender ID
////785348270528
//
//
//public class PantallaPrincipal extends AppCompatActivity {
//
//    //public static String RadioUrl = "http://stream.codigosur.org:8000/radiogermanabdala.mp3";
//    public static String RadioUrl = "http://icecast.omroep.nl/radio1-bb-mp3";
//
//    private MusicService musicSrv;
//    private Intent playIntent;
//    private boolean musicBound = false;
//
//    private ArrayList<Canciones> listaCanciones;
//    public static boolean isRunning;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Iconify.with(new FontAwesomeModule());
//
//        setContentView(R.layout.activity_pantalla_principal);
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        PrincipalAdapter mSectionsPagerAdapter = new PrincipalAdapter(getSupportFragmentManager());
//
//        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
//        if (mViewPager != null)
//            mViewPager.setAdapter(mSectionsPagerAdapter);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        if (tabLayout != null)
//            tabLayout.setupWithViewPager(mViewPager);
//
////        GCMInit gcm = new GCMInit(this);
////        gcm.Configure();
//
//        listaCanciones = new ArrayList<>();
//        listaCanciones.add(new Canciones(1, "Radio Online", "Esucha la radio online de ATE Capital", RadioUrl));
//        listaCanciones.add(new Canciones(2, "YO SOY DE ATE", "SEÑORES, YO SOY DE ATE.\nA MI NO ME IMPORTA NADA.\n\nYA LO CORRIMO´ A MAURICIO,\nY A LA METROPOLITANA.\n\nYA TODO EL MUNDO SABE\nQUE ATE TIENE HUEVOS… EVOS…\n\nQUE VA A DEJAR LA VIDA\nBANCANDO AL COMPAÑERO… ERO…", "https://api.soundcloud.com/tracks/256985160/stream?client_id=560021ebf731331a421867b43d4c4b78"));
//        listaCanciones.add(new Canciones(3, "LA VENTANITA", "MAURICIO EN EL GOBIERNO,\nLOS GORILAS DE FIESTA.\nTIRAN BALAS DE GOMA.\nREPRIMEN LA PROTESTA\n\nAGUINALDO EN PEDAZOS\nEL AUMENTO UNA PENA\nPARITARIA, UN CARAJO\nESTO ES UNA CONDENA.\n\nAHÍ VIENE ATE CON LOS LABURANTE\nLA VERDE Y BLANCA CON TODO EL AGUANTE\nAHÍ VIENE ATE CON LOS COMPAÑEROS\nCON LOS DESPIDOS NO HAY POBREZA CERO\n"));
//        listaCanciones.add(new Canciones(4, "SOMOS LOS GRASAS", "VAMO´ ESTATALES, VAMOS\nVAMOS DE CORAZÓN.\n\nSOMOS LOS NEGROS,\nSOMOS LOS GRASAS,\nPERO GORILAS NO !!!", "https://api.soundcloud.com/tracks/256984855/stream?client_id=560021ebf731331a421867b43d4c4b78"));
//        listaCanciones.add(new Canciones(5, "SOMOS NOSOTROS", "AHÍ VIENE ATE\nCON TODOS LOS ESTATALES\nDEFENDIENDO LOS DERECHOS\nY EL ESTADO NACIONAL\n\nSOMOS NOSOTROS\nLOS QUE VAMO´ A TODOS LADOS\nLOS QUE SIEMPRE NOS PLANTAMOS\nLOS QUE NO PUEDEN COMPRAR\n\nVAMOS VAMOS ATE\nVAMOS VAMOS VAMOS VAMOS VAMOS ATE"));
//        listaCanciones.add(new Canciones(6, "SOMOS LA PESADILLA DEL PRO", "EN LAS BUENAS, TAMBIEN EN LAS MALAS\n\nSOMO´ EL GREMIO DE GERMAN ABDALA\nEL QUE LUCHA POR LOS COMPAÑEROS\nNO SE JUNTA CON CACEROLEROS\nQUE QUIEREN VOLVER….\nA LOS 90\n\nGORILA, VAS A VER\nCON NOSOTROS NO VAN A PODER\nACA ESTA, YA LLEGO,\nSOMOS LA PESADILLA DEL PRO", "https://api.soundcloud.com/tracks/256984554/stream?client_id=560021ebf731331a421867b43d4c4b78"));
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_pantalla_principal, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (playIntent == null) {
//            playIntent = new Intent(this, MusicService.class);
//            bindService(playIntent, musicConnection, Context.BIND_AUTO_CREATE);
//            startService(playIntent);
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        isRunning = false;
//        musicSrv.MostrarNotificacion();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        isRunning = true;
//    }
//
//
//
//    @Override
//    protected void onDestroy() {
//        stopService(playIntent);
//        musicSrv=null;
//        super.onDestroy();
//    }
//
//
//    private ServiceConnection musicConnection = new ServiceConnection() {
//
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            MusicService.MusicBinder binder = (MusicService.MusicBinder) service;
//            musicSrv = binder.getService();
//            musicSrv.setList(listaCanciones);
//            musicBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            musicBound = false;
//        }
//    };
//
//    public ArrayList<Canciones> getLista(){
//        return listaCanciones;
//    }
//}
