package sg.edu.rp.c346.id20014009.p07simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewAction;
    Button btnAdd;
    Button btnClear;
    ListView lvAction;
    ArrayAdapter<String>aaAction;
    ArrayList<String>alAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNewAction=findViewById(R.id.editTextNewAction);
        btnAdd=findViewById(R.id.buttonAdd);
        btnClear=findViewById(R.id.buttonClear);
        lvAction=findViewById(R.id.listViewAction);

        alAction=new ArrayList<>();
        aaAction=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,alAction);
        lvAction.setAdapter(aaAction);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newAction=etNewAction.getText().toString();
                alAction.add(newAction);
                aaAction.notifyDataSetChanged();
                etNewAction.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alAction.clear();
                aaAction.notifyDataSetChanged();
            }
        });


    }
}