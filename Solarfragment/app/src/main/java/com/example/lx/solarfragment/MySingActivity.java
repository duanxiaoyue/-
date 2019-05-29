package com.example.lx.solarfragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lx.solarfragment.adapter.SingAdapter;
import com.example.lx.solarfragment.bean.Sing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MySingActivity extends AppCompatActivity {

    private String clientUrl;
    List<Sing> sings=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sing);

        clientUrl = getString(R.string.clientUrl);
        ImageView back = findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySingActivity.this.finish();
            }
        });

        Log.e("SingList","oncreate()");
        MySingActivity.SingListTask singListTask = new MySingActivity.SingListTask();
        singListTask.execute();

        SingAdapter singAdapter=new SingAdapter(sings,this,R.layout.singname);
        //设置Adapter
        ListView listView=findViewById(R.id.lv_sing);
        listView.setAdapter(singAdapter);
    }
    public class SingListTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                String path=clientUrl+"LookSingServlet";
                URL url=new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("contentType", "UTF-8");
                Log.e("SingList","is之前");
                InputStream is = connection.getInputStream();
                Log.e("SingList","is之后");
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    String res = new String(buffer, 0, len);
                    //解析Json格式
                    JSONArray array = new JSONArray(res);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        Sing sing=new Sing();
                        String name=object.getString("name");
                        sing.setSingname(name);
                        sings.add(sing);
                        Log.e("name",sing.toString());
                    }
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
