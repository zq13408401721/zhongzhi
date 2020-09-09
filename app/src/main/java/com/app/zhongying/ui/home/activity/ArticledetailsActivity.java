package com.app.zhongying.ui.home.activity;

import android.os.Bundle;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.zhongying.R;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class ArticledetailsActivity extends AppCompatActivity {

    private ImageView imagehead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articledetails);
        initView();
    }

    private void initView() {
        imagehead = findViewById(R.id.image_head);
        imagehead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tvtitle = findViewById(R.id.tv_title);
        TextPaint paint = tvtitle.getPaint();
        paint.setFakeBoldText(true);
    }

}