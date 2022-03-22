package id.ac.ubaya.adv160419058week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.adv160419058week4.viewmodel.DetailViewModel
import id.ac.ubaya.adv160419058week4.R
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private val studentListAdapter  = StudentListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        observeViewModel()
    }
    fun observeViewModel() {
        inputID.setText(viewModel.studentLiveData.value?.id)
        inputName.setText(viewModel.studentLiveData.value?.name)
        inputDob.setText(viewModel.studentLiveData.value?.dob)
        inputPhone.setText(viewModel.studentLiveData.value?.phone)


    }

}