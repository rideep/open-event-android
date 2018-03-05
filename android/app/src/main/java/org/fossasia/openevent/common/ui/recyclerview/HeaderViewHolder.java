package org.fossasia.openevent.common.ui.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.fossasia.openevent.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recyclerview_view_header)
    public TextView header;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}