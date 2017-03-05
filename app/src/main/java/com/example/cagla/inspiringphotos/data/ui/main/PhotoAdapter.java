package com.example.cagla.inspiringphotos.data.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cagla.inspiringphotos.R;
import com.example.cagla.inspiringphotos.data.Globals;
import com.example.cagla.inspiringphotos.data.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cagla on 05/03/2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MainViewHolder> {

    private List<Photo> recentPhotos;

    public PhotoAdapter(List<Photo> recentPhotos){
        this.recentPhotos = recentPhotos;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_photo, parent, false);
        MainViewHolder mainViewHolder = new MainViewHolder(rowView);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        //String photoFormat = "https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg";

        String farmId = String.valueOf(recentPhotos.get(position).photoFarm);
        String photoServerID = recentPhotos.get(position).photoServer;
        String photoId = recentPhotos.get(position).photoId;
        String photoSecret = recentPhotos.get(position).photoSecret;
        String photoUrl = Globals.HTTP_FARM + farmId + Globals.PHOTO_STATIC_URL + photoServerID + "/" + photoId +"_"+ photoSecret + ".jpg";

        Picasso.with(holder.itemView.getContext()).load(photoUrl).into(holder.recentPhotoImageView);

    }

    @Override
    public int getItemCount() {
        return recentPhotos.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview_recent_photo)
        ImageView recentPhotoImageView;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
