package com.example.knave_player;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoFoldersAdapter extends RecyclerView.Adapter<VideoFoldersAdapter.ViewHolder> {

    private final ArrayList<String> folderPath;
    private final Context context;

    public VideoFoldersAdapter(ArrayList<String> folderPath, Context context) {
        this.folderPath = folderPath;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.folder_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int indexPath = folderPath.get(position).lastIndexOf("/");
        String nameOfFolder = folderPath.get(position).substring(indexPath+1);
        holder.folderName.setText(nameOfFolder);
        holder.folderPath.setText(folderPath.get(position));
        holder.noOfFiles.setText("Videos");

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, VideoFilesActivity.class);
            intent.putExtra("folderName", nameOfFolder);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return folderPath.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView folderName, folderPath, noOfFiles;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            folderName = itemView.findViewById(R.id.folderName);
            folderPath = itemView.findViewById(R.id.folderPath);
            noOfFiles = itemView.findViewById(R.id.noOfFiles);
        }
    }
}