package com.example.c_19tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_list.view.*

class StateAdapter (val list: List<StatewiseItem>): BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        val item = list[position]
        view.stateTV.text = item.state
        view.confirmedTV.text = SpannableDelta("${item.confirmed}\n ↑${item.deltaconfirmed ?: "0" }",
        "#FF0000",
        item.confirmed?.length ?: 0
        )
        view.activeTV.text = SpannableDelta("${item.active}\n ↑${item.deltaactive ?: "0" }",
            "#F55F20",
            item.active?.length ?: 0
        )
        view.recoveredTV.text = SpannableDelta("${item.recovered}\n ↑${item.deltarecovered ?: "0" }",
            "#19CD4C",
            item.recovered?.length ?: 0
        )
        view.deathTV.text = SpannableDelta("${item.deaths}\n ↑${item.deltadeaths ?: "0" }",
            "#D2B55B",
            item.deaths?.length ?: 0
        )
        return view
    }

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = list.size
}