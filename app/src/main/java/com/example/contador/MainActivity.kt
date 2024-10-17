package com.example.contador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contador.ui.theme.ContadorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuIntervalos(
                        modifier = Modifier.padding(innerPadding)
                    )
                    Counter(
                        modifier = Modifier.padding(innerPadding),
                        isVisible = false
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ContadorTheme {
        Counter(modifier = Modifier.padding(),false)
    }
}


@Composable
fun Counter(modifier: Modifier = Modifier, isVisible: Boolean) {
    if (isVisible) {
        var theCounter by remember { mutableStateOf(0L) }
        var miConterDown by remember {
            mutableStateOf(
                CounterDown(
                    99,
                    { newvalue -> theCounter = newvalue })
            )
        }

        Column {
            Text(
                text = theCounter.toString(),
                modifier = modifier
            )
            Button(onClick = {
                miConterDown.toggle()
            }) {
                Text(
                    text = "Pulsar"
                )
            }
        }
    }
}


@Composable
fun MenuIntervalos(modifier: Modifier) {
    var sets by rememberSaveable { mutableStateOf("") }
    var work by rememberSaveable { mutableStateOf("") }
    var rest by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = sets,
            label = { Text("Num of sets") },
            onValueChange = { value ->
                if (value.length <= 2) {
                    sets = value.filter { it.isDigit() }
                }
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = work,
            label = { Text("Work time") },
            onValueChange = { value ->
                if (value.length <= 2) {
                    work = value.filter { it.isDigit() }
                }
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = rest,
            label = { Text("Rest Time") },
            onValueChange = { value ->
                if (value.length <= 2) {
                    rest = value.filter { it.isDigit() }
                }
            }
        )

    }








}

