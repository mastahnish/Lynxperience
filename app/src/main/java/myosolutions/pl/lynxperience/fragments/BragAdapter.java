package myosolutions.pl.lynxperience.fragments;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import myosolutions.pl.lynxperience.databinding.BragItemBinding;

/**
 * Created by Jacek on 2017-06-27.
 */

public class BragAdapter extends RecyclerView.Adapter<BragAdapter.BragItemsViewHolder>{

    private List<BragItem> mData;

    private OnItemClickListener mOnItemClickListener;

    public BragAdapter(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public void setData(List<BragItem> data) {
        this.mData = data;
    }

    @Override
    public BragItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BragItemBinding binding = BragItemBinding.inflate(inflater, parent, false);
        return new BragItemsViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(BragItemsViewHolder holder, int position) {
        BragItem item = mData.get(position);
        holder.mBinding.setBragItem(item);
    }



    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    class BragItemsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        BragItemBinding mBinding;

        BragItemsViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(mData.get(getAdapterPosition()));
            }
    }


    public interface OnItemClickListener {
        void onItemClick(BragItem item);
    }
}
