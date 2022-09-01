package com.example.happybirthdaycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.happybirthdaycompose.ui.theme.HappyBirthdayComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(1f)
                ) {
                    MainBackground()
                }
            }
        }
    }
}

@Preview
@Composable
fun MainBackground(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (androidParty, happyBirthdayText, signatureText) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(androidParty) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
        )
        Text(
            stringResource(id = R.string.happy_birthday_text),
            fontSize = 34.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .constrainAs(happyBirthdayText) {
                    top.linkTo(androidParty.top, 16.dp)
                    start.linkTo((androidParty.start), 16.dp)
                }
        )
        Text(
            stringResource(id = R.string.signature_text),
            fontSize = 34.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .constrainAs(signatureText) {
                    end.linkTo(parent.end, 16.dp)
                    bottom.linkTo(parent.bottom, 16.dp)
                }
        )
    }
}