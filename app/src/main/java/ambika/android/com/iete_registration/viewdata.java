package ambika.android.com.iete_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewdata extends AppCompatActivity {
    //ArrayList<String> participants;
    ArrayAdapter adapter;
    ListView lst;
    ArrayList<String> reglist = new ArrayList<>();
    ArrayList<String> participantdetails = new ArrayList<>();
    String participant;
    String table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle b = getIntent().getExtras();
        table = b.getString("event");
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference().child(table);
        lst = (ListView) findViewById(R.id.lst);
        adapter = new ArrayAdapter<String>(viewdata.this , android.R.layout.simple_list_item_1, reglist);
        lst.setAdapter(adapter);
        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String reg = dataSnapshot.getKey();
                reglist.add(reg);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String reg = (String)parent.getItemAtPosition(position);
                Intent intent = new Intent();
                intent.putExtra("reg", reg);
                intent.putExtra("event",table);
                intent.setClass(viewdata.this, Details.class);
                startActivity(intent);

            }
        });

        /*reglist.add("17BCE0795");
        reglist.add("bkjb");
        for(int i=0;i<reglist.size();i++){
            String reg = reglist.get(i);
            participant = reg;
            DatabaseReference regref = database.getReference(reg);
            database.getReference(reg).child("Name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String name = dataSnapshot.getValue(String.class);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            regref.child("Mobile").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String mobile = dataSnapshot.getValue(String.class);
                    participant = participant + " - " + mobile;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            regref.child("Email").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String email = dataSnapshot.getValue(String.class);
                    participant = participant + " - " + email;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            regref.child("Room").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String room = dataSnapshot.getValue(String.class);
                    participant = participant + " - " + room;
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            participantdetails.add(participant);
        }
        adapter = new ArrayAdapter<String>(viewdata.this , android.R.layout.simple_list_item_1,participantdetails);
        lst.setAdapter(adapter);*/


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
