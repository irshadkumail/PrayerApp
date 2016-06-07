package com.sodo.kumail.prayerapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by kumail on 6/4/2016.
 */

public class NavFrag extends Fragment {

    ImageView imageView;
    ListView listView;
    NavAdapter navAdapter;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)
    {
        View view=layoutInflater.inflate(R.layout.nav_frag,viewGroup,false);
        imageView= (ImageView) view.findViewById(R.id.nav_image);
        listView=(ListView)view.findViewById(R.id.nav_list);
        init();


        return view;
    }
    public void init()
    {
        navAdapter= new NavAdapter(getActivity(),new String[]{"About Us","Namaz Rules","Qibla Rules","Islamic Calender","Disclaimer"});
        listView.setAdapter(navAdapter);

    }


    class NavAdapter extends BaseAdapter
    {
        Context context;
        String[] array;
        public NavAdapter(Context context,String[] array)
        {
            this.context=context;
            this.array=array;

        }
        public Object getItem(int pos)
        {
            return array[pos];
        }
        public long getItemId(int id)
        {
            return id;
        }
        public int getCount()
        {
            return array.length;
        }
        public View getView(int pos,View convertView,ViewGroup parent)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.nav_list_row,parent,false);


            TextView textView= (TextView) view.findViewById(R.id.nav_row_text);
            ImageView imageView= (ImageView) view.findViewById(R.id.nav_row_image);

            textView.setText(array[pos]);


            return view;
        }


    }

}
