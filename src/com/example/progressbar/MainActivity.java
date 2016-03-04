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
		//���ô������������ô����ȺͲ������ȵĽ�����
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
		text.setText("��һ���Ȱٷֱȣ�" + (int)(first/(float)max*100)+ "% �ڶ����ȵİٷֱȣ�"+(int)(second/(float)max*100)+"%");
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
			//����10���̶�
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
			//�½�����
			prolog = new ProgressDialog(MainActivity.this);
			//���
			prolog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			//���ñ���
			prolog.setTitle("�����");
			//���öԻ�������
			prolog.setMessage("��ӭ������Խ����");
			//ͼ��
			prolog.setIcon(R.drawable.ic_launcher);
			
			/*
			 * 
			 * �趨һЩ����
			 * 
			 * */
			prolog.setMax(100);
			prolog.incrementProgressBy(50);
			prolog.setIndeterminate(false);
			
			//�趨ȷ����ť
			prolog.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "��ӭ������Խ����", Toast.LENGTH_SHORT).show();
				}
			});
			//�����˳���ť
			prolog.setCancelable(true);
			//��ʾ
			prolog.show();
			break;
		}
		text.setText("��һ���Ȱٷֱȣ�" + (int)(progress.getProgress()/(float)progress.getMax()*100)+ "% �ڶ����ȵİٷֱȣ�"+(int)(progress.getSecondaryProgress()/(float)progress.getMax()*100)+"%");
	}
}
