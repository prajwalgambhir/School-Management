package com.beebrainy.schoolmanagement.client.list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.beebrainy.schoolmanagement.R
import kotlinx.android.synthetic.main.fragment_search.*
import java.io.Serializable

class SearchFragment : Fragment() {

    private val ARG_LISTENER = "param1"

    private var listener: SearchListener? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            listener = arguments?.getSerializable(ARG_LISTENER) as SearchListener
        }
    }

    override fun onResume() {
        super.onResume()
        listener?.let {
            edtSearch.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    it.onQuery(s.toString())
                }

                override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(listener: SearchListener) =
                SearchFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARG_LISTENER, listener)
                    }
                }
    }

    interface SearchListener : Serializable {
        fun onQuery(query: String)
    }
}
