package com.sodo.kumail.prayerapp;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by kumail on 6/4/2016.
 */

public class MethodDialog extends DialogFragment implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {

    RadioGroup radioGroup;
    public static int selected_id=1;
    public static String selected_text="University of Islamic Sciences, Karachi";
    Button button;
    View view;
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle)
    {
        view=layoutInflater.inflate(R.layout.method_dialog,viewGroup,false);

        button= (Button) view.findViewById(R.id.dismiss_dialog);
        radioGroup= (RadioGroup) view.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);


        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        RadioButton radioButton= (RadioButton) view.findViewById(checkedId);
        selected_text=radioButton.getText().toString();
        if(checkedId==R.id.radio_0)
        {
            selected_id=0;

        }
        if(checkedId==R.id.radio_1)
        {
            selected_id=1;
        }
        if(checkedId==R.id.radio_2)
        {
            selected_id=2;
        }
        if(checkedId==R.id.radio_3)
        {
            selected_id=3;
        }
        if(checkedId==R.id.radio_4)
        {
            selected_id=5;
        }
        if(checkedId==R.id.radio_5)
        {
            selected_id=5;
        }
        if(checkedId==R.id.radio_6)
        {
            selected_id=6;
        }
    }

    @Override
    public void onClick(View v) {
        dismiss();

    }
}
