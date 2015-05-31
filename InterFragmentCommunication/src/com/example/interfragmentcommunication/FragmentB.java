package com.example.interfragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
	TextView tview;
	String data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_b, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		tview = (TextView) getActivity().findViewById(R.id.textView1);
		if(savedInstanceState==null)
		{
			setValue("Populated Dynamically");
		}
		else
		{
			setValue(savedInstanceState.getString("textdata"));
		}
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putSerializable("textdata", data);
	}
	public void setValue (String str){
		this.data=str;
		tview.setText(data);
	}
}
