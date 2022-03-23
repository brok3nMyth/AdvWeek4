package id.ac.ubaya.adv160419058week4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.AndroidViewModel
import id.ac.ubaya.adv160419058week4.model.Student
import id.ac.ubaya.adv160419058week4.viewmodel.ListViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application):AndroidViewModel(application) {
    val studentLiveData = MutableLiveData<Student>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    fun fetch(IdStudent : String) {
//        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//        studentLiveData.value = student1
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=$IdStudent"

        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {
                val result = Gson().fromJson<Student>(it, Student::class.java)
                studentLiveData.value = result
                Log.d("showvolley", it)
            },
            {
                Log.d("errorvolley",it.toString())
            }
        ).apply {
            tag = "TAG"
        }
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }


}