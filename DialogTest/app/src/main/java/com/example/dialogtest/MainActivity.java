package com.example.dialogtest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {
    private Button standardDialog;
    private Button setViewStatic;
    private Button setViewDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        standardDialog = findViewById(R.id.standard_dialog);
        setViewStatic = findViewById(R.id.setView_static);
        setViewDynamic = findViewById(R.id.setView_dynamic);

        standardDialog.setOnClickListener(this);
        setViewStatic.setOnClickListener(this);
        setViewDynamic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.standard_dialog:
                showStandardDialog();
                break;
            case R.id.setView_static:
                showSetViewStatic();
                break;
            case R.id.setView_dynamic:
                showSetViewDynamic();
                break;
        }
    }

//==================================================================================================

    /**
     *
     */
    private void showStandardDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);// 添加ICON
        builder.setTitle(R.string.dialog_title);// 添加标题
        builder.setMessage(R.string.dialog_message);// 添加消息
        builder.setPositiveButton(R.string.certain, this);
        builder.setPositiveButton(R.string.cancel, this);
        builder.create();
        builder.show();
    }

    /**
     * @param dialog
     * @param which
     */
    @Override
    public void onClick(DialogInterface dialog, int which) {
        // TODO Auto-generated method stud
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                // todo “确定按钮”响应
                Toast.makeText(MainActivity.this, R.string.certain_click, Toast.LENGTH_LONG).show();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                // todo “取消按钮”响应
                Toast.makeText(MainActivity.this, R.string.cancel_click, Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

//==================================================================================================

    /**
     *
     */
/*    private void showStandardDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);// 添加ICON
        builder.setTitle(R.string.dialog_title);// 添加标题
        builder.setMessage(R.string.dialog_message);// 添加消息
        builder.create();
        builder.show();
    }*/

//==================================================================================================

    /**
     *
     */
/*    private void showStandardDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.mipmap.ic_launcher);// 添加ICON
        builder.setTitle(R.string.dialog_title);// 添加标题
        builder.setMessage(R.string.dialog_message);// 添加消息
        builder.setPositiveButton(R.string.certain, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击响应
                Toast.makeText(MainActivity.this, R.string.certain_click, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击响应
                Toast.makeText(MainActivity.this, R.string.cancel_click, Toast.LENGTH_LONG).show();
            }
        });
        builder.create();
        builder.show();
    }*/

    private void showSetViewStatic() {
    }

    private void showSetViewDynamic() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
