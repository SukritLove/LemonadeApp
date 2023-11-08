package com.example.lemonadeapp

import android.graphics.Paint.Style
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    LemonadePage(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}


@Composable
fun LemonadePage(modifier: Modifier = Modifier) {

    var count by remember {
        mutableStateOf(1)
    }
    val idValue = getContentID(count)


    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .background(
                    colorResource(id = R.color.teal_200), shape = RoundedCornerShape(10.dp),
                )
                .clickable {
                    if (count != 4) count += 1 else count = 1
                }, contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = idValue.first), contentDescription = null
            )
        }

        Text(stringResource(id = idValue.second), modifier = Modifier.padding(40.dp))

    }

}

fun getContentID(count: Int = 1): Pair<Int, Int> {
    val contentId = when (count) {
        1 -> Pair(R.drawable.lemon_tree, R.string.TapLemon)
        2 -> Pair(R.drawable.lemon_squeeze, R.string.KeepTap)
        3 -> Pair(R.drawable.lemon_drink, R.string.Drink)
        else -> Pair(R.drawable.lemon_restart, R.string.EmptyGlass)
    }
    return contentId
}