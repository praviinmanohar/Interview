package co.dzeta.interview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<ModelList> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, subtitle;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
        }
    }

    public ListAdapter(List<ModelList> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ModelList movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.subtitle.setText(movie.getSubtitle());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}