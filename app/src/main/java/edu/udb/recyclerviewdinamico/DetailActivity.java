package edu.udb.recyclerviewdinamico;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class DetailActivity extends AppCompatActivity {
    ImageView teamImage;
    TextView teamDescription;

    WebView teamVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Team team = (Team) getIntent().getSerializableExtra("teamdetail");

        teamVideo = (WebView) findViewById(R.id.video);

        teamImage = (ImageView) findViewById(R.id.teamImage);

        teamDescription = (TextView) findViewById(R.id.teamDescription);

        WebSettings settings = teamVideo.getSettings();
        settings.setJavaScriptEnabled(true);
        teamVideo.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        teamVideo.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }

        });

        if(team.getVideoUrl() != null){
            Uri uri = Uri.parse(team.getVideoUrl());
            teamVideo.loadUrl(team.getVideoUrl());
        }

        teamDescription.setText(team.getDescription());
        Glide.with(this).load(team.getImgLogo()).fitCenter().bitmapTransform(new CropCircleTransformation(this)).into(teamImage);
    }
}
