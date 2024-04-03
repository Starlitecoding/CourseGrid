package com.example.coursesgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesgrid.data.DataSource
import com.example.coursesgrid.data.DataSource.topics
import com.example.coursesgrid.ui.theme.CoursesGridTheme
import com.example.coursesgrid.model.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseGridApp()
                }
            }
        }
    }
}

@Composable
fun CourseGridApp(modifier: Modifier = Modifier) {
    val topicList = DataSource.topics
    CourseGrid(topicList = topicList)
}


@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    Card() {
        Row()
        {
            Image(
                painter = painterResource(topic.courseImageId),
                contentDescription = stringResource(topic.courseNameId),
                modifier
                    .size(68.dp)
                    .fillMaxSize()

            )

            Column {
                Text(
                    text = stringResource(topic.courseNameId),
                    modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                )
                Row(modifier.padding(start = 16.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = "${topic.numOfCourses}",
                        modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium,

                    )
                }

            }


        }

    }
}


@Composable
fun CourseGrid(modifier: Modifier = Modifier, topicList: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp), // пространство между вертикальными элементами
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(topicList) { topic ->
                CourseCard(topic = topic)
            }
        }

    )

}

//@Composable
//@Preview
//private fun preview() {
//    CourseCard(Topic(R.string.business, 12, R.drawable.business))
//}

@Composable
@Preview
fun preview() {
    CoursesGridTheme {
        CourseGridApp()
    }
}