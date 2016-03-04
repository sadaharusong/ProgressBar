package com.example.progressbar;

import android.R.integer;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private ProgressBar progress;
	private Button add;
	private Button low;
	private Button ret;
	private TextView text;
	private Button show;
	private ProgressDialog prolog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//启用窗口特征，启用带进度和不带进度的进度条
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_main);
		setProgressBarVisibility(true);
		setProgressBarIndeterminateVisibility(true);
		setProgress(600);
		
		init();
		int first = progress.getProgress();
		int second = progress.getSecondaryProgress();
		int max  = progress.getMax();
		text.setText("第一进度百分比：" + (int)(first/(float)max*100)+ "% 第二进度的百分比："+(int)(second/(float)max*100)+"%");
		add.setOnClickListener(this);
		low.setOnClickListener(this);
		ret.setOnClickListener(this);
		show.setOnClickListener(this);
	}

	private void init() {
		// TODO Auto-generated method stub
		progress = (ProgressBar)findViewById(R.id.horiz);
		add = (Button)findViewById(R.id.button1);
		low = (Button)findViewById(R.id.button2);
		ret = (Button)findViewById(R.id.button3);
		text = (TextView)findViewById(R.id.textView1);
		show = (Button)findViewById(R.id.show);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			//都加10个刻度
			progress.incrementProgressBy(10);
			progress.incrementSecondaryProgressBy(10);
			
			break;
		case R.id.button2:
			progress.incrementProgressBy(-10);
			progress.incrementSecondaryProgressBy(-10);
			break;
		case R.id.button3:
			progress.setProgress(50);
			progress.setSecondaryProgress(80);
			break;
		case R.id.show:
			//新建对象
			prolog = new ProgressDialog(MainActivity.this);
			//风格
			prolog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			//设置标题
			prolog.setTitle("金坷垃");
			//设置对话框内容
			prolog.setMessage("欢迎大家来吃金坷垃");
			//图标
			prolog.setIcon(R.drawable.ic_launcher);
			
			/*
			 * 
			 * 设定一些属性
			 * 
			 * */
			prolog.setMax(100);
			prolog.incrementProgressBy(50);
			prolog.setIndeterminate(false);
			
			//设定确定按钮
			prolog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "欢迎大家来吃金坷垃", Toast.LENGTH_SHORT).show();
				}
			});
			//返回退出按钮
			prolog.setCancelable(true);
			//显示
			prolog.show();
			break;
		}
		text.setText("第一进度百分比：" + (int)(progress.getProgress()/(float)progress.getMax()*100)+ "% 第二进度的百分比："+(int)(progress.getSecondaryProgress()/(float)progress.getMax()*100)+"%");
	}
}
