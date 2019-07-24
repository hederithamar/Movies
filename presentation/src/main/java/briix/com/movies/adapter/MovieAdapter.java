package briix.com.movies.adapter;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import briix.com.movies.R;
import briix.com.movies.databinding.ItemListMovieBinding;
import briix.com.movies.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> mItems;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private int lastPosition = 0;

    public interface OnItemClickListener {
        void onClickMovie(ViewHolder holder, View view, Movie mMovie);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public MovieAdapter(List<Movie> items, Context context) {
        mItems = items;
        mContext = context;
    }

    public void swapItems(List<Movie> card) {
        if (card == null) {
            mItems = new ArrayList<>();
        } else {
            mItems = card;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMovieBinding mBinding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), R.layout.item_list_movie, parent, false);

        return new ViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie mMovie = mItems.get(position);
        holder.mBinding.setMovie(mMovie);
        String url = mMovie.getPosterPath();
        Glide.with(mContext)
                .load(url)
                .into(holder.mBinding.image);
        setAnimation(holder.mBinding.cardItemRegister, position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ItemListMovieBinding mBinding;

        ViewHolder(ItemListMovieBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
            this.mBinding.cardItemRegister.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                mOnItemClickListener.onClickMovie(this, v, mItems.get(position));
            }
        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}