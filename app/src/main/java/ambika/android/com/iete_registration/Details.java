package ambika.android.com.iete_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Details extends AppCompatActivity {
    EditText namelist;
    EditText regno;
    EditText mobilelist;
    EditText emaillist;
    EditText roomlist;
    EditText paymode;
    Button btnlist;
    String table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        namelist = (EditText)findViewById(R.id.name);
        regno = (EditText)findViewById(R.id.reg);
        mobilelist = (EditText)findViewById(R.id.mobile);
        emaillist = (EditText)findViewById(R.id.email);
        roomlist = (EditText)findViewById(R.id.room);
        paymode = (EditText) findViewById(R.id.pay);
        btnlist = (Button) findViewById(R.id.btnlist);
        Bundle b = getIntent().getExtras();
       String reg =  b.getString("reg");
       table = b.getString("event");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        DatabaseReference myref = database.getReference().child(table).child(reg);
        myref.child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                namelist.setText(name);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        regno.setText(reg);
        myref.child("Mobile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mobile = dataSnapshot.getValue(String.class);
                mobilelist.setText(mobile);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        myref.child("Email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String email = dataSnapshot.getValue(String.class);
                emaillist.setText(email);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        myref.child("Room").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String room = dataSnapshot.getValue(String.class);
                roomlist.setText(room);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        myref.child("Payment Mode").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String pay = dataSnapshot.getValue(String.class);
                paymode.setText(pay);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("event" , table);
                intent1.setClass(Details.this, viewdata.class);
                startActivity(intent1);
            }
        });


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
