package com.wuyu.test.demo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.wuyu.test.databinding.ActivityDemo1TransparentBinding
import org.greenrobot.eventbus.EventBus


class TransparentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemo1TransparentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDemo1TransparentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewListener()
    }

    private fun initViewListener() {
        binding.btnUpdate.setOnClickListener { view ->
            Snackbar.make(view, "更新底部Activity", Snackbar.LENGTH_LONG).show()
            EventBus.getDefault().post(Demo1Event("已更新底部"))
        }
    }

}