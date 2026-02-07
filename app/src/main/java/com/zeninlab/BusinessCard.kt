package com.zeninlab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.zeninlab.ui.theme.ForLab1Theme

@Composable
fun BusinessCardScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        @Suppress("UnusedBoxWithConstraintsScope")
        BoxWithConstraints {
            if (maxWidth < maxHeight) {
                PortraitLayout()
            } else {
                LandscapeLayout()
            }
        }
    }
}

@Composable
fun PortraitLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_large)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            LogoAndName()
        }
        ContactInfo()
    }
}

@Composable
fun LandscapeLayout() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LogoAndName()
        ContactInfo()
    }
}


@Composable
fun LogoAndName() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo_android),
            contentDescription = stringResource(id = R.string.android_logo_content_description),
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.logo_size))
                .clip(CircleShape)
                .background(colorResource(id = R.color.logo_background))
                .padding(dimensionResource(id = R.dimen.padding_small))
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
        Text(
            text = stringResource(id = R.string.user_name),
            fontSize = dimensionResource(id = R.dimen.font_size_large).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text_primary)
        )
        Text(
            text = stringResource(id = R.string.user_group),
            fontSize = dimensionResource(id = R.dimen.font_size_medium).value.sp,
            color = colorResource(id = R.color.text_secondary)
        )
    }
}

@Composable
fun ContactInfo() {
    Column(horizontalAlignment = Alignment.Start) {
        ContactRow(icon = R.drawable.logo_email, text = stringResource(id = R.string.user_email))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        ContactRow(icon = R.drawable.logo_telegram, text = stringResource(id = R.string.user_telegram))
    }
}

@Composable
fun ContactRow(icon: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null, // decorative icon
            modifier = Modifier.size(dimensionResource(id = R.dimen.contact_icon_size))
        )
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
        Text(
            text = text,
            fontSize = dimensionResource(id = R.dimen.font_size_medium).value.sp,
            color = colorResource(id = R.color.text_primary)
        )
    }
}

@Preview(showBackground = true, name = "Portrait Preview")
@Composable
fun BusinessCardPortraitPreview() {
    ForLab1Theme {
        PortraitLayout()
    }
}

@Preview(showBackground = true, name = "Landscape Preview", widthDp = 800, heightDp = 400)
@Composable
fun BusinessCardLandscapePreview() {
    ForLab1Theme {
        LandscapeLayout()
    }
}
