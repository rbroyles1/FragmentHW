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
public class Fragment2 extends Fragment implements View.OnClickListener {

    private Fragment2CommsCallback callback;
    private Button frag2Hi;
    private Button frag2Bye;
    private TextView result;

    public interface Fragment2CommsCallback {
        void frag2Hi(String greeting);
        void frag2Bye(String message);
        void onMessageReceived(String message);
    }


    public Fragment2() {
        // Required empty public constructor
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (Fragment2CommsCallback)getActivity();

        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement Frag2CommsCallback.");
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        frag2Hi = (Button)view.findViewById(R.id.frag2_hi_btn);
        frag2Bye = (Button)view.findViewById(R.id.frag2_bye_btn);
        frag2Hi.setOnClickListener(this);
        frag2Bye.setOnClickListener(this);
        result = (TextView)view.findViewById(R.id.frag2_result_tv);
        return view;
    }
    public void setGreetingMessage(String message) {
        result.setText(message);
    }
    public void setLeavingMessage(String message) {
        result.setText(message);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.frag2_hi_btn:
                callback.frag2Hi("Hi");
                break;
            case R.id.frag2_bye_btn:
                callback.frag2Bye("Bye");
                break;
        }
    }


}
