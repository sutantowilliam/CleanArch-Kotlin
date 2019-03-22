package com.example.ui.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ui.R
import com.example.ui.model.ProfileViewModel
import javax.inject.Inject
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BrowseAdapter @Inject constructor(): RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {

    var profiles: List<ProfileViewModel> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profile = profiles[position]
        holder.nameText.text = "${profile.name.title}. ${profile.name.first} ${profile.name.last}"

        Glide.with(holder.itemView.context)
            .load(profile.picture.medium)
            .into(holder.profileImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_profile, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return profiles.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nameText: TextView
        var profileImage: ImageView

        init {
            nameText = view.findViewById(R.id.text_name)
            profileImage = view.findViewById(R.id.image_profile)
        }
    }

}