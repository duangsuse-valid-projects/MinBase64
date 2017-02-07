package org.duangsuse.minb64;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.util.Base64;
import android.view.View.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Main();
	}
	void Main(){
		//Begin declaration
		final Context mContext = this;
		final TextView mText = (TextView)findViewById(R.id.Text);
		TextView mLoopCoder = (TextView)findViewById(R.id.times);
		Button isEncode = (Button)findViewById(R.id.isEncode);
		Button mDefault = (Button)findViewById(R.id.operate_default);
		Button mAdvance = (Button)findViewById(R.id.operate_advance);
		final String DialogTitle = getResources().getString(R.string.dialog_advance);
		//End declaration
		mDefault.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//Toast.makeText(mContext,Operator("gg",2,true),Toast.LENGTH_SHORT).show();
			}
		});
		mAdvance.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//Builder的代码是抄的...感谢开源中国 :smirk:
				new AlertDialog.Builder(mContext).setTitle(DialogTitle).setIcon(
					     android.R.drawable.ic_media_play).setItems(
					     new String[] { "Default" , "URL_safe", "no_wrap" , "no_close" , "no_padding" , "CRLF" },
					     new DialogInterface.OnClickListener() {
						      public void onClick(DialogInterface dialog, int which) {
									switch (which){
										case 0:
											Toast.makeText(mContext,"Default",Toast.LENGTH_LONG).show();
											mText.setText(Operator(mText.getText().toString(),Base64.DEFAULT,true));
											break;
										case 1:
											break;
										case 2:
											break;
										case 3:
											break;
										case 4:
											break;
										case 5:
											break;
									}
							       dialog.dismiss();
						      }
					     }).setNegativeButton(android.R.string.cancel, null).show();
			}
		});
	}
	String Operator(String input,int flag,boolean isEncode){
		if (isEncode){
			byte[] mByte = input.getBytes();
			String ret = Base64.encodeToString(mByte,flag);
			return ret;
		}
		else{
			byte[] decoded = Base64.decode(input,flag);
			String ret = decoded.toString();
			return ret;
		}
		//return "It Works! Your option: "+flag;
	}
}
