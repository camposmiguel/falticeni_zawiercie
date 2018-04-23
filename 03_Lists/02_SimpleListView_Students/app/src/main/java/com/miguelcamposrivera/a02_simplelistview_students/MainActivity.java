package com.miguelcamposrivera.a02_simplelistview_students;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listViewStudents;
    List<String> studentNamesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // 1. get a reference to the ListView component (layout)
        listViewStudents = findViewById(R.id.listViewStudents);

        // 2. Create the source data list
        studentNamesList = new ArrayList<>();

        // 3. Add elements to the list (students)
        studentNamesList.add("Andrei");
        studentNamesList.add("Ionut");
        studentNamesList.add("Alin");
        studentNamesList.add("Gabriel");
        studentNamesList.add("Damian");
        studentNamesList.add("Szymon");
        studentNamesList.add("Caty");
        studentNamesList.add("Claudiu");
        studentNamesList.add("Ilinca");
        studentNamesList.add("Cosmin");
        studentNamesList.add("Olga");
        studentNamesList.add("Arturo");
        studentNamesList.add("Bartosz");
        studentNamesList.add("Kacper");
        studentNamesList.add("Patryk");
        studentNamesList.add("Margarita");
        studentNamesList.add("Kuba");
        studentNamesList.add("Roksana");
        studentNamesList.add("Patricia");
        studentNamesList.add("Mateusz");
        studentNamesList.add("Karol");
        studentNamesList.add("Dawid");
        studentNamesList.add("Kamil");
        studentNamesList.add("Mihal");

        // 4. Create an adapter component
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                studentNamesList
        );

        // 5. Link ListView & Adapter
        listViewStudents.setAdapter(adapter);

        // 6. on item list click event
        listViewStudents.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = studentNamesList.get(position);
        Toast.makeText(this, "You clicked on: " + name, Toast.LENGTH_SHORT).show();

        view.animate().rotationXBy(360).setDuration(2000).start();
    }
}
