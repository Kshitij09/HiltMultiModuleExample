package com.kshitijpatil.testhilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.kshitijpatil.data.DataState
import com.kshitijpatil.data.User
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
  val userState by viewModel.members.collectAsState(initial = DataState.Loading)
  UsersList(userState)
}

@Composable
fun UsersList(userState: DataState<List<User>>) {
  when(userState) {
    is DataState.Success -> {
      LazyColumnFor(
        items = userState.data,
        modifier = Modifier
          .fillMaxWidth()
          .padding(start = 8.dp)
      ) { user ->
        Text(
          "${user.name}: ${user.email}",
          modifier = Modifier.padding(vertical = 4.dp)
        )
      }
    }
    is DataState.Error -> {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .wrapContentSize()
      ) {
        ProvideEmphasis(emphasis = AmbientEmphasisLevels.current.medium) {
          Text("Something went wrong...", style = MaterialTheme.typography.body1)
        }
      }
    }
    DataState.Loading -> {
      Box(modifier = Modifier.fillMaxSize().wrapContentSize()) {
        CircularProgressIndicator()
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  TestMultimoduleHiltTheme {
    MainContent()
  }
}