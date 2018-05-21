package ambika.android.com.iete_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnnext;
    RadioGroup events;
    RadioButton crackjack;
    RadioButton greatestheist;
    String event;
    RadioButton selected;
    Button btnview;
    int check =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        events = (RadioGroup) findViewById(R.id.events);
        btnview = (Button) findViewById(R.id.btnview);
        crackjack = (RadioButton) findViewById(R.id.rcrackjack);
        greatestheist =(RadioButton) findViewById(R.id.rgreatestheist);
        events.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rcrackjack:
                        event = "Crack jack";
                        check=1;
                        break;
                    case R.id.rgreatestheist:
                        event = "Greatest Heist";
                        check =1;
                        break;


                                            }
            }
        });

        btnnext = (Button) findViewById(R.id.btnnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==1) {
                    Intent intent1 = new Intent();
                    intent1.setClass(MainActivity.this, enterdata.class);
                    intent1.putExtra("event", event);
                    startActivity(intent1);
                }else{
                    Toast.makeText(MainActivity.this,"Choose Event",Toast.LENGTH_LONG).show();
                }

            }
        });
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check==1) {
                    Intent intent2 = new Intent();
                    intent2.setClass(MainActivity.this, viewdata.class);
                    intent2.putExtra("event", event);
                    startActivity(intent2);
                }else{
                    Toast.makeText(MainActivity.this,"Choose Event",Toast.LENGTH_LONG).show();

                }
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
}
