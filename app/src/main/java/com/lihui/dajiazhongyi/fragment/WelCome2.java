package com.lihui.dajiazhongyi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lihui.dajiazhongyi.R;

/**
 * Created by LiHui on 17/10/21.
 */

public class WelCome2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.welcome2,container, false);
        return inflate;
    }
}
