package com.znz.gametool.ViewGroup;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.znz.gametool.ViewGroup.GameButton;

import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.znz.gametool.AllBean.MapGlistBean;
import com.znz.gametool.AllBean.MapNlistBean;
import com.znz.gametool.R;

import java.util.ArrayList;
import com.znz.gametool.ViewGroup.GradientText;

public class MapExlaBaseApdate extends BaseExpandableListAdapter {

    //group
    private ArrayList<MapGlistBean> mapGlistBeans;
    //child
    private ArrayList<ArrayList<MapNlistBean>> mapNlistBeans;
    private Context context;

    public MapExlaBaseApdate(ArrayList<MapGlistBean> mapGlistBeans,ArrayList<ArrayList<MapNlistBean>> mapNlistBeans,Context context)
    {
        this.mapNlistBeans = mapNlistBeans;
        this.mapGlistBeans = mapGlistBeans;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return mapGlistBeans.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapNlistBeans.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mapGlistBeans.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapNlistBeans.get(groupPosition).get(childPosition);
    }

//    public MapNlistBean getChild(int groupPosition,int childPosition) { return mapNlistBeans.get(groupPosition).get(childPosition); }

//    @Override
//    public MapGlistBean getGroup(int groupPosition) {
//        return mapGlistBeans.get(groupPosition);
//    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GViewGrouHolde gViewGrouHolde;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_lift_map,parent,false);
            gViewGrouHolde = new GViewGrouHolde();
            gViewGrouHolde.textView = (DrwaCenterTextView) convertView.findViewById(R.id.map_tv);
            convertView.setTag(gViewGrouHolde);
        }
        else
        {
            gViewGrouHolde = (GViewGrouHolde)convertView.getTag();
        }
        gViewGrouHolde.textView.setDrawText(mapGlistBeans.get(groupPosition).getBmapName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CViewholder viewholder;
       if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.map_child,parent,false);
            viewholder = new CViewholder();
            viewholder.textView = (GradientText)convertView.findViewById(R.id.map_name);
            convertView.setTag(viewholder);
       }
       else
       {
            viewholder = (CViewholder)convertView.getTag();
         }
        viewholder.textView.setText(mapNlistBeans.get(groupPosition).get(childPosition).getMapName());
        return convertView;
    }

    class GViewGrouHolde
    {
        private DrwaCenterTextView textView;
    }
    class CViewholder
    {
        private GradientText textView;
    }
}
