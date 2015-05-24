package com.example.asus.cfbrowser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
        // Evita que los enlaces se abran fuera nuestra app ( navegador de android)
        webViewScreen.setWebViewClient(new WebViewClient());
        // zoom with two fingers
        webViewScreen.getSettings().setBuiltInZoomControls(true);

        imageButtonGo.setOnClickListener(this);
        imageButtonBack.setOnClickListener(this);
        imageButtonForward.setOnClickListener(this);

        //Pagina predeterminada
        editTextURL.setText("google.com");
        webViewScreen.loadUrl("http://"+editTextURL.getText().toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        Intent i;


        switch (item.getItemId()) {


            case R.id.item1:
                webViewScreen.clearHistory();
                webViewScreen.clearCache(true);


                return true;

            case R.id.item2:

                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }


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

                    webViewScreen.loadUrl("http://"+editTextURL.getText().toString());

                }



                break;


            case R.id.imageButtonBack:

                if (webViewScreen.canGoBack()){

                    webViewScreen.goBack();

                    editTextURL.setText(webViewScreen.getOriginalUrl().substring(7));

                }
                else{

                    Toast.makeText(getBaseContext(),"Not there are more pages visited",Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder dialogBox = new AlertDialog.Builder(this);

                    dialogBox.setMessage("Do you wish exit of the app?");

                    dialogBox.setCancelable(false);

                    dialogBox.setPositiveButton("Si", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogBox, int which) {
                            finish();
                        }
                    });

                    dialogBox.setNegativeButton("No", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogBox, int which) {
                            dialogBox.cancel();
                        }
                    });


                    dialogBox.show();
                }

                break;


            case R.id.imageButtonForward:


                if(webViewScreen.canGoForward()){
                    webViewScreen.goForward();
                    editTextURL.setText(webViewScreen.getOriginalUrl().substring(7));
                }
                else{

                    Toast.makeText(getBaseContext(), "Not there are more pages to visit", Toast.LENGTH_SHORT).show();

                }



                break;


            default:

                //dfsdfsfs;

        }




    }
}
