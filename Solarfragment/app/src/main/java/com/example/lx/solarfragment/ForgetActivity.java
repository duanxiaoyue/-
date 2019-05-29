package com.example.lx.solarfragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class ForgetActivity extends AppCompatActivity {

    private String clientUrl;
    EditText etName,etPhone,etEmail;
    TextView tvName;
    Button button;
    private Button btnBack;
    private int userId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        clientUrl = getString(R.string.clientUrl);
        etName=findViewById(R.id.et_name);
        etPhone=findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        tvName = findViewById(R.id.tv_name);
        button = findViewById(R.id.btn);
        btnBack=findViewById(R.id.clock_back_left);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForgetActivity.this.finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Revise revise = new Revise();
                revise.execute();
            }
        });
    }
    //连接数据库
    public class Revise extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                String path=clientUrl+"TestUserServlet";
                URL url=new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("contentType","UTF-8");
                OutputStream os = connection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
                BufferedWriter writer = new BufferedWriter(outputStreamWriter);
                String name1=etName.getText().toString();
                JSONObject object = new JSONObject();
                object.put("userName",name1);

                writer.write(String.valueOf(object));
                connection.connect();
                writer.flush();
                writer.close();

                InputStream is = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String res = reader.readLine();
                JSONObject objectJSON1 = new JSONObject(res);
                String email1 = objectJSON1.getString("email");
                String phone1 = objectJSON1.getString("phone");
                userId = objectJSON1.getInt("userId");

                //获取页面数据

                String phone2 = etPhone.getText().toString();
                String email2 = etEmail.getText().toString();
                Log.e("youxiang",etEmail.getText().toString());
                //判断数据是否相等
                if(phone1.equals(phone2)&&email1.equals(email2)){
                    //进行页面跳转
                    Intent intent = new Intent();
                    intent.setClass(ForgetActivity.this,ReviseActivity.class);
                    intent.putExtra("userId",userId);
                    startActivity(intent);
                }else {
                    tvName.setText("手机号/邮箱输入不正确");
                }
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
