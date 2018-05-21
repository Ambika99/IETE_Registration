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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class enterdata extends AppCompatActivity {
    Button btnsave;
    EditText name;
    EditText reg;
    EditText mobile;
    EditText email;
    EditText room;
    RadioGroup paymentmethod;
    int payment;
    String pay;
    RadioButton rcash;
    RadioButton rcard;
    Button btndata;
    ArrayList<String> reglist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle b = getIntent().getExtras();
        final String table = b.getString("event");
        btnsave = (Button) findViewById(R.id.btnsave);
        btndata = (Button) findViewById(R.id.btndata);
        name  = (EditText) findViewById(R.id.name);
        reg  = (EditText) findViewById(R.id.reg);
        mobile  = (EditText) findViewById(R.id.mobile);
        email  = (EditText) findViewById(R.id.email);
        room  = (EditText) findViewById(R.id.room);
        paymentmethod = (RadioGroup) findViewById(R.id.rpaymentmethods);
        rcash = (RadioButton) findViewById(R.id.cash);
        rcard = (RadioButton) findViewById(R.id.card);
        paymentmethod.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.cash:
                        pay = "Cash";
                        break;
                    case R.id.card:
                        pay = "Card";
                        break;
                }

            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myref = database.getReferenceFromUrl("https://ieteregistration.firebaseio.com/");
        if(table == "Crack Jack"){
            myref.child("Event").setValue(table);
        }
        else if(table == "Greatest Heist"){
            myref.child("Event").setValue(table);
        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reglist.add(reg.getText().toString());
                myref.child(table).child(reg.getText().toString()).child("Name").setValue(name.getText().toString());
                myref.child(table).child(reg.getText().toString()).child("Mobile").setValue(mobile.getText().toString());
                myref.child(table).child(reg.getText().toString()).child("Email").setValue(email.getText().toString());
                myref.child(table).child(reg.getText().toString()).child("Room").setValue(room.getText().toString());
                myref.child(table).child(reg.getText().toString()).child("Payment Mode").setValue(pay);
                Toast.makeText(enterdata.this, "Saved To Database", Toast.LENGTH_LONG).show();
            }
        });
        btndata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(enterdata.this , viewdata.class);
                intent1.putExtra("event",table);
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
