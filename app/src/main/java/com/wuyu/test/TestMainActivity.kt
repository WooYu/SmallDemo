package com.wuyu.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.wuyu.test.databinding.ActivityTestMainBinding
import com.wuyu.test.demo1.Demo1Event
import com.wuyu.test.demo1.TransparentActivity
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class TestMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewListener()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    private fun initViewListener() {
        binding.test1.setOnClickListener {
            startActivity(Intent(this, TransparentActivity::class.java))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: Demo1Event) {
        LogUtils.d("Demo1Event")
        binding.test1.text = event.content
    }

}