package jcristobal.frontinvaders_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * created by light2408 supported for jscristobal
 */
public class contacto extends Activity {

    private ProgressBar progressBar; // Para la barra de proceso

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        final Button boton_atras = (Button)findViewById(R.id.button);
        boton_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(contacto.this, MainActivity.class);
                startActivity(intent);

            }
        });


        // Trabajamos con WebView
        String URL = "https://github.com/light2408";
        WebView webview;
        webview = (WebView)findViewById(R.id.webView2);

        // Para que sólo se vea en el webview
        webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }});

        webview.getSettings().setJavaScriptEnabled(true);    // Permitimos que se ejecute JavaScript
        webview.getSettings().setLoadWithOverviewMode(true); // Ajustamos la vista para que no se vea demasiado grande
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setBuiltInZoomControls(true);  // habilitamos el zoom
        webview.loadUrl(URL);


        // Para la barra de proceso
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        webview.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view, int progress)
            {
                progressBar.setProgress(0);
                progressBar.setVisibility(View.VISIBLE);
                contacto.this.setProgress(progress * 1000);

                progressBar.incrementProgressBy(progress);

                if(progress == 100)
                {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });



    }
}
