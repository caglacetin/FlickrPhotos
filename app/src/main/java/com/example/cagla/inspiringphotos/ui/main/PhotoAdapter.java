package com.example.cagla.inspiringphotos.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cagla.inspiringphotos.Globals;
import com.example.cagla.inspiringphotos.R;
import com.example.cagla.inspiringphotos.service.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MainViewHolder> {

    private List<Photo> allPhotosList;

    public PhotoAdapter(List<Photo> allPhotosList){
        this.allPhotosList = allPhotosList;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_photo, parent, false);
        MainViewHolder mainViewHolder = new MainViewHolder(rowView);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        //String photoUrlFormat = "https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg";

        String farmId = String.valueOf(allPhotosList.get(position).photoFarm);
        String photoServerID = allPhotosList.get(position).photoServer;
        String photoId = allPhotosList.get(position).photoId;
        String photoSecret = allPhotosList.get(position).photoSecret;
        String photoUrl = Globals.HTTP_FARM + farmId + Globals.PHOTO_STATIC_URL + photoServerID + "/" + photoId +"_"+ photoSecret + ".jpg";

        Picasso.with(holder.itemView.getContext()).load(photoUrl).into(holder.photoImageView);

        holder.pictureNo.setText(String.valueOf(position+1));

    }

    @Override
    public int getItemCount() {
        return allPhotosList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview_photo)
        ImageView photoImageView;

        @BindView(R.id.text_picture_no)
        TextView pictureNo;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
