package com.example.taskmanager.Views
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.Model.Task

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun TaskCard(
    data: Task,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    val bgColor = when (data.priority) {
        "High" -> Color(0xFFFFCDD2) // Reddish shade
        "Medium" -> Color(0xFFFFF9C4) // Yellow shade
        "Low" -> Color(0xFFC8E6C9) // Green shade
        else -> Color.Cyan // Default shade for any other case
    }

    // Convert the Long timestamp to a formatted date string
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
    val dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(data.dueDate), ZoneId.systemDefault())
    val formattedDate = dateTime.format(formatter)

    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .background(
                color = bgColor,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data.title,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .weight(1f),
                fontSize = 20.sp,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(12.dp)
                    .clickable { onEdit() }
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .clickable { onDelete() }
            )
        }
        Text(
            text = data.description,
            modifier = Modifier.padding(top = 12.dp, start = 12.dp),
            fontSize = 15.sp,
            lineHeight = 20.sp,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Due: ${formattedDate}",
                modifier = Modifier.weight(1f),
                fontSize = 13.sp,
                color = Color.Black,
                lineHeight = 20.sp
            )
            Text(
                text = "Priority: ${data.priority}",
                modifier = Modifier.weight(1f),
                fontSize = 13.sp,
                color = Color.Black,
                lineHeight = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskCard() {
    TaskCard(
        data = Task(
            title = "Important Task",
            description = "This task needs to be done urgently.",
            dueDate = System.currentTimeMillis(), // Provide a Long timestamp
            priority = "High",
            isCompleted = false
        ),
        onDelete = {},
        onEdit = {}
    )
}
