package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF00EE87)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun ImageName(imagePaint: Painter, name: String, quote: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = imagePaint,
            contentDescription = null
        )
        Text(
            text = name,
            modifier = Modifier.padding(8.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = quote,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactInfo(icon: Painter, contact: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
       Icon(
           painter = icon,
           contentDescription = null,
           modifier = Modifier
               .size(36.dp)
               .weight(1f)
       )
        Spacer(modifier = Modifier.size(36.dp))
            Text(
                text = contact,
                modifier = Modifier.weight(2f)
            )
    }
}

@Composable
fun Contact(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        ContactInfo(
            icon = painterResource(R.drawable.call_24dp_e8eaed),
            contact = stringResource(R.string.phone),
            modifier = Modifier.weight(1f)
        )
        ContactInfo(
            icon = painterResource(R.drawable.email_24dp_e8eaed),
            contact = stringResource(R.string.email),
            modifier = Modifier.weight(1f)
        )
        ContactInfo(
            icon = painterResource(R.drawable.r),
            contact = stringResource(R.string.github),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        ImageName(
            imagePaint = painterResource(R.drawable.avartar),
            name = stringResource(R.string.name),
            quote = stringResource(R.string.quote),
            modifier = Modifier.weight(0.5f)
        )
        Contact(
            modifier = Modifier.weight(2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}