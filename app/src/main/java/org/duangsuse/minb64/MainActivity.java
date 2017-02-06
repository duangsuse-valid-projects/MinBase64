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
		TextView mText = (TextView)findViewById(R.id.Text);
		TextView mLoopCoder = (TextView)findViewById(R.id.times);
		Button isEncode = (Button)findViewById(R.id.isEncode);
		Button mDefault = (Button)findViewById(R.id.operate_default);
		Button mAdvance = (Button)findViewById(R.id.operate_advance);
		//End declaration
		mDefault.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(mContext,Operator("gg",2,true),Toast.LENGTH_SHORT).show();
			}
		});
		mAdvance.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//Builder的代码是抄的...感谢开源中国 :smirk:
				new AlertDialog.Builder(mContext).setTitle("请选择编解码参数").setIcon(
					     android.R.drawable.ic_media_play).setItems(
					     new String[] { "Default" , "URL_safe", "no_wrap" , "no_close" , "no_padding" , "CRLF" },
					     new DialogInterface.OnClickListener() {
						      public void onClick(DialogInterface dialog, int which) {
									switch (which){
										case 0:
											Toast.makeText(mContext,"Default",Toast.LENGTH_LONG).show();
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
					     }).setNegativeButton("取消", null).show();
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
			return "";
		}
		//return "It Works! Your option: "+flag;
	}
}
