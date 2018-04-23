package com.miguelcamposrivera.a03_customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class StudentAdapter extends ArrayAdapter<Student> {
    Context ctx;
    int template;
    List<Student> values;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        ctx = context;
        template = resource;
        values = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(template,parent,false);

        // 1. Get student info
        Student current = values.get(position);
        String name = current.getName();
        int age = current.getAge();
        String photoAddress = current.getPhotoUrl();

        // 2. Get the view components from the template
        TextView tvName = v.findViewById(R.id.textViewName);
        TextView tvAge = v.findViewById(R.id.textViewAge);
        ImageView ivPhoto = v.findViewById(R.id.imageViewPhoto);

        // 3. Set into the view component the current student info
        tvName.setText(name);
        tvAge.setText(String.valueOf(age));
        Picasso.get().load(photoAddress).into(ivPhoto);

        return v;
    }
}
