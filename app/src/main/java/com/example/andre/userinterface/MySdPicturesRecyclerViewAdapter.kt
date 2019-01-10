package com.example.andre.userinterface

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.andre.userinterface.R.drawable.abc_ab_share_pack_mtrl_alpha


import com.example.andre.userinterface.SdPicturesFragment.OnListFragmentInteractionListener
import com.example.andre.userinterface.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_sdpictures.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MySdPicturesRecyclerViewAdapter(
    private val mValues: ArrayList<String>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MySdPicturesRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_sdpictures, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        //Fill the Layout
        holder.mIdView.text = item
        holder.mContentView.text = item
        holder.mPicture.setImageResource(R.drawable.ic_menu_camera)
        //holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        var mPicture : ImageView = mView.image

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
