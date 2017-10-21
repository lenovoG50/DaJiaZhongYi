package com.lihui.dajiazhongyi.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lihui.dajiazhongyi.Home;
import com.lihui.dajiazhongyi.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by LiHui on 17/10/21.
 */

public class WelCome3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.welcome3,container, false);
        TextView textView = inflate.findViewById(R.id.titleView);
        SharedPreferences preferences = getActivity().getSharedPreferences("open", MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean("first", true);
        edit.commit();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Home.class));
                edit.putBoolean("first",false);
                edit.commit();
            }
        });
        return inflate;
    }


}
