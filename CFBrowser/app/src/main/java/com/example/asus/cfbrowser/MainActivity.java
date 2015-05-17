package com.example.asus.cfbrowser;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.webkit.WebView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    EditText editTextURL;
    ImageButton imageButtonGo;
    ImageButton imageButtonBack;
    ImageButton imageButtonForward;
    WebView webViewScreen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextURL= (EditText) findViewById(R.id.editTextURL);
        imageButtonGo= (ImageButton) findViewById(R.id.imageButtonGo);
        imageButtonBack= (ImageButton) findViewById(R.id.imageButtonBack);
        imageButtonForward= (ImageButton) findViewById(R.id.imageButtonForward);

        webViewScreen= (WebView) findViewById(R.id.webViewScreen);
        webViewScreen.setWebViewClient(new WebViewClient());

        imageButtonGo.setOnClickListener(this);
        imageButtonBack.setOnClickListener(this);
        imageButtonForward.setOnClickListener(this);

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
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imageButtonGo:

                if (editTextURL.getText().toString().equals("")){

                    Toast.makeText(getBaseContext(), "The Url field is empty", Toast.LENGTH_SHORT).show();

                }
                else{

                    Toast.makeText(getBaseContext(), "Directing to "+ editTextURL.getText().toString() , Toast.LENGTH_SHORT).show();

                    webViewScreen.loadUrl(editTextURL.getText().toString());

                }



                break;


            case R.id.imageButtonBack:

                Toast.makeText(getBaseContext(), "back"+ editTextURL.getText().toString() , Toast.LENGTH_SHORT).show();

                break;


            case R.id.imageButtonForward:

                Toast.makeText(getBaseContext(), "adelante", Toast.LENGTH_SHORT).show();

                break;


            default:

                //dfsdfsfs;

        }




    }
}
