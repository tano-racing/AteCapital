package nofuemagia.atecaptal.adapters;

//import android.media.MediaPlayer;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//
//import nofuemagia.atecaptal.fragments.CancioneroFragment;
//import nofuemagia.atecaptal.fragments.NovedadesFragment;
//import nofuemagia.atecaptal.fragments.RadioFragment;
//
///**
// * Created by jlionti on 01/04/2016. No Fue Magia
// */
//public class PrincipalAdapter  extends FragmentPagerAdapter {
//
//    public PrincipalAdapter(FragmentManager fm) {
//        super(fm);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//
//        switch (position) {
//            case 0:
//                return RadioFragment.newInstance();
//            case 1:
//                return NovedadesFragment.newInstance();
//            case 2:
//                return CancioneroFragment.newInstance();
//            default:
//                return RadioFragment.newInstance();
//
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return 3;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "Radio";
//            case 1:
//                return "Novedades";
//            case 2:
//                return "Cancionero";
//        }
//        return null;
//    }
//}
