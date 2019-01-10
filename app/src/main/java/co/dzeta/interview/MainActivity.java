package co.dzeta.interview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/* What is Application

 The Application class in Android is the base class within an Android app that contains all other components such as activities and services.
 The Application class, or any subclass of the Application class,
 is instantiated before any other class when the process for your application/package is created.
*/

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private ListAdapter adapter;
    private List<ModelList> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new ListAdapter(mList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(adapter);

        prepareModelData();
    }

    private void prepareModelData() {
        ModelList movie = new ModelList("Activity Life Cycle", "Iterate through Activity the process");
        mList.add(movie);

        movie = new ModelList("Fragment Life Cycle", "Iterate through fragment the process");
        mList.add(movie);

        movie = new ModelList("Android Kernal Architecture", "check the kernal architecture and how its work");
        mList.add(movie);

        adapter.notifyDataSetChanged();
    }

}
