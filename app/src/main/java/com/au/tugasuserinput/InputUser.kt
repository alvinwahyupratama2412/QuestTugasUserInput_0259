
package com.au.tugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodata(modifier: Modifier) {

    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }

    var android by remember { mutableStateOf(false) }
    var uiux by remember { mutableStateOf(false) }
    var web by remember { mutableStateOf(false) }

    var dropdownTerbuka by remember { mutableStateOf(false) }
    var tanggalDialog by remember { mutableStateOf(false) }
    var berhasil by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState()
    val dateFormat = stringResource(R.string.date_format)

    val daftarPengalaman = listOf(
        stringResource(R.string.experience_beginer),
        stringResource(R.string.experience_intermediate),
        stringResource(R.string.experience_advanced)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(R.color.white)
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(R.color.white))
        ) {

            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = stringResource(
                    R.string.background_description
                ),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height))
                    .align(Alignment.TopCenter)
            )

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = dimensionResource(R.dimen.card_offset)),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.card_radius),
                    topEnd = dimensionResource(R.dimen.card_radius)
                ),
                color = colorResource(R.color.white),
                shadowElevation = dimensionResource(R.dimen.card_elevation)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(
                            horizontal = dimensionResource(R.dimen.screen_padding),
                            vertical = dimensionResource(R.dimen.padding_large)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(R.dimen.field_spacing)
                    )
                ) {

                    Text(
                        text = stringResource(R.string.form_title),
                        color = colorResource(R.color.purple_primary),
                        fontSize = dimensionResource(R.dimen.title_size).value.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = stringResource(R.string.form_subtitle),
                        color = colorResource(R.color.gray_text),
                        fontSize = dimensionResource(R.dimen.subtitle_size).value.sp
                    )

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.padding_medium)
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.field_spacing)
                        )
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            label = { Text(stringResource(R.string.first_name)) },
                            singleLine = true,
                            modifier = Modifier.weight(1f)
                        )

                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            label = { Text(stringResource(R.string.last_name)) },
                            singleLine = true,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(stringResource(R.string.email)) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            dimensionResource(R.dimen.field_spacing)
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = tanggalLahir,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text(stringResource(R.string.birth_date)) },
                                trailingIcon = {
                                    Text(stringResource(R.string.calendar_icon))
                                },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable { tanggalDialog = true }
                            )
                        }

                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = pengalaman,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text(stringResource(R.string.experience)) },
                                trailingIcon = {
                                    Text(stringResource(R.string.dropdown_icon))
                                },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable { dropdownTerbuka = true }
                            )

                            DropdownMenu(
                                expanded = dropdownTerbuka,
                                onDismissRequest = { dropdownTerbuka = false }
                            ) {
                                daftarPengalaman.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(item) },
                                        onClick = {
                                            pengalaman = item
                                            dropdownTerbuka = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    if (tanggalDialog) {
                        DatePickerDialog(
                            onDismissRequest = { tanggalDialog = false },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        datePickerState.selectedDateMillis?.let { millis ->
                                            val formatter = SimpleDateFormat(
                                                dateFormat,
                                                Locale.getDefault()
                                            ).apply {
                                                timeZone = TimeZone.getTimeZone("UTC")
                                            }
                                            tanggalLahir = formatter.format(Date(millis))
                                        }
                                        tanggalDialog = false
                                    }
                                ) {
                                    Text(stringResource(R.string.confirm))
                                }
                            },
                            dismissButton = {
                                TextButton(
                                    onClick = { tanggalDialog = false }
                                ) {
                                    Text(stringResource(R.string.cancel))
                                }
                            }
                        ) {
                            DatePicker(state = datePickerState)
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.padding_small)
                        )
                    )

                    Text(
                        text = stringResource(R.string.choose_skill),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = android,
                                onCheckedChange = { android = it }
                            )
                            Text(
                                text = stringResource(R.string.android_skill),
                                fontSize = dimensionResource(R.dimen.skill_text_size).value.sp
                            )
                        }

                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = uiux,
                                onCheckedChange = { uiux = it }
                            )
                            Text(
                                text = stringResource(R.string.uiux_skill),
                                fontSize = dimensionResource(R.dimen.skill_text_size).value.sp
                            )
                        }

                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = web,
                                onCheckedChange = { web = it }
                            )
                            Text(
                                text = stringResource(R.string.web_skill),
                                fontSize = dimensionResource(R.dimen.skill_text_size).value.sp
                            )
                        }
                    }

                    Button(
                        onClick = { berhasil = true },
                        enabled = namaDepan.isNotBlank() &&
                                namaBelakang.isNotBlank() &&
                                email.isNotBlank() &&
                                tanggalLahir.isNotBlank() &&
                                pengalaman.isNotBlank() &&
                                (android || uiux || web),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(R.dimen.field_height)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.purple_primary),
                            disabledContainerColor = colorResource(R.color.gray_disabled)
                        )
                    ) {
                        Text(stringResource(R.string.proceed))
                    }

                    if (berhasil) {
                        Text(
                            text = stringResource(R.string.form_result),
                            color = colorResource(R.color.purple_primary),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.padding_large)
                        )
                    )
                }
            }
        }
    }
}
