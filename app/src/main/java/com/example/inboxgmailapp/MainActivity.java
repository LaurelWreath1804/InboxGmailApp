package com.example.inboxgmailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Message> msg = initMsgList();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ListViewAdapter(this, msg));
    }

  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private List<Message> initMsgList() {
        List<Message> list = new ArrayList<>();
        Message msg1 = new Message("Leonardo", "Hello");
        Message msg2 = new Message("Ronaldo", "Hello World!");
        Message msg3 = new Message("Pinocchio", "Are you OK?");
        Message msg4 = new Message("Betsy", "Hi there");
        Message msg5 = new Message("Abby", "Hi I'm fine thank you");
        Message msg6 = new Message("Newton", "Hi there");
        Message msg7 = new Message("Edison", "Follow the light!");
        Message msg8 = new Message("Hegel", "God is dead.");

        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
        list.add(msg4);
        list.add(msg5);
        list.add(msg6);
        list.add(msg7);
        list.add(msg8);

        return list;
    }
}