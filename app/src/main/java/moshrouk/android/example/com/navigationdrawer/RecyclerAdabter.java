package moshrouk.android.example.com.navigationdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdabter extends RecyclerView.Adapter<RecyclerAdabter.ViewHolder>{

    List<Itemlist> itemlists;
    Context context;
    public RecyclerAdabter( List<Itemlist> itemlists, Context context ) {
        this.itemlists = itemlists;
        this.context = context;
    }



    //this method call when create viewholder and return V.H
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity,parent,false);
        ViewHolder holder = new ViewHolder(row);
        return holder;

    }
    //this method call when create bind or link with V.H
    @Override
    public void onBindViewHolder( ViewHolder holder, int position ) {

        Itemlist itemlist =itemlists.get(position);
        holder.Head.setText(itemlist.getHead());
        holder.Description.setText(itemlist.getDescription());
    }


    //Calculated the number of row in RecyclerView
    @Override
    public int getItemCount() {
        return itemlists.size();
    }

    //create viewholder >> hold the row of RecyclerView and pass it to Adpter
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Head , Description;
        public ViewHolder( View itemView ) {
            super(itemView);
            //Here in adapter and not as activity so can not findViewByID direct call so we use the itemView.findViewById

            Head = (TextView) itemView.findViewById(R.id.textheading);
            Description = (TextView) itemView.findViewById(R.id.textdes);
        }
    }
}
