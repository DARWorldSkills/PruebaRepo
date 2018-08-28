package com.caucaragp.worldskills.primerensayo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    boolean bandera=true;
    public AFragment() {
        // Required empty public constructor
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_a, container, false);
        final TextView txtTiempo = view.findViewById(R.id.txtTiempo);
        final int [] tiempo = {0};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (bandera){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tiempo[0]++;

                            if (tiempo[0]==100){

                                endGame();

                            }
                            txtTiempo.setText(Integer.toString(tiempo[0]));
                        }
                    });
                }
            }
        });
        thread.start();


        return view;
    }
    int ab=0;
    private void endGame() {
        if (ab==0){
            ab=1;
            bandera=false;

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bandera=false;
    }
}
