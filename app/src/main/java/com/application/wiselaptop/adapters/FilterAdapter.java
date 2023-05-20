package com.application.wiselaptop.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.application.wiselaptop.R;
import com.application.wiselaptop.interfaces.OnClickFilter;
import com.application.wiselaptop.models.Filter;


import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {
    private static int save = -1;
    Context context;
    List<Filter> lFilter;
    private OnClickFilter onClickFilter;
    int selectedFilter = 0;

    public void setOnClickFilter(OnClickFilter onClickFilter) {
        this.onClickFilter = onClickFilter;
    }

    public FilterAdapter(Context context, List<Filter> lFilter) {
        this.context = context;
        this.lFilter = lFilter;
    }

    public void setlFilter(List<Filter> lFilter){
        this.lFilter = lFilter;
        notifyDataSetChanged();
    }

    @Override
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View filterView = LayoutInflater.from(this.context).inflate(R.layout.adapter_filter, parent, false);
        FilterViewHolder filterViewHolder = new FilterViewHolder(filterView);
        return filterViewHolder;
    }

    @Override
    public void onBindViewHolder(FilterViewHolder filterViewHolder, int position) {
        String filter = this.lFilter.get(position).getFilterName();
        Boolean isSelectedFilter = this.lFilter.get(position).getSelected();
        filterViewHolder.tvFilter.setText(filter);
        OnClickListenerFilter onClickListenerFilter = new OnClickListenerFilter(this.lFilter, position);
        onClickListenerFilter.setOnClickFilter(this.onClickFilter);
        filterViewHolder.itemView.setOnClickListener(onClickListenerFilter);
        filterViewHolder.tvFilter.setSelected(isSelectedFilter.booleanValue());
    }

    @Override
    public int getItemCount() {
        return this.lFilter.size();
    }


    public class FilterViewHolder extends RecyclerView.ViewHolder {
        TextView tvFilter;

        public FilterViewHolder(View itemView) {
            super(itemView);
            this.tvFilter = (TextView) itemView.findViewById(R.id.tvFilter);
        }
    }

    public class OnClickListenerFilter implements View.OnClickListener {
        List<Filter> lFilters;
        OnClickFilter onClickFilter;
        int position;

        public OnClickListenerFilter(List<Filter> filters, int position) {
            this.position = position;
            this.lFilters = filters;
        }

        public void setOnClickFilter(OnClickFilter onClickFilter) {
            this.onClickFilter = onClickFilter;
        }

        @Override
        public void onClick(View v) {
            boolean isSelected = this.lFilters.get(this.position).getSelected().booleanValue();
            this.lFilters.get(this.position).setSelected(Boolean.valueOf(!isSelected));
            OnClickFilter onClickFilter = this.onClickFilter;
            if (onClickFilter != null) {
                onClickFilter.onClick(Integer.valueOf(this.position));
            }
            FilterAdapter.this.notifyDataSetChanged();
        }
    }
}
