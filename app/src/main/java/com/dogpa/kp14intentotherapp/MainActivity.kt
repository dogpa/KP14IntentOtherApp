package com.dogpa.kp14intentotherapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.dogpa.kp14intentotherapp.ui.theme.KP14IntentOtherAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KP14IntentOtherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainView("Android",this)
                }
            }
        }
    }
}

@Composable
fun MainView(name: String, context:Context) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            openURL(context,"https://www.facebook.com")
        }) {
            Text(text = "跳轉網頁Facebook")
        }
        Button(onClick = {
            openURL(context,"https://line.me/ti/p/@mitsubishielectric")
        }) {
            Text(text = "Line")
        }
        Button(onClick = {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://maps.google.com/maps?saddr=25.034210948537485,121.56403195296623&daddr=武嶺&directionsmode=driving")
            startActivity(context, openURL, null )
        }) {
            Text(text = "跳轉Map")
        }
        Button(onClick = {
            openURL(context,"tel:0912345678")
        }) {
            Text(text = "致電0912345678")
        }
    }
}

fun openURL(context: Context, url: String) {

    // 建立一個Action view的 Intent
    val intent = Intent(Intent.ACTION_VIEW)

    // 在intent的data加入要前往的網址
    intent.data =
        Uri.parse(url)

    // 執行該intent
    startActivity(context, intent, null)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KP14IntentOtherAppTheme {
        MainView("Android",MainActivity())
    }
}


