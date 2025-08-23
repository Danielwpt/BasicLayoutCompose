package com.example.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccodelab.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicCodelabTheme {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(text = stringResource(R.string.placeholder_search))
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes image : Int,
    @StringRes imageTxt : Int,
    modifier : Modifier = Modifier
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(shape = CircleShape)
        )

        Text(
            text = stringResource(imageTxt),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun AlignYourBodyElementPreview() {
    AlignYourBodyElement(
        image = R.drawable.ab1_inversions,
        imageTxt = R.string.ab1_inversions,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes image : Int,
    @StringRes text : Int,
    modifier : Modifier
) {
    Surface (
        modifier = Modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteCollectionCardPreview() {
    FavoriteCollectionCard(
        R.drawable.fc2_nature_meditations,
        R.string.fc2_nature_meditations,
        modifier = Modifier.padding(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AlignYourBodyRow() {
    LazyRow (
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(alignBodyRowList()) {
            item -> AlignYourBodyElement(item.image, item.text)
        }
    }
}

fun alignBodyRowList() : List<AlignBodyList> {
    return listOf(
        AlignBodyList(R.drawable.ab1_inversions, R.string.ab1_inversions),
        AlignBodyList(R.drawable.ab2_quick_yoga, R.string.ab2_quick_yoga),
        AlignBodyList(R.drawable.ab3_stretching, R.string.ab3_stretching),
        AlignBodyList(R.drawable.ab4_tabata, R.string.ab4_tabata),
        AlignBodyList(R.drawable.ab5_hiit, R.string.ab5_hiit),
        AlignBodyList(R.drawable.ab6_pre_natal_yoga, R.string.ab6_pre_natal_yoga),
    )
}

@Preview(showBackground = true)
@Composable
fun FavoriteCollectionsGrid() {
    LazyHorizontalGrid(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        rows = GridCells.Fixed(2),
        modifier = Modifier.height(168.dp)
    ) {
        items(favoriteCollectionsList()) {
            item -> FavoriteCollectionCard(
            image = item.image, text = item.text, modifier = Modifier.height(80.dp)
            )
        }
    }
}

fun favoriteCollectionsList() : List<FavoriteCollections> {
    return listOf(
        FavoriteCollections(R.drawable.fc1_short_mantras, R.string.fc1_short_mantras),
        FavoriteCollections(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
        FavoriteCollections(R.drawable.fc3_stress_and_anxiety, R.string.fc3_stress_and_anxiety),
        FavoriteCollections(R.drawable.fc4_self_massage, R.string.fc4_self_massage),
        FavoriteCollections(R.drawable.fc5_overwhelmed, R.string.fc5_overwhelmed),
        FavoriteCollections(R.drawable.fc6_nightly_wind_down, R.string.fc6_nightly_wind_down),
    )
}

@Composable
fun HomeSection(
    @StringRes title : Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column (modifier) {
        Text(stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeSectionPreview() {
    BasicCodelabTheme {
        HomeSection(
            R.string.align_your_body
        ) {
            AlignYourBodyRow()
        }
    }
}