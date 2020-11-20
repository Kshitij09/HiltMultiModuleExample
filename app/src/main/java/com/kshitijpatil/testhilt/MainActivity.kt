package com.kshitijpatil.testhilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.kshitijpatil.testhilt.ui.TestMultimoduleHiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TestMultimoduleHiltTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          MainContent()
        }
      }
    }
  }
}

@Composable
fun MainContent() {
  val viewModel: MainViewModel = viewModel()
  LazyColumnFor(
    items = viewModel.members,
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 8.dp)
  ) { member ->
    Text("${member.status}: ${member.flatNo}", modifier = Modifier.padding(vertical = 4.dp))
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  TestMultimoduleHiltTheme {
    MainContent()
  }
}