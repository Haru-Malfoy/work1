package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.myviewholder>{

    private Context context;
    private List<String> mlist = new ArrayList<>();
    private List<String> mlist1 = new ArrayList<>();
    private int expandPosition = -1;
    private myviewholder mViewholder;

    public adapter(Context context, List<String> mList) {
        this.context  = context;
    }

    public void setExpandCollapseDataList(List<String> list) {
        mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public adapter.myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(final adapter.myviewholder viewHolder, int position) {
        viewHolder.tvTeam.setText(mlist.get(position));
//            for(int i=0 ; i < mlist.size() ; i++){
//                mlist1.add(mlist.get(i));
//            }
        viewHolder.tvTeamChild.setText(mlist.get(position+17));

        final boolean isExpand = position == expandPosition;
        viewHolder.rlChild.setVisibility(isExpand ? View.VISIBLE : View.GONE);
        viewHolder.rlParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mViewholder !=null){
                    mViewholder.rlChild.setVisibility(View.GONE);
                    notifyItemChanged(expandPosition);
                }
                expandPosition = isExpand ? -1 : viewHolder.getAdapterPosition();
                mViewholder = isExpand ? null : viewHolder;
                notifyItemChanged(viewHolder.getAdapterPosition());
            }
        });
        viewHolder.tvTeamChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "你点击了"+viewHolder.tvTeamChild.getText(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(v.getContext(),MainActivity2.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist == null ? 0 :mlist.size()/2;
    }


    public static class myviewholder extends RecyclerView.ViewHolder {
        RelativeLayout rlParent,rlChild;
        TextView tvTeam,tvTeamChild;
        public myviewholder(View itemView) {
            super(itemView);
            rlParent = itemView.findViewById(R.id.rl_parent);
            rlChild = itemView.findViewById(R.id.rl_child);
            tvTeam = itemView.findViewById(R.id.tv_team);
            tvTeamChild = itemView.findViewById(R.id.tv_team_child);
        }
    }
}

