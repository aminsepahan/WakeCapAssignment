package com.wakecap.android.assignment.ui.kotlinList

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wakecap.android.assignment.R
import com.wakecap.android.assignment.models.BaseItem
import com.wakecap.android.assignment.models.RoleAttributes
import com.wakecap.android.assignment.models.WorkerAttributes
import kotlinx.android.synthetic.main.item_role.view.*
import kotlinx.android.synthetic.main.item_worker.view.*

/**
 * Created by Amin on 26/11/2017.
 *
 */
@Suppress("UNCHECKED_CAST")
class KotlinListAdapter(val modelList: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ListItem.ROLE -> ViewHolderRole(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_role, parent, false)
            )
            else -> ViewHolderWorker(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_worker, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (modelList.get(position).getType()) {
            ListItem.ROLE -> (holder as ViewHolderRole).bindItemsForRole(modelList[position])
            else -> (holder as ViewHolderWorker).bindItemsForWorker(modelList[position])
        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    class ViewHolderWorker(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItemsForWorker(model: ListItem) {

            itemView.workerName.text = (model as BaseItem<WorkerAttributes>).attributes.fullName
            itemView.workerRole.visibility = GONE
            itemView.workerRoleTitle.visibility = GONE
            if (model.attributes.Inventories.isNotEmpty()) {
                itemView.workerInventory.text = model.attributes.Inventories[0].attributes.name
            } else {
                itemView.workerInventory.text = "N/A"
            }
        }

    }

    class ViewHolderRole(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItemsForRole(model: ListItem) {
            itemView.title.text = (model as BaseItem<RoleAttributes>).attributes.name
        }


    }

    override fun getItemViewType(position: Int): Int {
        return modelList[position].getType()
    }

}