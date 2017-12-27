package com.lnavarro.peopleconcept.app.ui.people.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnavarro.peopleconcept.R;
import com.lnavarro.peopleconcept.app.widget.CircleTransformation;
import com.lnavarro.peopleconcept.domain.model.Person;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by luis on 17/10/17.
 */

public class PeopleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<Person> mData;
    private HeroesListener mClickListener;

    public interface HeroesListener {
        void onHeroeSelected(Person person, ImageView image);
    }

    public PeopleAdapter(Context context, ArrayList<Person> data) {
        this.mContext = context;
        this.mData = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_people, parent, false);
        viewHolder = new PeopleViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final Person person = mData.get(position);

        if(person.getPicture() != null && !TextUtils.isEmpty(person.getPicture().getLarge())){
            Picasso.with(mContext)
                    .load(person.getPicture().getLarge())
                    .transform(new CircleTransformation())
                    .placeholder(ContextCompat.getDrawable(mContext, R.drawable.placeholder_people_adapter))
                    .into(((PeopleViewHolder) holder).image);
            ((PeopleViewHolder) holder).image.setVisibility(View.VISIBLE);
        } else {
            ((PeopleViewHolder) holder).image.setVisibility(View.INVISIBLE);
        }

        ((PeopleViewHolder) holder).name.setText(person.getName().getFirst() + " " + person.getName().getLast());
        ((PeopleViewHolder) holder).phone.setText(person.getPhone());

        ((PeopleViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onHeroeSelected(person, ((PeopleViewHolder) holder).image);
                }
            }
        });

    }

    public void setOnItemClickListener(HeroesListener listener) {
        this.mClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, phone;

        public PeopleViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);

        }
    }
}
