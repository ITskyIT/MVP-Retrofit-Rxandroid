package com.tian.mvpdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tian.mvpdemo.R;
import com.tian.mvpdemo.bean.GirlBean;

import java.util.List;

/**
 * 数据适配器
 */
public class GirlAdapter extends BaseAdapter{
    private Context context;
    private List<GirlBean> list;

    public GirlAdapter(Context context, List<GirlBean> list) {
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
        Picasso.with(context).load(list.get(position).getImgPath()).into(holder.iv1);
        holder.tv1.setText(list.get(position).getIntroduction());
        holder.tv2.setText(list.get(position).getStars());
        return convertView;
    }
    class ViewHolder {
        ImageView iv1;
        TextView tv1;
        TextView tv2;
    }
}
