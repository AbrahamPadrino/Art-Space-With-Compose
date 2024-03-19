
package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    Column(
        modifier = Modifier
            .padding(18.dp)
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        var result by remember { mutableStateOf(1) }
        val item = result

        val image = generateImage(item)
        val title = generateTitle(item)
        val artist = generateArtist(item)

        //PaintImage()
        Spacer(modifier = Modifier.height(48.dp))
        Image(
            modifier = Modifier
                .width(300.dp)
                .height(400.dp),
            contentScale = ContentScale.Fit,
            painter = painterResource(image),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(48.dp))
        //PaintText()
        Text(
            text = stringResource(title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(artist),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        //PaintButton()
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { if (result > 1) result -=1 }) {
                Text(text = stringResource(R.string.previus_art))
            }
            Button(onClick = { if (result < 9) result +=1 }) {
                Text(text = stringResource(R.string.next_art))
            }

        }
    }

}
internal fun generateImage(item: Int): Int {
    return when (item) {
        1 -> (R.drawable.art_1)
        2 -> (R.drawable.art_2)
        3 -> (R.drawable.art_3)
        4 -> (R.drawable.art_4)
        5 -> (R.drawable.art_5)
        6 -> (R.drawable.art_6)
        7 -> (R.drawable.art_7)
        8 -> (R.drawable.art_8)
        else -> (R.drawable.art_9)
    }
}
internal fun generateTitle(item: Int): Int {
    return when (item) {
        1 -> (R.string.title_art_one)
        2 -> (R.string.title_art_two)
        3 -> (R.string.title_art_three)
        4 -> (R.string.title_art_four)
        5 -> (R.string.title_art_five)
        6 -> (R.string.title_art_six)
        7 -> (R.string.title_art_seven)
        8 -> (R.string.title_art_eight)
        else -> (R.string.title_art_nine)
    }
}
internal fun generateArtist(item: Int): Int {
    return when (item) {
        1 -> (R.string.name_art_one)
        2 -> (R.string.name_art_two)
        3 -> (R.string.name_art_three)
        4 -> (R.string.name_art_four)
        5 -> (R.string.name_art_five)
        6 -> (R.string.name_art_six)
        7 -> (R.string.name_art_seven)
        8 -> (R.string.name_art_eight)
        else -> (R.string.name_art_nine)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}