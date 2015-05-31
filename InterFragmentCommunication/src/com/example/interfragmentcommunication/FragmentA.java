package com.example.interfragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentA extends Fragment implements OnClickListener{
	Button btn;
	int counter=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(savedInstanceState !=null){
			counter=savedInstanceState.getInt("mycounter",0);
		}
		else {
			counter=0;
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_a, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		btn = (Button) getActivity().findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, "Button is clicked", Toast.LENGTH_LONG).show();
		counter++;
		Communicator comm;
		comm = (Communicator) getActivity();
		comm.sendCounter(counter);
		Log.d("DEB", "Button is clicked. Counter = "+counter);
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putInt("mycounter", counter);
		super.onSaveInstanceState(outState);
	}
}
