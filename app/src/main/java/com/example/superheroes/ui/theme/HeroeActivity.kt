package com.example.superheroes.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes.R
import com.example.superheroes.data.Hero

@ExperimentalMaterial3Api
@Composable
fun SuperheroeTopBar(){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}
@Composable
fun SuperheroeItem(hero : Hero, modifier: Modifier){
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
            .padding(bottom = dimensionResource(id = R.dimen.padding_small))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            HeroeInformation(
                heroeName = hero.nameRes,
                heroeDescription = hero.descriptionRes,
                modifier = modifier
                    .weight(1f)
                    .padding(end = dimensionResource(id = R.dimen.padding_medium))
            )
            HeroeIcon(heroeIcon = hero.imageRes)

        }
    }
}

@Composable
fun HeroeIcon(@DrawableRes heroeIcon: Int, modifier: Modifier = Modifier){
    Image(
        modifier = modifier
            .size(72.dp)
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(heroeIcon),
        contentDescription = null
    )
}

@Composable
fun HeroeInformation(heroeName: Int,heroeDescription : Int,modifier: Modifier){
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroeName),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = stringResource(heroeDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}