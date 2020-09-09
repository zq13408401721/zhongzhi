package com.app.zhongying.activity.own;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.zhongying.R;

public class Modify_nameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView name_returns;
    private TextView name_title;
    private TextView name_preservation;
    private EditText name_text;
    private ImageView eliminate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_name);
        initView();
        initdata();
    }


    private void initView() {
        name_returns = (ImageView) findViewById(R.id.name_returns);
        name_returns.setOnClickListener(this);
        name_title = (TextView) findViewById(R.id.name_title);
        name_preservation = (TextView) findViewById(R.id.name_preservation);
        name_text = (EditText) findViewById(R.id.name_text);
        eliminate = (ImageView) findViewById(R.id.eliminate);

        name_text.addTextChangedListener(textWatcher);
        eliminate.setOnClickListener(this);
    }
    private void initdata() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        name_text.setText(name);
    }
   private TextWatcher textWatcher= new TextWatcher(){

       @Override
       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }

       @Override
       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }

       @Override
       public void afterTextChanged(Editable editable) {


           //如果有名字显示叉

           if (name_text.getEditableText().length()>=1){
               eliminate.setVisibility(View.VISIBLE);
           }else {
               eliminate.setVisibility(View.GONE);
           }
       }
   };


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.eliminate:
                name_text.setText("");
                break;

            case  R.id.name_returns:
                finish();
                break;
        }
    }
}