package com.caucaragp.worldskills.primerensayo;


import android.animation.Animator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {


    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_b, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerPrueba);
        AdapterT adapterT = new AdapterT(getContext());
        recyclerView.setAdapter(adapterT);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        adapterT.setMlistener(new AdapterT.OnClickListener() {
            @Override
            public void itemClick(int position, ImageView item) {
                Animator animator = ViewAnimationUtils.createCircularReveal(item,0,item.getHeight(),0,item.getHeight()*1.5f);
                animator.setDuration(500);
                animator.start();
            }
        });


        return view;
    }

}
