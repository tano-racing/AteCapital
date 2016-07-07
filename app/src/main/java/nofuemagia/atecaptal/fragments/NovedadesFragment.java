package nofuemagia.atecaptal.fragments;

//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.loopj.android.http.AsyncHttpClient;
//import com.loopj.android.http.JsonHttpResponseHandler;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//import cz.msebera.android.httpclient.Header;
//import nofuemagia.atecaptal.R;
//import nofuemagia.atecaptal.adapters.CancioneroAdapter;
//import nofuemagia.atecaptal.model.Canciones;
//import nofuemagia.atecaptal.model.Novedades;
//
///**
// * Created by jlionti on 01/04/2016. No Fue Magia
// */
//public class NovedadesFragment extends Fragment {
//    private RecyclerView recList;
//
////    private static final String ARG_SECTION_NUMBER = "section_number";
//
//    public NovedadesFragment() {
//    }
//
//    public static NovedadesFragment newInstance() {
//
//        NovedadesFragment fragment = new NovedadesFragment();
////        Bundle args = new Bundle();
////        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
////        fragment.setArguments(args);
//
//        return fragment;
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.fragment_novedades, container, false);
//
//        SwipeRefreshLayout srl = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_novedades);
//        srl.setEnabled(false);
//
//        recList = (RecyclerView) rootView.findViewById(R.id.recycler_novedades);
//        recList.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(getContext());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        recList.setLayoutManager(llm);
//
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.post("http://www.atecapital.somee.com/Home/ListadoNoticias", null, new JsonHttpResponseHandler() {
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                super.onFailure(statusCode, headers, responseString, throwable);
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
//
//                Type listType = new TypeToken<ArrayList<Novedades>>() {}.getType();
//                ArrayList<Novedades> yourClassList = new Gson().fromJson(timeline.toString(), listType);
//
//                NovedadesAdapter adapter = new NovedadesAdapter(getContext(), yourClassList);
//                recList.setAdapter(adapter);
//            }
//        });
//
//        return rootView;
//    }
//}