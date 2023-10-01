package com.savchuk.booklistapptask.presentation.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.savchuk.booklistapptask.R

@Composable
fun ErrorComponent(
    errorText: String,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = errorText, style = TextStyle(
                fontFamily = FontFamily.Serif,
                fontSize = 24.sp,
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onRetryClick, shape = RoundedCornerShape(8.dp)) {
            Text(text = stringResource(R.string.retry).uppercase())

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorComponentPreview() {
    ErrorComponent("Some problem", {})
}
