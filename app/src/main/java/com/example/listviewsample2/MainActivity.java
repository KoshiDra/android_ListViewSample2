package com.example.listviewsample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewオブジェクト作成
        ListView lv = findViewById(R.id.lvMenu);

        // 表示リスト作成
        List<String> list = new ArrayList<>();

        // データ登録
        list.add("唐揚げ定食");
        list.add("ハンバーグ定食");
        list.add("生姜焼き定食");
        list.add("ステーキ定食");
        list.add("野菜炒め定食");
        list.add("とんかつ定食");
        list.add("ミンチかつ定食");
        list.add("チキンカツ定食");
        list.add("コロッケ定食");
        list.add("回鍋肉定食");
        list.add("麻婆豆腐定食");
        list.add("豆板醬定食");
        list.add("焼き魚定食");
        list.add("焼肉定食");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list);

        lv.setAdapter(adapter);

        // リストビューのアイテムにリスナ設定
        lv.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // ダイアログ表示
            OrderConfirmDialogFragment o = new OrderConfirmDialogFragment();
            o.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }
}