package com.example.inboxgmailapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<Message> messages;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListViewAdapter(Context context, List<Message> listMsg) {
        this.context = context;
        this.messages = listMsg;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int pos) {
        return messages.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int pos, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
           convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
           viewHolder = new ViewHolder();
           viewHolder.profilePicView =(ImageView) convertView.findViewById(R.id.user_profile_pic);
           viewHolder.usernameView = (TextView) convertView.findViewById(R.id.username);
           viewHolder.contentView = (TextView) convertView.findViewById(R.id.message_content);
           convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Message msg = this.messages.get(pos);
        String firstLetter = String.valueOf(msg.getUsername().charAt(0));
        ColorGenerator colorGenerator = ColorGenerator.MATERIAL;

        int color = colorGenerator.getColor(getItem(pos));
        TextDrawable drawable = TextDrawable.builder().buildRound(firstLetter, color);
        viewHolder.profilePicView.setImageDrawable(drawable);
        viewHolder.usernameView.setText(msg.getUsername());
        viewHolder.contentView.setText(msg.getContent());

        return convertView;
    }

    static class ViewHolder {
        ImageView profilePicView;
        TextView usernameView;
        TextView contentView;
    }
}
