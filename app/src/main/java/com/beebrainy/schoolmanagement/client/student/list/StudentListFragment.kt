package com.beebrainy.schoolmanagement.client.student.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.beebrainy.schoolmanagement.R
import com.beebrainy.schoolmanagement.app.StudentApplication
import com.beebrainy.schoolmanagement.client.list.SearchFragment
import com.beebrainy.schoolmanagement.databinding.StudentListFragmentBinding
import com.beebrainy.schoolmanagement.server.database.entities.StudentEntity
import com.beebrainy.schoolmanagement.server.util.Utils

class StudentListFragment : Fragment(), SearchFragment.SearchListener {

    companion object {
        @JvmStatic
        fun newInstance() =
                StudentListFragment()
    }

    private lateinit var viewModel: StudentListViewModel
    private lateinit var binding: StudentListFragmentBinding

    private var searchQuery = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding =
                DataBindingUtil.inflate(inflater, R.layout.student_list_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
                this,
                StudentListViewModelFactory(activity?.application as StudentApplication)
        ).get(StudentListViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initView()
        addNewStudent()
    }

    private fun initView() {
        val list = binding.viewModel?.getStudentObservable()
        binding.rvList.adapter =
                StudentAdapter { selectedItem: StudentEntity -> listItemClicked(selectedItem) }
        list?.observe(viewLifecycleOwner, Observer {
            (binding.rvList.adapter as StudentAdapter).setList(it)
            (binding.rvList.adapter as StudentAdapter).filter(searchQuery)
        })
    }

    private fun listItemClicked(selectedItem: StudentEntity) {
        Toast.makeText(activity, selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onQuery(query: String) {
        searchQuery = query
        (binding.rvList.adapter as StudentAdapter).filter(query)
    }

    private fun addNewStudent() {
        viewModel.run {
            val fatName = Utils.generateRandomString(Utils.generateRandomNum(7, 9))
            val surname = Utils.generateRandomString(Utils.generateRandomNum(7, 9))
            addStudent(
                    Utils.generateRandomString(Utils.generateRandomNum(7, 9)),
                    fatName,
                    surname,
                    "$fatName ${Utils.generateRandomString(Utils.generateRandomNum(7, 9))} $surname}",
                    "${Utils.generateRandomString(Utils.generateRandomNum(7, 9))}  ${Utils.generateRandomString(Utils.generateRandomNum(7, 9))} $surname"
            )
        }
    }
}
