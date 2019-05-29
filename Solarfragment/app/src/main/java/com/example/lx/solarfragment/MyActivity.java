package com.example.lx.solarfragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lx.solarfragment.bean.User;

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

public class MyActivity extends AppCompatActivity {

    private  int userId;
    private String clientUrl;
    public static int MY_SCORE;
  //  public static int USER_ID;
    public static int USER_SCORE;
    private ImageView BackLeft;
    private ImageView UserImg;
    private TextView UserName;
    private TextView  UserScore;
    private LinearLayout ScoreDetails;
    private LinearLayout ScoreMart;
    private LinearLayout ChangeUser;
    private LinearLayout ZhuCe;
    private LinearLayout SetUp;
    private LinearLayout CheckOut;
    private User user;
    private int score;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        clientUrl = getString(R.string.clientUrl);
        userId=MainActivity.USER_ID;
      //  USER_ID=userId;
        Log.e("userId",userId+"");
        /*用户 控件*/
        UserImg = findViewById(R.id.user_img);
        UserName = findViewById(R.id.user_name);
        UserScore = findViewById(R.id.user_score);
        BackLeft = findViewById(R.id.iv_back_eft);

        /**
         * 实例化调用postNameTask
         */


        /*功能页面 控件*/
        ScoreDetails = findViewById(R.id.ll_score_details);
        ScoreMart = findViewById(R.id.ll_score_mart);
        ChangeUser = findViewById(R.id.ll_change_user);
        ZhuCe = findViewById(R.id.ll_zhu_ce);
        SetUp = findViewById(R.id.ll_set_up);
        CheckOut = findViewById(R.id.ll_check_out);

        /*结束当前页面*/
        BackLeft.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
              //  MyActivity.this.finish();
                Intent intent=new Intent(MyActivity.this,MainActivity.class);
                intent.putExtra("userId",userId);
                startActivity(intent);
            }
        });

        ScoreDetails.setOnClickListener(new ViewClick());
        ScoreMart.setOnClickListener(new ViewClick());
        ChangeUser.setOnClickListener(new ViewClick());
        ZhuCe.setOnClickListener(new ViewClick());
        SetUp.setOnClickListener(new ViewClick());
        CheckOut.setOnClickListener(new ViewClick());
    }

    /**
     *Activity跳转事件
     */
    public class ViewClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch(v.getId()){
                case R.id.ll_score_details:
                    intent.setClass(MyActivity.this,IntegralActivity.class);
                    intent.putExtra("userId",userId);
                    startActivity(intent);
                    break;
                case R.id.ll_score_mart:
                    intent.setClass(MyActivity.this,MartActivity.class);
                    intent.putExtra("userId",userId);
                    startActivity(intent);
                    break;
                case R.id.ll_change_user:
                    //销毁登录记录
                    SharedPreferences spout2 =getSharedPreferences("myInfo", 0);
                    SharedPreferences.Editor ed2 =spout2.edit();
                    ed2.clear();
                    ed2.commit();
                    intent.setClass(MyActivity.this,LoginActivity.class);
                    startActivity(intent);

                    intent.setClass(MyActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_zhu_ce:
                    intent.setClass(MyActivity.this,RegisterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.ll_set_up:

                    intent.setClass(MyActivity.this,SettingActivity.class);
                    intent.putExtra("userId",userId);
                    startActivity(intent);
                    break;
                case R.id.ll_check_out:
                    intent.setClass(MyActivity.this,LoginActivity.class);
                    startActivity(intent);
                    break;


            }
        }
    }



    /**
     * 发送name
     * 接收用户所有信息
     */

    public class PostNameTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                String path=clientUrl+"GetNameServlet";
                URL url=new URL(path);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("contentType","UTF-8");
                OutputStream os = connection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
                BufferedWriter writer = new BufferedWriter(outputStreamWriter);
                JSONObject object = new JSONObject();
                object.put("user_id",userId);
                writer.write(String.valueOf(object));
                connection.connect();
                writer.flush();
                writer.close();
                InputStream is = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String res = reader.readLine();
                JSONObject objectJSON1 = new JSONObject(res);
                userName=objectJSON1.getString("user");
                score=objectJSON1.getInt("score");
                MY_SCORE=score;
                USER_SCORE=score;
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

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            UserName.setText(userName);
            UserScore.setText(MY_SCORE+"");

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        PostNameTask postNameTask = new PostNameTask();
        postNameTask.execute();
    }
}
