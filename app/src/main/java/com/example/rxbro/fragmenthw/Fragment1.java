package com.example.rxbro.fragmenthw;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {

    private Fragment1CommsCallback callback;
    private Button frag1Hi;
    private Button frag1Bye;
    private TextView result;

    public interface Fragment1CommsCallback {
        void frag1Hi(String greeting);
        void frag1Bye(String message);
        void onMessageReceived(String message);

    }


    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (Fragment1CommsCallback)getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement Fragment1CommsCallback.");
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        frag1Hi = (Button)view.findViewById(R.id.frag1_hi_btn);
        frag1Bye = (Button)view.findViewById(R.id.frag1_bye_btn);
        frag1Hi.setOnClickListener(this);
        frag1Bye.setOnClickListener(this);
        result = (TextView)view.findViewById(R.id.frag1_result_tv);
        return view;
    }
    public void setResult(String message) {
        result.setText(message);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frag1_hi_btn:
                callback.frag1Hi("Hi");
                break;
            case R.id.frag1_bye_btn:
                callback.frag1Bye("Bye");
                break;
        }
    }

}
