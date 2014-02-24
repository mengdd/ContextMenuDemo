package com.example.mengdd.hellocontextmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class HelloContextMenuMainActivity extends Activity {

    private TextView mTextView1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_context_menu_main);

        mTextView1 = (TextView) findViewById(R.id.textView1);

        // 注册要弹出ContextMenu的View
        registerForContextMenu(mTextView1);

        // 转入下一个例子
        View nextBtn = findViewById(R.id.next1);
        nextBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HelloContextMenuMainActivity.this,
                        ContextualActionModeActivity.class);
                startActivity(intent);

            }
        });

        // 转入第三个例子
        View nextBtn2 = findViewById(R.id.next2);
        nextBtn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HelloContextMenuMainActivity.this,
                        ListCABActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        // 第二个参数为当前点击的view

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        // 把布局inflate进menu对象
        inflater.inflate(R.menu.context_menu1, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        boolean result = false;
        switch (item.getItemId()) {
        case R.id.edit:

            Toast.makeText(HelloContextMenuMainActivity.this, "Edit",
                    Toast.LENGTH_LONG).show();
            result = true;
            break;
        case R.id.help:
            Toast.makeText(HelloContextMenuMainActivity.this, "Help",
                    Toast.LENGTH_LONG).show();
            result = true;
            break;
        default:
            result = super.onContextItemSelected(item);
            break;

        }

        return result;

    }

}
