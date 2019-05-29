package com.example.lx.solarfragment.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lx.solarfragment.ClockActivity;
import com.example.lx.solarfragment.MyActivity;
import com.example.lx.solarfragment.R;

public class FirstFragment extends Fragment {

    public static int NUMBER;
    private Button btnMore;
    private int userId;

    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;


//    轮播图
    int[] imageIds = new int[]{
            R.drawable.g1,
            R.drawable.g3,
            R.drawable.g3,
            R.drawable.g4,
            R.drawable.g5
    };
    private AdapterViewFlipper flipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.firstfragment_layout,container,false);

        bt1=view.findViewById(R.id.bt1);
        bt2=view.findViewById(R.id.bt2);
        bt3=view.findViewById(R.id.bt3);
        bt4=view.findViewById(R.id.bt4);
        bt5=view.findViewById(R.id.bt5);
        bt6=view.findViewById(R.id.bt6);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NUMBER=1;
                Intent intent=new Intent(getActivity(),ClockActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NUMBER=2;
                Intent intent=new Intent(getActivity(),ClockActivity.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NUMBER=3;
                Intent intent=new Intent(getActivity(),ClockActivity.class);
                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NUMBER=4;
                Intent intent=new Intent(getActivity(),ClockActivity.class);
                startActivity(intent);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NUMBER=5;
                Intent intent=new Intent(getActivity(),ClockActivity.class);
                startActivity(intent);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NUMBER=6;
                Intent intent=new Intent(getActivity(),ClockActivity.class);
                startActivity(intent);
            }
        });

//        轮播图
        flipper = (AdapterViewFlipper)view.findViewById(R.id.flipper);
        flipper.bringToFront();
        //创建一个BaseAdapter对象，该对象夬提供Gallery所显示的列表项
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //创建一个ImageView
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(imageIds[position]);
                //设置ImageView的缩放图
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //为imageView设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT

                ));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
        flipper.startFlipping();

//        进入MyActivity
        btnMore=view.findViewById(R.id.btn_more);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(),MyActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.next_in,R.anim.next_out);
            }
        });


        return view;
    }

    public void setData(int data) {
        userId = data;
    }

    public void prev(View source)
    {
        //显示上一个组件
        flipper.showPrevious();
        //停止播放
    }

    public void next(View source)
    {
        flipper.showNext();
    }

}

