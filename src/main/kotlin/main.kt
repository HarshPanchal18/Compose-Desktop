import androidx.compose.desktop.LocalAppWindow
import androidx.compose.desktop.Window
import androidx.compose.desktop.WindowEvents
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.window.KeyStroke
import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem

fun main() = Window(
    title = "Compose with desktop",
    menuBar = MenuBar(
        Menu(
            name = "File",
            MenuItem("New", shortcut = KeyStroke(Key.N)),
            MenuItem("Open", shortcut = KeyStroke(Key.O)),
            MenuItem("Exit", shortcut = KeyStroke(Key.Q))
        ),
        Menu(
            name = "Edit",
            MenuItem("Cut", shortcut = KeyStroke(Key.X)),
            MenuItem("Copy", shortcut = KeyStroke(Key.C))
        ),
    ),
    events = WindowEvents(onMaximize = {}),
    undecorated = true
) {
    val window = LocalAppWindow.current
    window.keyboard.setShortcut(key = Key.Q, callback = { window.close() })
    App()
}

fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Scaffold(topBar = {}) {
            TopAppBar(title = { Text("Compose with desktop") })
            Column(
                modifier = Modifier.background(Color.Green.copy(0.5F)).fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    text = "Hello, Desktop!"
                }) {
                    Row {
                        Icon(Icons.Filled.ArrowRight,null, tint = Color.White)
                        Text("Get started")
                    }
                }
            }
        }
    }
}