package com.linechen.webviewdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DefaultWebViewActivity extends AppCompatActivity {

    /**
     * android sdk api >= 17 时需要加@JavascriptInterface
     *
     * @author fei
     */
    final class InJavaScriptLocalObj {

        @JavascriptInterface
        public void showSource(String html) {

        }
    }

    WebView webView;

    private static final String url1 = "http://120.26.73.227:8081/api/page/file/promotion/tea/recruit.html";

    private static final String url2 = "https://www.baidu.com/index.php?tn=monline_3_dg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_web_view);
        webView = (WebView) findViewById(R.id.webview);

        initWebView();

        loadUrl();
    }

    private void loadUrl() {
        webView.loadUrl(url1);
    }

    private void initWebView() {
        initSettings();

        initWebViewClient();

        initWebChromeClient();
    }

    private void initWebChromeClient() {
        webView.setWebChromeClient(new WebChromeClient(){

        });
    }

    private void initWebViewClient() {
        webView.setWebViewClient(new WebViewClient(){

        });
    }

    private void initSettings() {
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new InJavaScriptLocalObj(), "local_obj");
        webView.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.getSettings().setDomStorageEnabled(false);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
    }


}
