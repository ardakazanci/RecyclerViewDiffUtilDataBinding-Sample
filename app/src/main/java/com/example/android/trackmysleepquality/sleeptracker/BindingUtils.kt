package com.example.android.trackmysleepquality.sleeptracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight


/**
 * Uyku süresinin formatlanması için BindAdapter.
 * xml tarafında kullanılacak
 */
@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight) {
	// TextView uzantısı olarak ayarladığımız için text ' e direk ulaşabildik.
	text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, context.resources)
}

/**
 * Uyku kalitesi değerinin ayarlanması için BindAdapter.
 * xml tarafında kullanılacak
 */
@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(item: SleepNight) {
	text = convertNumericQualityToString(item.sleepQuality, context.resources)
}

/**
 * Uyku kalite image' larını image view ' e belli bir formata göre atama işlemini sağlar.
 */
@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNight) {
	setImageResource(
		when (item.sleepQuality) {
			0 -> R.drawable.ic_sleep_0
			1 -> R.drawable.ic_sleep_1
			2 -> R.drawable.ic_sleep_2
			3 -> R.drawable.ic_sleep_3
			4 -> R.drawable.ic_sleep_4
			5 -> R.drawable.ic_sleep_5
			else -> R.drawable.ic_sleep_active
		}
	)
}


