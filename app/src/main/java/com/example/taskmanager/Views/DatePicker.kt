import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.R
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerfunction( selectedDate : Long?  , onDateChange : (Long?)->Unit){
    var datepickercontroller by remember { mutableStateOf(false) }
    val dateState = rememberDatePickerState()
    val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")

    val displayText = if (selectedDate != null) {
        val localDate = Instant.ofEpochMilli(selectedDate)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
        localDate.format(formatter).toString()
    } else {
        "Select Date"
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                color = Color.Gray,
                width = 1.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text =displayText,
            fontWeight = FontWeight(500),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        IconButton(onClick = { datepickercontroller = true }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_calender),
                contentDescription = "Dropdown"
            )
        }
    }

    if (datepickercontroller) {
        DatePickerDialog(
            onDismissRequest = { datepickercontroller = false },
            confirmButton = {
                Button(onClick = {
                    if (dateState.selectedDateMillis != null) {
                        onDateChange(dateState.selectedDateMillis)
                        datepickercontroller = false
                    }
                }) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                Button(onClick = { datepickercontroller = false }) {
                    Text(text = "Cancel")
                }
            }
        ) {
            androidx.compose.material3.DatePicker(state = dateState)
        }
    }
}