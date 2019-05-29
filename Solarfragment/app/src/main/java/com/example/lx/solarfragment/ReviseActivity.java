package com.example.lx.solarfragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReviseActivity extends AppCompatActivity {

    private String clientUrl;
    Button button;
    EditText etPassword,etCpassword;
    TextView tvCpassword;
    String password,cpassword;
    private Button btnBack;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revise);
        clientUrl = getString(R.string.clientUrl);
        userId=getIntent().getIntExtra("userId",0);
        button=findViewById(R.id.btn);
        etPassword=findViewById(R.id.et_password);
        etCpassword=findViewById(R.id.et_cpassword);
        tvCpassword = findViewById(R.id.tv_cpassword);
        btnBack=findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReviseActivity.this.finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b=Equal();
                if(b) {
                    Revise revise = new Revise();
                    revise.execute();
                    Intent intent=new Intent(ReviseActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    //判断两次密码输入是否一致
    public boolean Equal(){
        password = etPassword.getText().toString();
        cpassword = etCpassword.getText().toString();
        if (password!=null){
            if (password.equals(cpassword)){
                tvCpassword.setText("两次密码输入一致");
                return true;
            }else {
                tvCpassword.setText("两次密码输入不一致");
                return false;
            }
        }else {
            tvCpassword.setText("密码不能为空");
            return false;
        }
    }
    public class Revise extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                String path=clientUrl+"UpdatePasswordServlet";
                URL url=new URL(path);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("contentType","UTF-8");
                OutputStream os = connection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
                BufferedWriter writer = new BufferedWriter(outputStreamWriter);
                JSONObject object = new JSONObject();
                object.put("password",etPassword.getText().toString());
                object.put("userId",userId);
                writer.write(String.valueOf(object));
                connection.connect();
                writer.flush();
                writer.close();
                InputStream is = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                reader.close();
                inputStreamReader.close();
                is.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


    }
}
