package edu.bluejack151.JChat.jchat3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shiperus.ark.jchat3.R;

/**
 * Created by komputer on 12/22/2015.
 */
public class FragmentChat extends android.support.v4.app.Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance)
    {
        View view=inflater.inflate(R.layout.fragmentchat,container,false);
        return  view;
    }
}