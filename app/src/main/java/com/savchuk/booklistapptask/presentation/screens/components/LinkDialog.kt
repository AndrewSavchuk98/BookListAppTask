package com.savchuk.booklistapptask.presentation.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.savchuk.booklistapptask.domain.models.BookLink

@Composable
fun LinkDialog(
    onDismissRequest: () -> Unit,
    onLinkClicked: (String) -> Unit,
    list: List<BookLink>
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            LazyColumn(
                Modifier
                    .fillMaxHeight(0.8f)
                    .padding(12.dp)
            ) {
                items(list) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        val annotatedString = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.Blue,
                                    textDecoration = TextDecoration.Underline
                                )
                            ) {
                                append(it.link)
                            }
                        }
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it.name, style = TextStyle(
                                fontFamily = FontFamily.Serif,
                            )
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onLinkClicked(it.link)
                                }, text = annotatedString,
                            style = TextStyle(
                                fontFamily = FontFamily.Serif,
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }
                }
            }
            TextButton(
                onClick = { onDismissRequest() },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
            ) {
                Text("Dismiss")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LinkDialogPreview() {
    LinkDialog({}, {}, listOf(
        BookLink("Amazon", "https://amazon.com"),
        BookLink("Google", "https://google.com"),
        BookLink("Amazon", "https://amazon.com"),
        BookLink("Google", "https://google.com"),
        BookLink("Amazon", "https://amazon.com"),
        BookLink("Google", "https://google.com"),
        BookLink("Amazon", "https://amazon.com"),
        BookLink("Google", "https://google.com")
    )
    )
}