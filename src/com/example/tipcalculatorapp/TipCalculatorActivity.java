package com.example.tipcalculatorapp;

import android.R.bool;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

	private EditText etTotalBill;
	private Button btnTip10;
	private Button btnTip20;
	private Button btnTip30;
	private TextView tvCalcluatedTip;
	private TextView tvCalculatedTotal;
	private EditText etCustomTip;
	private Button btnCalculateTip;
	
	private float tip;
	private float totalBill;
	private float calculatedTip;
	private boolean clearCustomTip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		etTotalBill = (EditText)findViewById(R.id.etBill);
		btnTip10 = (Button)findViewById(R.id.btn10);
		btnTip20 = (Button)findViewById(R.id.btn20);
		btnTip30 = (Button)findViewById(R.id.btn30);
		tvCalcluatedTip = (TextView)findViewById(R.id.tvCalculatedTip);
		tvCalculatedTotal = (TextView)findViewById(R.id.tvCalculatedTotal);
		etCustomTip = (EditText)findViewById(R.id.etEnterTip);
		btnCalculateTip = (Button)findViewById(R.id.btnCalculateCustomTip);
		
		
		btnCalculateTip.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(etCustomTip.getText().toString().equals("")){
					Toast.makeText(getBaseContext(), "Please enter the tip value / total bill", Toast.LENGTH_SHORT).show();
				} else {
					tip = Float.parseFloat(etCustomTip.getText().toString());
					clearCustomTip = false;
					calculateTip(tip, clearCustomTip);
				}
			}
		});
		
		
		btnTip10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(etTotalBill.getText().toString().equals("") || etTotalBill.getText().toString().equals("")){
					Toast.makeText(getBaseContext(), "Please enter the total bill", Toast.LENGTH_SHORT).show();
				} else {
					tip = 10;
					clearCustomTip = true;
					calculateTip(tip, clearCustomTip);
				}
			}
		});
		
		btnTip20.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(etTotalBill.getText().toString().equals("")){
					Toast.makeText(getBaseContext(), "Please enter the total bill", Toast.LENGTH_SHORT).show();
				} else {
					tip = 20;
					clearCustomTip = true;
					calculateTip(tip, clearCustomTip);
				}		
			}
		});
		
		btnTip30.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(etTotalBill.getText().toString().equals("")){
					Toast.makeText(getBaseContext(), "Please enter the total bill", Toast.LENGTH_SHORT).show();
				} else {
					tip = 30;
					clearCustomTip = true;
					calculateTip(tip, clearCustomTip);
				}	
			}
		});
	}


	private void calculateTip(float tipSelected, boolean clearCustomTip){
		tip = tipSelected;
		tvCalcluatedTip.setText("");
		tvCalculatedTotal.setText("");
		if(clearCustomTip){
			etCustomTip.setText("");
		}
		calculatedTip = (Float.parseFloat(etTotalBill.getText().toString())* tip)/100;
		tvCalcluatedTip.setText(Float.toString(calculatedTip));
		tvCalculatedTotal.setText(Float.toString(Float.parseFloat(etTotalBill.getText().toString()) + calculatedTip));
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}
