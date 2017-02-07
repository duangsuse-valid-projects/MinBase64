package org.duangsuse.minb64;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.util.Base64;
import android.view.View.*;
import android.graphics.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
		//this.getActionBar().hide(); //使用主题的方法实现了
		int color = Color.parseColor("#e8e8e8");
		setColor(this , color); //这段调用的方法什么的都是我抄的.....感谢源:http://m.open-open.com/m/lib/view/1455584716230.html
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
	/** * 设置状态栏颜色 * * @param activity 需要设置的activity * @param color 状态栏颜色值 */
    public static void setColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 生成一个状态栏大小的矩形
            View statusView = createStatusView(activity, color);
            // 添加 statusView 到布局中
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            decorView.addView(statusView);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }}
	/** * 生成一个和状态栏大小相同的矩形条 * * @param activity 需要设置的activity * @param color 状态栏颜色值 * @return 状态栏矩形条 */
    private static View createStatusView(Activity activity, int color) {
        // 获得状态栏高度
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);

        // 绘制一个和状态栏一样高的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
																		 statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }
    
}
