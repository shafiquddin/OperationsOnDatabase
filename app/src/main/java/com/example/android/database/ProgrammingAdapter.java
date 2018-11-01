//package com.example.android.database;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.viewHolder> {
//    String[] data;
//
//    public ProgrammingAdapter(String data) {
//        this.data = data;
//
//    }
//
//    @NonNull
//    @Override
//    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.item_list, parent, false);
//        return new viewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
//        String title = data[position];
//        holder.txt.setText(title);
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.length;
//    }
//
//    public class viewHolder extends RecyclerView.ViewHolder {
//        TextView txt;
//
//        public viewHolder(View itemView) {
//            super(itemView);
//            txt = (TextView) itemView.findViewById(R.id.edit);
//
//        }
//    }
//}
