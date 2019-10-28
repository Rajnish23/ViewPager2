package com.android.viewpager2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.android.viewpager2.MainActivity.tabColors;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {

    public static final String ARGS_KEY = "count";


    public TabFragment() {
        // Required empty public constructor
    }

    public static TabFragment getInstance(int count){
        Bundle args = new Bundle();
        args.putInt(ARGS_KEY, count);

        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(args);

        return tabFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.fragment_text);
        LinearLayout starLayout = view.findViewById(R.id.start_ll);


        int count = -1;
        if(getArguments() != null){
            count = getArguments().getInt(ARGS_KEY, -1);
        }

        if(count != -1){

            textView.setText(getString(R.string.hello_fragment, String.valueOf(count)));

            for(int i=0; i<count; i++){
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(R.drawable.ic_star_border_black_24dp);
                starLayout.addView(imageView);
            }
        }
    }
}
