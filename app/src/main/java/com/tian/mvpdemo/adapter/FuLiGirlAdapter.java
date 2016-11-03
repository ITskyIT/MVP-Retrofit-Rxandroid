package com.tian.mvpdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tian.mvpdemo.R;
import com.tian.mvpdemo.bean.FuLiGirl;

import java.util.List;

/**
 * Created by jiujiu on 2016/11/2.
 */
public class FuLiGirlAdapter extends BaseAdapter{
    private Context context;
    private List<FuLiGirl.FuLi> list;

    public FuLiGirlAdapter(Context context, List<FuLiGirl.FuLi> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        if (list.size()<=0||list==null){
            return 0;
        }
        else
            return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.girl_item,null);
            holder.iv1= (ImageView) convertView.findViewById(R.id.imageView);
            holder.tv1= (TextView) convertView.findViewById(R.id.textView);
            holder.tv2= (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getUrl()).into(holder.iv1);
        holder.tv1.setText(list.get(position).getType());
        holder.tv2.setText(list.get(position).getCreatedAt());
        return convertView;
    }
    class ViewHolder {
        ImageView iv1;
        TextView tv1;
        TextView tv2;
    }
}
