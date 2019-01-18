package com.wakecap.android.assignment.ui.workersList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wakecap.android.assignment.R;
import com.wakecap.android.assignment.models.BaseItem;
import com.wakecap.android.assignment.models.WorkerAttributes;

import java.util.List;

/**
 * Created by Amin on 09/08/2016.
 * <p>
 * This class will be used for
 */

public class JavaListAdapter extends RecyclerView.Adapter<JavaListAdapter.GroupViewHolder> {

    private List<BaseItem<WorkerAttributes>> modelList;

    public JavaListAdapter(List<BaseItem<WorkerAttributes>> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_worker, viewGroup, false);
        return new GroupViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final GroupViewHolder holder, final int position) {
        final BaseItem<WorkerAttributes> model = modelList.get(position);
        holder.name.setText(model.getAttributes().getFullName());
        holder.role.setText(model.getAttributes().getRoleName());
        holder.inventory.setText(model.getAttributes().getInventories().get(0).getAttributes().getName());
    }


    static class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView name, role, inventory;

        GroupViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.workerName);
            role = itemView.findViewById(R.id.workerRole);
            inventory = itemView.findViewById(R.id.workerInventory);

        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
