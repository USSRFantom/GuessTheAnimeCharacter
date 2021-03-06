package ussrfantom.com.example.guesstheanimecharacter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.logging.Level;

public class LevelsAdapter extends RecyclerView.Adapter<LevelsAdapter.LevelsViewHolder> {

    private ArrayList<Levels> levels;
    private OnImageClickListener onImageClickListener;

    public LevelsAdapter(ArrayList<Levels> levels) {
        this.levels = levels;
    }

    interface OnImageClickListener{
        void onImageClick(int position);
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public LevelsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.levels_item, viewGroup, false);
        return new LevelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelsViewHolder notesViewHolder, int position) {
        Levels levelss = levels.get(position);
        ImageView imageView = notesViewHolder.imageViewLevels;
        Picasso.get().load(levelss.getImage()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }



    class LevelsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewLevels;

        public LevelsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewLevels = itemView.findViewById(R.id.imageViewLevels);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onImageClickListener != null){
                        onImageClickListener.onImageClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
