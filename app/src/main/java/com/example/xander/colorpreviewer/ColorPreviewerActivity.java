package com.example.xander.colorpreviewer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ColorPreviewerActivity extends Activity {

    private Button colorButton;
    private TextView colorText;
    private View colorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_previewer);

        colorButton = (Button) findViewById(R.id.colorButton);
        colorText = (TextView) findViewById(R.id.colorText);
        colorView = findViewById(R.id.colorView);

        colorText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int color = 0;
                try {
                    color = Color.parseColor(colorText.getText().toString());
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong color");
                }
                colorView.setBackgroundColor(color);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = 0;
                try {
                    color = Color.parseColor(colorText.getText().toString());
                } catch (IllegalArgumentException e) {
                    System.out.println("Wrong color");
                }
                colorView.setBackgroundColor(color);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.color_previewer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
