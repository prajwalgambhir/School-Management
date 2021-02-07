package com.beebrainy.schoolmanagement.client.student.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.beebrainy.schoolmanagement.R
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity
import com.beebrainy.schoolmanagement.databinding.ItemListStudentBinding

/**
 * Created by Prajwal Gambhir on 24-05-2020.
 * Copyright (2020) by BeeBrainy
 */
class StudentAdapter(
    private val clickListener: (StudentEntity) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentCard>() {

    private var _fullList = ArrayList<StudentEntity>()
    private var _filteredList = ArrayList<StudentEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentCard {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemListStudentBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_list_student, parent, false)
        return StudentCard(binding)
    }

    override fun getItemCount(): Int {
        return _filteredList.size
    }

    override fun onBindViewHolder(holder: StudentCard, position: Int) {
        holder.bind(_filteredList.get(position), clickListener)
    }

    fun setList(list: List<StudentEntity>) {
        _fullList.clear()
        _filteredList.clear()
        _fullList.addAll(list)
        _filteredList.addAll(list)
        notifyDataSetChanged()
    }

    fun filter(query: String?) {
        _filteredList.clear()
        if (query.isNullOrEmpty()) {
            _filteredList.addAll(_fullList)
        } else {
            for (stud in _fullList) {
                if (stud.firstName.contains(query, true) || stud.lastName.contains(query, true)) {
                    _filteredList.add(stud)
                }
            }
        }
        notifyDataSetChanged()
    }

    inner class StudentCard(var binding: ItemListStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(studentEntity: StudentEntity, clickListener: (StudentEntity) -> Unit) {
            binding.tvName.text =
                "${studentEntity.id} ${studentEntity.firstName} ${studentEntity.midName} ${studentEntity.lastName}"
            binding.tvClass.text = "NA"
            binding.listItemLayout.setOnClickListener({ clickListener(studentEntity) })
        }

    }
}