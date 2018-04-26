package com.miguelcamposrivera.a01_fragmentlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelcamposrivera.a01_fragmentlist.dummy.DummyContent.DummyItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyStudentRecyclerViewAdapter extends RecyclerView.Adapter<MyStudentRecyclerViewAdapter.ViewHolder> {

    private final List<Student> mValues;
    private Context ctx;
    private int template;

    // Constructor
    public MyStudentRecyclerViewAdapter(Context context, int layout, List<Student> items) {
        mValues = items;
        ctx = context;
        template = layout;
    }

    // The method to load the template
    // Template > XML layout file where we design 1 list item
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(template, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // The current Student item
        holder.mItem = mValues.get(position);

        // Set the student properties into the view components
        holder.tvName.setText(holder.mItem.getName());
        holder.tvAge.setText(holder.mItem.getAge()+" years old");
        holder.tvSchool.setText(holder.mItem.getSchoolName());

        Picasso.get()
                .load(holder.mItem.getPhotoUrl())
                .into(holder.ivPhoto);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // Define the group of Views we have in the template
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivPhoto;
        public final TextView tvName;
        public final TextView tvAge;
        public final TextView tvSchool;


        // We put the model type that we have in the list
        public Student mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivPhoto = view.findViewById(R.id.imageViewPhoto);
            tvName = view.findViewById(R.id.textViewName);
            tvAge = view.findViewById(R.id.textViewAge);
            tvSchool = view.findViewById(R.id.textViewSchool);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvName.getText() + "'";
        }
    }
}
